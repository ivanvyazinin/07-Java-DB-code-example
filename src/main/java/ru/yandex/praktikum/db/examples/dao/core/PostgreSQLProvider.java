package ru.yandex.praktikum.db.examples.dao.core;

import java.sql.*;

public class PostgreSQLProvider {

    protected final static String URL = "jdbc:postgresql://localhost:5432/public";
    protected String tableName;

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Can not get connection: " + e.getMessage());
        }
        return null;
    }

}