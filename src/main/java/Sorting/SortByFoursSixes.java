package Sorting;

import BattingDAO.IplLeagueDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByFoursSixes implements Sorting {

    @Override
    public List<IplLeagueDAO> getSort(List<IplLeagueDAO> list) {
        list.sort((player1,player2) -> ((player2.sixes * 6) + (player2.fours * 4)) - ((player1.sixes * 6) + (player1.fours * 4)));
//        Collections.reverse(list);
        return list;
    }
}
