package it.fides.sportivo.entity;

import java.math.BigDecimal;


public class Stadio {


    private int id;
    private String  nome;
    private int capienza;
    private double costo_biglietto;


    public Stadio(int id, String nome, int capienza, double costo_biglietto) {
        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
        this.costo_biglietto = costo_biglietto;
    }

    public Stadio() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public double getCosto_biglietto() {
        return costo_biglietto;
    }

    public void setCosto_biglietto(double costo_biglietto) {
        this.costo_biglietto = costo_biglietto;
    }

    @Override
    public String toString() {
        return "Stadio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capienza=" + capienza +
                ", costo_biglietto=" + costo_biglietto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stadio stadio = (Stadio) o;
        return id == stadio.id &&
                capienza == stadio.capienza;
    }

}
