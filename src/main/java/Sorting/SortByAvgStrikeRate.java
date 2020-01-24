package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByAvgStrikeRate implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
       list.sort(Comparator.comparing(IplLeagueDAO::getAvg).thenComparing(IplLeagueDAO::getStrikeRate).reversed());
       return list;
    }
}
