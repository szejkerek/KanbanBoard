package com.gordon.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of setUserName method, of class User.
     */
    @ParameterizedTest
    @ValueSource(strings = {"1213", "       9999(_)(&^%$#", "87654ffffffffffffffffffffffffffffffffffffffffffff321"})
    public void testSetUserName(String testValue) {
        System.out.println("setUserName");
        User instance = new User();
        instance.setUserName(testValue);
        assertEquals(testValue, instance.getUserName());
    }

    /**
     * Test of getUserName method, of class User.
     */
    @ParameterizedTest
    @ValueSource(strings = {"1213eewew", "       9999(_)(&^%$#", "87654321"})
    public void testGetUserName(String testValue) {
        System.out.println("getUserName");
        User instance = new User();
        instance.setUserName(testValue);
        assertEquals(testValue, instance.getUserName());
    }
    
}
