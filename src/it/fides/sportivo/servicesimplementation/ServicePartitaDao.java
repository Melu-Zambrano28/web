package it.fides.sportivo.servicesimplementation;

import com.mysql.jdbc.PreparedStatement;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;
import it.fides.sportivo.services.ServicePartita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicePartitaDao implements ServicePartita {
    private static Connection conx;
    private static PreparedStatement st;
    private static ResultSet rs;
    private static final String queryCreaPartita="INSERT INTO partita(data_partita, goal_sql_home, goal_sql_visitor, id_sq_home, id_sq_visitor, id_stadio)"+"VALUES(?,?,?,?,?,?)";
    private static final String queryUpdateUtente="UPDATE cliente SET nome=?, cognome=?, data_nascita=? " +" WHERE id=? ";
    private static final String queryDeleteUtente="DELETE FROM cliente WHERE id=?";
    private static final String queryFind="SELECT * FROM cliente WHERE id=?";


    public void insertPartita(Partita partita, Squadra squadra, Stadio stadio) throws SQLException {
        conx= DataSourceSingleton.getInstance().getConnection();


    }

    public void updatePartita(Partita partita) throws SQLException {

    }

    public void deletePartita(Partita partita) throws SQLException {

    }

    public Partita TrovaclienteById(int i) throws SQLException {
        return null;
    }
}
