package cricket_league;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CricketAnalyzer {
    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IPLBattingCSV> battingCSVList = csvBuilder.getCSVFileList(reader, IPLBattingCSV.class);
            return battingCSVList.size();
        } catch (IOException e){
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.BATTING_CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        }
    }
}