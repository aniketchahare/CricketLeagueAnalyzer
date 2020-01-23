package Sorting;

public enum SortMode {
    AVG(new SortByAvg()),
    STRIKERATE(new SortByStrikeRate()),
    FOURS_SIXES(new SortByFoursSixes()),
    STRIKERATE_FOURS_SIXES(new SortByStrikeRateFoursSixes()),
    AVERAGES_STRIKERATE(new SortByAvgStrikeRate()),
    RUNS_AVERAGES(new SortByRunsAvgs());

    public Sorting sortMode;

    SortMode(Sorting sorting) {
        this.sortMode = sorting;
    }
}
