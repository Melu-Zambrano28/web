package it.esempio.sportivo.servlet;

import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.entity.Squadra;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.servicesimplementation.ServiceSquadraDao;
import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

public class ServletInserisciPartita extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("dataPartita").replace("T",","); //sistemar
        //GregorianCalendar dataPartita= Util_Data_Time.convertiStringDataTime_GregorianCalendar(data);
        int idsqHome=Integer.parseInt(request.getParameter("sq_Home"));
        int  idStadio=Integer.parseInt(request.getParameter("stadio"));
        int idVisitor=Integer.parseInt(request.getParameter("sq_Visitor"));
        if(idsqHome!= idVisitor && data.length()>0) {
            GregorianCalendar dataPartita= Util_Data_Time.convertiStringDataTime_GregorianCalendar(data);
            Squadra home = null;
            Squadra visitor = null;
            Stadio stadio = null;
            Partita partita = new Partita();
            try {
                home = ServiceSquadraDao.selectSquadra(idsqHome);
                visitor = ServiceSquadraDao.selectSquadra(idVisitor);
                stadio = ServiceStadioDao.TrovaStadioById(idStadio);
                partita.setData_partita(dataPartita);
                request.setAttribute("partita", partita);
                ServicePartitaDao.inserisciPartita(partita, home, visitor, stadio);
            } catch (Exception e) {
               response.sendRedirect("BackEndError.jsp");
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
