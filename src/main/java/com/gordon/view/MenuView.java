package com.gordon.view;

/**
 * View for the menu.
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class MenuView {

    /**
     * Print main menu on screen.
     */
    public void displayMainMenu() {
        System.out.println("\n######MENU######");
        System.out.println("1. Show board");
        System.out.println("2. Add task");
        System.out.println("3. Add column");
        System.out.println("4. Move task");
        System.out.println("5. Change board name");
        System.out.println("6. Change user");
        System.out.println("7. Clear board");
        System.out.println("0. Exit");
    }
}
