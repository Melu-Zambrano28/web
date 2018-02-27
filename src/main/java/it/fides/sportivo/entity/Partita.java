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
    private int id_stadio;
    private Stadio stadio;


    public Partita() {
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

   public void set_stadio(Stadio stadio) {
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
}
