package it.fides.sportivo.servlet;

import it.fides.sportivo.Util.Util_Data_Time;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.servicesimplementation.ServicePartitaDao;
import it.fides.sportivo.servicesimplementation.ServiceSquadraDao;
import it.fides.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

public class ServletInserisciPartita extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("dataPartita").replace("T",","); //sistemar
        GregorianCalendar dataPartita= Util_Data_Time.convertiStringDataTime_GregorianCalendar(data);
        int idsqHome=Integer.parseInt(request.getParameter("sq_Home"));
        int  idStadio=Integer.parseInt(request.getParameter("stadio"));
        int idVisitor=Integer.parseInt(request.getParameter("sq_Visitor"));
        if(idsqHome!= idVisitor) {
            Squadra home = null;
            Squadra visitor = null;
            Stadio stadio = null;
            Partita partita = new Partita();
            try {
                home = ServiceSquadraDao.selectSquadra(idsqHome);
                visitor = ServiceSquadraDao.selectSquadra(idVisitor);
                stadio = ServiceStadioDao.TrovaStadioById(idStadio);
                partita.setData_partita(dataPartita);
               ServicePartitaDao.inserisciPartita(partita, home, visitor, stadio);
            } catch (Exception e) {
                e.printStackTrace();
                //mandarla a un mesaggio di errore di DB
            }
            response.sendRedirect("Gestore.jsp");
        }else {
            response.sendRedirect("ErrorFormato.jsp");
        }


    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
