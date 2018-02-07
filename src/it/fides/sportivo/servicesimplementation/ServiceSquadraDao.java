package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceSquadraDao {

    private static final String insert_squadra = "INSERT INTO squadra (nome) VALUES (?)";
    private static final String delete_squadra = "DELETE FROM squadra WHERE id = ?";
    private static final String update_squadra = "UPDATE squadra SET nome = ? WHERE id = ?";
    private static final String select_squadra = "SELECT id, nome FROM squadra WHERE id = ?";
    private static final String select_listaSquadra = "SELECT id, nome FROM squadra";

    public static void insertSquadra(String nome) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(insert_squadra);
        stmt.setString(1, nome);
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void insertSquadra(Squadra squadra) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(insert_squadra);
        stmt.setString(1, squadra.getNome());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static Squadra selectSquadra(int id) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_squadra);
        Squadra squadra = null;
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            squadra = new Squadra(resultSet.getInt(1), resultSet.getString(2));
            System.out.println(squadra.toString());
        }
        stmt.close();
        conn.close();
        return squadra;
    }

    public static void deleteSquadra(int id) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(delete_squadra);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void aggiornaSquadra(String nome, int id) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(update_squadra);
        stmt.setString(1, nome);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void aggiornaSquadra(Squadra squadra, String nome) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(update_squadra);
        stmt.setString(1, nome);
        stmt.setInt(2, squadra.getId());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static List<Squadra> listaSquadra() throws  SQLException {
        List<Squadra> listaSquadre = new ArrayList<Squadra>();
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_listaSquadra);
        Squadra squadra = null;
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            squadra = new Squadra(resultSet.getInt(1), resultSet.getString(2));
            listaSquadre.add(squadra);
        }
        return listaSquadre;
    }

}
