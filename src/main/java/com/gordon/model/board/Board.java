package com.gordon.model.board;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Board {

    String boardName;
    private List<Column> columns = null;

    public Board(String _boardName) {
        boardName = _boardName;
        columns = new ArrayList<Column>();
    }

    public void addColumn(Column collumn) {
        columns.add(collumn);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Boolean isEmpty() {
        return (columns.size() == 0);
    }
}
