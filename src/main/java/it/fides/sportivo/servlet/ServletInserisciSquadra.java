package it.fides.sportivo.servlet;

import it.fides.sportivo.entity.Squadra;
import it.fides.sportivo.servicesimplementation.ServiceSquadraDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletInserisciSquadra extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // response.setContentType("application/json");

        //JSONObject json = new JSONObject();
        String nomeSquadra="";
        Squadra squadra= null;
        if(request.getParameter("inviaSquadra")!=null){
            nomeSquadra=request.getParameter("nomeSquadra");
                if(nomeSquadra.length()>0) {
                    squadra = new Squadra();
                    squadra.setNome(nomeSquadra);
                    request.setAttribute("squadra", squadra);
                    try{

                    //json.put("nome squadra", squadra.getNome());
                    //response.getWriter().write(json.toString());
                    ServiceSquadraDao.insertSquadra(squadra);
                    response.sendRedirect("Gestore.jsp");


                    } catch (Exception e) {
                        e.printStackTrace();
                        response.sendRedirect("backendError.jsp");
                    }

                }


                else {
                    response.sendRedirect("ErrorFormato.jsp");
                }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
