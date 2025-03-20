package com.TestOfTables;

import com.Connection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAuthor {
    //добавить автора.

    public static void insertAuthor(String firstName, String lastName) {

        try {
            Connection conn = JDBC.getInstanse();
            String sql = "INSERT INTO books.authors (firstName, lastName) VALUES( ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            int rows = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            }
    }


    public static void updateAuthorName(String firstName, int authorID) {
        try {
            Connection conn = JDBC.getInstanse();
            String sqlUpdate = "UPDATE books.authors  SET firstName=(?) WHERE authorID=(?)";
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);

            stmt.setString(1, firstName);
            stmt.setInt(2, authorID);
            int rows = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static int getAuthorId(String firstName, String lastName){
        int authorID=0;
        try {
            Connection conn = JDBC.getInstanse();
            String sqlUpdate = "SELECT authorID FROM books.authors WHERE firstName =? AND lastName=?";
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                authorID = rs.getInt("authorID");
                System.out.println("authorID: " + authorID);
            }
            return authorID;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
