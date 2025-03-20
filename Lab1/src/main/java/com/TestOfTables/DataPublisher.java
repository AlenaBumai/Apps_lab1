package com.TestOfTables;

import com.Connection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataPublisher {

//добавить автора.

    public static void insertPublisher(String publisherName) {

        try {
            Connection conn = JDBC.getInstanse();
            String sqlInsert = "INSERT INTO books.publishers (publisherName) VALUES(?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, publisherName);
            int rows = stmt.executeUpdate();


        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updatePublisher(String publisherName, int publisherID){
        try {
        Connection conn = JDBC.getInstanse();
        String sqlUpdate = "UPDATE books.publishers  SET publisherName=(?) WHERE publisherID=(?)";
        PreparedStatement stmt = conn.prepareStatement(sqlUpdate);

        stmt.setString(1, publisherName);
            stmt.setInt(2, publisherID);
        int rows = stmt.executeUpdate();


    }
        catch  (SQLException ex) {
            ex.printStackTrace();
        }
}

public static int getPublisherId(String publisherName){
    int publisherID=0;
    try {
        Connection conn = JDBC.getInstanse();
        String sqlUpdate = "SELECT  publisherID  FROM  books.publishers WHERE publisherName  =?";
        PreparedStatement stmt = conn.prepareStatement(sqlUpdate);

        stmt.setString(1, publisherName);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            publisherID = rs.getInt("publisherID");
            System.out.println("publisherID: " + publisherID);
        }
   return publisherID;
    }
    catch (SQLException ex) {
        ex.printStackTrace();
        return 0;
    }
  }
}
