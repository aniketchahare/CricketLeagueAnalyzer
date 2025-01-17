package cricket_league;

public class CricketAnalyzerException extends Exception {

    enum ExceptionType {
        IPL_BATTING_FILE_PROBLEM, INCORRECT_FILE_DATA, NO_DATA_FOUND, IPL_BOWLING_FILE_PROBLEM;
    }
    ExceptionType type;

    public CricketAnalyzerException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
