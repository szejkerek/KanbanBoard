package com.gordon.controller;

import com.gordon.model.CommandLineArguments;
import com.gordon.model.User;
import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Controller {

    private final View view = new View();
    private final BoardController boardController = new BoardController();

    private final MenuController menuController = new MenuController(view);

    private User currentUser = null;

    public Controller(CommandLineArguments arg) {
        //Initialize other controllers
        initializeControllers();

        //Create user and ask for his credentials
        currentUser = new User(view);
        if (!arg.hasGotUserName()) {
            currentUser.askForUserName();
        } else {
            currentUser.setName(arg.getUserName());
        }
    }

    public void startApp() {
        menuController.startAppLoop();
    }

    private void initializeControllers() {
        boardController.init(this);
        menuController.init(this);
    }

    //Getters&Setters
    public BoardController getBoardController() {
        return boardController;
    }

    public MenuController getMenuController() {
        return menuController;
    }
}
