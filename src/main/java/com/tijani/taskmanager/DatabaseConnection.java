package com.tijani.taskmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

    private static final String URL = "jdbc:postgresql://localhost:5432/task_manager";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ahmed";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}