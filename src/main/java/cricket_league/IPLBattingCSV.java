package cricket_league;

import com.opencsv.bean.CsvBindByName;

public class IPLBattingCSV {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "BF", required = true)
    public int ballFaced;

    @CsvBindByName(column = "SR", required = true)
    public String strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int hundred;

    @CsvBindByName(column = "50", required = true)
    public int fifty;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @Override
    public String toString() {
        return "IPLBattingCSV{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", average=" + average +
                ", ballFaced=" + ballFaced +
                ", strikeRate='" + strikeRate + '\'' +
                ", hundred=" + hundred +
                ", fifty=" + fifty +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }

}
