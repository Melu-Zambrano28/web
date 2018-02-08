package it.fides.sportivo.servicesimplementation;
import it.fides.sportivo.entity.Biglietto;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBigliettoDao {

        private final static String insert_biglietto = "INSERT INTO biglietto (seriale_biglietto, id_partecipazione, nome, " +
                "cognome, id_sconto, id_stato_biglietto) VALUES (?, ?, ?, ?, ?, ?)";
        private final static String select_biglietto = "SELECT * FROM biglietto WHERE seriale_biglietto = ?";
        private final static String update_biglietto = "UPDATE biglietto SET seriale_biglietto = ?, id_partecipazione = ?," +
                " nome = ?, cognome = ?, id_sconto = ?, id_stato_biglietto = ? WHERE seriale_biglietto = ?";
        private final static String delete_biglietto = "DELETE FROM biglietto WHERE seriale_biglietto = ?";

        public static void inserisciBiglietto(Biglietto biglietto) throws SQLException {
            Connection conn = DataSourceSingleton.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(insert_biglietto);
            stmt.setString(1, biglietto.getSeriale_biglietto());
            stmt.setInt(2, biglietto.getId_partecipazione());
            stmt.setString(3, biglietto.getNome());
            stmt.setString(4, biglietto.getCognome());
            stmt.setInt(5, biglietto.getId_sconto());
            stmt.setInt(6, biglietto.getId_stato_biglietto());
            stmt.execute();
            stmt.close();
            conn.close();
        }

        public static void aggiornaBiglietto(Biglietto biglietto) throws SQLException {
            Connection conn = DataSourceSingleton.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(update_biglietto);
            stmt.setString(1, biglietto.getSeriale_biglietto());
            stmt.setInt(2, biglietto.getId_partecipazione());
            stmt.setString(3, biglietto.getNome());
            stmt.setString(4, biglietto.getCognome());
            stmt.setInt(5, biglietto.getId_sconto());
            stmt.setInt(6, biglietto.getId_stato_biglietto());
            stmt.setString(7, biglietto.getSeriale_biglietto());
            stmt.execute();
            stmt.close();
            conn.close();
        }

        public static Biglietto selectBiglietto(String seriale_biglietto) throws  SQLException{
            Biglietto biglietto = null;
            Connection conn = DataSourceSingleton.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(select_biglietto);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                String seriale_biglietto2 = resultSet.getString(1);
                int id_partecipazione = resultSet.getInt(2);
                String nome = resultSet.getString(3);
                String cognome = resultSet.getString(4);
                int id_sconto = resultSet.getInt(5);
                int stato_biglietto = resultSet.getInt(6);
                biglietto = new Biglietto();
            }
            return biglietto;
        }

        public static void deleteBiglietto() throws SQLException {
            Connection conn = DataSourceSingleton.getInstance().getConnection();
        }



}
