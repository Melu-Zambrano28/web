package it.fides.sportivo.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util_Data_Time {


    //trasformazione della data nel formato giusto per il database
    public static java.sql.Date covertiGregorianCalendar_Sql(GregorianCalendar data_nascita){
        java.sql.Date dataSql = new java.sql.Date(data_nascita.getTimeInMillis());
        return dataSql;
    }

    //trasforma un gregorian calendar in sql dataTime(data+tempo formato sql)
    public static java.sql.Timestamp convertiDataTimeUtil_Sql(GregorianCalendar data){
        java.sql.Timestamp dataTime=new java.sql.Timestamp(data.getTimeInMillis());
        return dataTime;
    }

    public static GregorianCalendar convertiTimeStampSql_GregorianCalendar(java.sql.Timestamp data){
        java.util.GregorianCalendar dataGragorian= new java.util.GregorianCalendar();
        dataGragorian.setGregorianChange(data);
        return dataGragorian;
    }

    //trasforma una data con formato sql in gregorianCalendar
    public static GregorianCalendar convertiDataSql_Gregorian(java.sql.Date sqlDate){
        GregorianCalendar utilDate=new GregorianCalendar();
        utilDate.setGregorianChange(sqlDate);
        return utilDate;
    }

    //trasforma una string in sqlDate = in una data per sql

    public static java.sql.Date convertiString_SqlDataTime(String data){
        String data_Partita = data;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        java.util.Date date = null;
        Calendar cal = null;
        java.sql.Date dataSql=null;
        try {
            date = df.parse(data_Partita);
            cal = new GregorianCalendar();
            cal.setTime(date);
            dataSql= Util_Data_Time.covertiGregorianCalendar_Sql((GregorianCalendar) cal); //sql

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataSql;
    }

    /*Trasforma una string in gregorian calendar senza splittare*/
    public static GregorianCalendar convertiStringDate_GregorianDate(String data){
        String data_Partita = data;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        GregorianCalendar cal = null;
        java.sql.Date dataSql=null;
        GregorianCalendar dataPartitaG=null;
        try {
            date = df.parse(data_Partita);
            cal = new GregorianCalendar();
            cal.setTime(date);
            dataPartitaG = Util_Data_Time.convertiDataSql_Gregorian(dataSql); //util


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataPartitaG;
    }

    public static String convertiGregorianCalendar_String (GregorianCalendar data){
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(data);
        String dateFormatted = fmt.format(data.getGregorianChange());
        return dateFormatted;

    }

    public static String convertiGregorianCalendarDataTime_String (GregorianCalendar data){
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        fmt.setCalendar(data);
        String dateFormatted = fmt.format(data.getGregorianChange());
        return dateFormatted;

    }


    //splita una string e la ritorna come gregorianCalendar
    public static GregorianCalendar convertiStringDataTime_GregorianCalendar(String data){
       String [] dataSplit=data.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
       int giorni=Integer.parseInt(dataSplit[2]);
       int mesi=Integer.parseInt(dataSplit[1]);
       int anni=Integer.parseInt(dataSplit[0]);
       int ore=Integer.parseInt(dataSplit[3]);
       int minuti=Integer.parseInt(dataSplit[4]);
       GregorianCalendar dataPartitaG=new GregorianCalendar(anni, (mesi-1),giorni,ore, minuti);
        return dataPartitaG;
    }

    public static int getAnnoCorrente(){
        GregorianCalendar oggi = new GregorianCalendar();
        int anno=oggi.get(Calendar.YEAR);
        return anno;

    }




}


