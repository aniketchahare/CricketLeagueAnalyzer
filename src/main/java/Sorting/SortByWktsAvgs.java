package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByWktsAvgs implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(IplLeagueDAO::getWickets).thenComparing(IplLeagueDAO::getAvg).reversed());
        return list;
    }
}
