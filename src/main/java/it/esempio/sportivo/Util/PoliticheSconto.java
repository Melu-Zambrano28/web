package it.esempio.sportivo.Util;

import it.esempio.sportivo.entity.Cliente;

import javax.rmi.CORBA.Util;
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


    public static int  isGiornoFortunato(String data){
        GregorianCalendar dataGregorian = Util_Data_Time.convertiStringDate_GregorianDate(data);
        int giornoRange= dataGregorian.get(Calendar.DAY_OF_MONTH);
        Random random= new Random();
        int giornoFortunato= random.nextInt(giornoRange);

        return giornoFortunato;
    }


    
}
