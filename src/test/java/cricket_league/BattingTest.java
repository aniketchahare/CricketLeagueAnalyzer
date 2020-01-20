package cricket_league;

import com.google.gson.Gson;
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
            int numOfRecords = cricketAnalyzer.loadBattingDataFile(BATTING_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);
        } catch (CricketAnalyzerException e){ }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingDataFile(WRONG_BATTING_CSV_FILE_PATH);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingDataFile(WRONG_BATTING_CSV_FILE_TYPE);
        } catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenBattingCSVFile_WithWrongDelimeter_ShouldThrowException() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingDataFile(BATTING_CSV_FILE_WITH_WRONG_DELIMETER);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }

    @Test
    public void givenBattingCSVFile_WhenSortedOnAvg_ShouldReturnSortedResult() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadBattingDataFile(BATTING_CSV_FILE_PATH);
            List<IPLBattingCSV> avgWiseSortedData = cricketAnalyzer.getAvgWiseSortedData();
            Assert.assertEquals(83.2, avgWiseSortedData.get(0).average, 0);
        } catch (CricketAnalyzerException e) {

        }
    }
}
