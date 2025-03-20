package com.TestOfTables;

import com.Connection.JDBC;
import com.Query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTitles {
    //БД. ВСТАВИТЬ В БД ПРИНИМАЕМОЕ ЛЕКАРСТВО ******** create
    //******************************************
    public static void insertBook(String isbn, String title, int editionNumber, int year, String publisherName, float price, String authorName, String authorLastName) {


        Connection conn = null;
        try {
            conn = JDBC.getInstanse();
            conn.setAutoCommit(false); // Start transaction
            PreparedStatement stmt1 = conn.prepareStatement(Query.insertTitle);

            stmt1.setString(1, isbn);
            stmt1.setString(2, title);
            stmt1.setInt(3, editionNumber);
            stmt1.setInt(4, year);
            stmt1.setInt(5, DataPublisher.getPublisherId(publisherName));
            stmt1.setFloat(6, price);
            int rows1 = stmt1.executeUpdate();


            PreparedStatement stmt2 = conn.prepareStatement(Query.insertIsbn);
            stmt2.setInt(1, DataAuthor.getAuthorId(authorName, authorLastName));
            stmt2.setString(2, isbn);
            int rows2 = stmt2.executeUpdate();
            conn.commit();

        }
        catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        }

    }
}