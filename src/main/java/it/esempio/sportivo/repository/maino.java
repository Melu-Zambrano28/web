package it.esempio.sportivo.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.esempio.sportivo.Util.CalendarJsonSerializer;
import it.esempio.sportivo.Util.GeneraSerialBiglietto;
import it.esempio.sportivo.Util.PoliticheSconto;
import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Amministratore;
import it.esempio.sportivo.entity.Cliente;
import it.esempio.sportivo.entity.Partita;

import it.esempio.sportivo.servicesimplementation.ServiceAmministratoreDao;
import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;

import it.esempio.sportivo.services.ServicePartita;
import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;


import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class maino {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {


//        Connection con = DataSourceSingleton.getInstance().getConnection(); //aperta
//        Connection con1= DataSourceSingleton.getInstance().getConnection();
//        System.out.println(con1+" \nconex 2 "+con);


        GregorianCalendar date = new GregorianCalendar(1977,4-1,8);
        java.sql.Date risult= Util_Data_Time.covertiGregorianCalendar_Sql(date);
        System.out.println("dal metodo trasforma "+risult);


        GregorianCalendar cal1 = Util_Data_Time.convertiDataSql_Gregorian(risult);
        System.out.println("Sql a gregoriian: "+cal1.getGregorianChange());
       //ServiceStatoBigliettoDao.updateDescrizioneStato(1,"sconto per studenti");
       String seriale= GeneraSerialBiglietto.getSeriale();
        String seriale2= GeneraSerialBiglietto.getSeriale();
       System.out.print(seriale+"\nSeriale 2 :"+seriale2);
       System.out.println("lunghezze del seriale 1: "+seriale.length()+"\nseriale 2 lungh: "+seriale2.length());

      /* Biglietto biglietto = new Biglietto();
       biglietto.setNome("melissa");
       biglietto.setId_partecipazione(3);
       biglietto.setCognome("zambrano");
       biglietto.setId_sconto(1);
       biglietto.setId_stato_biglietto(2);
       biglietto.setSeriale_biglietto("7d7d4134-e78c-449e-a85d-b0002b95b036");


        ServiceBigliettoDao.deleteBiglietto("7d7d4134-e78c-449e-a85d-b0002b95b036");*/
//        ServiceSquadraDao dqdao= new ServiceSquadraDao();
//        ArrayList<Squadra> elenco = dqdao.listaSquadra();
//        for(int i=0; i<elenco.size(); i++){
//            System.out.println(elenco);
//        }

//        int idStadio=ServiceStadioDao.trovaStadioByName("olimpico");
////        int idSq=ServiceSquadraDao.trovaSquadraByName("milanS"); //zero se no existe
////        System.out.println(idStadio+"\n"+idSq);




        GregorianCalendar data = Util_Data_Time.convertiStringDataTime_GregorianCalendar("28-08-1994,12:23");
        System.out.println(data.getGregorianChange());
        ServicePartitaDao dd = new ServicePartitaDao();

        ArrayList<Partita> sce = dd.listaPartitaOrig("orario");
        ArrayList<Partita> sceMelissa = dd.elencoOrdinatoPerData();
        for(Partita parti : sceMelissa) System.out.println(parti.getData_partita().getGregorianChange());


        Gson gson2 = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(GregorianCalendar.class, new CalendarJsonSerializer()).create();

        System.out.println(gson2.toJson(sce));














//        Cliente cliente = new Cliente();
//        cliente.setNome("Elsa");
//        cliente.setCognome("Mera");
//        cliente.setData_nascita(date);
//        cliente.setId(15);
//
//        ServiceClienteDao data = new ServiceClienteDao();
//        data.deleteCliente(cliente);
//
//        ServiceClienteDao.chiudiTutto();

//        ServicePartitaDao partitaDao = new ServicePartitaDao();
//        ArrayList<Partita> elencoP = partitaDao.elencoOrdinatoPerData();
//        for(int i=0; i<elencoP.size(); i++){
//            System.out.println("codice partita: "+elencoP.get(i).getId());
//            System.out.println("data: "+elencoP.get(i).getData_partita().getGregorianChange());
//            System.out.println("Stadio: "+elencoP.get(i).getStadio().getNome());
//
//            System.out.println("home: "+elencoP.get(i).getSquadra_home().getNome());
//            System.out.println("visitor: "+elencoP.get(i).getSquadra_visitor().getNome());
//
//        }

        Cliente melu = new Cliente();
        melu.setNome("melu");
        melu.setCognome("guzman");
        melu.setId(2);

//        int anni=date.get(Calendar.YEAR);
 /*       GregorianCalendar oggi = new GregorianCalendar(1945,12,28);
        melu.setData_nascita(oggi);
        System.out.println(PoliticheSconto.isOver65(melu));
        Random r = new Random();
        System.out.println(Util_Data_Time.getDaysOfMoth(oggi));
        ServicePartitaDao partite = new ServicePartitaDao();

        ArrayList<Partita> elenco = partite.elencoOrdinatoPerData();
        Partita pronta = elenco.get(1);
        System.out.println(PoliticheSconto.calcolaSconto(melu, pronta));
        System.out.println(ServiceStadioDao.incassoTotalePerStadio(9).getCosto_biglietto()); */

        Amministratore ad = new Amministratore();
        ad.setNome("melissa");
        ad.setCognome("guzman");
        ad.setRuolo("administratore");

        System.out.println(ServiceAmministratoreDao.trovaAdminByID(1).getEmail());
        System.out.println(ServiceAmministratoreDao.trovaPwByEmail(ad.getEmail(), ad.getRuolo()));



    }

}
