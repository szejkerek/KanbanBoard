package com.gordon.model.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class ColumnTest {
    
    public ColumnTest() {
    }
    
    /**
     * Test of removeTask method, of class Column.
     */
    @Test
    public void testRemoveTask() {
        Column c = new Column("Column");
        Task t = new Task("Task");
        c.addTask(t);
        c.removeTask(t);
        
        assertEquals(0, c.getTasks().size());     
    }
    
     /**
     * Test of removeTask method, of class Column.
     */
    @Test
    public void testRemoveTaskNotInColumn() {
        Column c = new Column("Column");
        Task t = new Task("Task");
        Task fakeTask = new Task("Task");

        c.addTask(t);
        c.removeTask(fakeTask);
        
        assertEquals(1, c.getTasks().size());  
    }

    /**
     * Test of addTask method, of class Column.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Column c = new Column("Column");
        Task t = new Task("Task");

        c.addTask(t);
        
        assertEquals(1, c.getTasks().size());  
    }

}
