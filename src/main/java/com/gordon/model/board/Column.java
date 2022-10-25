package com.gordon.model.board;

import com.gordon.model.board.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the column. 
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class Column {

    /**
     * List of tasks that are in the column.
     */
    private List<Task> tasks = null;

    /**
     * Column name.
     */
    private String columnName = "Default column";

    /**
     * Constructor for the column.
     *
     * @param _columnName Column name.
     */
    public Column(String _columnName) {
        columnName = _columnName;
        tasks = new ArrayList<Task>(0);
    }

    /**
     * Remove task from list.
     *
     * @param task Task to be removed.
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Getter for column name.
     *
     * @return Column name.
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Setter for column name.
     *
     * @param columnName Column name.
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Add new task to column.
     *
     * @param newTask New task to be added to the column.
     */
    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    /**
     * Getter for the list of tasks.
     *
     * @return List of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

}
