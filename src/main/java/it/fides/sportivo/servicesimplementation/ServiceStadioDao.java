package it.fides.sportivo.servicesimplementation;

//alfonso

import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceStadioDao {
    private static Connection conex;
    private static ResultSet rs;
    private static PreparedStatement st;
    private static Stadio stadio= new Stadio();
    //private static  ArrayList<Stadio> lista_stadio = new ArrayList<Stadio>();
    private static String select="SELECT * FROM stadio";
    private static String trova_per_id ="SELECT * FROM stadio WHERE id=?";
    private static final String insert_stadio = "INSERT INTO stadio (nome, capienza, costo_blg) VALUES (?,?,?)";
    private static final String delete_stadio = "DELETE FROM stadio WHERE id = ?";
    private static final String update_stadio= "UPDATE squadra SET nome = ? ,capienza= ? ,costo_blg= ? WHERE id = ?";


    public static void insertStadio(Stadio stadio) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_stadio);
        st.setString(1, stadio.getNome());
        st.setInt(2,stadio.getCapienza());
        st.setDouble(3,stadio.getCosto_biglietto());
        st.execute();
        st.close();
        conex.close();
    }


    public static Stadio TrovaStadioById(int id) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(trova_per_id);
        st.setInt(1, id);
        rs= st.executeQuery();
        while (rs.next()) {
            stadio.setId(rs.getInt("id"));
            stadio.setNome(rs.getString("nome"));
            stadio.setCapienza(rs.getInt("capienza"));
            stadio.setCosto_biglietto(rs.getDouble("costo_blg"));
        }
        st.close();
        conex.close();
        return stadio;
    }

    public static void deleteStadio(int id) throws SQLException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(delete_stadio);
        st.setInt(1, id);
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaStadio(Stadio stadio) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        st= conn.prepareStatement(update_stadio);
        st.setString(1, stadio.getNome());
        st.setInt(2,stadio.getCapienza());
        st.setDouble(3,stadio.getCosto_biglietto());
        st.setInt(4,stadio.getId());
        st.executeUpdate();
        st.execute();
        st.close();
        conn.close();
    }

    public static ArrayList<Stadio> listaStadio() throws SQLException {
        conex=DataSourceSingleton.getInstance().getConnection();
        ArrayList<Stadio> lista_stadio = new ArrayList<Stadio>();
        st = conex.prepareStatement(select);
        rs =st.executeQuery();

        while(rs.next())
        {
            lista_stadio.add(
                    new Stadio(rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getDouble(4)));
        }
        conex.close();
        return lista_stadio;
    }








}




