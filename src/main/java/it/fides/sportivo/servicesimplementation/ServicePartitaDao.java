package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.*;
import java.util.ArrayList;

public class ServicePartitaDao {

    private static Connection conex = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;


    private static final String insert_partita = "INSERT INTO partita (data_partita, id_sq_home, id_sq_visitor, id_stadio)" +
            " VALUES (?, ?, ?, ?)";
    private static final String update_partita = "UPDATE partita SET data_partita = ?, id_sq_home = ?, id_sq_visitor = ?, id_stadio = ? WHERE id = ?";
    private static final String aggiorna_risultato = "UPDATE  partita SET goal_sq_home = ?, goal_sq_visitor = ? WHERE id = ?";
    private final static String delete_partita = "DELETE FROM partita WHERE id = ?";
    private static final String select_listaPartita = "SELECT * FROM partita WHERE id_stadio = ?";


    public static void inserisciPartita(Partita partita, Squadra sq_home, Squadra sq_visitor, Stadio stadio) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_partita);
        int idStadio = ServiceStadioDao.trovaStadioByName(stadio.getNome());
        int idSquadraVisitor = ServiceSquadraDao.trovaSquadraByName(sq_visitor.getNome());
        int idSquadrahome = ServiceSquadraDao.trovaSquadraByName(sq_home.getNome());
        st.setDate(1, partita.getData_partita());
        st.setInt(2, idSquadrahome);
        st.setInt(3, idSquadraVisitor);
        st.setInt(4, stadio.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio, Partita partita) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(update_partita);
        st.setDate(1, partita.getData_partita());
        st.setInt(2, sq_home.getId());
        st.setInt(3, sq_visitor.getId());
        st.setInt(4, stadio.getId());
        st.setInt(5, partita.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaRisultatoPartita(int goal_home, int goal_visitor, Partita partita) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(aggiorna_risultato);
        st.setInt(1, goal_home);
        st.setInt(2, goal_visitor);
        st.setInt(3, partita.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void deletePartita(int id) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(delete_partita);
        st.setInt(1, id);
        st.execute();
    }


    public static ArrayList<Partita> listaPartite(int id_stadio) throws SQLException, ClassNotFoundException {
        ArrayList<Partita> elencoPartite = new ArrayList<Partita>();
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_listaPartita);
        Partita partita = null;
        stmt.setInt(1, id_stadio);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            int idsqhome = resultSet.getInt("id_sq_home");
            partita = new Partita(resultSet.getInt("id"), resultSet.getDate("data_partita"),
                    resultSet.getInt("goal_sq_home"), resultSet.getInt("goal_sq_visitor"),
                    idsqhome, resultSet.getInt("id_sq_visitor"),
                    resultSet.getInt("id_stadio"));
            //System.out.println(resultSet.getInt("id_sq_home"));
            elencoPartite.add(partita);

        }
        return elencoPartite;
    }
}

