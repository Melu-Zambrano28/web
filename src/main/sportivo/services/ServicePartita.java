package main.sportivo.services;

import main.sportivo.entity.Cliente;
import main.sportivo.entity.Partita;
import main.sportivo.entity.Squadra;
import main.sportivo.entity.Stadio;

import java.sql.SQLException;

public interface ServicePartita {

    void insertPartita(Partita partita, Squadra squadra, Stadio stadio) throws SQLException;

    void updatePartita(Partita partita) throws SQLException;

    void deletePartita(Partita partita) throws SQLException;

    Partita TrovaclienteById(int i) throws SQLException;
}
