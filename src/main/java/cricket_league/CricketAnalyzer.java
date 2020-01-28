package cricket_league;

import BattingDAO.IplLeagueDAO;
import Sorting.Sorting;
import Sorting.SortMode;

import java.util.ArrayList;
import java.util.List;

public class CricketAnalyzer {
    public enum CSVFileType { BATTING, BOWLING, INNING }
    public List<IplLeagueDAO> csvList = new ArrayList<>();

    public int loadFileData(CSVFileType csvFileType, String... csvFilePath) throws CricketAnalyzerException {
        csvList = new CricketAdapterFactory().getFileData(csvFileType, csvFilePath);
        int listSize = csvList.size();
        return listSize;
    }
//    private  <E> int loadFileData(String csvFilePath, Class<E> iplCSVClass) throws CricketAnalyzerException {
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
//            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
//            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, iplCSVClass);
//            Iterable<E> iterable = () -> csvFileIterator;
//            if (iplCSVClass.getName().equals("cricket_league.IPLBattingCSV")) {
//                StreamSupport.stream(iterable.spliterator(), false)
//                        .map(IPLBattingCSV.class::cast)
//                        .forEach(data -> csvList.add(new IplLeagueDAO(data)));
//            } else {
//                StreamSupport.stream(iterable.spliterator(), false)
//                        .map(IPLBowlingCSV.class::cast)
//                        .forEach(data -> csvList.add(new IplLeagueDAO(data)));
//            }
////            csvList.forEach(System.out::println);
//            return csvList.size();
//        } catch (IOException e) {
//            throw new CricketAnalyzerException(e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM);
//        }
//        catch (CSVBuilderException e) {
//            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
//        } catch (RuntimeException e) {
//            throw new CricketAnalyzerException(e.getMessage(),
//                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
//        }
//    }

    public List<IplLeagueDAO> getSortedData(SortMode sortMode) {
        Sorting sorting = sortMode.sortMode;
        return sorting.getSort(this.csvList);
    }
}
