package com.gordon.view;

import java.util.Scanner;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class View {
    private MenuView menuView = new MenuView();
  
    public void showMessage(String message){
        System.out.println("Message " + message);
    }
    public String getResponseWithMessage(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    } 
    
    
    //Getters&Setters
    public MenuView getMenuView() {
        return menuView;
    }
}
