package com.gordon.controller;

import com.gordon.model.ItemAlreadyExsistException;
import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
import com.gordon.view.View;
import java.util.List;

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
        Column column = new Column(controller.getStringResponseWithMessage("Type column name: "));
        try {
            board.addColumn(column);
        } catch (ItemAlreadyExsistException e) {
            System.err.println(e.getMessage());
        }

    }

    public void addTask() {
        int columnID = selectColumn(board.getColumns());
        if (columnID == -1) {
            return;
        }
        String taskName = controller.getStringResponseWithMessage("Specify task name: ");
        Task newTask = new Task(taskName);
        newTask.setAuthor(controller.getCurrentUser());

        try {
            board.addTask(newTask, board.getColumns().get(columnID));
        } catch (ItemAlreadyExsistException e) {
            System.err.println(e.getMessage());
        }

        view.showMessage("Do you want to upload content to task?");
        if (view.confirmationMessage()) {
            newTask.setContent(controller.getStringResponseWithMessage("Enter tasks conntent: "));
        }
        
       
    }

    public void clearBoard() {
        if (view.showWarning("clear whole board?")) {
            for (Column c : board.getColumns()) {
                c.getTasks().clear();
            }
            board.getColumns().clear();

            view.showMessage("BOARD CLEARED");
        }
    }

    public void createNewBoard(String name) {
        board = new Board(name);
    }
    
    public void moveTask()
    {
        view.showMessage("Select column to take the task from.");
        int _fromID = selectColumn(board.getColumns());       
        if(_fromID == -1)
            return;
        
        
        view.showMessage("Select the task you want to move.");
        List<Task> tempTaskList = board.getColumns().get(_fromID).getTasks();      
        int tempTaskID = selectTask(tempTaskList);       
        if(tempTaskID == -1)
            return;
        
        Task tempTask = tempTaskList.get(tempTaskID);
        view.showMessage("Select the column you want the task to move to.");
        int _toID = selectColumn(board.getColumns());
        if(_toID == -1)
            return;
        
        board.moveTask(tempTask, _fromID, _toID);      
    }
    
    
    private int selectColumn(List<Column> columnList) {
        for (int i = 0; i < columnList.size(); i++) {
            System.out.println(i + 1 + ". " + columnList.get(i).getColumnName());
        }
        view.showMessage("0. None");
        
        int response = controller.getIntResponseWithMessage("Specify which column: ") - 1;  
        if(response >= columnList.size() || response < 0 )
            response = -1;
        
        //returned value -1 means none of the column was selected 
        return response;
    }
    
    private int selectTask(List<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ". " + taskList.get(i).getTaskName());
        }
        view.showMessage("0. None");
        
        int response = controller.getIntResponseWithMessage("Specify which task: ") - 1;  
        if(response >= taskList.size() || response < 0 )
            response = -1;
        
        //returned value -1 means none of the column was selected 
        return response;
    }
}
