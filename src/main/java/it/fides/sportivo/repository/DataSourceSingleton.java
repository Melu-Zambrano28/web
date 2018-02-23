package it.fides.sportivo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceSingleton {


    /*

       private DataSourceSingleton() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3333/gestionale_sportivo?useSSL=false", "root", "password");

        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        return getIstanza().getConnection();
    }



    public static DataSourceSingleton getInstance() throws SQLException {
        if (istanza == null)
            istanza = new DataSourceSingleton();
        else if (istanza.getConnection().isClosed()) {
           istanza = new DataSourceSingleton();
       }
        return istanza;
    }
} */



    private static DataSourceSingleton istanza;
    private Connection conn;
    private final static String URL_DB = "jdbc:mysql://localhost:3333/gestionale_sportivo?useSSL=false";
    private final static String USR_DB = "root";
    private final static String PWD_DB = "password";

    private void initConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(URL_DB, USR_DB, PWD_DB);
    }

    private DataSourceSingleton() throws SQLException {
        try {
            initConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if(conn==null || conn.isClosed()){
            initConnection();
        }
        return conn;
    }

    public static DataSourceSingleton getInstance() throws SQLException, ClassNotFoundException {
        if (istanza == null)
            istanza = new DataSourceSingleton();
        else if (istanza.getConnection().isClosed()) {
           istanza = new DataSourceSingleton();
       }
        return istanza;
    }
}


