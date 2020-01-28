package cricket_league;

import BattingDAO.IplLeagueDAO;

import java.util.ArrayList;
import java.util.List;

public class CricketAdapterFactory {
    public List<IplLeagueDAO> battingList = new ArrayList<>();
    public List<IplLeagueDAO> playerList = new ArrayList<>();

    public List<IplLeagueDAO> getFileData(CricketAnalyzer.CSVFileType csvFileType,
                                          String... csvFilePath) throws CricketAnalyzerException {
        if (csvFileType.equals(CricketAnalyzer.CSVFileType.BATTING)) {
            return new IPLBattingAdapter().loadFileData(csvFilePath[0]);
        }
        if (csvFileType.equals(CricketAnalyzer.CSVFileType.BOWLING)) {
            return new IPLBowlingAdapter().loadFileData(csvFilePath[0]);
        }
        if (csvFileType.equals(CricketAnalyzer.CSVFileType.INNING)) {
            battingList = new IPLBattingAdapter().loadFileData(csvFilePath[0]);
            new IPLBowlingAdapter().loadFileData(csvFilePath[1]).forEach(player -> {
                battingList.forEach(batsman -> {
                    if ( batsman.playerName.equals(player.playerName)){
                        batsman.bowlerAvg = player.bowlerAvg;
                        playerList.add(batsman);
                    }
                });
            });
        }
        return playerList;

//        throw new CricketAnalyzerException("Unknown Data", CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
    }
}
