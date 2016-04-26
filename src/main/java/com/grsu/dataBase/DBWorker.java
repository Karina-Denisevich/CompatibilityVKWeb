package com.grsu.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/musicgroups";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBWorker(){

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }catch (SQLException ex){

            ex.printStackTrace();
        }
    }

    public Connection getConnection() {

        return connection;
    }
}
