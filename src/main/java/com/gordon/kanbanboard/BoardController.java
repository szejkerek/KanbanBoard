package com.gordon.kanbanboard;

import com.gordon.model.board.Task;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Bartłomiej Gordon
 */
public class BoardController implements Initializable {

    /**
     * JavaFX ChoiceBox
     */
    @FXML
    private ChoiceBox<String> choiceBox;
    /**
     * JavaFX TextArea to write title of task
     */
    @FXML
    private TextArea taskTitle;
    /**
     * JavaFX TextArea to write content of task
     */
    @FXML
    private TextArea taskContent;
    /**
     * JavaFX Button for submiting task
     */
    @FXML
    private Button submitBtn;
    /**
     * JavaFX Label for task creator
     */
    @FXML
    private Label titleLabel;
    /**
     * JavaFX Button for clearing task creator
     */
    @FXML
    private Button clearBtn;
    /**
     * JavaFX TableView containing tasks
     */
    @FXML
    private TableView<Task> doneTable;
    /**
     * JavaFX TableView containing tasks
     */
    @FXML
    private TableView<Task> inProgressTable;
    /**
     * JavaFX TableView containing tasks
     */
    @FXML
    private TableView<Task> toDoTable;
    /**
      * JavaFX Button
     */
    @FXML
    private Button tpButton;
    /**
     * JavaFX Button
     */
    @FXML
    private Button ptBtn;
    /**
      * JavaFX Button
     */
    @FXML
    private Button pdBtn;
    /**
      * JavaFX Button
     */
    @FXML
    private Button dpBtn;
    /**
      * JavaFX Button
     */

    private String priority[] = {"1 Very high", "2 High", "3 Normal", "4 Low", "5 Very low"};
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> doneTitleColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> doneDescriptionColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, Integer> donePriorityColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> inProgressTitleColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> inProgressDescriptionColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, Integer> inProgressPriorityColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> toDoTitleColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, String> toDoDescriptionColumn;
    /**
     * JavaFX TableColumn containing tasks
     */
    @FXML
    private TableColumn<Task, Integer> toDoPriorityColumn;
    /**
     * JavaFX Button
     */
    @FXML
    private Button removeTaskBtn;
    /**
      * JavaFX Label
     */
    @FXML
    private Label noTitleLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBox.getItems().addAll(priority);
        choiceBox.setValue("3 Normal");

        toDoTitleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        toDoDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskContent"));
        toDoPriorityColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskPriority"));

        inProgressTitleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        inProgressDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskContent"));
        inProgressPriorityColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskPriority"));

        doneTitleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        doneDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskContent"));
        donePriorityColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskPriority"));

    }

    /**
     * JavaFX OnAction function on button for  clearing task creator fields
     * @param event Action event
     */
    @FXML
    private void onClearBtnPressed(ActionEvent event) {
        resteToDefault();
        noTitleLabel.setVisible(false);
    }

    /**
     * JavaFX OnAction function on button for submiting task creator fields
     * @param event Action event
     */
    @FXML
    private void submitOnClicked(ActionEvent event) {

        String taskTitleText = taskTitle.getText();
        String taskDesctiptionText = taskContent.getText();
        Integer taskPriorityNumber = getChoiceBoxValue();

        if (taskTitleText.isEmpty()) {
            noTitleLabel.setText("You must enter task title before submiting");
            return;
        }

        if (taskDesctiptionText.isEmpty()) {
            taskDesctiptionText = "-";
        }

        Task task = new Task(
                taskTitleText,
                taskDesctiptionText,
                taskPriorityNumber);

        addTask(task, toDoTable);
        resteToDefault();
    }

    /**
     * Setting title on top
     * @param username USername to set
     */
    public void setTitle(String username) {
        titleLabel.setText("Personal board of " + username);
    }

    /**
     * JavaFX OnAction function on button for moving task from todo to inprogress
     * @param event Action event
     */
    @FXML
    private void tpOnClick(ActionEvent event) {
        moveSelectedTask(toDoTable, inProgressTable);
    }

    /**
     * JavaFX OnAction function on button for moving task from inprogress to todo 
     * @param event Action event
     */
    @FXML
    private void ptOnClick(ActionEvent event) {
        moveSelectedTask(inProgressTable, toDoTable);
    }

    /**
     * JavaFX OnAction function on button for moving task from inprogress to done
     * @param event Action event
     */
    @FXML
    private void pdOnClick(ActionEvent event) {
        moveSelectedTask(inProgressTable, doneTable);
    }

    /**
     * JavaFX OnAction function on button for moving task from done to inprogress
     * @param event Action event
     */
    @FXML
    private void dpOnClick(ActionEvent event) {
        moveSelectedTask(doneTable, inProgressTable);
    }

    /**
     * JavaFX OnAction function on button for removing selected task
     * @param event Action event
     */
    @FXML
    private void removeTaskOnClick(ActionEvent event) {
        removeSelectedTask(toDoTable);
        removeSelectedTask(inProgressTable);
        removeSelectedTask(doneTable);
    }

    /**
     * Adding task to specified table 
     * @param task Task to move 
     * @param table Table 
     */
    private void addTask(Task task, TableView<Task> table) {
        ObservableList<Task> tasks = table.getItems();
        tasks.add(task);
        table.setItems(tasks);
    }

    /**
     * Remove task from specified table 
     * @param table Table
     */
    private void removeSelectedTask(TableView<Task> table) {
        int selectedID = table.getSelectionModel().getSelectedIndex();
        if (selectedID != -1) {
            table.getItems().remove(selectedID);
        }
    }

    /**
     * Move task from one table to another
     * @param tableFrom From table 
     * @param tableTo To table
     */
    private void moveSelectedTask(TableView<Task> tableFrom, TableView<Task> tableTo) {
        ObservableList<Task> fromTasks = tableFrom.getItems();
        ObservableList<Task> toTasks = tableTo.getItems();

        int index = tableFrom.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            toTasks.add(fromTasks.get(index));
            fromTasks.remove(index);
        }
    }

    /**
     * Gets choice box value 
     * @return Choice Box Value
     */
    private Integer getChoiceBoxValue() {
        Integer number = 0;
        try {
            String priority = "" + choiceBox.getValue().charAt(0);

            number = Integer.parseInt(priority);
        } catch (NumberFormatException ex) {
        }
        return number;
    }

    /**
     * Resets to default
     */
    private void resteToDefault() {
        taskTitle.setText("");
        noTitleLabel.setText("");
        taskContent.setText("");
        choiceBox.setValue("3 Normal");
    }

}
