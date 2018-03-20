package it.esempio.sportivo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletValidaLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //facendo così posso ancora vedere il gestore

        String pwProva="12345";
        String user=request.getParameter("user");
        String pwUser=request.getParameter("pwd");
        if(request.getParameter("login")!= null && user.length()>0 && pwUser.length()>0 ){

                if(pwUser.equals(pwProva)) {

                    HttpSession sessione = request.getSession(true);
                    sessione.setAttribute("usuario",user);
                    request.setAttribute("sessione", sessione);

                    response.sendRedirect("Gestore.jsp");
                }else {
                    response.sendRedirect("LoginGestore.jsp");
                }


        }else{
            response.sendRedirect("ErrorFormato.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
