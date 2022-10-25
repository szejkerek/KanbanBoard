package com.gordon.view;

import com.gordon.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class View {

    private Controller controller;
    private MenuView menuView = new MenuView(this);
    private BoardView boardView = new BoardView(this);

    public View(Controller _controller)
    {
        controller = _controller;
    }
    public Boolean showWarning(String action) {
        showMessage("Are you sure to " + action);
        return confirmationMessage();
    }

    public Boolean confirmationMessage() {
        String response = controller.getStringResponseWithMessage("Type \"yes\" or \"no\": ");
        response.toLowerCase();

        return (response.equals("yes") || response.equals("y"));
    }

    public void showMessage(String message) {
        System.out.println(message);
    }


    //Getters&Setters
    public MenuView getMenuView() {
        return menuView;
    }

    public BoardView getBoardView() {
        return boardView;
    }
}
