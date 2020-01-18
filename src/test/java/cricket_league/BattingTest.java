package cricket_league;

import CSVBuilder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BattingTest {

    private static final String BATTING_CSV_FILE_PATH = "/home/admin123/Documents/CricketLeagueAnalyzer/src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenBattingCSVFile_ShouldReturnCSVFileData() throws IOException, CSVBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int numOfRecords = cricketAnalyzer.loadBattingDataFile(BATTING_CSV_FILE_PATH);
        Assert.assertEquals(100, numOfRecords);
    }
}
