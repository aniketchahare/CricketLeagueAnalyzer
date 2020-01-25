package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Comparator;
import java.util.List;

public class SortByRunsAvgs implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(IplLeagueDAO::getRuns).thenComparing(IplLeagueDAO::getBatsmanAvg).reversed());
        return list;
    }
}