package com.tijani.taskmanager;

import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        TaskDao dao = new TaskDao();
        try {
            dao.addTask("Learn JDBC", "Finish the task manager project");
            dao.addTask("Apply to AmaliTech", "Send CV and GitHub link");

            System.out.println("--- All tasks ---");
            for (Task t : dao.getAllTasks()) {
                System.out.println(t);
            }

            dao.updateStatus(1, "DONE");
            System.out.println("--- After update ---");
            for (Task t : dao.getAllTasks()) {
                System.out.println(t);
            }

            dao.deleteTask(2);
            System.out.println("--- After delete ---");
            for (Task t : dao.getAllTasks()) {
                System.out.println(t);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}