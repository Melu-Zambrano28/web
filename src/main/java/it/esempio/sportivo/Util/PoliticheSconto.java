package it.esempio.sportivo.Util;

import it.esempio.sportivo.entity.Cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

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


    
}
