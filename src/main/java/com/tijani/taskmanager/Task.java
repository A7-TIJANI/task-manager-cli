package com.tijani.taskmanager;

import java.sql.Timestamp;

public class Task {
    private int id;
    private String title;
    private String description;
    private String status;
    private Timestamp createdAt;

    public Task(int id, String title, String description, String status, Timestamp createdAt){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public Timestamp getCreatedAt() { return createdAt; };

    @Override
    public String toString() {
        return "[" + id + "]" + title + " | " + status + " | " + createdAt;
    }
}