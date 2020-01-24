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
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBattingCSV.class);
            Iterable<IPLBattingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(), false).forEach(data -> csvList.add(new IplLeagueDAO(data)));
            return csvList.size();
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

    public int loadBowlingDataFile(String csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLBowlingCSV.class);
            Iterable<IPLBowlingCSV> iterable = () -> csvFileIterator;
            StreamSupport.stream(iterable.spliterator(), false).forEach(data -> csvList.add(new IplLeagueDAO(data)));
            return csvList.size();
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

    public List<IplLeagueDAO> getSortedData(SortMode sortMode) {
        Sorting sorting = sortMode.sortMode;
        return sorting.getSort(this.csvList);
    }
}