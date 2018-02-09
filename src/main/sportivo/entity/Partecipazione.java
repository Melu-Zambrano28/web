package main.sportivo.entity;

public class Partecipazione
{
    private int id;
    private String stato;
    private int id_cliente;
    private int id_partita;

    public Partecipazione(){}

    public Partecipazione(int id, String stato, int id_cliente, int id_partita) {
        this.id = id;
        this.stato = stato;
        this.id_cliente = id_cliente;
        this.id_partita = id_partita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_partita() {
        return id_partita;
    }

    public void setId_partita(int id_partita) {
        this.id_partita = id_partita;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", stato='" + stato + '\'' +
                ", id_cliente=" + id_cliente +
                ", id_partita=" + id_partita +
                '}';
    }
}
