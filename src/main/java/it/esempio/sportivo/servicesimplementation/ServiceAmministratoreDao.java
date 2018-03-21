package it.esempio.sportivo.servicesimplementation;

import it.esempio.sportivo.entity.Amministratore;
import it.esempio.sportivo.entity.Biglietto;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAmministratoreDao {
    private static Connection conex=null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    private final static String inserisciAdmin = "INSERT INTO amministratori (nome, cognome, ruolo, email) values (?,?,?,?)";
    private final static String updateAdmin = "UPDATE amministratori SET nome = ?, cognome = ?,ruolo = ? , email = ? WHERE id = ?";
    private final static String trova_per_id="Select * from amministratori  where id=?";
    private final static String deleteAdmin = "delete from amministratori where id=?";
    private final static String trovaPw="SELECT \n" +
            "pw pw\n" +
            "FROM amministratori\n" +
            "WHERE email=? AND ruolo=?";

    public static void inserisciAdmin(Amministratore admin) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(inserisciAdmin);
        st.setString(1, admin.getNome());
        st.setString(2,admin.getCognome());
        st.setString(3,admin.getRuolo());
        st.setString(4,admin.getEmail());
        st.execute();
        st.close();
        conex.close();
    }

    //sistemarlo non funziona al momento
    public static void aggiornaAdmin(Amministratore admin) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(updateAdmin);
        st.setString(1, admin.getNome());
        st.setString(2, admin.getCognome());
        st.setString (3,admin.getRuolo());
        st.setString(4, admin.getEmail());
        st.setInt(5, admin.getId());
        st.close();
        conex.close();
    }

    public static Amministratore trovaAdminByID(int id) throws SQLException, ClassNotFoundException {
        Amministratore admin =null;
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(trova_per_id);
        st.setInt(1, id);
        rs= st.executeQuery();
        while (rs.next()) {
            admin= new Amministratore();
            admin.setId(rs.getInt("id"));
            admin.setNome(rs.getString("nome"));
            admin.setCognome(rs.getString ("cognome"));
            admin.setRuolo(rs.getString("ruolo"));
            admin.setEmail(rs.getString("email"));
        }
        return admin;
    }

    public static void deleteAdmin(int id) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(deleteAdmin);
        st.setInt(1, id);
        st.execute();
        st.close();
        conex.close();
    }

    public static String  trovaPwByEmail(String email, String ruolo) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(trovaPw);
        st.setString(1, email);
        st.setString(2, ruolo);
        rs = st.executeQuery();
        String pw = "";
        while (rs.next()) {
            pw = rs.getString("pw");

        }
        return pw;
    }


}
