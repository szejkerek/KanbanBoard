package com.gordon.controller;

import com.gordon.model.board.Board;
import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class BoardController {

    private Controller controller = null;
    private View view = null;
    private Board board = null;

    public BoardController(View _view) {
        view = _view;
    }

    public void init(Controller _controller) {
        controller = _controller;
    }

    public void showBoard() {
        view.getBoardView().showBoard(board);
    }

    public void clearBoard() {
        if (view.showWarning("clear whole board?")) {
            view.showMessage("BOARD CLEARED");
        }
    }
    
    public void createNewBoard(){
        
    }
}
