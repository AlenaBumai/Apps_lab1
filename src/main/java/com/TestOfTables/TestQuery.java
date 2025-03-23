package com.TestOfTables;

import com.Connection.JDBC;

import javax.sql.StatementEventListener;
import java.sql.*;

public class TestQuery {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = JDBC.getInstanse();
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO titles (isbn, title, editionNumber, YEAR, publisherID, price)  " +
                    "VALUES('55aa', 'Антропология', 3, 2016, (SELECT publisherID FROM publishers WHERE PublisherName LIKE '%Гродно'), 40.0)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
