package it.fides.sportivo.entity;

public class Stato_biglietto
{
    private int id;
    private String descrizione;

    public Stato_biglietto(){}

    public Stato_biglietto(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Stato_biglietto{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
