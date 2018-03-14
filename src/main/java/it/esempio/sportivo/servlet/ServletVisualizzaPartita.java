//package it.esempio.sportivo.servlet;
//
//import it.esempio.sportivo.entity.Partita;
//import it.esempio.sportivo.servicesimplementation.ServicePartitaDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class ServletVissualizzaPartita extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServicePartitaDao partita = new ServicePartitaDao();
//        try {
//            ArrayList<Partita>elencoPartita= partita.elencoOrdinatoPerData();
//            request.setAttribute("listaPartite", elencoPartita);
//        } catch (Exception e) {
//           response.sendRedirect("BackEndError");
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
