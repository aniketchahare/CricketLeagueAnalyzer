package cricket_league;

import BattingDAO.IplLeagueDAO;
import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import Sorting.Sorting;
import Sorting.SortMode;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class CricketAnalyzer {
    public List<IplLeagueDAO> csvList = new ArrayList<>();

    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
            return loadFileData(csvFilePath, IPLBattingCSV.class);
    }

    public int loadBowlingDataFile(String csvFilePath) throws CricketAnalyzerException {
        return loadFileData(csvFilePath, IPLBowlingCSV.class);
    }

    private  <E> int loadFileData(String csvFilePath, Class<E> iplCSVClass) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, iplCSVClass);
            Iterable<E> iterable = () -> csvFileIterator;
            if (iplCSVClass.getName().equals("cricket_league.IPLBattingCSV")) {
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(IPLBattingCSV.class::cast)
                        .forEach(data -> csvList.add(new IplLeagueDAO(data)));
            } else {
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(IPLBowlingCSV.class::cast)
                        .forEach(data -> csvList.add(new IplLeagueDAO(data)));
            }
//            csvList.forEach(System.out::println);
            return csvList.size();
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.IPL_FILE_PROBLEM);
        }
        catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }

    public List<IplLeagueDAO> getSortedData(SortMode sortMode) {
        Sorting sorting = sortMode.sortMode;
        return sorting.getSort(this.csvList);
    }
}
