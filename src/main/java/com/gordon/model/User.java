package com.gordon.model;

import com.gordon.view.View;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class User {

    private View view = null;
    private String name = "";

    public User(View _view) {
        view = _view;
    }

    public void askForUserName() {
        do {
            name = view.getResponseWithMessage("Enter your user name: ");
        } while (!validateUserName(name));
    }

    public void setName(String _name) {
        if (!validateUserName(_name)) {
            askForUserName();
        } else {
            name = _name;
        }
    }

    public String getName() {
        return name;
    }

    private Boolean validateUserName(String userName) {
        if (userName.length() == 0) {
            view.showMessage("User name cannot be empty");
            return false;
        } else if (userName.length() > 25) {
            view.showMessage("User name cannot be longer than 25 characters");
            return false;
        } else {
            //User name passed all cases
            return true;
        }
    }
}
