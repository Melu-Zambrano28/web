package it.fides.sportivo.servlet;

import it.fides.sportivo.Util.UtilClientDao;
import it.fides.sportivo.entity.Cliente;
import it.fides.sportivo.servicesimplementation.ServiceClienteDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServletInserisciCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String data = req.getParameter("data-nascita");


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Calendar cal = null;
        try {
            date = df.parse(data);
            cal = new GregorianCalendar();
            cal.setTime(date);
            Date sql = UtilClientDao.trasformaDataUtilSql((GregorianCalendar) cal);
            System.out.println(sql);
            GregorianCalendar nascita = UtilClientDao.trasformaDataSqlaUtil((java.sql.Date) sql);
            Cliente cliente = new Cliente(nome, cognome, nascita);
            System.out.println(cliente.getData_nascita());
            ServiceClienteDao.createCliente(cliente);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
