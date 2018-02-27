package it.fides.sportivo.servlet;

import it.fides.sportivo.Util.Util_Data_Time;
import it.fides.sportivo.Util.Util_Data_Time;
import it.fides.sportivo.entity.Cliente;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.servicesimplementation.ServiceClienteDao;
import it.fides.sportivo.servicesimplementation.ServicePartitaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        GregorianCalendar dataNascita = Util_Data_Time.transStringDateGregorianDate(data);

        try {



            Cliente cliente = new Cliente();
            cliente.setCognome(cognome);
            cliente.setNome(nome);
            cliente.setData_nascita(dataNascita);
            ServiceClienteDao.createCliente(cliente);
            req.setAttribute("cliente", cliente);



        } catch (Exception e) {
            resp.sendRedirect("BackEndError.jsp");
        }

        resp.sendRedirect("MostraCliente.jsp");
    }
}
