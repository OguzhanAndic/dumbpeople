package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AccountCreation {

    public static void main(String[] args) {
        createAccount();
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Make an account:");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String userPasswordHash = scanner.nextLine(); // Här kan du lägga till en hash-funktion om du vill kryptera lösenord.
            System.out.print("Enter email: ");
            String userEmail = scanner.nextLine();

            try (Connection dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SprintPlanner", "root", "123")) {

                System.out.println("Connected to server");

                // Kontrollera om användarnamnet redan finns
                String queryUsername = "SELECT Username FROM Users WHERE Username = ?";
                try (PreparedStatement usernameStmt = dbConnection.prepareStatement(queryUsername)) {
                    usernameStmt.setString(1, username);
                    ResultSet userResult = usernameStmt.executeQuery();

                    if (userResult.next()) {
                        System.out.println("Username already exists.");
                        continue;
                    }
                }

                // Kontrollera om mejladressen redan finns
                String queryEmail = "SELECT Email FROM Users WHERE Email = ?";
                try (PreparedStatement emailStmt = dbConnection.prepareStatement(queryEmail)) {
                    emailStmt.setString(1, userEmail);
                    ResultSet emailResult = emailStmt.executeQuery();

                    if (emailResult.next()) {
                        System.out.println("Email already exists.");
                        continue;
                    }
                }

                // Generera ett nytt UserID (autoinkrement i databasen skulle vara enklare att hantera detta!)
                String getMaxIdQuery = "SELECT MAX(UserID) FROM Users";
                int newUserID = 1; // Standardvärde om databasen är tom.
                try (PreparedStatement maxIdStmt = dbConnection.prepareStatement(getMaxIdQuery)) {
                    ResultSet maxIdResult = maxIdStmt.executeQuery();
                    if (maxIdResult.next()) {
                        newUserID = maxIdResult.getInt(1) + 1; // Sätt nästa ID.
                    }
                }

                // Lägg till kontot i databasen
                String queryInsert = "INSERT INTO Users (UserID, Username, PasswordHash, Email) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = dbConnection.prepareStatement(queryInsert)) {
                    insertStmt.setInt(1, newUserID);
                    insertStmt.setString(2, username);
                    insertStmt.setString(3, userPasswordHash); // Lösenord i klartext, bör hashas i en riktig implementation.
                    insertStmt.setString(4, userEmail);

                    int rowsInserted = insertStmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Account created successfully!");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Connection failed: " + e.getMessage());
                break;
            }
        }

        scanner.close();
    }
}

