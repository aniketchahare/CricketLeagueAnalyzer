package Sorting;

public enum SortMode {
    AVG_BATSMAN(new SortByAvgBatsman()),
    AVG_BOWLER(new SortByAvgBowler()),

    STRIKERATE(new SortByStrikeRate()),
    FOURS_SIXES(new SortByFoursSixes()),
    STRIKERATE_FOURS_SIXES(new SortByStrikeRateFoursSixes()),

    BATSMAN_AVERAGES_STRIKERATE(new SortByBatsmanAvgStrikeRate()),
    BOWLER_AVERAGES_STRIKERATE(new SortByBowlerAvgStrikeRate()),

    RUNS_AVERAGES(new SortByRunsAvgs()),
    ECONOMY(new SortByEconomy()),
    STRIKERATE_FIVE_FOUR_WKTS(new SortByStrikeRateFiveFourWkts()),
    WICKETS_AVERAGES(new SortByWktsAvgs()),
    BATTING_BOWLING_AVERAGE(new SortByBattingBowlingAvg());

    public Sorting sortMode;

    SortMode(Sorting sorting) {
        this.sortMode = sorting;
    }
}
