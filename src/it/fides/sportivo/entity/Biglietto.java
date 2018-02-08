package it.fides.sportivo.entity;

import it.fides.sportivo.Util.GeneraSerialBiglietto;
import sun.java2d.loops.FillRect;

public class Biglietto
{
    private String seriale_biglietto;
    private int id_partecipazione;
    private int id_sconto;
    private int id_stato_biglietto;
    private String nome;
    private String cognome;

    public Biglietto(){}

    public Biglietto(String seriale_biglietto, int id_partecipazione, int id_sconto, int id_stato_biglietto, String nome, String cognome) {
        this.seriale_biglietto = seriale_biglietto;
        this.id_partecipazione = id_partecipazione;
        this.id_sconto = id_sconto;
        this.id_stato_biglietto = id_stato_biglietto;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getSeriale_biglietto() {
        return seriale_biglietto;
    }

    public void setSeriale_biglietto(String seriale_biglietto) {
        this.seriale_biglietto = seriale_biglietto;
    }

    public int getId_partecipazione() {
        return id_partecipazione;
    }

    public void setId_partecipazione(int id_partecipazione) {
        this.id_partecipazione = id_partecipazione;
    }

    public int getId_sconto() {
        return id_sconto;
    }

    public void setId_sconto(int id_sconto) {
        this.id_sconto = id_sconto;
    }

    public int getId_stato_biglietto() {
        return id_stato_biglietto;
    }

    public void setId_stato_biglietto(int id_stato_biglietto) {
        this.id_stato_biglietto = id_stato_biglietto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "seriale_biglietto='" + seriale_biglietto + '\'' +
                ", id_partecipazione=" + id_partecipazione +
                ", id_sconto=" + id_sconto +
                ", id_stato_biglietto=" + id_stato_biglietto +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
