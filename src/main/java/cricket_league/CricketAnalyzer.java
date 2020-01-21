package cricket_league;

import BattingDAO.IplLeagueDAO;
import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalyzer {
    public List<IplLeagueDAO> battingCSVList = new ArrayList<>();

    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBattingCSV.class);
            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(),false).forEach(data -> battingCSVList.add(new IplLeagueDAO(data)));
            return battingCSVList.size();
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }

    public List getAvgWiseSortedData() {
        System.out.println("in average sort");
       List<IPLBattingCSV> iplBattingDto = battingCSVList.stream()
                .sorted((data1,data2) -> data2.avg - data1.avg < 0 ? -1 : 1).map(iplLeagueDto-> iplLeagueDto.getIplDto())
                .collect(Collectors.toList());
        iplBattingDto.forEach(System.out::println);
//        for (int i=0 ; i < battingCSVList.size() ; i++){avgWiseSortedData
//            System.out.println(battingCSVList.get(i).average+" "+battingCSVList.get(i).player);
//        }
        return iplBattingDto;
    }

    public List getStrikeRateWiseSortedData() {
        List<IPLBattingCSV> iplBattingDto = battingCSVList.stream()
                .sorted((data1,data2) -> data2.strikeRate - data1.strikeRate < 0 ? -1 : 1).map(iplLeagueDAO -> iplLeagueDAO.getIplDto())
                .collect(Collectors.toList());

        return iplBattingDto;
    }

    public List getBoundaryWiseSortedData() {
        List<IPLBattingCSV> iplBattingDto= battingCSVList.stream()
                .sorted((data1,data2) -> ((data2.sixes * 6) + (data2.fours *4)) - ((data1.sixes * 6) + (data1.fours *4))).map(iplLeagueDAO ->  iplLeagueDAO.getIplDto())
                .collect(Collectors.toList());
//        for (int i=0 ; i < battingCSVList.size() ; i++){
//            System.out.println(battingCSVList.get(i).fours+" "+battingCSVList.get(i).sixes+" "+battingCSVList.get(i).player);
//        }
        return iplBattingDto;
    }
}