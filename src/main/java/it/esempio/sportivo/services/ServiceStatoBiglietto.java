package it.esempio.sportivo.services;

import java.sql.SQLException;

public interface ServiceStatoBiglietto {

    void insertDescrizioneStato(String descrizione) throws SQLException;

    void updateDescrizioneStato(int id) throws SQLException;

    void deleteDescrizioneStato(int id) throws SQLException;

    void  TrovaStatoBigliettoById(int i) throws SQLException;

}
