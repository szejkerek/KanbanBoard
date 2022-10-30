package com.gordon.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class processing command-line arguments.
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class CommandLineArguments {

    /**
     * Name of the board passed by parameter.
     */
    private String boardName = "";
    /**
     * Name of the user passed my parameters.
     */
    private String userName = "";

    /**
     * User name switch.
     */
    private final String userNameSwitch = "-u";

    /**
     * Board name switch.
     */
    private final String boardNameSwitch = "-b";

    /**
     * List of all parameters present in application.
     */
    private final List<String> allParameters = new ArrayList();

    /**
     * Arguments passed by command-line parameters.
     */
    private String[] arguments;

    /**
     * Current index of iteration on parameters.
     */
    private int currentIndex = 0;

    /**
     * Constructor that adds all switches to allParameters list.
     */
    public CommandLineArguments() {
        allParameters.add(userNameSwitch);
        allParameters.add(boardNameSwitch);
    }

    /**
     * Processing arguments passed in command-line arguments.
     *
     * @param args Command-line arguments.
     */
    public void processArguments(String[] args) {
        arguments = args;
        if (arguments.length == 0) {
            return;
        }

        //Process strings in argumets
        findUserName();
        findBoardName();
       
    }

    /**
     * Find userName in parameters and set it as private class field.
     */
    private void findUserName() {
        userName = findStringInParameters(userNameSwitch);
    }

    /**
     * Find boardName in parameters and set it as private class field.
     */
    private void findBoardName() {
        boardName = findStringInParameters(boardNameSwitch);
    }

    /**
     * Finds string value in parameters with given switch.
     *
     * @param parameterSwitch Specific parameter switch.
     */
    private String findStringInParameters(String parameterSwitch) {

        String tempString = "";
        currentIndex = 0;
        while (!arguments[currentIndex].equals(parameterSwitch)) {
            currentIndex++;
            if (currentIndex >= arguments.length) {
                return "";
            }
        }
        if (currentIndex + 1 < arguments.length) {
            currentIndex++;
            while (!allParameters.contains(arguments[currentIndex])) {
                tempString = mergeStrings(tempString, arguments[currentIndex], " ");
                currentIndex++;
                if (currentIndex >= arguments.length && !tempString.equals("")) {
                    return tempString;
                } else if (currentIndex >= arguments.length) {
                    return tempString;
                }
            }
        }
        return tempString;
    }

    /**
     * Merge two string together with given spacer between.
     *
     * @param a First string.
     * @param b Second string.
     * @param between Spacer between.
     */
    private String mergeStrings(String a, String b, String between) {
        return a + between + b;
    }

    /**
     * Getter for board name.
     *
     * @return Board name.
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * Getter for user name.
     *
     * @return User name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Function checking if board name was specified in command-line arguments.
     * @return True if board name was specified, false otherwise.
     */
    public Boolean hasGotBoardName() {
        return !boardName.equals("");
    }

    /**
     * Function checking if user name was specified in command-line arguments.
     * @return True if user name was specified, false otherwise.
     */
    public Boolean hasGotUserName() {
        return !userName.equals("");
    }   
    
    public void showHelp(){
       System.out.println("Command-line arguments: -b [board name] -u [user name]");
    }
}
