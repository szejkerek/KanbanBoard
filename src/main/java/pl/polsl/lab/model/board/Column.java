package pl.polsl.lab.model.board;

import java.util.ArrayList;
import java.util.List;
import pl.pols.lab.services.PersistentData;

/**
 * Class implementing the column. 
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.1
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

    public Boolean contains(String taskName)
    {
        for(var task : getTasks())
        {
            if(taskName.equals(task.getTaskName()))
            {
               return true;
            }
        }
        return false;
    }
    
    /**
     * Remove task from list.
     *
     * @param task Task to be removed.
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }
    
    public void removeTask(String taskName) {
       PersistentData.getInstance().deleteTask(taskName);

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
     * @param _columnName Column name.
     */
    public void setColumnName(String _columnName) {
        columnName = _columnName;
    }

    /**
     * Add new task to column.
     *
     * @param newTask New task to be added to the column.
     */
    public void addTask(Task newTask) {
        tasks.add(newTask);
    }
    
    public void addTask(String title, String description) {
        PersistentData.getInstance().insertTask(title, description, columnName);
    }

    /**
     * Getter for the list of tasks.
     *
     * @return List of tasks.
     */
    public List<Task> getTasks() {
        return PersistentData.getInstance().selectTasks(columnName);
    }

}
