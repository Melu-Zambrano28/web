package it.esempio.sportivo.servicesimplementation;

//alfonso

import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.*;
import java.util.ArrayList;

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
    private static final String update_stadio= "UPDATE stadio SET nome = ? , capienza = ? ,costo_blg= ? WHERE id = ?";
    private static final String incasso_per_stadio="SELECT SUM(biglietto.prezzo_finale) totale,\n" +
            "stadio.nome nomeStadio,\n" +
            "stadio.id stadioId\n" +
            "FROM biglietto\n" +
            "INNER JOIN stato_biglietto ON biglietto.id_stato_biglietto=stato_biglietto.id\n" +
            "INNER JOIN partita ON biglietto.id_partita=partita.id\n" +
            "INNER JOIN stadio ON partita.id_stadio=stadio.id\n" +
            "GROUP BY stadio.nome , stato_biglietto.id\n" +
            "HAVING stato_biglietto.id =3 AND stadio.id=? ";

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
        st.close();
        conex.close();
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
        conex= DataSourceSingleton.getInstance().getConnection();
        st= conex.prepareStatement(update_stadio);
        st.setString(1, stadio.getNome());
        st.setInt(2,stadio.getCapienza());
        st.setDouble(3,stadio.getCosto_biglietto());
        st.setInt(4,stadio.getId());
        st.executeUpdate();
        st.close();
        conex.close();
    }

    public  ArrayList<Stadio> listaStadio() throws SQLException, ClassNotFoundException {
        conex=DataSourceSingleton.getInstance().getConnection();

        st = conex.prepareStatement(select);
        rs =st.executeQuery();
        ArrayList<Stadio> lista_stadio = new ArrayList<Stadio>();

        while(rs.next())
        {
            lista_stadio.add(
                    new Stadio(rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getDouble(4)));
        }
        return lista_stadio;
    }


    public static Stadio TrovaStadioByName(String stadio_nome) throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(trova_per_nome);
        st.setString(1, stadio_nome);
        rs= st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int capienza = rs.getInt("capienza");
            double bigl = rs.getDouble("costo_blg");
            /*stadio.setId(rs.getInt("id"));
            stadio.setNome(rs.getString("nome"));
            stadio.setCapienza(rs.getInt("capienza"));
            stadio.setCosto_biglietto(rs.getDouble("costo_blg"));*/
            stadio = new Stadio(id, nome, capienza, bigl);
        }
        return stadio;
    }

    public static Stadio incassoTotalePerStadio(int id) throws SQLException, ClassNotFoundException {
        conex= DataSourceSingleton.getInstance().getConnection();
        st= conex.prepareStatement(incasso_per_stadio);
        st.setInt(1, id);
        Stadio stadio = null;
        rs=st.executeQuery();
        while (rs.next()){
            stadio = new Stadio();
            stadio.setId(rs.getInt("stadioId"));
            stadio.setCosto_biglietto(rs.getDouble("totale"));
            stadio.setNome(rs.getString("nomeStadio"));
        }
        st.close();
        conex.close();
        return stadio;
    }









}




