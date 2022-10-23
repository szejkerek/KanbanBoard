package com.gordon.controller;

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
                response = view.getIntResponseWithMessage("Please make a selection [1-(????)]: ");
            } catch (NumberFormatException nfe) {
                view.showMessage("Message couldn't be parsed into number.");
                view.showMessage("Please try again!");

                continue;
            }
            processResponse(response);

        } while (!quitApp);

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
                break;
            case 5:
                break;
            case 6:
                controller.getBoardController().clearBoard();
                break;
            case 7:                
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
