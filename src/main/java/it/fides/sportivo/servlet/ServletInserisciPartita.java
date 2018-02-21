package it.fides.sportivo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ServletInserisciPartita extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("CUCU");
        response.setContentType("application/json");

        List<Squadra> squadrone = new ArrayList<>();
        Squadra json = new Squadra(2,"Avellino");  Squadra json2 = new Squadra(2,"Aquila");
        Squadra json3 = new Squadra(2,"Aosta"); Squadra json4 = new Squadra(2,"Ascoli Piceno");
        squadrone.add(json); squadrone.add(json2); squadrone.add(json3); squadrone.add(json4);
        Gson giasone = new GsonBuilder().create();
        String giasoneJ = giasone.toJson(squadrone);

        response.getWriter().write(giasoneJ);
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
