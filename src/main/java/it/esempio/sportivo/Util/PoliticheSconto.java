package it.esempio.sportivo.Util;

import it.esempio.sportivo.entity.Cliente;
import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.entity.Sconto;
import it.esempio.sportivo.servicesimplementation.ServiceScontoDao;

import javax.rmi.CORBA.Util;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class PoliticheSconto {


    public static boolean isStudent(Cliente cliente){
       GregorianCalendar dataCliente=cliente.getData_nascita();
       int anno =dataCliente.get(Calendar.YEAR);
       int etaCliente =Util_Data_Time.getAnnoCorrente()-anno;
       return etaCliente<=26;
    }

    public static boolean isOver65(Cliente cliente){
        GregorianCalendar dataCliente=cliente.getData_nascita();
        int anno =dataCliente.get(Calendar.YEAR);
        int etaCliente =Util_Data_Time.getAnnoCorrente()-anno;
        return etaCliente>=65;
    }


    public static boolean  isGiornoFortunato(Partita data){
        GregorianCalendar dataGregorian = data.getData_partita();
        int giornoContronto= dataGregorian.get(Calendar.DAY_OF_MONTH);
        Random random= new Random();
        int giornoFortunato= 14;

        return giornoContronto==giornoFortunato;
    }

    public static double getSconto(int id){
        double percentuale=0;
        Sconto sconto;
        try {
            sconto=ServiceScontoDao.selectSconto(id);
            percentuale=sconto.getPerc_scon();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return percentuale;
    }
    


    public static double calcolaSconto2(Cliente c, Partita p ){
        double sconto_max=0;


        try {
            if(PoliticheSconto.isStudent(c) && PoliticheSconto.getSconto(1) > sconto_max) {
                sconto_max=PoliticheSconto.getSconto(1);

            }
            if(PoliticheSconto.isOver65(c) && PoliticheSconto.getSconto(2) > sconto_max){
                sconto_max=PoliticheSconto.getSconto(2);

            }
            if(PoliticheSconto.isGiornoFortunato(p) && PoliticheSconto.getSconto(3) > sconto_max){
                sconto_max=PoliticheSconto.getSconto(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return sconto_max;
    }









    
}
