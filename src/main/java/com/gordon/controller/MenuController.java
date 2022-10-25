package com.gordon.controller;

import com.gordon.model.User;
import com.gordon.view.View;

/**
 * Controller for the menu.
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class MenuController {

    /**
     * Main view of the application.
     */
    private final View view;

    /**
     * Main controller of the application.
     */
    private final Controller controller;

    /**
     * Variable that determines if the app should quit in current menu loop
     * iteration.
     */
    private Boolean quitApp = false;

    /**
     * Constructor for MenuController.
     *
     * @param _controller Main controller.
     */
    public MenuController(Controller _controller) {
        controller = _controller;
        view = controller.getView();
    }

    /**
     * Starts and manages main menu loop.
     */
    public void startAppLoop() {
        int response;
        do {
            view.getMenuView().displayMainMenu();
            try {
                response = controller.getIntResponseWithMessage("Please make a selection [0-7]: ");
            } catch (NumberFormatException nfe) {
                view.showMessage("Message couldn't be parsed into number.");
                view.showMessage("Please try again!");

                continue;
            }
            processResponse(response);

        } while (!quitApp);

    }

    /**
     * Wrapper for creating new user.
     */
    private void createNewCurrentUser() {
        User newUser = new User();
        newUser.setUserName(controller.getStringResponseWithMessage("Type your new user: "));
        controller.setCurrentUser(newUser);
    }

    /**
     * Processing response form startAppLoop() and choose appropriate function.
     */
    private void processResponse(int response) {
        switch (response) {
            case 1:
                controller.getBoardController().showBoard();
                break;
            case 2:
                controller.getBoardController().addTask();
                break;
            case 3:
                controller.getBoardController().addColumn();
                break;
            case 4:
                controller.getBoardController().moveTask();
                break;
            case 5:
                controller.getBoardController().changeBoardName();
                break;
            case 6:
                createNewCurrentUser();
                break;
            case 7:
                controller.getBoardController().clearBoard();
                break;
            case 0:
                view.showMessage("Quitting app...");
                quitApp = true;
                break;
            default:
                view.showMessage("Please make a valid selection.");
                break;
        }
    }
}
