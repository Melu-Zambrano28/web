package it.fides.sportivo.entity;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Cliente {

    private int id;
    private String nome;
    private String cognome;
    private GregorianCalendar data_nascita;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cognome, GregorianCalendar data_nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public GregorianCalendar getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(GregorianCalendar data_nascita) {
        this.data_nascita = data_nascita;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
