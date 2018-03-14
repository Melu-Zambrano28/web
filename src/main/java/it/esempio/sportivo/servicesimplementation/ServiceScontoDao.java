package it.esempio.sportivo.servicesimplementation;

import it.esempio.sportivo.entity.Sconto;
import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceScontoDao {
    private static final String insert_sconto = "INSERT INTO sconto (descrizione,perc_scon) VALUES (?,?)";
    private static final String delete_sconto = "DELETE FROM sconto WHERE id = ?";
    private static final String update_sconto = "UPDATE sconto SET descrizione = ?, perc_scon = ? WHERE id = ?";
    private static final String select_sconto = "SELECT id, descrizione, perc_scon FROM sconto WHERE id = ?";
    private static final String select_listaSconto = "SELECT id, descrizione, perc_scon FROM sconto";


    public static void insertSconto(Sconto sconto) throws SQLException, ClassNotFoundException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(insert_sconto);
        stmt.setString(1, sconto.getDescrizione());
        stmt.setDouble(2, sconto.getPerc_scon());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static Sconto selectSconto(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_sconto);
        Sconto sconto = null;
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            sconto = new Sconto(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3));

        }
        stmt.close();
        conn.close();
        return sconto;
    }

    public static void deleteSconto(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(delete_sconto);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void aggiornaSconto(Sconto sconto, String descrizione,double perc_scon,int id) throws SQLException, ClassNotFoundException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(update_sconto);
        stmt.setString(1, descrizione);
        stmt.setDouble(2, perc_scon);
        stmt.setInt(3,sconto.getId());
        stmt.execute();
        stmt.close();
        conn.close();
    }



    public List<Sconto> listaSconto() throws SQLException, ClassNotFoundException {
        List<Sconto> listaSconti = new ArrayList<Sconto>();
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_listaSconto);
        Sconto sconto = null;
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            sconto = new Sconto(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
            listaSconti.add(sconto);
        }
        return listaSconti;
    }

}

