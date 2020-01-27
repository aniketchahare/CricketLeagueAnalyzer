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

public class IPLBowlingAdapter {
    public List<IplLeagueDAO> csvList = new ArrayList<>();

    public List<IplLeagueDAO> loadFileData(String[] csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLBowlingCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBowlingCSV.class);
            Iterable<IPLBowlingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(), false)
                    .map(IPLBowlingCSV.class::cast)
                    .forEach(data -> csvList.add(new IplLeagueDAO(data)));
//            csvList.forEach(System.out::println);
            return csvList;
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.IPL_BOWLING_FILE_PROBLEM);
        }
        catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }
}
