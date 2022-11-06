package com.gordon.model.board;

import com.gordon.model.ItemAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the board.
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.2
 */
public class Board {

    /**
     * Board name.
     */
    private String boardName;

    /**
     * List of columns present in board.
     */
    private List<Column> columns = null;

    /**
     * Constructor for board.
     *
     * @param _boardName Board name.
     */
    public Board(String _boardName) {
        boardName = _boardName;
        columns = new ArrayList<Column>();
    }

    /**
     * Add task to specific column.
     *
     * @param task Task that we want to add to board.
     * @param collumn Column that is parent to the task.
     * @throws com.gordon.model.ItemAlreadyExistsException Thrown when task we
     * want to add already exists on board.
     */
    public void addTask(Task task, Column collumn) throws ItemAlreadyExistsException {
        for (Column c : columns) {
            for (Task t : c.getTasks()) {
                if (t.getTaskName().equals(task.getTaskName())) {
                    throw new ItemAlreadyExistsException("Task with this name already exist on board!");
                }
            }
        }
        for (Column c : columns) {
            if (c.equals(collumn)) {
                c.addTask(task);
            }
        }
    }

    /**
     * Move task between columns.
     *
     * @param _task Task that we want to move.
     * @param _fromID ID of a column we want to move the task from.
     * @param _toID ID of a column we want to move the task to.
     */
    public void moveTask(Task _task, int _fromID, int _toID) {
        if (!columns.get(_fromID).getTasks().contains(_task)) {
            return;
        }
        columns.get(_fromID).removeTask(_task);
        columns.get(_toID).addTask(_task);
    }

    /**
     * Add column to the board.
     *
     * @param column Column that we want to add.
     * @throws com.gordon.model.ItemAlreadyExistsException Thrown when column we
     * want to add already exists on board.
     */
    public void addColumn(Column column) throws ItemAlreadyExistsException {
        for (Column c : columns) {
            if (c.getColumnName().equals(column.getColumnName())) {
                throw new ItemAlreadyExistsException("Column with this name already exist!");
            }
        }
        columns.add(column);
    }

    /**
     * Function to change if list of columns is empty.
     *
     * @return True if board is empty, false otherwise.
     */
    public Boolean isEmpty() {
        return columns.isEmpty();
    }

    /**
     * Getter for the list of columns.
     *
     * @return List of columns.
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Getter for board name.
     *
     * @return Board name.
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * Setter for board name.
     *
     * @param boardName New board name.
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
