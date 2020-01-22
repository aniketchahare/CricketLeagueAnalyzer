package Sorting;

public enum SortMode {
    AVG(new SortByAvg()), STRIKERATE(new SortByStrikeRate()), FOURS_SIXES(new SortByFoursSixes()), ;

    public Sorting sortMode;

    SortMode(Sorting sorting) {
        this.sortMode = sorting;
    }
}
