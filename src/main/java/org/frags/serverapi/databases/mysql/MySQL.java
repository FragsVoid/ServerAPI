package org.frags.serverapi.databases.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {


    private String host;
    private String port; // usually 3306
    private String database;
    private String username;
    private String password;

    private Connection connection;

    public MySQL(String host, String port, String database, String username, String password) {

        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }


    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
