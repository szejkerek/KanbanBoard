package com.gordon.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
//
public class CommandLineArguments {

    //Content of arguments
    private String boardName = "";
    private String userName = "";

    //Parameters indexes 
    private final String userNameParameter = "-u";
    private final String boardParameter = "-b";

    //Remeber to add newly added parameters to this list inside constructor
    private final List<String> allParameters = new ArrayList();

    //Fields needed to iterate through argumets 
    private String[] arguments;
    private int currentIndex = 0;

    public CommandLineArguments() {
        allParameters.add(userNameParameter);
        allParameters.add(boardParameter);
    }

    public void processArguments(String[] args) {
        arguments = args;
        if (arguments.length == 0) {
            return;
        }

        //Process strings in argumets
        findUserName();
        findBoardName();
    }

    public String getBoardName() {
        return boardName;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean hasGotBoardName() {
        return boardName != "";
    }

    public Boolean hasGotUserName() {
        return userName != "";
    }

    private void findUserName() {
        userName = findStringInParameters(userNameParameter);
    }

    private void findBoardName() {
        boardName = findStringInParameters(boardParameter);
    }

    private String findStringInParameters(String parameter) {

        String tempString = "";
        currentIndex = 0;
        while (!arguments[currentIndex].equals(parameter)) {
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

    private String mergeStrings(String a, String b, String between) {
        return a + between + b;
    }

}
