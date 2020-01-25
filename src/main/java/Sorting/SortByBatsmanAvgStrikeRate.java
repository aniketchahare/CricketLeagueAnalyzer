package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByBatsmanAvgStrikeRate implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
       list.sort(Comparator.comparing(IplLeagueDAO::getBatsmanAvg).thenComparing(IplLeagueDAO::getStrikeRate).reversed());
       return list;
    }
}
