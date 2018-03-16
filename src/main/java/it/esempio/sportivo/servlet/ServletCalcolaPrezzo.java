package it.esempio.sportivo.servlet;

import it.esempio.sportivo.Util.PoliticheSconto;
import it.esempio.sportivo.entity.Cliente;
import it.esempio.sportivo.entity.Partita;
import it.esempio.sportivo.servicesimplementation.ServiceClienteDao;
import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletCalcolaPrezzo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        int idPartita = Integer.parseInt(req.getParameter("id-partita"));
        double prezzoBiglietto = -1;

        Cliente c;
        Partita p;

        try {
            c = ServiceClienteDao.getClienteByNameSurname(nome, cognome);
            p = ServicePartitaDao.getPartitaById(idPartita);
            double sconto = PoliticheSconto.calcolaSconto(c, p);
            double costoBase = p.getStadio().getCosto_biglietto();
            prezzoBiglietto = costoBase - costoBase / 100 * sconto;
            req.setAttribute("PartitaSel", p);
            req.setAttribute("ClienteSel", c);
        }
        catch (Exception e) {
            resp.sendRedirect("BackEndError.jsp");
        }

        if(prezzoBiglietto==-1){
            resp.sendRedirect("BackEndError.jsp");
        }



        req.getRequestDispatcher("AcquistaBiglietto.jsp?prezzo=" + prezzoBiglietto).forward(req, resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doPost(req, resp);
    }
}
