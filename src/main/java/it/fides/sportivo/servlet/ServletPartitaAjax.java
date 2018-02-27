package it.fides.sportivo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.fides.sportivo.entity.Partita;
import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.servicesimplementation.ServicePartitaDao;

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

        Gson giasone = new GsonBuilder().create();


        ArrayList<Partita> elencoPartita=null;
        ServicePartitaDao partitaDao = new ServicePartitaDao();
        String giasoneJ="";
        try {
            elencoPartita=partitaDao.elencoOrdinatoPerData() ;
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
