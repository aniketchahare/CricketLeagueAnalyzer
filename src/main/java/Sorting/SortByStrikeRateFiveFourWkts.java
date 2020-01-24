package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByStrikeRateFiveFourWkts implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(IplLeagueDAO::getStrikeRate).thenComparing(IplLeagueDAO::getFiveWickets).thenComparing(IplLeagueDAO::getFourWickets).reversed());
        return list;
    }
}
