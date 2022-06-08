/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tn.iit.entities.Enseignant;
import tn.iit.entities.Seance;
import tn.iit.persistance.EnseignantDAO;
import tn.iit.persistance.GradeDAO;
import tn.iit.persistance.SeanceDAO;

/**
 *
 * @author tunin
 */
public class authentification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");

        Enseignant e = null;
        EnseignantDAO edao = new EnseignantDAO();
        GradeDAO gdao = new GradeDAO();
        SeanceDAO sdao = new SeanceDAO();
        int l = edao.getEnseignants().size();
        List<Enseignant> list = edao.getEnseignants();

        for (int i = 0; i < l; i++) {
            if ((list.get(i).getLogin().equals(login)) && (list.get(i).getPassword().equals(pwd))) {
                e = list.get(i);
            }
        }
        if (e != null) {
            //auth réussi
            int id_grade = e.getId_grade();
            String lib_grade = gdao.getGradeByID(id_grade).getLibelle();
            if (lib_grade.equals("administrateur")) {

                HttpSession session = request.getSession();
                session.setAttribute("user", e);
                response.sendRedirect("./menu.jsp");
            } else {

                List<Seance> liste_s = sdao.getSeancesByIdEnseignant(e.getId());

                HttpSession session = request.getSession();
                session.setAttribute("user", e);
                //response.sendRedirect("./menuenseignant.jsp");    
                RequestDispatcher dispatch = request.getRequestDispatcher("./menuenseignant.jsp");
                request.setAttribute("liste_s", liste_s);
                dispatch.forward(request, response);

            }
        } else {
            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet authentification</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Authentification non réussi</h1>");
                out.println("</body>");
                out.println("</html>");
                response.setHeader("refresh", "5; ./index.html");
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
