/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.iit.entities.Enseignant;
import tn.iit.persistance.EnseignantDAO;
import tn.iit.service.EnseignantService;
import tn.iit.service.GradeService;

/**
 *
 * @author tunin
 */
public class EnseignantController extends HttpServlet {

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
        EnseignantService es = new EnseignantService();
        GradeService gs = new GradeService();
        EnseignantDAO edaoo = new EnseignantDAO();
        String action = request.getParameter("action");
        List<Enseignant> list = es.getAll();

        if (request.getParameter("action").equalsIgnoreCase("add")) {
            Enseignant a = es.addEnseignant(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("cin")),request.getParameter("prenom"), request.getParameter("nom"), request.getParameter("adresse"), request.getParameter("email"),Integer.parseInt(request.getParameter("phone")), request.getParameter("login"),request.getParameter("password"),Integer.valueOf(request.getParameter("grade_lib")));
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeenseignant.jsp");
            list.add(a);
            request.setAttribute("listeenseignant", list);
            request.setAttribute("enseignant", a);
            request.setAttribute("action", "add");
            dispatch.forward(request, response);
        } else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            es.removeEnseignant(id);
            list = es.getAll();
            request.setAttribute("listeenseignant", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listeenseignant.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("upgrade")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int cin = Integer.parseInt(request.getParameter("cin"));
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            String adresse = request.getParameter("adresse");
            String email = request.getParameter("email");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            int id_grade = Integer.valueOf(request.getParameter("grade_lib"));
            
            Enseignant a = new Enseignant(id, cin, prenom, nom, adresse, email, phone, login, password, id_grade);
                                
            es.updateEnseignant(a);
            list = es.getAll();
            request.setAttribute("listeenseignant", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listeenseignant.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            Enseignant a = edaoo.getEnseignantByID(id);
            request.setAttribute("enseignant", a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./editenseignant.jsp");
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeenseignant.jsp");
            request.setAttribute("listeenseignant", list);
            dispatch.forward(request, response);
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
