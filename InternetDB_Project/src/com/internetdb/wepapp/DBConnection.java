package com.internetdb.wepapp;

import java.sql.Connection;
import java.sql.DriverManager;

import com.internetdb.wepapp.Secret.Secret;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName(Secret.DRIVER);
            connection = DriverManager.getConnection(Secret.URL, Secret.UID, Secret.UPW);
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
