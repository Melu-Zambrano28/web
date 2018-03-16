package it.esempio.sportivo.entity;

public class Biglietto
{
    private String seriale_biglietto;
    private int id_sconto;
    private int id_stato_biglietto;
    private int id_partita;
    private String nome;
    private String cognome;
    private double prezzo;

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public Biglietto(){}

    public Biglietto(int id_stato_biglietto, int id_partita, double prezzo, String nome, String cognome) {
        this.id_stato_biglietto = id_stato_biglietto;
        this.nome = nome;
        this.cognome = cognome;
        this.prezzo = prezzo;
        this.id_partita = id_partita;
    }

    public Biglietto(int id_sconto, int id_stato_biglietto, String nome, String cognome, int prezzo) {
        this.id_sconto = id_sconto;
        this.id_stato_biglietto = id_stato_biglietto;
        this.nome = nome;
        this.cognome = cognome;
        this.prezzo = prezzo;
    }

    public String getSeriale_biglietto() {
        return seriale_biglietto;
    }

    public void setSeriale_biglietto(String seriale_biglietto) {
        this.seriale_biglietto = seriale_biglietto;
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
                ", id_sconto=" + id_sconto +
                ", id_stato_biglietto=" + id_stato_biglietto +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
