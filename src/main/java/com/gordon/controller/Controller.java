package com.gordon.controller;

import com.gordon.model.board.Board;
import com.gordon.model.CommandLineArguments;
import com.gordon.model.User;

import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Controller {
    private View view = new View();
    private MenuController menuController = new MenuController();
    private BoardController boardController = new BoardController();
    private User currentUser = null;


    public Controller(CommandLineArguments arg) { 
        //Create user and ask for his credentials
        currentUser = new User(view);
        if (!arg.hasGotUserName()) {
            currentUser.askForUserName();
        } else {
            currentUser.setName(arg.getUserName());
        }
    }

}
