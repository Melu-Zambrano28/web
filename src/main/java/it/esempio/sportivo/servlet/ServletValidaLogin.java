package it.esempio.sportivo.servlet;

import it.esempio.sportivo.servicesimplementation.ServiceAmministratoreDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class ServletValidaLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname=request.getParameter("user");
        String pwUser=request.getParameter("pwd");
        String ruolo=request.getParameter("ruolo");
        String email=nickname+"@"+ruolo+".it";
        try {
            String pwDb = ServiceAmministratoreDao.trovaPwByEmail(email,ruolo);

        if(request.getParameter("login")!= null && nickname.length()>0 && pwUser.length()>0 ){

                if(pwUser.equals(pwDb)) {

                    HttpSession sessione = request.getSession(true);
                    sessione.setAttribute("usuario",pwUser);
                    request.setAttribute("sessione", sessione);

                    response.sendRedirect("Gestore.jsp");
                }else {
                    response.sendRedirect("LoginGestore.jsp");
                }


        }else{
            response.sendRedirect("ErrorFormato.jsp");
        }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
