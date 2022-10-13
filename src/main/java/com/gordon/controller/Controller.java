package com.gordon.controller;

import com.gordon.model.Board;
import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Controller {
    private View view = null;
    private Board board = null;
    private int numberOfColumns = 0;
    private String boardName;
    
    
    public Controller(){
        view = new View();
        boardName = "Default board";
        board = new Board(numberOfColumns, boardName);
    }
    
    public Controller(int _numberOfColums){
        view = new View();
        
        //Validate and set number of columns
        if(_numberOfColums < 0){
            numberOfColumns = 0;
        }
        else{
            numberOfColumns = _numberOfColums;
        }
        
        //Validate and set board name
        do{
            boardName = view.getBoardName(); 
        }
        while(!validateBoardName(boardName));
        
        //Create Board
        board = new Board(numberOfColumns,boardName);
    }

    private boolean validateBoardName(String boardName){
        if(boardName == ""){
            view.showMessage("Board name cannot be empty");
            return false;
        }
        else if(boardName.length() > 20)
        {
            view.showMessage("Board name cannot be longer than 20 characters");
            return false;
        }
        else {
            //Board name passed all cases
            return true;
        }
    }
}
