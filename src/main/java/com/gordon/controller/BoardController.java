package com.gordon.controller;

import com.gordon.model.ItemAlreadyExistsException;
import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
import com.gordon.view.View;
import java.util.List;
import java.util.stream.Stream;

/**
 * Controller for the board.
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class BoardController {

    /**
     * Main controller of the application.
     */
    private final Controller controller;

    /**
     * Main view of the application.
     */
    private final View view;

    /**
     * The board assigned to the application.
     */
    private Board board;

    /**
     * Board's controller constructor.
     *
     * @param _controller Main controller.
     */
    public BoardController(Controller _controller) {
        controller = _controller;
        view = controller.getView();
    }

    /**
     * Wrapper for printing board.
     */
    public void showBoard() {
        view.getBoardView().showBoard(board);
    }

    /**
     * Wrapper for changing board name.
     */
    public void changeBoardName() {
        String newName = controller.getStringResponseWithMessage("Specify new board name: ");
        board.setBoardName(newName);
    }

    /**
     * Wrapper for adding columns.
     */
    public void addColumn() {
        Column column = new Column(controller.getStringResponseWithMessage("Type column name: "));
        try {
            board.addColumn(column);
        } catch (ItemAlreadyExistsException e) {
            view.showMessage(e.getMessage());
        }

    }

    /**
     * Wrapper for adding tasks.
     */
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
        } catch (ItemAlreadyExistsException e) {
            view.showMessage(e.getMessage());
        }

        view.showMessage("Do you want to upload content to task?");
        if (view.confirmationMessage()) {
            newTask.setContent(controller.getStringResponseWithMessage("Enter tasks conntent: "));
        }
    }

    /**
     * Clear board.
     */
    public void clearBoard() {
        if (!view.showWarning("Do you want to clear the whole board?")) 
            return;
        
        Stream<Column> stream;       
        stream = board.getColumns().stream();
        stream.forEach(p -> p.getTasks().clear());

        board.getColumns().clear();
        view.showMessage("BOARD CLEARED");     
    }

    /**
     * Wrapper for creating new board.
     *
     * @param name Name of the new board...
     */
    public void createNewBoard(String name) {
        board = new Board(name);
    }

    /**
     * Wrapper for moving tasks.
     */
    public void moveTask() {
        view.showMessage("Select column to take the task from.");
        int _fromID = selectColumn(board.getColumns());
        if (_fromID == -1) {
            return;
        }

        view.showMessage("Select the task you want to move.");
        List<Task> tempTaskList = board.getColumns().get(_fromID).getTasks();
        int tempTaskID = selectTask(tempTaskList);
        if (tempTaskID == -1) {
            return;
        }

        Task tempTask = tempTaskList.get(tempTaskID);
        view.showMessage("Select the column you want the task to move to.");
        int _toID = selectColumn(board.getColumns());
        if (_toID == -1) {
            return;
        }

        board.moveTask(tempTask, _fromID, _toID);
    }

    /**
     * Display list of columns on screen and ask for user input to select one.
     *
     * @param columnList list of columns to manage.
     */
    private int selectColumn(List<Column> columnList) {     
        for (int i = 0; i < columnList.size(); i++) {
            view.showMessage(i + 1 + ". " + columnList.get(i).getColumnName());
        }
        view.showMessage("0. None");

        int response = controller.getIntResponseWithMessage("Specify which column: ") - 1;
        if (response >= columnList.size() || response < 0) {
            response = -1;
        }

        //returned value -1 means none of the column was selected 
        return response;
    }

    /**
     * Display list of tasks on screen and ask for user input to select one.
     *
     * @param taskList List of tasks to manage.
     */
    private int selectTask(List<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            view.showMessage(i + 1 + ". " + taskList.get(i).getTaskName());
        }
        view.showMessage("0. None");

        int response = controller.getIntResponseWithMessage("Specify which task: ") - 1;
        if (response >= taskList.size() || response < 0) {
            response = -1;
        }

        //returned value -1 means none of the column was selected 
        return response;
    }
}
