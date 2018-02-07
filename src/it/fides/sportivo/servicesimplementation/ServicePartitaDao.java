package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicePartitaDao {


    private static final String insert_partita = "INSERT INTO partita (data_partita, goal_sq_home, goal_sq_visitor, id_sq_home, id_sq_visitor, id_stadio)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String update_partita = "UPDATE partita SET data_partita = ?, id_sq_home = ?, id_sq_visitor = ?, id_stadio = ? WHERE id = ?";
    private static final String aggiorna_risultato = "UPDATE  partita SET goal_sq_home = ?, goal_sq_visitor = ? WHERE id = ?";

    public static void inserisciPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(insert_partita);
        stmt.setDate(1, new Date(1234-5-7));
        //stmt.setInt(2, 1);
        //stmt.setInt(3, 1);
        stmt.setInt(2, sq_home.getId());
        stmt.setInt(3, sq_visitor.getId());
        stmt.setInt(4, stadio.getId());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void aggiornaPartita(Squadra sq_home, Squadra sq_visitor, Stadio stadio, Partita partita) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(insert_partita);
        stmt.setDate(1, partita.getData_partita());
        stmt.setInt(2, 1);
        stmt.setInt(3, 1);
        stmt.setInt(4, sq_home.getId());
        stmt.setInt(5, sq_visitor.getId());
        stmt.setInt(6, stadio.getId());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static void aggiornaRisultatoPartita(int goal_home, int goal_visitor, Partita partita) throws SQLException {
        Connection conn = DataSourceSingleton.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(aggiorna_risultato);
        stmt.setInt(1, goal_home);
        stmt.setInt(2, goal_visitor);
        stmt.setInt(3, partita.getId());
        stmt.execute();
        stmt.close();
        conn.close();
    }

    }

