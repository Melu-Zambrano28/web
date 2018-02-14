package main.sportivo.entity;

import java.math.BigDecimal;

public class Sconto
{
    private int id;
    private String descrizione;
    private double perc_scon;

    public Sconto(){}

    public Sconto(int id, String descrizione, double perc_scon) {
        this.id = id;
        this.descrizione = descrizione;
        this.perc_scon = perc_scon;
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

    public double getPerc_scon() {
        return perc_scon;
    }

    public void setPerc_scon(double perc_scon) {
        this.perc_scon = perc_scon;
    }

    @Override
    public String toString() {
        return "Sconto{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", perc_scon=" + perc_scon +
                '}';
    }
}
