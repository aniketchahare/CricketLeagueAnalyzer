package BattingDAO;

import cricket_league.IPLBattingCSV;
import cricket_league.IPLBowlingCSV;

public class IplLeagueDAO {
    public int position;
    public String player;
    public int matches;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public Double avg;
    public int ballFaced;
    public Double strikeRate;
    public int hundred;
    public int fifty;
    public int fours;
    public int sixes;

    public Double over;
    public int wickets;
    public int bbi;
    public Double econ;
    public int fourWickets;
    public int fiveWickets;

    public IplLeagueDAO() {
    }

    public IplLeagueDAO(IPLBattingCSV iplBattingCSV) {
        position = iplBattingCSV.pos;
        player = iplBattingCSV.player;
        matches = iplBattingCSV.match;
        inns = iplBattingCSV.innings;
        notOut = iplBattingCSV.notOut;
        runs = iplBattingCSV.runs;
        highScore = iplBattingCSV.highScore;
        avg = iplBattingCSV.average;
        ballFaced = iplBattingCSV.ballFaced;
        strikeRate = iplBattingCSV.strikeRate;
        hundred = iplBattingCSV.hundred;
        fifty = iplBattingCSV.fifty;
        fours = iplBattingCSV.fours;
        sixes = iplBattingCSV.sixes;
    }

    public IplLeagueDAO(IPLBowlingCSV iplBowlingCSV) {
        position = iplBowlingCSV.pos;
        player = iplBowlingCSV.player;
        matches = iplBowlingCSV.matches;
        inns = iplBowlingCSV.innings;
        over = iplBowlingCSV.over;
        runs = iplBowlingCSV.runs;
        wickets = iplBowlingCSV.wickets;
        bbi = iplBowlingCSV.bbi;
        avg = iplBowlingCSV.average;
        econ = iplBowlingCSV.econ;
        strikeRate = iplBowlingCSV.strikeRate;
        fourWickets = iplBowlingCSV.fourWickets;
        fiveWickets = iplBowlingCSV.fiveWickets;
    }

    public IPLBattingCSV getIplDto(){
        return new IPLBattingCSV (position ,
                player , matches, inns,notOut , runs, highScore , avg, ballFaced,
                strikeRate,   hundred , fifty, fours ,sixes);
    }

    public int getPosition() {
        return position;
    }

    public String getPlayer() {
        return player;
    }

    public int getMatches() {
        return matches;
    }

    public int getInns() {
        return inns;
    }

    public int getNotOut() {
        return notOut;
    }

    public int getRuns() {
        return runs;
    }

    public String getHighScore() {
        return highScore;
    }

    public double getAvg() {
        return avg;
    }

    public int getBallFaced() {
        return ballFaced;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getHundred() {
        return hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public double getOver() {
        return over;
    }

    public int getWickets() {
        return wickets;
    }

    public int getBbi() {
        return bbi;
    }

    public double getEcon() {
        return econ;
    }

    public int getFourWickets() {
        return fourWickets;
    }

    public int getFiveWickets() {
        return fiveWickets;
    }

    @Override
    public String toString() {
        return "IplLeagueDAO{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", avg=" + avg +
                ", ballFaced=" + ballFaced +
                ", strikeRate=" + strikeRate +
                ", hundred=" + hundred +
                ", fifty=" + fifty +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", over=" + over +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", econ=" + econ +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}

