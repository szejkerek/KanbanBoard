package com.gordon.jiraclone;
import com.gordon.model.CommandLineArguments;
import com.gordon.controller.Controller;
/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class JiraClone {

    public static void main(String[] args) {
        
        CommandLineArguments arg = new CommandLineArguments();  
        arg.processArguments(args);
        
        Controller controller = null;          
    }
           
}
    
    

