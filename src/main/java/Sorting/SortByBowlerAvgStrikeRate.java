package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByBowlerAvgStrikeRate implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(IplLeagueDAO::getBowlerAvg).thenComparing(IplLeagueDAO::getStrikeRate).reversed());
        return list;
    }
}
