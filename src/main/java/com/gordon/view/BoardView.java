package com.gordon.view;

import com.gordon.model.board.Board;
import com.gordon.model.board.Column;
import com.gordon.model.board.Task;
import java.util.List;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class BoardView {

    View view;

    public BoardView(View _view) {
        view = _view;
    }

    public void showBoard(Board board) {
        System.out.println("BOARD NAME: " + board.getBoardName());

        if (board.getColumns().size() == 0) {
            System.out.println("*board is empty*");
            return;
        }

        for (Column c : board.getColumns()) {
            System.out.println("\nCOLUMN NAME: " + c.getColumnName());
            if (c.getTasks().size() == 0) {
                System.out.println("*column is empty*");
                continue;
            }

            for (Task t : c.getTasks()) {
                System.out.print(t.getTaskName() + " - ");
                if (!t.hasContent()) {
                    System.out.println("*task has no content*");
                    continue;
                }
                System.out.println(t.getContent());
            }
        }
    }

    public int selectColumn(List<Column> columnList) {
        for (int i = 0; i < columnList.size(); i++) {
            System.out.println(i + 1 + ". " + columnList.get(i).getColumnName());
        }
        System.out.println("0. None");
        
        int response = view.getIntResponseWithMessage("Specify which column: ") - 1;  
        if(response >= columnList.size() || response < 0 )
            response = -1;
        
        //returned value -1 means none of the column was selected 
        return response;
    }
    
    public int selectTask(List<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ". " + taskList.get(i).getTaskName());
        }
        System.out.println("0. None");
        
        int response = view.getIntResponseWithMessage("Specify which task: ") - 1;  
        if(response >= taskList.size() || response < 0 )
            response = -1;
        
        //returned value -1 means none of the column was selected 
        return response;
    }
}
