package cricket_league;

import BattingDAO.IplLeagueDAO;
import Sorting.SortMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class BowlingTest {

    private static final String BATTING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostRuns.csv";

    private static final String BOWLING_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_BOWLING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/main/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_BOWLING_CSV_FILE_TYPE = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostWkts.txt";
    private static final String BOWLING_CSV_FILE_WITH_WRONG_DELIMETER = "./src/test/resources/IPL2019FactsheetMostWktsDelimeter.csv";

    @Test
    public void givenBowlingCSVFile_ShouldReturnCSVFileData() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numOfRecords = cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            Assert.assertEquals(99, numOfRecords);
        } catch (CricketAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, WRONG_BOWLING_CSV_FILE_PATH);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BOWLING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBowlingCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, WRONG_BOWLING_CSV_FILE_TYPE);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BOWLING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBowlingCSVFile_WithWrongDelimeter_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_WITH_WRONG_DELIMETER);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }

//    -------

    @Test
    public void givenBowlingCSVFile_WhenSortedOnAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.AVG_BOWLER);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Krishnappa Gowtham", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnSR_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.STRIKERATE);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Krishnappa Gowtham", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnEconomy_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.ECONOMY);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Ben Cutting", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e){ }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnStrikeRate_With5wAnd4w_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.STRIKERATE_FIVE_FOUR_WKTS);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Krishnappa Gowtham", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnAverages_WithStrikeRate_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.BOWLER_AVERAGES_STRIKERATE);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Krishnappa Gowtham", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBowlingCSVFile_WhenSortedOnMaxWkts_WithBestAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BOWLING, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.WICKETS_AVERAGES);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Imran Tahir", sortedData.get(0).playerName);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingBowlingCSVFile_WhenSortedOn_BattingAndBowlingAvgs_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.INNING, BATTING_CSV_FILE_PATH, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.BATTING_BOWLING_AVERAGE);
//            sortedData.forEach(System.out::println);
//            System.out.println(sortedData.size());
            Assert.assertEquals(49, sortedData.size());
        }  catch (CricketAnalyzerException e){

        }
    }

    @Test
    public void givenBattingBowlingCSVFile_WhenSortedOn_MostRunsAndWkts_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.INNING, BATTING_CSV_FILE_PATH, BOWLING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.MOST_RUNS_WKTS);
//            sortedData.forEach(System.out::println);
//            System.out.println(sortedData.size());
            Assert.assertEquals(49, sortedData.size());
        }  catch (CricketAnalyzerException e){

        }
    }
}
