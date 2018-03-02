package it.esempio.sportivo.services;

import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.entity.Squadra;
import it.esempio.sportivo.entity.Stadio;

import java.sql.SQLException;

public interface ServicePartita {

    void insertPartita(Partita partita, Squadra squadra, Stadio stadio) throws SQLException;

    void updatePartita(Partita partita) throws SQLException;

    void deletePartita(Partita partita) throws SQLException;

    Partita TrovaclienteById(int i) throws SQLException;
}
