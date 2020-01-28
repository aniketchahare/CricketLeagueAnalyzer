package cricket_league;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlingCSV {

    public IPLBowlingCSV() {
    }

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public Double over;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "Avg", required = true)
    public Double average;

    @CsvBindByName(column = "Econ", required = true)
    public Double econ;

    @CsvBindByName(column = "SR", required = true)
    public Double strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    public IPLBowlingCSV(int position, String player, int matches, int innings, double over, int runs, int wickets, int bbi, double avg, double econ, double strikeRate, int fourWickets, int fiveWickets) {

        this.pos = position;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.over = over;
        this.runs = runs;
        this.wickets = wickets;
        this.bbi = bbi;
        this.average = avg;
        this.econ = econ;
        this.strikeRate = strikeRate;
        this.fourWickets = fourWickets;
        this.fiveWickets = fiveWickets;
    }

    @Override
    public String toString() {
        return "IPLBowlingCSV{" +
                "pos=" + pos +
                ", playerName='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", over=" + over +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", average=" + average +
                ", econ=" + econ +
                ", strikeRate=" + strikeRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
