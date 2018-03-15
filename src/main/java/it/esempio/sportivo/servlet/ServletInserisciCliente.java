package it.esempio.sportivo.servlet;

import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Cliente;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.servicesimplementation.ServiceClienteDao;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        GregorianCalendar dataNascita = Util_Data_Time.convertiStringDate_GregorianDate(data);

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

        ServiceStadioDao stadio = new ServiceStadioDao();
        ArrayList<Stadio> listaStadi = new ArrayList<Stadio>();
        try {
            listaStadi = stadio.listaStadio();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("stadio", listaStadi);

        req.getRequestDispatcher("MostraCliente.jsp").forward(req, resp);
    }
}
