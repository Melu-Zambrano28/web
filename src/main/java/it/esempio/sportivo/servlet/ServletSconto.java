package it.esempio.sportivo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import it.esempio.sportivo.Util.PoliticheSconto;
import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Cliente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class ServletSconto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("application/json");
      String  dataNascita=request.getParameter("dataNascita");
      GregorianCalendar dataClienteGregorian = Util_Data_Time.convertiStringDate_GregorianDate(dataNascita);
      String nomeCliente=request.getParameter("nomeCliente");
      String cognomeCliente=request.getParameter("cognomeCliente");
      Cliente cliente= new Cliente();
      cliente.setNome(nomeCliente);
      cliente.setCognome(cognomeCliente);
      cliente.setData_nascita(dataClienteGregorian);
      System.out.println(PoliticheSconto.isOver65(cliente));

        PrintWriter out= response.getWriter();
        Gson giasone = new GsonBuilder().create();
        String json="melissa, belen, guzman";
        json = giasone.toJson(cliente);
        out.write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
