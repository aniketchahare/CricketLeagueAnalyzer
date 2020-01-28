package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByRunsWickets implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(IplLeagueDAO::getRuns).thenComparing(IplLeagueDAO::getWickets).reversed());
        return list;
    }
}