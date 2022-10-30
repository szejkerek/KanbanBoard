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
        System.out.println("moveTask");
        fail("The test case is a prototype.");
    }

    @Test
    public void testMoveSameTask() {
        System.out.println("moveTask");
        fail("The test case is a prototype.");
    }

    @Test
    public void testMoveTaskToSameColums() {
        System.out.println("moveTask");
        fail("The test case is a prototype.");
    }

    @Test
    public void testMoveTaskToNonExsistentColumn() {
        System.out.println("moveTask");
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testMoveNullTask() {
        System.out.println("moveTask");
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of addColumn method, of class Board.
     */
    @Test
    public void testAddColumn() {
        System.out.println("addColumn");
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Board.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class Board.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardName method, of class Board.
     */
    @Test
    public void testGetBoardName() {
        System.out.println("getBoardName");
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardName method, of class Board.
     */
    @Test
    public void testSetBoardName() {
        System.out.println("setBoardName");
        fail("The test case is a prototype.");
    }

}
