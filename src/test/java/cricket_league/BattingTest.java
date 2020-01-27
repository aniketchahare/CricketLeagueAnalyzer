package cricket_league;

import BattingDAO.IplLeagueDAO;
import Sorting.SortMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class BattingTest {

    private static final String BATTING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_BATTING_CSV_FILE_TYPE = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostRuns.txt";
    private static final String BATTING_CSV_FILE_WITH_WRONG_DELIMETER = "./src/test/resources/IPL2019FactsheetMostRunsDelimeter.csv";

    @Test
    public void givenBattingCSVFile_ShouldReturnCSVFileData() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numOfRecords = cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);
        } catch (CricketAnalyzerException e) {
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, WRONG_BATTING_CSV_FILE_PATH);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, WRONG_BATTING_CSV_FILE_TYPE);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongDelimeter_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_WITH_WRONG_DELIMETER);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }

//    ---------

    @Test
    public void givenBattingCSVFile_WhenSortedOnAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.AVG_BATSMAN);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("MS Dhoni", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnSR_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.STRIKERATE);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Ishant Sharma", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOn_Max6sAnd4s_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.FOURS_SIXES);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Andre Russell", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnStrikeRate_With6sAnd4s_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.STRIKERATE_FOURS_SIXES);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("Andre Russell", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnAverages_WithStrikeRate_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.BATSMAN_AVERAGES_STRIKERATE);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("MS Dhoni", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnMaxRuns_WithAverages_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadFileData(CricketAnalyzer.CSVFileType.BATTING, BATTING_CSV_FILE_PATH);
            List<IplLeagueDAO> sortedData = cricketAnalyzer.getSortedData(SortMode.RUNS_AVERAGES);
//            sortedData.forEach(System.out::println);
            Assert.assertEquals("David Warner", sortedData.get(0).player);
        } catch (CricketAnalyzerException e) {

        }
    }
}
