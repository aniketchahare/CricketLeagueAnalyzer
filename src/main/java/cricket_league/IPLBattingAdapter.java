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
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class IPLBattingAdapter {
    public List<IplLeagueDAO> csvList = new ArrayList<>();

    public List<IplLeagueDAO> loadFileData(String csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLBattingCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBattingCSV.class);
            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(), false)
                    .map(IPLBattingCSV.class::cast)
                    .forEach(data -> csvList.add(new IplLeagueDAO(data)));
//            csvList.forEach(System.out::println);
            return csvList;
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM);
        }
        catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }
}
