package it.esempio.sportivo.servicesimplementation;

import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.*;

public class ServiceStatoBigliettoDao{
    private static String insertDescrizione="INSERT INTO stato_biglietto (descrizione) VALUES (?)";
    private static final String updateDescrizione="UPDATE stato_biglietto SET descrizione=? " +" WHERE id=? ";
    private static final String deleteDescrizione="DELETE FROM stato_biglietto WHERE id=?";
    private static Connection conx;
    private static ResultSet  rs;
    private static PreparedStatement st;


    public static void insertDescrizioneStato(String descrizione) throws SQLException, ClassNotFoundException {
        conx= DataSourceSingleton.getInstance().getConnection();
        st=conx.prepareStatement(insertDescrizione);
        st.setString(1,descrizione);
        st.executeUpdate();

    }

    public static void updateDescrizioneStato(int id,String descrizione) throws SQLException, ClassNotFoundException {
        conx=DataSourceSingleton.getInstance().getConnection();
        st=conx.prepareStatement(updateDescrizione);
        st.setString(1,descrizione);
        st.setInt(2,id);
        st.executeUpdate();

    }

    public static  void deleteDescrizioneStato(int id) throws SQLException, ClassNotFoundException {
        conx=DataSourceSingleton.getInstance().getConnection();
        st=conx.prepareStatement(deleteDescrizione);
        st.setInt(1,id);
        st.executeUpdate();


    }

    public static void TrovaStatoBigliettoById(int id) throws SQLException, ClassNotFoundException {
        conx=DataSourceSingleton.getInstance().getConnection();
        Statement stm =conx.createStatement();
        int idDb=0;
        String desc="";
        rs=stm.executeQuery("SELECT * FROM stato_biglietto WHERE id="+id);
        while(rs.next()){

            idDb=rs.getInt("id");
            desc=rs.getString("descrizione");

            System.out.println("id_StatoBiglietto: "+id+" \nDescrizione: "+desc);
        }
    }


}
