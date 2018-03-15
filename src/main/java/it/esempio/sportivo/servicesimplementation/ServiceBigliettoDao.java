package it.esempio.sportivo.servicesimplementation;
import it.esempio.sportivo.Util.GeneraSerialBiglietto;
import it.esempio.sportivo.entity.Biglietto;
import it.esempio.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBigliettoDao {

        private static Connection conex=null;
        private static PreparedStatement st = null;
        private static ResultSet rs = null;

        private final static String insert_biglietto = "INSERT INTO biglietto (seriale_biglietto, nome, " +
                "cognome, id_sconto, id_stato_biglietto) VALUES (?, ?, ?, ?, ?)";
        private final static String select_biglietto = "SELECT * FROM biglietto WHERE seriale_biglietto = ?";
        private final static String update_biglietto = "UPDATE biglietto SET nome = ?, cognome = ?, id_sconto = ?, id_stato_biglietto = ? WHERE seriale_biglietto = ?";
        private final static String delete_biglietto = "DELETE FROM biglietto WHERE seriale_biglietto = ?";
        private final static String listaBiglietti="SELECT biglietto.seriale_biglietto seriale,\n" +
                "cliente.nome nome,\n" +
                "cliente.cognome cognome,\n" +
                "sconto.descrizione descrizione,\n" +
                "partita.data_partita data_p,\n" +
                "s1.nome home,\n" +
                "s2.nome visitor\n" +
                "FROM biglietto\n" +
                "INNER JOIN cliente ON biglietto.id_cliente=cliente.id\n" +
                "INNER JOIN sconto ON biglietto.id_sconto=sconto.id\n" +
                "INNER JOIN squadra AS s1 ON partita.id_sq_home=s1.id\n" +
                "INNER JOIN squadra AS s2 ON partita.id_sq_visitor=s2.id\n";

        public static void inserisciBiglietto(Biglietto biglietto) throws SQLException, ClassNotFoundException {
            conex = DataSourceSingleton.getInstance().getConnection();
            st = conex.prepareStatement(insert_biglietto);
            String seriale= GeneraSerialBiglietto.getSeriale();
            st.setString(1, seriale); //sicuro: cosi i seriali vengono generati solo per insrimento
            st.setString(2, biglietto.getNome());
            st.setString(3, biglietto.getCognome());
            st.setInt(4, biglietto.getId_sconto());
            st.setInt(5, biglietto.getId_stato_biglietto());
            st.execute();
            st.close();
            conex.close();
        }

        public static void aggiornaBiglietto(Biglietto biglietto) throws SQLException, ClassNotFoundException {
            conex = DataSourceSingleton.getInstance().getConnection();
            st = conex.prepareStatement(update_biglietto);
            st.setString(1, biglietto.getNome());
            st.setString(2, biglietto.getCognome());
            st.setInt(3, biglietto.getId_sconto());
            st.setInt(4, biglietto.getId_stato_biglietto());
            st.setString(5, biglietto.getSeriale_biglietto());
            st.execute();
            st.close();
            conex.close();
        }

        public static Biglietto selectBiglietto(String seriale_biglietto) throws SQLException, ClassNotFoundException {
            Biglietto biglietto = null;
            conex = DataSourceSingleton.getInstance().getConnection();
            st = conex.prepareStatement(select_biglietto);
            rs = st.executeQuery();
            while(rs.next()) {
                String seriale_biglietto2 = rs.getString(1);
                String nome = rs.getString(2);
                String cognome = rs.getString(3);
                int id_sconto = rs.getInt(4);
                int stato_biglietto = rs.getInt(5);
                biglietto = new Biglietto();
            }
            return biglietto;
        }

        public static void deleteBiglietto(String s) throws SQLException, ClassNotFoundException {
            conex = DataSourceSingleton.getInstance().getConnection();
            st = conex.prepareStatement(delete_biglietto);
            st.setString(1,s);
            st.execute();
        }



}
