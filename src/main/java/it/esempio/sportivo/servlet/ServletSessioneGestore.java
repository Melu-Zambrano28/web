package it.esempio.sportivo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletSessioneGestore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionGestore =request.getSession();
        String nomeSessione = (String) sessionGestore.getAttribute("user");
        if(nomeSessione.length()>0){
            response.sendRedirect("Gestore.jsp");

        }else{
            response.getWriter().write("Non valido");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
