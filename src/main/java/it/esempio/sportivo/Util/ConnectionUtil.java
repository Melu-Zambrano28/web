package it.esempio.sportivo.Util;

import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection conx =null;

    public static Connection apreConnection() throws SQLException, ClassNotFoundException {
        conx = DataSourceSingleton.getInstance().getConnection();
        return conx;
    }

    public static void chiudiConnection() throws SQLException {
        if(!conx.isClosed())
            conx.close();
        else
            System.out.println("Connection già chiusa");
    }
}
