package it.esempio.sportivo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ServletIncasso extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idstadio = Integer.parseInt(request.getParameter("stadio"));
        Stadio stadio = null;
        try {
            stadio = ServiceStadioDao.incassoTotalePerStadio(idstadio);
            if(stadio!=null) {
                request.setAttribute("stadioServlet", stadio);

            }else{
                stadio=ServiceStadioDao.TrovaStadioById(idstadio);
                stadio.setCosto_biglietto(0);
            }
            Gson gson = new GsonBuilder().create();
            String json = "";
            json = gson.toJson(stadio);
            PrintWriter out = response.getWriter();
            out.write(json);
        } catch (Exception e) {
            response.sendRedirect("BackEndError.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
