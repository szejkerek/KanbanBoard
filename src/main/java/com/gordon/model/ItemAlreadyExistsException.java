package com.gordon.model;

/**
 * Exception for already existing items.
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class ItemAlreadyExistsException extends Exception {

    /**
     * Constructor for exception.
     *
     * @param message Message that displays when exception occur.
     */
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
