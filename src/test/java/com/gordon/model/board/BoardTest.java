package com.gordon.model.board;

import com.gordon.model.ItemAlreadyExistsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class BoardTest {

    public BoardTest() {
    }

    /**
     * Test of addTask method, of class Board.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Board board = new Board("name");
        Column column = new Column("Column");
        Task newTask = new Task("Task", "new task");

        try {
            board.addColumn(column);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        Boolean found = false;
        for (Column c : board.getColumns()) {
            if (c.getTasks().contains(newTask)) {
                found = true;
            }
        }
        assertTrue(found);
    }

    /**
     * Test of addTask method, of class Board adding the same task.
     */
    @Test
    public void testAddTaskAlreadyInCollumn() {
        System.out.println("addTask");
        Board board = new Board("name");
        Column column = new Column("Column");
        Task newTask = new Task("Task", "new task");

        try {
            board.addColumn(column);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");

        }

        ItemAlreadyExistsException e = assertThrows(
                ItemAlreadyExistsException.class,
                () -> board.addTask(newTask, column));
        assertEquals("Task with this name already exist on board!", e.getMessage());
    }

    /**
     * Test of moveTask method, of class Board.
     */
    @Test
    public void testMoveTask() {
        System.out.println("addTask");
        Board board = new Board("name");
        Column column = new Column("Column");
        Column column2 = new Column("Column2");
        
        Task newTask = new Task("Task", "new task");
        
        try {
            board.addColumn(column);
            board.addColumn(column2);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        
        board.moveTask(newTask, 0, 1);

        assertEquals(board.getColumns().get(1).getTasks().get(0), newTask);    
    }

    /**
     * Test of moveTask method, of class Board move to the same column.
     */
    @Test
    public void testMoveTaskToTheSameColumn() {
        System.out.println("addTask");
        Board board = new Board("name");
        Column column = new Column("Column");
        Column column2 = new Column("Column2");
        
        Task newTask = new Task("Task", "new task");
        
        try {
            board.addColumn(column);
            board.addColumn(column2);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        
        board.moveTask(newTask, 0, 0);

        assertEquals(board.getColumns().get(0).getTasks().get(0), newTask);    
    }

     /**
     * Test of moveTask method, of class Board.
     */
    @Test
    public void testMoveTaskToNonExsistentColumn() {
        System.out.println("addTask");
        Board board = new Board("name");
        Column column = new Column("Column");
        Column column2 = new Column("Column2");
        
        Task newTask = new Task("Task", "new task");
        
        try {
            board.addColumn(column);
            board.addColumn(column2);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        
        board.moveTask(newTask, 0, 0);

        assertEquals(board.getColumns().get(0).getTasks().get(0), newTask);  
    }
    
    /**
     * Test of addColumn method, of class Board.
     */
    @Test
    public void testAddColumn() {
        System.out.println("testAddColumn");
        Board board = new Board("name");
        Column column = new Column("Column");
        
        try {
            board.addColumn(column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }

        assertEquals(board.getColumns().get(0), column);  
    }

    /**
     * Test of isEmpty method, of class Board.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("testIsEmpty");
        Board board = new Board("name");
        Column column = new Column("Column");
        
        Task newTask = new Task("Task");
        
        try {
            board.addColumn(column);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        assertEquals(board.getColumns().get(0).getTasks().get(0).getContent(), "");  
    }
    
     /**
     * Test of hasConntent method, of class Board.
     */
    @Test
    public void testHasContent() {
        System.out.println("testIsEmpty");
        Board board = new Board("name");
        Column column = new Column("Column");
        
        Task newTask = new Task("Task");
        
        try {
            board.addColumn(column);
            board.addTask(newTask, column);
        } catch (ItemAlreadyExistsException e) {
            fail("Exception was caught.");
        }
        assertFalse(board.getColumns().get(0).getTasks().get(0).hasContent());  
    }
}
