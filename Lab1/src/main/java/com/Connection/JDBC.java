package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;

public class JDBC {

        private static JDBC dbconnector = null;
        private static Connection connection = null;

        private static  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static  String DATABASE_URL = "jdbc:mysql://localhost:3306/books";

        private static  String USER = "root";
        private static  String PASSWORD = "Nebo191083";

        private JDBC() {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                System.out.println("-------------------------------------------");
                System.out.println("|  Подключение к базе данных установлено  |");
                System.out.println("-------------------------------------------\n");

            } catch (SQLException e) {
                System.out.println("-------------------------------------------");
                System.out.println("|  Не удалось подключиться к базе данных  |");
                System.out.println("-------------------------------------------\n");
                e.printStackTrace();
            }


        }

        public static Connection getInstanse() {
            if (dbconnector == null) {
                dbconnector = new JDBC();
            }
            return connection;
        }

        public static String getJdbcDriver() {
            return JDBC_DRIVER;
        }

        public static String getDatabaseUrl() {
            return DATABASE_URL;
        }

        public static String getUser() {
            return USER;
        }

        public static String getPassword() {
            return PASSWORD;
        }

    }


