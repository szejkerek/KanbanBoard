package com.gordon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class CommandLineArgumentsTest {
    
    public CommandLineArgumentsTest() {
    }

    /**
     * Test of processArguments method, of class CommandLineArguments.
     */
    @Test
    public void testProcessArgumentsSetUserName() {
        System.out.println("testProcessArgumentsSetUserName");
        String expectedResult = "user";
        String[] args = {"-u", expectedResult, "-b", "board Name"};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        assertEquals(expectedResult,instance.getUserName());
    }
    
    @Test
    public void testProcessArgumentsSetBoardName() {
        System.out.println("testProcessArgumentsSetBoardName");
        String expectedResult = "board";
        String[] args = {"-u", "user", "-b", expectedResult};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        assertEquals(expectedResult, instance.getBoardName());
    }

    /**
     * Test of getBoardName method, of class CommandLineArguments.
     */
    @Test
    public void testGetBoardName() {
        System.out.println("getBoardName");
        String expectedResult = "board";
        String[] args = {"-u", "user", "-b", expectedResult};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertEquals(expectedResult,instance.getBoardName());
    }

    /**
     * Test of getUserName method, of class CommandLineArguments.
     */
    @Test
    public void testGetUserName() {
        System.out.println("testGetUserName");
        String expectedResult = "user";
        String[] args = {"-u", expectedResult, "-b", "user"};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertEquals(expectedResult,instance.getUserName());
    }

    /**
     * Test of hasGotBoardName method, of class CommandLineArguments.
     */
    @Test
    public void testHasGotBoardName() {
        System.out.println("testHasGotBoardName");
        String expectedResult = "board";
        String[] args = {"-u", "user", "-b", expectedResult};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertTrue(instance.hasGotBoardName());
    }
    
        @Test
    public void testHasGotNoneBoardName() {
        System.out.println("testHasGotBoardName with none board name");
        String boardName = "";
        String[] args = {"-u", "user"};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertFalse(instance.hasGotBoardName());
    }

    /**
     * Test of hasGotUserName method, of class CommandLineArguments.
     */
    @Test
    public void testHasGotUserName() {
        System.out.println("testHasGotUserName");
        String userName = "user";
        String[] args = {"-u", userName, "-b", "board"};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertTrue(instance.hasGotUserName());
    }
    
        /**
     * Test of hasGotUserName method, of class CommandLineArguments.
     */
    @Test
    public void testHasGotNoneUserName() {
        System.out.println("testHasGotUserName with none user name");
        String[] args = {"-b", "board"};
        
        CommandLineArguments instance = new CommandLineArguments();
        instance.processArguments(args);
        
        assertFalse(instance.hasGotUserName());
    }
    
}
