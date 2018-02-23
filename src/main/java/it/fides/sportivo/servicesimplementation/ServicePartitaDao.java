package it.fides.sportivo.servicesimplementation;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import it.fides.sportivo.Util.Util_Data_Time;
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
    private static final String select_stringa_partita = "SELECT partita.id as id, sq1.nome as sq_home, partita.goal_sq_home as goal_home, sq2.nome as sq_visitor, partita.goal_sq_visitor as goal_visitor, stad.nome as stadio, partita.data_partita as orario FROM partita" +
            " inner join squadra sq1 " +
            "on partita.id_sq_home = sq1.id " +
            "inner join squadra sq2 " +
            "on partita.id_sq_visitor = sq2.id " +
            "inner join stadio stad " +
            "on partita.id_stadio = stad.id " +
            "order by stad.id";


    public static void inserisciPartita(Partita partita, Squadra sq_home, Squadra sq_visitor, Stadio stadio) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_partita);

        java.sql.Timestamp sqlData= Util_Data_Time.convertiDataTimeUtil_Sql(partita.getData_partita());
        st.setTimestamp(1,sqlData);
        st.setInt(2, sq_home.getId());
        st.setInt(3, sq_visitor.getId());
        st.setInt(4, stadio.getId());
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio, Partita partita) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(update_partita);
        java.sql.Date sqlData= Util_Data_Time.covertiGregorianCalendar_Sql(partita.getData_partita());
        st.setDate(1, sqlData);
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


    public static ArrayList<Partita> listaPartitaOrig() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt;
        ResultSet resultSet;
        ArrayList<Partita> elencoPartite = new ArrayList<Partita>();
        conex = DataSourceSingleton.getInstance().getConnection();
        stmt = conex.prepareStatement(select_stringa_partita);
        Partita partita;
        GregorianCalendar data_partita_gregoriana;
        Squadra partita_sq_home;
        Squadra partita_sq_visitor;
        Stadio stadio;
        int gh, gv, id;
        resultSet = stmt.executeQuery();
        while (true) {
            if (!(resultSet.next())) break;
            id = resultSet.getInt("id");
            java.sql.Date data_partita = resultSet.getDate("orario");
            gh = resultSet.getInt("goal_home");
            gv = resultSet.getInt("goal_visitor");
            String squadraA = resultSet.getString("sq_home");
            String squadraB = resultSet.getString("sq_visitor");
            String stadio_n = resultSet.getString("stadio");
            partita_sq_home = ServiceSquadraDao.selectSquadra(squadraA);
            partita_sq_visitor = ServiceSquadraDao.selectSquadra(squadraB);
            stadio = ServiceStadioDao.TrovaStadioByName(stadio_n);
            System.out.println(resultSet.isClosed());
            data_partita_gregoriana = Util_Data_Time.convertiDataSql_Gregorian(data_partita);
            partita = new Partita(id, data_partita_gregoriana,
                    partita_sq_home, partita_sq_visitor, gh, gv,
                    stadio);
            elencoPartite.add(partita);
            System.out.println( conex.isClosed());
        }
        return elencoPartite;
    }


    public static Map<String, String[]> listaPartiteOriginal() throws SQLException, ClassNotFoundException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(select_stringa_partita);
        HashMap<String, String[]> listone = new HashMap<String, String[]>();
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                String sq_home = resultSet.getString("sq_home");
                String sq_visitor = resultSet.getString("sq_visitor");
                String stadio = resultSet.getString("stadio");
                int id_partita = resultSet.getInt("id");
                String[] raccolta = {
                        sq_home,
                        sq_visitor,
                        stadio
                };
                listone.put("partita-id: " + id_partita, raccolta);
            }
        }
        return listone;
    }

}

