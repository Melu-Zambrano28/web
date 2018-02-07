package it.fides.sportivo.services;

import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;

import java.sql.SQLException;

public interface ServiceStatoBiglietto {

    void insertDescrizioneStato(String descrizione) throws SQLException;

    void updateDescrizioneStato(int id) throws SQLException;

    void deleteDescrizioneStato(int id) throws SQLException;

    void  TrovaStatoBigliettoById(int i) throws SQLException;

}
