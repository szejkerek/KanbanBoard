package com.gordon.view;

import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
import java.util.List;

/**
 * View for the board.
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class BoardView {

    /**
     * Prints board on screen.
     *
     * @param board Board to be printed.
     */
    public void showBoard(Board board) {
        System.out.println("BOARD NAME: " + board.getBoardName());
        showColumnsWithTasks(board.getColumns());
    }

    /**
     * Prints all columns with its tasks on screen.
     *
     * @param columnsList Column list.
     */
    private void showColumnsWithTasks(List<Column> columnsList) {
        if (columnsList.isEmpty()) {
            System.out.println("*board is empty*");
            return;
        }
        for (Column c : columnsList) {
            showColumn(c);
        }
    }

    /**
     * Prints one column with its tasks on screen.
     *
     * @param c Column to be printed.
     */
    private void showColumn(Column c) {
        System.out.println("\nCOLUMN NAME: " + c.getColumnName());
        showTasks(c.getTasks());
    }

    /**
     * Prints all tasks from list.
     *
     * @param tasksList Tasks to be printed.
     */
    private void showTasks(List<Task> tasksList) {
        if (tasksList.isEmpty()) {
            System.out.println("*no tasks*");
        }

        for (Task t : tasksList) {
            showTask(t);
        }
    }

    /**
     * Print specific task with its content.
     *
     * @param t Task to be printed.
     */
    private void showTask(Task t) {
        System.out.print(t.getTaskName() + " - ");
        if (!t.hasContent()) {
            System.out.println("*task has no content*");
        }
        System.out.println(t.getContent());
    }
}
