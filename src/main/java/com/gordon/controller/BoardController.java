package com.gordon.controller;

import com.gordon.model.ItemAlreadyExsistException;
import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
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

    public void addColumn() {      
        Column column = new Column(view.getStringResponseWithMessage("Type column name: "));
        try {
            board.addColumn(column);
        } catch (ItemAlreadyExsistException e) {
            System.err.println(e.getMessage());
        }

    }
    
    public void addTask(){
        int columnID = view.getBoardView().selectColumn(board.getColumns());
        if(columnID == -1)
            return;
        String taskName = view.getStringResponseWithMessage("Specify task name: ");
        Task newTask = new Task(taskName);
        
        view.showMessage("Do you want to upload content to task?");
        if(view.confirmationMessage())
        {
          newTask.setContent(view.getStringResponseWithMessage("Enter tasks conntent: "));
        }

        try {
            board.addTask(newTask,board.getColumns().get(columnID));
        } catch (ItemAlreadyExsistException e) {
            System.err.println(e.getMessage());
        }
    }

    public void clearBoard() {
        if (view.showWarning("clear whole board?")) {
            for(Column c : board.getColumns())
            {
                c.getTasks().clear();
            }
            board.getColumns().clear();
            
            view.showMessage("BOARD CLEARED");
        }
    }

    public void createNewBoard(String name) {
        board = new Board(name);
    }
}
