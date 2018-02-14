package it.fides.sportivo.services;

import it.fides.sportivo.entity.Cliente;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;

import java.sql.SQLException;

public interface ServicePartita {

    void insertPartita(Partita partita, Squadra squadra, Stadio stadio) throws SQLException;

    void updatePartita(Partita partita) throws SQLException;

    void deletePartita(Partita partita) throws SQLException;

    Partita TrovaclienteById(int i) throws SQLException;
}
