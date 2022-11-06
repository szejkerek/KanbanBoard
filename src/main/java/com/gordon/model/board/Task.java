package com.gordon.model.board;

import com.gordon.model.User;
import com.gordon.model.board.enums.TaskPriority;

/**
 * Class implementing the task. 
 * 
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 * @version 1.1
 */

public class Task {

    /**
     * Task name.
     */
    private String taskName = "";
    
     /**
     * Task priority.
     */
    private TaskPriority taskPriority = TaskPriority.Lowest;

    /**
     * Content of the task.
     */
    private String content = "";

    /**
     * Author of the task.
     */
    private User author;

    /**
     * Constructor for task specifying only its name.
     *
     * @param _taskName Task name.
     */
    public Task(String _taskName) {
        taskName = _taskName;
    }

    /**
     * Constructor for task specifying its name and initial content.
     *
     * @param _taskName Task name.
     * @param initialContent Initial content.
     */
    public Task(String _taskName, String initialContent) {
        taskName = _taskName;
        content = initialContent;
    }

    /**
     * Copy constructor.
     *
     * @param _task Task to be copied.
     */
    public Task(Task _task) {
        taskName = _task.getTaskName();
        content = _task.getContent();
    }

    /**
     * Getter for the author of the task.
     *
     * @return Author of the task.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Setter for the tasks author.
     *
     * @param author New task author.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Getter for task name.
     *
     * @return Task name.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Setter for task name.
     *
     * @param _taskName New task name.
     */
    public void setTaskName(String _taskName) {
        this.taskName = _taskName;
    }

    /**
     * Setter for tasks content.
     *
     * @param content Task content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter for task content.
     *
     * @return Task content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Function that checks if task has any content.
     * @return True if task has content, false otherwise.
     */
    public Boolean hasContent() {
        return !content.equals("");
    }
    
     /**
     * Setter for task priority.
     *
     * @param _taskPriority Task content.
     */
    public void setTaskPriority(TaskPriority _taskPriority) {
        taskPriority = _taskPriority;
    }

    /**
     * Getter for task priority.
     *
     * @return Task priority.
     */
    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

}
