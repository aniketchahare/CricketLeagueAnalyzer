package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByAvgBowler implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(iplLeagueDAO -> iplLeagueDAO.bowlerAvg));
        Collections.reverse(list);
        return list;
    }
}
