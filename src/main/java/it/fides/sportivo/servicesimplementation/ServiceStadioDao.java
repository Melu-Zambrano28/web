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

    private static final String trovaIdperNome="SELECT id FROM stadio WHERE nome=?";
    private static final String select="SELECT * FROM stadio";
    private static final String trova_per_id ="SELECT * FROM stadio WHERE id=?";
    private static final String trova_per_nome ="SELECT id, nome, capienza, costo_blg FROM stadio WHERE nome = ?";
    private static final String insert_stadio = "INSERT INTO stadio (nome, capienza, costo_blg) VALUES (?,?,?)";
    private static final String delete_stadio = "DELETE FROM stadio WHERE id = ?";
    private static final String update_stadio= "UPDATE squadra SET nome = ? ,capienza= ? ,costo_blg= ? WHERE id = ?";


    public static void insertStadio(Stadio stadio) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(insert_stadio);
        st.setString(1, stadio.getNome());
        st.setInt(2,stadio.getCapienza());
        st.setDouble(3,stadio.getCosto_biglietto());
        st.execute();
        st.close();
        conex.close();
    }


    public static Stadio TrovaStadioById(int id) throws SQLException, ClassNotFoundException {
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

        conex.close();
        return stadio;
    }

    public static Stadio TrovaStadioByName(String stadio_nome) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(trova_per_nome);
        st.setString(1, stadio_nome);
        rs= st.executeQuery();
        while (rs.next()) {
            stadio.setId(rs.getInt("id"));
            stadio.setNome(rs.getString("nome"));
            stadio.setCapienza(rs.getInt("capienza"));
            stadio.setCosto_biglietto(rs.getDouble("costo_blg"));
        }
        return stadio;
    }

    //Trova gli stadi per nome
    public static int trovaStadioByName(String nome) throws SQLException, ClassNotFoundException {
        conex =DataSourceSingleton.getInstance().getConnection();
        st=conex.prepareStatement(trovaIdperNome);
        st.setString(1,nome);
        rs=st.executeQuery();
        int idStadio=0;
        while (rs.next()){
            idStadio=rs.getInt("id");
        }
        return idStadio;
    }

    public static void deleteStadio(int id) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(delete_stadio);
        st.setInt(1, id);
        st.execute();
        st.close();
        conex.close();
    }

    public static void aggiornaStadio(Stadio stadio) throws SQLException, ClassNotFoundException {
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


    public  ArrayList<Stadio> listaStadio() throws SQLException, ClassNotFoundException {
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




