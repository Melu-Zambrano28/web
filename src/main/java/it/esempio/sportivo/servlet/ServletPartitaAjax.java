package it.esempio.sportivo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.esempio.sportivo.Util.CalendarJsonSerializer;
import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ServletPartitaAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("CUCU");
        response.setContentType("application/json");
        String ordine = request.getParameter("ordinePartite");

        Gson giasone = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(GregorianCalendar.class, new CalendarJsonSerializer()).create();


        ArrayList<Partita> elencoPartita=null;
        //ServicePartitaDao partitaDao = new ServicePartitaDao();
        String giasoneJ="";
        try {
            elencoPartita= ServicePartitaDao.listaPartitaOrig(ordine);
            giasoneJ = giasone.toJson(elencoPartita);


        } catch (Exception e) {
            response.sendRedirect("BackEndError.jsp");
        }

        response.getWriter().write(giasoneJ);

    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
