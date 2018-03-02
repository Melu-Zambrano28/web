package it.esempio.sportivo.entity;


public class Squadra {

    private int id;
    private String nome;

    public Squadra() {
    }

    public Squadra(int id, String nome) {
        this.id = id;
        this.nome = nome;
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


    public String toString() {
        return "Squadra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }


}
