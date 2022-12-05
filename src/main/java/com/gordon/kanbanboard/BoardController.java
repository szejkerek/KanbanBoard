package com.gordon.kanbanboard;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author barte
 */
public class BoardController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField taskTitle;
    @FXML
    private Button submitBtn;
    @FXML
    private Label titleLabel;
    @FXML
    private Button clearBtn;
    @FXML
    private TableView<Task> doneTable;
    @FXML
    private TableView<Task> inProgressTable;
    @FXML
    private TableView<Task> toDoTable;
    @FXML
    private Button removeToDoBtn;
    @FXML
    private Button tpButton;
    @FXML
    private Button ptBtn;
    @FXML
    private Button pdBtn;
    @FXML
    private Button dpBtn;
    @FXML
    private Button removeInProgressBtn;
    @FXML
    private Button removeDoneBtn;

    private String priority[] = {"1 Very high", "2 High", "3 Normal", "4 Low", "5 Very low"};
    @FXML
    private TableColumn<Task, String> doneTitleColumn;
    @FXML
    private TableColumn<Task, String> doneDescriptionColumn;
    @FXML
    private TableColumn<Task, Integer> donePriorityColumn;
    @FXML
    private TableColumn<Task, String> inProgressTitleColumn;
    @FXML
    private TableColumn<Task, String> inProgressDescriptionColumn;
    @FXML
    private TableColumn<Task, Integer> inProgressPriorityColumn;
    @FXML
    private TableColumn<Task, String> toDoTitleColumn;
    @FXML
    private TableColumn<Task, String> toDoDescriptionColumn;
    @FXML
    private TableColumn<Task, Integer> toDoPriorityColumn;
    @FXML
    private TextField taskContent;

    /**
     * Initializes the controller class.
     */
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

    private void resteToDefault() {
        taskTitle.setText("");
        taskContent.setText("");
        choiceBox.setValue("3 Normal");
    }

    @FXML
    private void onClearBtnPressed(ActionEvent event) {
        resteToDefault();
    }

    @FXML
    private void submitBtnClicked(ActionEvent event) {
        int number = 0;
        try {
            String priority = "" + choiceBox.getValue().charAt(0);

            number = Integer.parseInt(priority);
        } catch (NumberFormatException ex) {
        }

        Task task = new Task(
                taskTitle.getText(),
                taskContent.getText(),
                number);
        ObservableList<Task> tasks = toDoTable.getItems();
        tasks.add(task);
        toDoTable.setItems(tasks);
        resteToDefault();
    }

    public void setTitle(String username) {
        titleLabel.setText("Personal board of " + username);
    }

    @FXML
    private void tpOnClick(ActionEvent event) {
        TableView<Task> from = toDoTable;
        TableView<Task> to = inProgressTable;

        ObservableList<Task> fromTasks = from.getItems();
        ObservableList<Task> toTasks = to.getItems();

        int index = from.getSelectionModel().getSelectedIndex();

        if (index != -1) {
            toTasks.add(fromTasks.get(index));
            fromTasks.remove(index);
        }

    }

    @FXML
    private void ptOnClick(ActionEvent event) {
    }

    @FXML
    private void pdOnClick(ActionEvent event) {
    }

    @FXML
    private void dpOnClick(ActionEvent event) {
    }

    @FXML
    private void removeInProgressOnClick(ActionEvent event) {
        int selectedID = inProgressTable.getSelectionModel().getSelectedIndex();
        inProgressTable.getItems().remove(selectedID);
    }

    @FXML
    private void removeDoneOnClick(ActionEvent event) {
        int selectedID = doneTable.getSelectionModel().getSelectedIndex();
        doneTable.getItems().remove(selectedID);
    }

    @FXML
    private void removeToDoOnClick(ActionEvent event) {
        int selectedID = toDoTable.getSelectionModel().getSelectedIndex();
        toDoTable.getItems().remove(selectedID);
    }

}
