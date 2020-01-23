package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByStrikeRateFoursSixes implements Sorting {

    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(iplLeagueDAO -> {
            double strikeRate = ((iplLeagueDAO.fours * 4) + (iplLeagueDAO.sixes * 6))*100 / iplLeagueDAO.ballFaced;
            return strikeRate;
        }));
        Collections.reverse(list);
//        Comparator<IplLeagueDAO> comparatorFourSix = (IplLeagueDAO iplLeagueDAO1,IplLeagueDAO iplLeagueDAO2)   ->
//           ((iplLeagueDAO2.fours * 4) + (iplLeagueDAO2.sixes * 6)) - ((iplLeagueDAO1.fours * 4) + iplLeagueDAO1.sixes * 6);
//        Comparator<IplLeagueDAO> comparatorStrikingRate = (IplLeagueDAO iplLeagueDAO1,IplLeagueDAO iplLeagueDAO2) -> (int) (iplLeagueDAO2.strikeRate - iplLeagueDAO1.strikeRate);
//        list.sort(comparatorFourSix.thenComparing(comparatorStrikingRate));
        return list;
    }
}
