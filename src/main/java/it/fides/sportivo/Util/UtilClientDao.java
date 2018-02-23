package it.fides.sportivo.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UtilClientDao {


    //trasformazione della data nel formato giusto per il database
    public static java.sql.Date trasformaDataUtilSql(GregorianCalendar data_nascita){
        java.sql.Date dataSql = new java.sql.Date(data_nascita.getTimeInMillis());
        return dataSql;
    }

    //trasforma un gregorian calendar in sql dataTime(data+tempo formato sql)
    public static java.sql.Timestamp trasformaDataTimeUtilSql(GregorianCalendar data){
        java.sql.Timestamp dataTime=new java.sql.Timestamp(data.getTimeInMillis());
        return dataTime;
    }

    //trasforma una data con formato sql in gregorianCalendar
    public static GregorianCalendar trasformaDataSqlaUtil(java.sql.Date sqlDate){
        GregorianCalendar utilDate=new GregorianCalendar();
        utilDate.setGregorianChange(sqlDate);
        return utilDate;
    }

    //trasforma una string in sqlDate = in una data per sql

    public static java.sql.Date transStringDateaSqlDate(String data){
        String data_Partita = data;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        java.util.Date date = null;
        Calendar cal = null;
        java.sql.Date dataSql=null;
        try {
            date = df.parse(data_Partita);
            cal = new GregorianCalendar();
            cal.setTime(date);
            dataSql= UtilClientDao.trasformaDataUtilSql((GregorianCalendar) cal); //sql
           // GregorianCalendar dataPartitaSql = UtilClientDao.trasformaDataSqlaUtil(sql); //util


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataSql;
    }

    /*Trasforma una string in gregorian calendar senza splittare
    public static GregorianCalendar transStringDateGregorianDate(String data){
        String data_Partita = data;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        Calendar cal = null;
        java.sql.Date dataSql=null;
        GregorianCalendar dataPartitaG=null;
        try {
            date = df.parse(data_Partita);
            cal = new GregorianCalendar();
            cal.setTime(date);
            dataSql= UtilClientDao.trasformaDataUtilSql((GregorianCalendar) cal); //sql
            dataPartitaG = UtilClientDao.trasformaDataSqlaUtil(dataSql); //util


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataPartitaG;
    }*/

    //splita una string e la ritorna come gregorianCalendar
    public static GregorianCalendar transDataTimeinGregorianCalendar(String data){
       String [] dataSplit=data.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
       int giorni=Integer.parseInt(dataSplit[2]);
       int mesi=Integer.parseInt(dataSplit[1]);
       int anni=Integer.parseInt(dataSplit[0]);
       int ore=Integer.parseInt(dataSplit[3]);
       int minuti=Integer.parseInt(dataSplit[4]);
       GregorianCalendar dataPartitaG=new GregorianCalendar(anni, mesi,giorni,ore, minuti);
        return dataPartitaG;
    }

}


