package cricket_league;

import BattingDAO.IplLeagueDAO;

import java.util.List;

public class CricketAdapterFactory {
    public List<IplLeagueDAO> getFileData(CricketAnalyzer.CSVFileType csvFileType,
                                          String... csvFilePath) throws CricketAnalyzerException {
        if (csvFileType.equals(CricketAnalyzer.CSVFileType.BATTING))
            return new IPLBattingAdapter().loadFileData(csvFilePath);
        if (csvFileType.equals(CricketAnalyzer.CSVFileType.BOWLING))
            return new IPLBowlingAdapter().loadFileData(csvFilePath);
        throw new CricketAnalyzerException("Unknown Data", CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);

    }
}
