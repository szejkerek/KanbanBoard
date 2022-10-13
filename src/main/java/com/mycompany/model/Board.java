package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon
 */
public class Board {
    String boardName;
    private List<Column> columns = null;
    
    public Board(int numberOfColumns, String _boardName){
        boardName = _boardName;
        columns = new ArrayList<Column>(numberOfColumns);
    }
    
    public void addColumn(Column collumn){
        columns.add(collumn);
    }
    
    public List<Column> getColumns() {
        return columns;
    }
}
