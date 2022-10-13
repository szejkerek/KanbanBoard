package com.mycompany.view;

import com.mycompany.model.Board;
import com.mycompany.model.Column;
import com.mycompany.model.Task;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bartłomiej Gordon
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
