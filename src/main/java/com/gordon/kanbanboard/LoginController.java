/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gordon.kanbanboard;

import com.gordon.model.User;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Bartek
 */
public class LoginController {

    private User _user;

    @FXML
    private TextField usernameTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Label warning;

    @FXML
    private void buttonClicked(ActionEvent event) throws IOException {
        if (!getUserNameFromInput()) {
            App.setRoot("Board");
        }
    }

    private Boolean getUserNameFromInput() {
        String userName;

        userName = usernameTextField.getText();

        if (validateName(userName)) {
            usernameTextField.clear();
            return false;
        }

        _user = new User();
        _user.setUserName(userName);
        return true;
    }

    private void showWarning(String displayText) {
        warning.setVisible(true);
        warning.setText(displayText);
    }

    private void disableWarning() {
        warning.setVisible(false);
        warning.setText("");
    }

    private Boolean validateName(String userName) {
        disableWarning();
        if (userName.length() == 0) {
            showWarning("Name cannot be empty");
            return false;
        } else if (userName.length() > 25) {
            showWarning("Name cannot be longer than 25 characters");
            return false;
        } else {
            showWarning("Loggin' in!");
            return true;
        }
    }
}
