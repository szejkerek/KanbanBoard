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
    public String getStringResponseWithMessage(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    } 
    public int getIntResponseWithMessage(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int number = Integer.parseInt(scanner.next());      
 
        return number;
    } 
    
    //Getters&Setters
    public MenuView getMenuView() {
        return menuView;
    }
}
