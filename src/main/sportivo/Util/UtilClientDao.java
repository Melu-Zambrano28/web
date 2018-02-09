package main.sportivo.Util;

import java.util.GregorianCalendar;

public class UtilClientDao {


    //trasformazione della data nel formato giusto per il database
    public static java.sql.Date trasformaDataUtilSql(GregorianCalendar data_nascita){
        java.sql.Date dataSql = new java.sql.Date(data_nascita.getTimeInMillis());
        return dataSql;
    }

    public static GregorianCalendar trasformaDataSqlaUtil(java.sql.Date sqlDate){
        GregorianCalendar utilDate=new GregorianCalendar();
        utilDate.setGregorianChange(sqlDate);
        return utilDate;
    }

}


