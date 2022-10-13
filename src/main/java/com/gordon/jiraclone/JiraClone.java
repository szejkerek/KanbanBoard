package com.gordon.jiraclone;
import com.gordon.controller.Controller;
/**
 *
 * @author Bartłomiej Gordon
 * @version 1.0
 */
public class JiraClone {

    public static void main(String[] args) {
        // Number of parameters passed to the program
        Controller controller = null;
        int paremetersNumber = args.length;
        
        // Write all the parameters passed to the program
        if(paremetersNumber == 0){
            System.out.println("No parameter");
            controller = new Controller();
        }
        else if(paremetersNumber == 1){
            try{
                Integer parsedParametersNumber = Integer.valueOf(args[0]);
                //Parameter is parsed sucesfully to an Intiger 
               controller = new Controller(parsedParametersNumber);
            }
            catch (NumberFormatException ex){
                 System.out.println("Parameter must be a number!");
            }
        }
        else{
            System.out.println("Too many parameters");
        }
    }
}
