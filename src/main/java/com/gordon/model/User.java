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

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

}
