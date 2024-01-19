package org.example;

import java.sql.*;
import java.util.*;
public class BookManagementSystem {

    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_2324_db", "root", "");

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Insert a new book");
                System.out.println("2. Update book information");
                System.out.println("3. Delete a book");
                System.out.println("4. Display all books");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        // Insert a new book
                        System.out.print("Enter book name: ");
                        String bookName = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter publication: ");
                        String publication = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int publicationYear = scanner.nextInt();
                        System.out.print("Enter price: ");
                        float price = scanner.nextFloat();

                        String insertQuery = "INSERT INTO books (book_name, author, publication, publication_year, price) " +
                                "VALUES ('" + bookName + "', '" + author + "', '" + publication + "', " +
                                publicationYear + ", " + price + ")";
                        statement.executeUpdate(insertQuery);
                        System.out.println("Book inserted successfully!");
                        break;

                    case 2:
                        // Update book information
                        System.out.print("Enter book ID to update: ");
                        int bookIdToUpdate = scanner.nextInt();
                        System.out.print("Enter new price: ");
                        float newPrice = scanner.nextFloat();

                        String updateQuery = "UPDATE books SET price = " + newPrice + " WHERE book_id = " + bookIdToUpdate;
                        statement.executeUpdate(updateQuery);


                        System.out.println("Book information updated successfully!");
                        break;

                    case 3:
                        // Delete a book
                        System.out.print("Enter book ID to delete: ");
                        int bookIdToDelete = scanner.nextInt();

                        String deleteQuery = "DELETE FROM books WHERE book_id = " + bookIdToDelete;
                        statement.executeUpdate(deleteQuery);
                        System.out.println("Book deleted successfully!");
                        break;

                    case 4:
                        // Display all books
                        String selectQuery = "SELECT * FROM books";
                        ResultSet resultSet = statement.executeQuery(selectQuery);

                        while (resultSet.next()) {
                            int bookId = resultSet.getInt("book_id");
                            bookName = resultSet.getString("book_name");
                            author = resultSet.getString("author");
                            publication = resultSet.getString("publication");
                            publicationYear = resultSet.getInt("publication_year");
                            price = resultSet.getFloat("price");

                            System.out.println("Book ID: " + bookId +
                                    ", Book Name: " + bookName +
                                    ", Author: " + author +
                                    ", Publication: " + publication +
                                    ", Publication Year: " + publicationYear +
                                    ", Price: $" + price);
                        }
                        break;

                    case 5:
                        // Exit the program
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
