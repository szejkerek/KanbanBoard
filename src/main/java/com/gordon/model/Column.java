package com.gordon.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon
 */
public class Column {
    private String columnName = "Empty column";
    private List<Task> tasks = null;

    public void addTask(Task newTask){
        tasks.add(newTask);
    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    public Column(String _columnName){
        columnName = _columnName;
        tasks = new ArrayList<Task>(0);
    }
}
