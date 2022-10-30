package com.gordon.jiraclone;

import com.gordon.model.CommandLineArguments;
import com.gordon.controller.Controller;

//
// Command-line arguments: -b [board name] -u [user name]
//
// Parameters can be passed in no particular order.
//
// Sample usage: KanbanBoard -b Example Board -u Bartek /
//

/**
 * Main class
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class JiraClone {

    /**
     * Main function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        CommandLineArguments commandLineArgs = new CommandLineArguments();
        commandLineArgs.processArguments(args);
        
        if(!commandLineArgs.hasGotUserName() || !commandLineArgs.hasGotUserName()){
            commandLineArgs.showHelp();
        }
        
        Controller controller = new Controller(commandLineArgs);
        controller.startApp();
    }

}
