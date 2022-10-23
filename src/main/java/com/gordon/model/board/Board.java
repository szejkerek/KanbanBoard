package com.gordon.model.board;

import com.gordon.model.ItemAlreadyExsistException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Board {

    private String boardName;
    private List<Column> columns = null;

    public Board(String _boardName) {
        boardName = _boardName;
        columns = new ArrayList<Column>();
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public void addTask(Task task, Column collumn) throws ItemAlreadyExsistException {
        for (Column c : columns) {
            for (Task t : c.getTasks()) {
                if (t.getTaskName().equals(task.getTaskName())) {
                    throw new ItemAlreadyExsistException("Task with this name already exist on board!");
                }
            }
        }
        for (Column c : columns) {
            if (c.equals(collumn)) {
                c.addTask(task);
            }
        }
    }

    public void addColumn(Column collumn) throws ItemAlreadyExsistException {
        for (Column c : columns) {
            if (c.getColumnName().equals(collumn.getColumnName())) {
                throw new ItemAlreadyExsistException("Column with this name already exist!");
            }
        }
        columns.add(collumn);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Boolean isEmpty() {
        return (columns.size() == 0);
    }

}
