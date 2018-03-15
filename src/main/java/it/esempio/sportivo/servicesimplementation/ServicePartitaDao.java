package it.esempio.sportivo.servicesimplementation;

import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.entity.Squadra;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ServicePartitaDao {

    private static Connection conex=null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;


    private static final String insert_partita = "INSERT INTO partita (data_partita, id_sq_home, id_sq_visitor, id_stadio)" +
            " VALUES (?, ?, ?, ?)";
    private static final String update_partita = "UPDATE partita SET data_partita = ?, id_sq_home = ?, id_sq_visitor = ?, id_stadio = ? WHERE id = ?";
    private static final String aggiorna_risultato = "UPDATE  partita SET goal_sq_home = ?, goal_sq_visitor = ? WHERE id = ?";
    private final static String delete_partita = "DELETE FROM partita WHERE id = ?";
    private static final String querySelect="SELECT * FROM partita";
    private static final String ordinaPerData="SELECT partita.id AS id,\n" +
            "sq1.id AS id_sq_home,\n" +
            " sq1.nome AS sq_home, \n" +
            "sq2.id AS id_sq_Visitor,\n" +
            " sq2.nome AS sq_visitor,  \n" +
            "\n" +
            " stad.nome AS stadio,\n" +
            " stad.id AS idStadio,\n" +
            " stad.capienza AS capienza,\n" +
            "stad.costo_blg AS prezzo, \n"+
            " partita.data_partita AS orario \n" +
            " FROM partita \n" +
            " INNER JOIN squadra sq1 ON partita.id_sq_home = sq1.id \n" +
            " INNER JOIN squadra sq2 ON partita.id_sq_visitor = sq2.id \n" +
            " INNER JOIN stadio stad ON partita.id_stadio = stad.id\n" +
            " ORDER BY orario";

    private static final String select_stringa_partita = "SELECT partita.id as id, sq1.nome as sq_home, partita.goal_sq_home as goal_home, sq2.nome as sq_visitor, partita.goal_sq_visitor as goal_visitor, stadio.nome as stadio, partita.data_partita as orario FROM partita" +
            " inner join squadra sq1 " +
            "on partita.id_sq_home = sq1.id " +
            "inner join squadra sq2 " +
            "on partita.id_sq_visitor = sq2.id " +
            "inner join stadio stadio " +
            "on partita.id_stadio = stadio.id " +
            "HAVING orario > now() " +
            "order by "; //+
    private static final String querySelectPartitaById="SELECT * FROM partita WHERE id=?";


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
        st.setInt(4,stadio.getId());
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
        st.setInt(1,id);
        st.execute();

    }


  /*  public ArrayList<Partita> listaPartita() throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(querySelect);
        Partita partita=null;
        ArrayList<Partita> listaPartita= new ArrayList<Partita>();
        rs = st.executeQuery();
        while(rs.next()) {
            partita = new Partita();
            partita.setId(rs.getInt(""));

            listaPartita.add(partita);
        }
        return listaPartita;
    }*/

    public ArrayList<Partita> elencoOrdinatoPerData() throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(ordinaPerData);
        Partita partita=null;

        ArrayList<Partita> listaPartita= new ArrayList<Partita>();
        rs = st.executeQuery();
        while(rs.next()) {
            partita = new Partita();
            partita.setId(rs.getInt("id"));

            //data
            GregorianCalendar data_partita =Util_Data_Time.convertiTimeStampSql_GregorianCalendar(rs.getTimestamp("orario"));
            partita.setData_partita(data_partita);
            //stadio
            Stadio stadio=new Stadio();
            stadio.setId(rs.getInt("idStadio"));
            stadio.setNome(rs.getString("stadio"));
            stadio.setCapienza(rs.getInt("capienza"));
            stadio.setCosto_biglietto(rs.getDouble("prezzo"));

            //home
            Squadra home=new  Squadra();
            home.setId(rs.getInt("id_sq_home"));
            home.setNome(rs.getString("sq_home"));

            //visitor
            Squadra visitor=new Squadra();
            visitor.setId(rs.getInt("id_sq_visitor"));
            visitor.setNome(rs.getString("sq_visitor"));

            partita.setSquadra_home(home);
            partita.setSquadra_visitor(visitor);
            partita.set_stadio(stadio);
            listaPartita.add(partita);

        }
        return listaPartita;


    }

    public static ArrayList<Partita> listaPartitaOrig(String ordine) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt;
        ResultSet resultSet;
        ArrayList<Partita> elencoPartite = new ArrayList<Partita>();
        conex = DataSourceSingleton.getInstance().getConnection();
        stmt = conex.prepareStatement(select_stringa_partita + ordine);
        Partita partita;
        Squadra partita_sq_home;
        Squadra partita_sq_visitor;
        Stadio stadio;
        int gh, gv, id;
        resultSet = stmt.executeQuery();
        while (true) {
            if (!(resultSet.next())) break;
            id = resultSet.getInt("id");
            java.sql.Date data_partita = resultSet.getDate("orario");
            //String data_partita = resultSet.getString("orario");
            gh = resultSet.getInt("goal_home");
            gv = resultSet.getInt("goal_visitor");
            String squadraA = resultSet.getString("sq_home");
            String squadraB = resultSet.getString("sq_visitor");
            String stadio_n = resultSet.getString("stadio");
            partita_sq_home = ServiceSquadraDao.selectSquadra(squadraA);
            partita_sq_visitor = ServiceSquadraDao.selectSquadra(squadraB);
            stadio = ServiceStadioDao.TrovaStadioByName(stadio_n);
            GregorianCalendar data_partita_gregoriana =  Util_Data_Time.convertiTimeStampSql_GregorianCalendar(resultSet.getTimestamp("orario"));
            System.out.println(data_partita);
            System.out.println(data_partita_gregoriana);
            partita = new Partita(id, data_partita_gregoriana,
                    partita_sq_home, partita_sq_visitor, gh, gv,
                    stadio);
            elencoPartite.add(partita);
        }
        conex.close();
        return elencoPartite;
    }
    public static Partita getPartitaById(int id) throws SQLException, ClassNotFoundException{
        Partita p;
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(querySelectPartitaById);
        st.setInt(1, id);
        rs = st.executeQuery();

        p = ServicePartitaDao.mappaturaPartita(rs);

        return p;

    }

    private static Partita mappaturaPartita(ResultSet result) throws SQLException, ClassNotFoundException {
        Partita p = new Partita();
        p.setId(result.getInt("id"));
        java.sql.Date sqlDate=result.getDate("data_partita");
        GregorianCalendar newDate= Util_Data_Time.convertiDataSql_Gregorian(sqlDate);
        p.setData_partita(newDate);
        p.setSquadra_home(ServiceSquadraDao.selectSquadra(result.getInt("squadra_home")));
        p.setSquadra_visitor(ServiceSquadraDao.selectSquadra(result.getInt("squadra_visitor")));
        p.setGol_home(result.getInt("gol_home"));
        p.setGol_visitor(result.getInt("gol_visitor"));
        p.set_stadio(ServiceStadioDao.TrovaStadioById(result.getInt("id_stadio")));

        return p;
    }

}

