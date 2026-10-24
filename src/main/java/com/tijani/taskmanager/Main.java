package com.tijani.taskmanager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TaskDao dao = new TaskDao();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n=== TASK MANAGER ===");
            System.out.println("1. Add task");
            System.out.println("2. List all tasks");
            System.out.println("3. Update task status");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        dao.addTask(title, description);
                        System.out.println("Task added.");
                    }
                    case "2" -> {
                        List<Task> tasks = dao.getAllTasks();
                        if (tasks.isEmpty()){
                            System.out.println("No task yet.");
                        } else {
                            tasks.forEach(System.out::println);
                        }
                    }
                    case "3" -> {
                        System.out.print("Task ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("New status (TODO / DONE): ");
                        String status = scanner.nextLine().trim().toUpperCase();   // 1. READ
                        if (!status.equals("TODO") && !status.equals("DONE")) {     // 2. VALIDATE
                            System.out.println("Status must be TODO or DONE.");
                            break;
                        }
                        dao.updateStatus(id, status);
                        System.out.println("Status updated.");
                    }
                    case "4" -> {
                        System.out.print("Task ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        dao.deleteTask(id);
                        System.out.println("Task deleted.");
                    }
                    case "5" -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice, try 1-5.");
                }
            } catch (SQLException e){
                System.err.println("Database error: " + e.getMessage());
            } catch (NumberFormatException e){
                System.err.println("Please enter a valid number for the ID.");
            }
        }
    }
}