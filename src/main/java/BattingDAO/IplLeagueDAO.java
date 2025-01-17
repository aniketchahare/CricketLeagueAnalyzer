package BattingDAO;

import cricket_league.IPLBattingCSV;
import cricket_league.IPLBowlingCSV;

public class IplLeagueDAO {
    public int position;
    public String playerName;
    public int matches;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public Double batsmanAvg;
    public int ballFaced;
    public Double strikeRate;
    public int hundred;
    public int fifty;
    public int fours;
    public int sixes;

    public Double bowlerAvg;
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
        playerName = iplBattingCSV.player;
        matches = iplBattingCSV.match;
        inns = iplBattingCSV.innings;
        notOut = iplBattingCSV.notOut;
        runs = iplBattingCSV.runs;
        highScore = iplBattingCSV.highScore;
        batsmanAvg = iplBattingCSV.average;
        ballFaced = iplBattingCSV.ballFaced;
        strikeRate = iplBattingCSV.strikeRate;
        hundred = iplBattingCSV.hundred;
        fifty = iplBattingCSV.fifty;
        fours = iplBattingCSV.fours;
        sixes = iplBattingCSV.sixes;
    }

    public IplLeagueDAO(IPLBowlingCSV iplBowlingCSV) {
        position = iplBowlingCSV.pos;
        playerName = iplBowlingCSV.player;
        matches = iplBowlingCSV.matches;
        inns = iplBowlingCSV.innings;
        over = iplBowlingCSV.over;
        runs = iplBowlingCSV.runs;
        wickets = iplBowlingCSV.wickets;
        bbi = iplBowlingCSV.bbi;
        bowlerAvg = iplBowlingCSV.average;
        econ = iplBowlingCSV.econ;
        strikeRate = iplBowlingCSV.strikeRate;
        fourWickets = iplBowlingCSV.fourWickets;
        fiveWickets = iplBowlingCSV.fiveWickets;
    }

    public IPLBattingCSV getIplDto(){
        return new IPLBattingCSV (position ,
                playerName, matches, inns,notOut , runs, highScore , batsmanAvg, ballFaced,
                strikeRate,   hundred , fifty, fours ,sixes);
    }

    public int getPosition() {
        return position;
    }

    public String getPlayerName() {
        return playerName;
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

    public double getBatsmanAvg() {
        return batsmanAvg;
    }

    public double getBowlerAvg() {
        return bowlerAvg;
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
                ", playerName='" + playerName + '\'' +
                ", matches=" + matches +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", batsmanAvg=" + batsmanAvg +
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

