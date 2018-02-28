package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.Util.Util_Data_Time;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

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


    public static void inserisciPartita(Partita partita,Squadra sq_home, Squadra sq_visitor, Stadio stadio) throws SQLException, ClassNotFoundException {
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

}

