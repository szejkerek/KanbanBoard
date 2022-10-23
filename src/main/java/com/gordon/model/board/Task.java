package com.gordon.model.board;

import com.gordon.model.User;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
public class Task {
    private String taskName = "";
    private String content = "";

    public void setContent(String content) {
        this.content = content;
    }
    private User author;
    
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String _taskName) {
        this.taskName = _taskName;
    }  
    
    public Task(String taskName){
        taskName = taskName;
    }
    
    public String getContent() {
        return content;
    }
    
    public Boolean hasContent()
    {
        return (content != "");
    }

    public Task(String taskName, String initialContent){
        taskName = taskName;
        content = initialContent;
    }
}
