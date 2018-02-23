package it.fides.sportivo.entity;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Partita {


    private int id;
    private GregorianCalendar data_partita;
    private Squadra squadra_home;
    private Squadra squadra_visitor;
    private int gol_home;
    private int gol_visitor;

    private Stadio stadio;



    public Partita() {
    }
//
 //   public Partita(int anInt, Date date, int anInt1, int anInt2, int anInt3, int anInt4, int anInt5) {
 //   }

    public Partita(int id, Date data_partita, Squadra squadra_home, Squadra squadra_visitor, int gol_home, int gol_visitor, int id_stadio, Stadio stadio) {
        this.id = id;
        this.data_partita = data_partita;
        this.squadra_home = squadra_home;
        this.squadra_visitor = squadra_visitor;
        this.gol_home = gol_home;
        this.gol_visitor = gol_visitor;
        this.id_stadio = id_stadio;
        this.stadio = stadio;
    }

    public Partita(int id, Date data_partita, int goal_sq_home, int goal_sq_visitor, int id_sq_home, int id_sq_visitor, int id_stadio) {
        this.id = id;
        this.data_partita = data_partita;
        this.gol_home = goal_sq_home;
        this.gol_visitor = goal_sq_visitor;
        this.id_squadra_home = id_sq_home;
        this.id_squadra_visitor = id_sq_visitor;
        this.id_stadio = id_stadio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getData_partita() {
        return data_partita;
    }

    public void setData_partita(GregorianCalendar data_partita) {
        this.data_partita = data_partita;
    }

    public Squadra getSquadra_home() {
        return squadra_home;
    }

    public void setSquadra_home(Squadra squadra_home) {
        this.squadra_home = squadra_home;
    }

    public Squadra getSquadra_visitor() {
        return squadra_visitor;
    }

    public void setSquadra_visitor(Squadra squadra_visitor) {
        this.squadra_visitor = squadra_visitor;
    }

    public int getGol_home() {
        return gol_home;
    }

    public void setGol_home(int gol_home) {
        this.gol_home = gol_home;
    }

    public int getGol_visitor() {
        return gol_visitor;
    }

    public void setGol_visitor(int gol_visitor) {
        this.gol_visitor = gol_visitor;
    }

   public void setId_stadio(Stadio stadio) {
       this.stadio=stadio;
   }

    public Stadio getStadio() {
        return stadio;
    }

    @Override
    public String toString() {
        return "Partita{" +
                "id=" + id +
                ", data_partita=" + data_partita +
                ", squadra_home=" + squadra_home +
                ", squadra_visitor=" + squadra_visitor +
                ", gol_home=" + gol_home +
                ", gol_visitor=" + gol_visitor +
                ", id_stadio=" + id_stadio +
                '}';
    }

    //Variabile e costruttori

    public int getId_squadra_home() {
        return id_squadra_home;
    }

    public int getId_squadra_visitor() {
        return id_squadra_visitor;
    }

    public int getId_stadio() {
        return id_stadio;
    }

    private int id_squadra_home;
    private int id_squadra_visitor;
    private int id_stadio;
}
