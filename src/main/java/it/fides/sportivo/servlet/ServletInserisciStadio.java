package it.fides.sportivo.servlet;

import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.servicesimplementation.ServiceStadioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ServletInserisciStadio extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stadio stadio = new Stadio();
        PrintWriter out= response.getWriter();
        String nomeStadio = request.getParameter("nomeStadio");
        String prezzoS=request.getParameter("prezzo").replace("," ,"." );
        String capienzaS=request.getParameter("capienza");
        int capienza=0;
        double costoBiglietto=0;

        if(request.getParameter("invia")!=null && nomeStadio.length()>0 && prezzoS.length()>0 && capienzaS.length()>0) {
            capienza = Integer.parseInt(capienzaS);
            costoBiglietto = Double.parseDouble(prezzoS);


            if (nomeStadio.length() > 0 && capienza > 0 && costoBiglietto > 0) {
                stadio.setNome(nomeStadio);
                stadio.setCapienza(capienza);
                stadio.setCosto_biglietto(costoBiglietto);
                request.setAttribute("stadio", stadio);

                try {
                    ServiceStadioDao.insertStadio(stadio);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                out.print("<h1>OKKKKKKKKKKKKKKKKK</h1>");
                response.sendRedirect("InserisciStadio.jsp");


            } else {
                response.sendRedirect("ErrorFormato.jsp");
            }

        }else {
            response.sendRedirect("ErrorFormato.jsp");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
