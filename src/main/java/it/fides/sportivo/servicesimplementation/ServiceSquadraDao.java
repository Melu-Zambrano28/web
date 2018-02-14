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

    private static  Connection conex;
    private static ResultSet rs;
    private static PreparedStatement st;
    //private static ArrayList<Squadra> elencoSquadra=new ArrayList<Squadra>();

    private static final String insert_squadra = "INSERT INTO squadra (nome) VALUES (?)";
    private static final String delete_squadra = "DELETE FROM squadra WHERE id = ?";
    private static final String update_squadra = "UPDATE squadra SET nome = ? WHERE id = ?";
    private static final String select_squadra = "SELECT id, nome FROM squadra WHERE id = ?";
    private static final String select_listaSquadra = "SELECT id, nome FROM squadra";

    public static void insertSquadra(String nome) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_squadra);
        st.setString(1, nome);
        st.execute();
        st.close();
        conex.close();
    }

    public static void insertSquadra(Squadra squadra) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_squadra);
        st.setString(1, squadra.getNome());
        st.execute();
        st.close();
        conex.close();
    }

    public static Squadra selectSquadra(int id) throws SQLException {
        conex= DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(select_squadra);
        Squadra squadra = null;
        st.setInt(1, id);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next()) {
            squadra = new Squadra(resultSet.getInt(1), resultSet.getString(2));
            System.out.println(squadra.toString());
        }
        st.close();
        conex.close();
        return squadra;
    }

    public static void deleteSquadra(int id) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(delete_squadra);
        st.setInt(1, id);
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaSquadra(String nome, int id) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(update_squadra);
        st.setString(1, nome);
        st.setInt(2, id);
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaSquadra(Squadra squadra, String nome) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(update_squadra);
        st.setString(1, nome);
        st.setInt(2, squadra.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static ArrayList<Squadra> listaSquadra() throws  SQLException {
        ArrayList<Squadra> elencoSquadra=new ArrayList<Squadra>();
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_listaSquadra);
        Squadra squadra = null;
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            squadra = new Squadra(resultSet.getInt(1), resultSet.getString(2));
            elencoSquadra.add(squadra);
        }
        return elencoSquadra;
    }

}
