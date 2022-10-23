package com.gordon.model;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class ItemAlreadyExsistException extends Exception {

    public ItemAlreadyExsistException(String message) {
        super(message);
    }
}
