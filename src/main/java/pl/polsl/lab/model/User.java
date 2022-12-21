package pl.polsl.lab.model;

/**
 * Class implementing the user. 
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.0
 */
public class User {

    /**
     * User name.
     */
    private String userName = "";

    /**
     * Setter for user name.
     *
     * @param _userName New user name.
     */
    public void setUserName(String _userName) {
        userName = _userName;
    }

    /**
     * Getter for user name.
     *
     * @return User name.
     */
    public String getUserName() {
        return userName;
    }

}
