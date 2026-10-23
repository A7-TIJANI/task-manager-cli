package com.tijani.taskmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    // CREATE — PreparedStatement prevents SQL injection (the ? placeholders)
    public void addTask(String title, String description) throws SQLException {
        String sql = "INSERT INTO tasks (title, description) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.executeUpdate();   // for INSERT/UPDATE/DELETE — returns rows affected
        }
    }

    // READ — ResultSet is a cursor over the rows Postgres sends back
    public List<Task> getAllTasks() throws SQLException {
        String sql = "SELECT id, title, description, status, created_at FROM tasks ORDER BY id";
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {   // for SELECT
            while (rs.next()) {                      // walk row by row
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                ));
            }
        }
        return tasks;
    }

    // UPDATE
    public void updateStatus(int id, String status) throws SQLException {
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deleteTask(int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}