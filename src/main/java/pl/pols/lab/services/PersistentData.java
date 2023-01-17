/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.pols.lab.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pl.polsl.lab.model.board.Column;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class PersistentData {

    Connection con = null;
    Column toDo = new Column("toDo");
    Column inProgress = new Column("inProgress");
    Column done = new Column("done");

    private static PersistentData INSTANCE;

    public PersistentData() {

    }

    public static PersistentData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersistentData();
        }
        return INSTANCE;
    }

    public Column getToDo() {
        return toDo;
    }

    public Column getInProgress() {
        return inProgress;
    }

    public Column getDone() {
        return done;
    }

    public void createTables() {
        // make a connection to DB
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app");
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE tasks"
                    + "(id int GENERATED ALWAYS AS IDENTITY not null, "
                    + "title VARCHAR(255), description VARCHAR(255), PRIMARY KEY(ID))");
            statement.executeUpdate("CREATE TABLE toDo"
                    + "(id int GENERATED ALWAYS AS IDENTITY not null, "
                    + "task_id INT, FOREIGN KEY(task_id) REFERENCES tasks(id) ON DELETE CASCADE, PRIMARY KEY(ID))");
            statement.executeUpdate("CREATE TABLE inProgress"
                    + "(id int GENERATED ALWAYS AS IDENTITY not null, "
                    + "task_id INT, FOREIGN KEY(task_id) REFERENCES tasks(id) ON DELETE CASCADE, PRIMARY KEY(ID))");
            statement.executeUpdate("CREATE TABLE done"
                    + "(id int GENERATED ALWAYS AS IDENTITY not null, "
                    + "task_id INT, FOREIGN KEY(task_id) REFERENCES tasks(id) ON DELETE CASCADE, PRIMARY KEY(ID))");
            System.out.println("Tables created");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public void deleteData() {

        // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            Statement statement = con.createStatement();
            // Usuwamy dane z tabeli
            int numberOfDeletedRows = statement.executeUpdate("DELETE FROM Dane WHERE nazwisko = 'Mickiewicz'");
            System.out.println("Data removed: " + numberOfDeletedRows + " rows");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public void insertTask(String title, String description, String tableName) {
        // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            PreparedStatement pstm;
            ResultSet rs;
            String query = "insert into tasks (title, description) values (?,?)";
            pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, title);
            pstm.setString(2, description);
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if(rs !=null && rs.next())
            {
                PreparedStatement pstmToDo;
                String queryToDo = "insert into "+tableName+" (task_id) values (?)";
                pstmToDo = con.prepareStatement(queryToDo);
                pstmToDo.setInt(1, rs.getInt(1));
                pstmToDo.executeUpdate();   
            }
            
            
            System.out.println("Data inserted");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public void selectData() {

        // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM TASKS");
            // Przeglądamy otrzymane wyniki
            System.out.printf("|%-3s|%-12s|%-10s|\n", "ID", "taskName", "taskContent");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.printf("|%-3s", rs.getInt("id"));
                System.out.printf("|%-12s", rs.getString("taskName"));
                System.out.printf("|%-10s", rs.getString("taskContent"));
            }
            System.out.println("-----------------------------------");
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
