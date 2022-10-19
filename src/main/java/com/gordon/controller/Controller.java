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
    private final BoardController boardController = new BoardController(view);
    private final MenuController menuController = new MenuController(view);
    
    private User currentUser = null;
    
    public Controller(CommandLineArguments arg) {
        //Initialize other controllers
        initializeControllers();

        //Create user and ask for his credentials

        System.out.println(arg.hasGotUserName() + arg.getUserName());
        System.out.println(arg.hasGotBoardName() + arg.getBoardName());

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
    
    private String askForName(Boolean isInParameters, String parameterName, String message) {
        String name;
        if (isInParameters) {
            return parameterName;
        } else {
            do {
                name = view.getStringResponseWithMessage(message);
            } while (!validateName(name));
        }
        return name;
    }
    
    private Boolean validateName(String userName) {
        if (userName.length() == 0) {
            view.showMessage("Name cannot be empty");
            return false;
        } else if (userName.length() > 25) {
            view.showMessage("Name cannot be longer than 25 characters");
            return false;
        } else {
            //Name passed all cases
            return true;
        }
    }
}
