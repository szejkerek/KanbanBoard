package com.gordon.controller;

import com.gordon.model.CommandLineArguments;
import com.gordon.model.User;
import com.gordon.view.View;
import java.util.Scanner;

/**
 * Main controller of the application.
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class Controller {

    /**
     * Main view of application.
     */
    private final View view = new View(this);

    /**
     * Sub-controller controlling Board.
     */
    private final BoardController boardController = new BoardController(this);

    /**
     * Sub-controller controlling Menu.
     */
    private final MenuController menuController = new MenuController(this);

    /**
     * User that is currently making changes to the board.
     */
    private User currentUser = new User();

    /**
     * Constructor of main controller, it asks for userName and boardName if it
     * wasn't specified in parameters.
     *
     * @param arg Command-line parameters passed to the application.
     */
    public Controller(CommandLineArguments arg) {
        //Ask for userName and boardName if user didnt specified it in parameters
        String userName = askForName(arg.hasGotUserName(), arg.getUserName(), "Enter your user name: ");
        String boardName = askForName(arg.hasGotBoardName(), arg.getBoardName(), "Enter your first board name: ");

        currentUser.setUserName(userName);
        boardController.createNewBoard(boardName);
    }

    /**
     * Starts the application with it's main menu loop.
     */
    public void startApp() {
        menuController.startAppLoop();
    }

    /**
     * Asks for the user input.
     *
     * @param message Message displayed before asking for user input.
     * @return Returns user input as string.
     */
    public String getStringResponseWithMessage(String message) {
        Scanner scanner = new Scanner(System.in);
        view.showMessage(message);
        return scanner.nextLine();
    }

    /**
     * Asks for the user input.
     *
     * @param message Message displayed before asking for user input.
     * @return Returns user input as integer.
     */
    public int getIntResponseWithMessage(String message) {
        Scanner scanner = new Scanner(System.in);
        view.showMessage(message);
        int number;
        try {
            number = Integer.parseInt(scanner.next());
        } catch (NumberFormatException ex) {
            number = -1;
        }
        return number;
    }

    /**
     * Wrapper for asking for missing parameters.
     *
     * @param isInParameters Check for situation if parameter was specified in
     * parameters.
     * @param parameterValue Parameter value from command-line arguments.
     * @param message Message displayed before asking for user input.
     */
    private String askForName(Boolean isInParameters, String parameterValue, String message) {
        String name;
        if (isInParameters) {
            return parameterValue;
        } else {
            do {
                name = getStringResponseWithMessage(message);
            } while (!validateName(name));
        }
        return name;
    }

    /**
     * Validate username to meet the requirements.
     */
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

    /**
     * Getter for main view.
     *
     * @return Main view.
     */
    public View getView() {
        return view;
    }

    /**
     * Getter for current user.
     *
     * @return Current user.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Setter for new current user.
     *
     * @param newUser New current user.
     */
    public void setCurrentUser(User newUser) {
        this.currentUser = newUser;
    }

    /**
     * Getter for board controller.
     *
     * @return board controller.
     */
    public BoardController getBoardController() {
        return boardController;
    }

    /**
     * Getter for menu controller.
     *
     * @return Menu controller.
     */
    public MenuController getMenuController() {
        return menuController;
    }
}
