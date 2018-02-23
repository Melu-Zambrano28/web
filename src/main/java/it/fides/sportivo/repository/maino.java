package it.fides.sportivo.repository;

import java.sql.SQLException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.servicesimplementation.ServicePartitaDao;

import java.sql.SQLException;
import java.util.ArrayList;

import it.fides.sportivo.Util.GeneraSerialBiglietto;
import it.fides.sportivo.Util.Util_Data_Time;

import java.sql.*;
import java.util.GregorianCalendar;

public class maino {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {


//        Connection con = DataSourceSingleton.getInstance().getConnection(); //aperta
//        Connection con1= DataSourceSingleton.getInstance().getConnection();
//        System.out.println(con1+" \nconex 2 "+con);


        GregorianCalendar date = new GregorianCalendar(1977, 4 - 1, 8);
        java.sql.Date risult = Util_Data_Time.covertiGregorianCalendar_Sql(date);
        System.out.println("dal metodo trasforma " + risult);


        GregorianCalendar cal1 = Util_Data_Time.convertiDataSql_Gregorian(risult);
        System.out.println("Sql a gregoriian: " + cal1.getGregorianChange());
        //ServiceStatoBigliettoDao.updateDescrizioneStato(1,"sconto per studenti");
        String seriale = GeneraSerialBiglietto.getSeriale();
        String seriale2 = GeneraSerialBiglietto.getSeriale();
        System.out.print(seriale + "\nSeriale 2 :" + seriale2);
        System.out.println("lunghezze del seriale 1: " + seriale.length() + "\nseriale 2 lungh: " + seriale2.length());

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


//        Cliente cliente = new Cliente();
//        cliente.setNome("Elsa");
//        cliente.setCognome("Mera");
//        cliente.setData_nascita(date);
//        cliente.setId(15);
//
//        ServiceClienteDao data = new ServiceClienteDao();
//        data.deleteCliente(cliente);
//
    }
}