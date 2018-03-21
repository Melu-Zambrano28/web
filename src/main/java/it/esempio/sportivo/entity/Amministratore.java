package it.esempio.sportivo.entity;

public class Amministratore {
    private String nome;
    private String cognome;
    private String email;
    private String ruolo;
    private  int id;
    private String password;

    public Amministratore(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public  void  setEmail(String email){
        this.email=email;
    }


    public String getEmail() {
        String emailFinale = this.getNome()+"."+this.cognome+"@"+this.getRuolo()+".it";
        this.email=emailFinale;
        return email;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


}
