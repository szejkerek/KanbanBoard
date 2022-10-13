package com.gordon.model;

/**
 *
 * @author Bartłomiej Gordon
 */
public class Task {
    private String content = "";
    
    public Task(){
        
    }
    
    public String getContent() {
        return content;
    }

    public Task(String initialContent){
        content = initialContent;
    }
}
