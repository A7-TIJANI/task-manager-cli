# Task Manager CLI

A console-based task manager built with **plain JDBC** (no frameworks) to
demonstrate Java ↔ PostgreSQL connectivity and full CRUD operations.

## Tech Stack
- Java 21
- PostgreSQL 18
- Maven
- JDBC (DriverManager, PreparedStatement, ResultSet)

## Features
- Add tasks with title and description
- List all tasks
- Update task status (TODO / DONE)
- Delete tasks

## Project Structure
- `DatabaseConnection.java` — JDBC connection factory
- `Task.java` — model class
- `TaskDao.java` — CRUD operations (Data Access Object pattern)
- `Main.java` — interactive console menu

## Setup
1. Create the database:
   ```sql
   CREATE DATABASE task_manager;
   CREATE TABLE tasks (
       id SERIAL PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       description TEXT,
       status VARCHAR(20) NOT NULL DEFAULT 'TODO',
       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
   );