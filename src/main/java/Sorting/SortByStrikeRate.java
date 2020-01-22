package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByStrikeRate implements Sorting {
    @Override
    public List getSort(List<IplLeagueDAO> list) {
        list.sort(Comparator.comparing(iplLeagueDAO -> iplLeagueDAO.strikeRate));
        Collections.reverse(list);
        return list;
    }
}
