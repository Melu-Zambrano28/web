package it.fides.sportivo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceSingleton {

   // private DataSourceSingleton() {}

    private static DataSourceSingleton istanza;
    private Connection conn;

    /*

    public static DataSourceSingleton getIstanza() throws SQLException {
        if(istanza == null) {
            istanza = new DataSourceSingleton();
        }
        return istanza;
    }



    public Connection getConnection() throws SQLException {
        return getIstanza().connessione();
    }

    private Connection connessione() throws SQLException {
        Connection conn = null;
        try {
            conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3333/squalo?useSSL=false", "root", "password");
            System.out.println(conn.isClosed());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    } */

    private DataSourceSingleton() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionale_sportivo?useSSL=false", "root", "2809");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DataSourceSingleton getInstance() throws SQLException {
        if (istanza == null)
            istanza = new DataSourceSingleton();
//        } else if (istanza.getConnection().isClosed()) {
//            istanza = new DataSourceSingleton();
//        }

        return istanza;
    }
}


