package ru.yandex.praktikum.db.examples.simple;

import java.sql.*;

public class SimpleDBAccess {

    private static final String URL = "jdbc:postgresql://localhost:5432/public";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void executeQueryAndPrintResult(String query) {
        try {
            // Opening database connection to PostgreSQL server
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Creating statement object to execute query
            statement = connection.createStatement();

            // Executing query
            resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (i > 1) System.out.print(", ");
                    String columnName = rsmd.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnName + ": " + columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Error during DB query executing: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Error during DB resources closing: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SimpleDBAccess.executeQueryAndPrintResult("SELECT * FROM customer");
    }

}