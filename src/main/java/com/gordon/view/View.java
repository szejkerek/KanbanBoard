package com.gordon.view;

import java.util.Scanner;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class View {

    private MenuView menuView = new MenuView(this);
    private BoardView boardView = new BoardView(this);

    public Boolean showWarning(String action) {
        showMessage("Are you sure to " + action);
        return confirmationMessage();
    }

    public Boolean confirmationMessage() {
        String response = getStringResponseWithMessage("Type \"yes\" or \"no\": ");
        response.toLowerCase();

        return (response.equals("yes") || response.equals("y"));
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getStringResponseWithMessage(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public int getIntResponseWithMessage(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int number;
        try{
            number = Integer.parseInt(scanner.next());
        }
        catch(NumberFormatException ex)
        {
            number = 0;
        }
        return number;
    }

    //Getters&Setters
    public MenuView getMenuView() {
        return menuView;
    }

    public BoardView getBoardView() {
        return boardView;
    }
}
