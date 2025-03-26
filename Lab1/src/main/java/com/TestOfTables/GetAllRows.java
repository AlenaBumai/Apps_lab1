package com.TestOfTables;

import com.Connection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.Query.*;

import static com.TestOfTables.DataAuthor.getAuthorId;

public class GetAllRows {

    public static void getAuthors(){
    try{
        System.out.println("Executing statement...");

        Connection conn = JDBC.getInstanse();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(Query.selectAuthors);

        System.out.println("Retrieving data from database...");

        while (resultSet.next()) {
            int id = resultSet.getInt("AuthorId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");


            System.out.println("\n-------------------\n");
            System.out.println("id: " + id);
            System.out.println("firstName: " + firstName);
            System.out.println("lastName: " + lastName);
                    }
    }
    catch (Exception ex) {
        System.out.println(ex.getMessage());

    }

}

    public static void getPublishers(){

        try{
            System.out.println("Executing statement...");

            Connection conn = JDBC.getInstanse();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(Query.selectPublishers);

            System.out.println("Retrieving data from database...");

            while (resultSet.next()) {
                int id = resultSet.getInt("publisherId");
                String publisherName = resultSet.getString("publisherName");



                System.out.println("\n-------------------\n");
                System.out.println("id: " + id);
                System.out.println("publisherName: " + publisherName);
                        }
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());

        }


    }

    public static void getAllBooks() {
        try {
            System.out.println("Executing statement...");
            Connection conn = JDBC.getInstanse();
            String query = "SELECT * FROM books.titles";
            PreparedStatement stmt = conn.prepareStatement( query);
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.println("Retrieving data from database...");

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                int editionNumber = resultSet.getInt("editionNumber");
                int year = resultSet.getInt("year");
                int publisherId = resultSet.getInt("publisherId");
                float price = resultSet.getFloat("price");

                System.out.println("\n-------------------\n");
                System.out.println("isbn: " + isbn);
                System.out.println("title: " + title);
                System.out.println("editionNumber: " + editionNumber);
                System.out.println("year: " + year);

                System.out.println("publisherId: " + publisherId);
                System.out.println("price: " + price);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

        public static void getBooksByAuthor(String firstName, String lastName){
        try{
            System.out.println("Executing statement...");
            Connection conn = JDBC.getInstanse();
            PreparedStatement stmt = conn.prepareStatement(Query.selectBooksByAuthorID);
            stmt.setInt(1, getAuthorId(firstName, lastName));
            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Retrieving data from database...");

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                int editionNumber = resultSet.getInt("editionNumber");
                int year = resultSet.getInt("year");
                int publisherId = resultSet.getInt("publisherId");
                float price = resultSet.getFloat("price");

                System.out.println("\n-------------------\n");
                System.out.println("isbn: " + isbn);
                System.out.println("title: " + title);
                System.out.println("editionNumber: " + editionNumber);
                System.out.println("year: " + year);

                System.out.println("publisherId: " + publisherId);
                System.out.println("price: " + price);
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());

        }


    }

    public static void getBooksByPublisher(String publisherName){


        try{
            System.out.println("Executing statement...");
            Connection conn = JDBC.getInstanse();
            PreparedStatement stmt = conn.prepareStatement(Query.selectBooksByPublisher);
            stmt.setInt(1, DataPublisher.getPublisherId(publisherName));
            ResultSet resultSet = stmt.executeQuery();


            System.out.println("Retrieving data from database...");

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                int editionNumber = resultSet.getInt("editionNumber");
                int year = resultSet.getInt("year");
                int publisherId = resultSet.getInt("publisherId");
                float price = resultSet.getFloat("price");


                System.out.println("\n-------------------\n");
                System.out.println("isbn: " + isbn);
                System.out.println("title: " + title);
                System.out.println("editionNumber: " + editionNumber);
                System.out.println("year: " + year);

                System.out.println("publisherId: " + publisherId);
                System.out.println("price: " + price);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());

        }


    }




}
