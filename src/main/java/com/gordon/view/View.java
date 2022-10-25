package com.gordon.view;

import com.gordon.controller.Controller;

/**
 * Main view of the application.
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class View {

    /**
     * Main controller.
     */
    private final Controller controller;

    /**
     * Menu view.
     */
    private final MenuView menuView = new MenuView();

    /**
     * Board view.
     */
    private final BoardView boardView = new BoardView();

    /**
     *
     * @param _controller
     */
    public View(Controller _controller) {
        controller = _controller;
    }

    /**
     * Prints warning on screen.
     *
     * @param action Warning message displayed on screen.
     * @return Check user accepted warning.
     */
    public Boolean showWarning(String action) {
        showMessage("Are you sure to " + action);
        return confirmationMessage();
    }

    /**
     * Display confirmation message on screen.
     *
     * @return Check user accepted question.
     */
    public Boolean confirmationMessage() {
        String response = controller.getStringResponseWithMessage("Type \"yes\" or \"no\": ");
        String toLowerCase = response.toLowerCase();

        return (toLowerCase.equals("yes") || toLowerCase.equals("y"));
    }

    /**
     * Prints message on screen.
     *
     * @param message Message.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Getter for menu view.
     *
     * @return Main view.
     */
    public MenuView getMenuView() {
        return menuView;
    }

    /**
     * Getter for board view.
     *
     * @return Board view.
     */
    public BoardView getBoardView() {
        return boardView;
    }
}
