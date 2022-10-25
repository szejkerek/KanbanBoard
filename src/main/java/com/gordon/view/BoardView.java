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
}
