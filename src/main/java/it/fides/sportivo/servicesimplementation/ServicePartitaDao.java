package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.*;
import java.util.ArrayList;

public class ServicePartitaDao {

    private static Connection conex=null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;


    private static final String insert_partita = "INSERT INTO partita (data_partita, goal_sq_home, goal_sq_visitor, id_sq_home, id_sq_visitor, id_stadio)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String update_partita = "UPDATE partita SET data_partita = ?, id_sq_home = ?, id_sq_visitor = ?, id_stadio = ? WHERE id = ?";
    private static final String aggiorna_risultato = "UPDATE  partita SET goal_sq_home = ?, goal_sq_visitor = ? WHERE id = ?";
    private final static String delete_partita = "DELETE FROM partita WHERE id = ?";
    private static final String select_listaSquadra = "SELECT id, nome FROM squadra";

    public static void inserisciPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_partita);
        st.setDate(1, new Date(1234-5-7));
        st.setInt(2, sq_home.getId());
        st.setInt(3, sq_visitor.getId());
        st.setInt(4, stadio.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio, Partita partita) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_partita);
        st.setDate(1, partita.getData_partita());
        st.setInt(2, 1);
        st.setInt(3, 1);
        st.setInt(4, sq_home.getId());
        st.setInt(5, sq_visitor.getId());
        st.setInt(6, stadio.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaRisultatoPartita(int goal_home, int goal_visitor, Partita partita) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(aggiorna_risultato);
        st.setInt(1, goal_home);
        st.setInt(2, goal_visitor);
        st.setInt(3, partita.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void deletePartita(int id) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(delete_partita);
        st.setInt(1,id);
        st.execute();
    }

    public static ArrayList<Squadra> listaSquadra() throws  SQLException {
        ArrayList<Squadra> elencoSquadre = new ArrayList<>();
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_listaSquadra);
        Squadra squadra = null;
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()) {
            squadra = new Squadra(resultSet.getInt(1), resultSet.getString(2));
                   elencoSquadre.add(squadra);
        }
        conex.close();
        return elencoSquadre;
    }

    }

