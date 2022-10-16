package com.gordon.view;

import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class View {
    
    public void showMessage(String message){
        System.out.println("Message " + message);
    }
    public String getBoardName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board name: ");
        return scanner.next();
    }
    
    public void printBoard(Board board){
        //Print all columns inside board
        List<Column> columns = board.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            printColumn(columns.get(i));
        }
         System.out.println("BOARD PRINTED");
    }
    
    private void printColumn(Column column){
         //Print all columns inside board
        List<Task> tasks = column.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            printTask(tasks.get(i));
        }
         System.out.println("COLUMN PRINTED");
    }
    
    private void printTask(Task task){
         System.out.println(task.getContent());
         System.out.println("TASK PRINTED");
    }
    
}
