/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.pols.lab.services;

import static jakarta.xml.ws.RespectBindingFeature.ID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pl.polsl.lab.model.board.Column;
import pl.polsl.lab.model.board.Task;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class PersistentData {

    Column toDo = new Column("toDo");
    Column inProgress = new Column("inProgress");
    Column done = new Column("done");

    private static PersistentData INSTANCE;

    public PersistentData() {
        Task task = new Task("Tas", "Content");
        Task task2 = new Task("Task2", "Contentkhfcysvjcbvadkjbshlhifblhdk");

        insertNewTask(1, task);
        insertNewTask(2, task2);
        selectData();

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
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Dane "
                    + "(id INTEGER, nazwisko VARCHAR(50), "
                    + "imie VARCHAR(50), ocena FLOAT )");
            System.out.println("Table created");
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

    public void insertNewTask(Integer ID, Task task) {
        // make a connection to DB
        try ( Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO TASKS VALUES (" + ID + ", \'" + task.getTaskName() + "\', \'" + task.getTaskContent() + "\')");
            System.out.println("Data inserted");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
        public void selectData() {

        // make a connection to DB
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "app", "app")) {
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
