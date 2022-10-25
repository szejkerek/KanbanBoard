package com.gordon.controller;

import com.gordon.model.User;
import com.gordon.view.MenuView;
import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class MenuController {

    private View view = null;
    private MenuView menuView = null;
    private Controller controller = null;

    private Boolean quitApp = false;

    public MenuController(View _view) {
        view = _view;
        menuView = view.getMenuView();
    }

    public void init(Controller _controller) {
        controller = _controller;
    }

    public void startAppLoop() {

        int response;
        do {
            menuView.displayMainMenu();
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
    
    private void createNewUser()
    {
        User newUser = new User();
        newUser.setName(controller.getStringResponseWithMessage("Type your new user: "));
        controller.setCurrentUser(newUser);
    }

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
                break;
            case 6:
                controller.getBoardController().clearBoard();
                break;
            case 7:     
                createNewUser();
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
