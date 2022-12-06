package com.gordon.model.board;

import com.gordon.model.User;

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
    protected String taskName = "";
    /**
     * Content of the task.
     */
    protected String taskContent = "";

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     * Task priority.
     */
    protected Integer taskPriority = 0;

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
     * Constructor for task specifying its name and initial taskDescription.
     *
     * @param _taskName Task name.
     * @param initialContent Initial taskDescription.
     */
    public Task(String _taskName, String initialContent) {
        taskName = _taskName;
        taskContent = initialContent;
    }

    public Task(String _taskName, String _taskContent, Integer priority) {
        taskName = _taskName;
        taskContent = _taskContent;
        taskPriority = priority;
    }

    /**
     * Copy constructor.
     *
     * @param _task Task to be copied.
     */
    public Task(Task _task) {
        taskName = _task.getTaskName();
        taskContent = _task.getContent();
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
     * Setter for tasks taskDescription.
     *
     * @param content Task taskDescription.
     */
    public void setContent(String content) {
        this.taskContent = content;
    }

    /**
     * Getter for task taskDescription.
     *
     * @return Task taskDescription.
     */
    public String getContent() {
        return taskContent;
    }

    public Integer getTaskPriority() {
        return taskPriority;
    }

    /**
     * Function that checks if task has any taskDescription.
     *
     * @return True if task has taskDescription, false otherwise.
     */
    public Boolean hasContent() {
        return !taskContent.equals("");
    }

}
