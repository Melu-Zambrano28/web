package it.fides.sportivo.repository;

import it.fides.sportivo.Util.GeneraSerialBiglietto;
import it.fides.sportivo.Util.UtilClientDao;
import it.fides.sportivo.services.ServiceStatoBiglietto;
import it.fides.sportivo.servicesimplementation.ServiceStatoBigliettoDao;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.UUID;

public class maino {

    public static void main(String args[]) throws SQLException {


//        Connection con = DataSourceSingleton.getInstance().getConnection(); //aperta
//        Connection con1= DataSourceSingleton.getInstance().getConnection();
//        System.out.println(con1+" \nconex 2 "+con);


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









    }

}