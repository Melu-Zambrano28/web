package it.fides.sportivo.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.fides.sportivo.Util.GeneraSerialBiglietto;
import it.fides.sportivo.Util.UtilClientDao;
import it.fides.sportivo.entity.Biglietto;

import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.servicesimplementation.ServiceStatoBigliettoDao;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class maino {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {


/*

        GregorianCalendar date = new GregorianCalendar(1977,4-1,8);
        java.sql.Date risult=UtilClientDao.trasformaDataUtilSql(date);
        System.out.println("dal metodo trasforma "+risult);


        GregorianCalendar cal1 =UtilClientDao.trasformaDataSqlaUtil(risult);
        System.out.println("Sql a gregoriian: "+cal1.getGregorianChange());
       //ServiceStatoBigliettoDao.updateDescrizioneStato(1,"sconto per studenti");
       String seriale= GeneraSerialBiglietto.getSeriale();
        String seriale2= GeneraSerialBiglietto.getSeriale();
       System.out.print(seriale+"\nSeriale 2 :"+seriale2);
       System.out.println("lunghezze del seriale 1: "+seriale.length()+"\nseriale 2 lungh: "+seriale2.length());

       Biglietto biglietto = new Biglietto();
       biglietto.setNome("melissa");
       biglietto.setId_partecipazione(3);
       biglietto.setCognome("zambrano");
       biglietto.setId_sconto(1);
       biglietto.setId_stato_biglietto(2);
       biglietto.setSeriale_biglietto("7d7d4134-e78c-449e-a85d-b0002b95b036");  */

        List<Squadra> squadrone = new ArrayList<>();
        Squadra json = new Squadra(2,"Avellino");  Squadra json2 = new Squadra(2,"Aquila");
        Squadra json3 = new Squadra(2,"Aosta"); Squadra json4 = new Squadra(2,"Ascoli Piceno");
        squadrone.add(json); squadrone.add(json2); squadrone.add(json3); squadrone.add(json4);
        Gson giasone = new GsonBuilder().create();
        String giasoneJ = giasone.toJson(squadrone);

        System.out.println(giasoneJ);

    }

}
