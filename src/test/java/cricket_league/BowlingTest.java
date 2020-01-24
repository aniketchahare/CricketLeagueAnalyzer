package cricket_league;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BowlingTest {

    private static final String BOWLING_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_BOWLING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/main/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_BOWLING_CSV_FILE_TYPE = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostWkts.txt";
    private static final String BOWLING_CSV_FILE_WITH_WRONG_DELIMETER = "./src/test/resources/IPL2019FactsheetMostWktsDelimeter.csv";

    @Test
    public void givenBowlingCSVFile_ShouldReturnCSVFileData() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numOfRecords = cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_PATH);
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
            cricketAnalyzer.loadBowlingDataFile(WRONG_BOWLING_CSV_FILE_PATH);
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
            cricketAnalyzer.loadBowlingDataFile(WRONG_BOWLING_CSV_FILE_TYPE);
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
            cricketAnalyzer.loadBowlingDataFile(BOWLING_CSV_FILE_WITH_WRONG_DELIMETER);
        } catch (CricketAnalyzerException e) {
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }
}
