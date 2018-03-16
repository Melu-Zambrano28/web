package it.esempio.sportivo.repository;

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

    private final static String URL_DB = "jdbc:mysql://localhost:3306/gestionale_sportivo?useSSL=false";
    private final static String USR_DB = "root";
    private final static String PWD_DB = "2809";

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

    public static DataSourceSingleton getInstance() throws SQLException {
        if (istanza == null)
            istanza = new DataSourceSingleton();
//        } else if (istanza.getConnection().isClosed()) {
//            istanza = new DataSourceSingleton();
//        }

        return istanza;
    }
}


