package cricket_league;

import org.junit.Assert;
import org.junit.Test;

public class BattingTest {

    private static final String BATTING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenBattingCSVFile_ShouldReturnCSVFileData() {
        try {
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            int numOfRecords = cricketAnalyzer.loadBattingDataFile(BATTING_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);
        } catch (CricketAnalyzerException e){ }
    }
}
