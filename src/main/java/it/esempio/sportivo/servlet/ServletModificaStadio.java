package it.esempio.sportivo.servlet;

import it.esempio.sportivo.entity.Stadio;
import it.esempio.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletModificaStadio extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeStadio=request.getParameter("nomeStadioModifica");
        String capienzaModifica=request.getParameter("capienzaModifica");
        int capienza=0;
        Stadio stadio = null;
        if(request.getParameter("modificaStadio")!=null && nomeStadio.length()>0 && capienzaModifica.length()>0){
            capienza=Integer.parseInt(capienzaModifica);
            try {
                int id= ServiceStadioDao.trovaStadioByName(nomeStadio);
                stadio=ServiceStadioDao.TrovaStadioById(id);
                stadio.setNome(nomeStadio);
                stadio.setCapienza(capienza);
                ServiceStadioDao.aggiornaStadio(stadio);

            } catch (Exception e) {
               response.sendRedirect("BackEndError.jsp");
            }

            response.sendRedirect("Gestore.jsp");

        }else{
            response.sendRedirect("ErrorFormato.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
