/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.pols.lab.services;

import pl.polsl.lab.model.board.Column;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class PersistentData {

    Column toDo = new Column("toDo");

    Column inProgress = new Column("inProgress");
    Column done = new Column("done");

    private static PersistentData INSTANCE;

    public static PersistentData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersistentData();
        }
        return INSTANCE;
    }

    public Column getToDo() {
        return toDo;
    }

    public Column getInProgress() {
        return inProgress;
    }

    public Column getDone() {
        return done;
    }
}
