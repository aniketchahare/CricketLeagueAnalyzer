package cricket_league;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CricketAnalyzer {
    public List<IPLBattingCSV> battingCSVList = new ArrayList<>();

    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            battingCSVList = csvBuilder.getCSVFileList(reader, IPLBattingCSV.class);
            System.out.println(battingCSVList.size());
            return battingCSVList.size();
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.IPL_BATTING_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }

    public List getAvgWiseSortedData() {
        battingCSVList=battingCSVList.stream()
                .sorted((data1,data2) -> data2.average - data1.average < 0 ? -1 : 1)
                .collect(Collectors.toList());
        for (int i=0 ; i < battingCSVList.size() ; i++){
            System.out.println(battingCSVList.get(i).average+" "+battingCSVList.get(i).player);
        }
        return battingCSVList;
    }
}