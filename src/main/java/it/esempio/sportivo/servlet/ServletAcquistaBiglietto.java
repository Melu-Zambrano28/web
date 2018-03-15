package it.esempio.sportivo.servlet;

import it.esempio.sportivo.entity.Biglietto;
import it.esempio.sportivo.servicesimplementation.ServiceBigliettoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletAcquistaBiglietto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idStatoBiglietto = Integer.parseInt(req.getParameter("acquistato-prenotato"));
        int idPartita = Integer.parseInt(req.getParameter("id-partita"));
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        int prezzo = Integer.parseInt("prezzo");
        Biglietto b = new Biglietto(idStatoBiglietto, idPartita, prezzo, nome, cognome);
        try {
            ServiceBigliettoDao.inserisciBiglietto(b);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

