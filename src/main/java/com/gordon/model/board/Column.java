package com.gordon.model.board;

import com.gordon.model.board.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Column {

    private List<Task> tasks = null;
    private String columnName = "Empty column";

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Column(String _columnName) {
        columnName = _columnName;
        tasks = new ArrayList<Task>(0);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
