package it.fides.sportivo.servlet;

import it.fides.sportivo.Util.UtilClientDao;
import it.fides.sportivo.entity.Squadra;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServletInserisciPartita extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data_Partita = request.getParameter("dataPartita");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        Calendar cal = null;
        try {
            date = df.parse(data_Partita);
            cal = new GregorianCalendar();
            cal.setTime(date);
            java.sql.Date sql = UtilClientDao.trasformaDataUtilSql((GregorianCalendar) cal); //sql
            GregorianCalendar dataPartitaSql = UtilClientDao.trasformaDataSqlaUtil(sql); //util
            System.out.println(dataPartitaSql.getClass());


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
