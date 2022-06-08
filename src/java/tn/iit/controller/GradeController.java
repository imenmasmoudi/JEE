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
import tn.iit.entities.Grade;
import tn.iit.persistance.GradeDAO;
import tn.iit.service.GradeService;

/**
 *
 * @author tunin
 */
public class GradeController extends HttpServlet {

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

        GradeService gs = new GradeService();
        GradeDAO gdaoo = new GradeDAO();
        String action = request.getParameter("action");
        List<Grade> list = gs.getAll();

        if (request.getParameter("action").equalsIgnoreCase("add")) {
            Grade a = gs.addGrade((Integer.parseInt(request.getParameter("id"))), (request.getParameter("libelle")), (Float.parseFloat(request.getParameter("prix_c"))), (Float.parseFloat(request.getParameter("prix_td"))), (Float.parseFloat(request.getParameter("prix_tp"))));

            RequestDispatcher dispatch = request.getRequestDispatcher("./listegrade.jsp");
            list.add(a);
            request.setAttribute("listegrade", list);
            request.setAttribute("grade", a);
            request.setAttribute("action", "add");
            dispatch.forward(request, response);
        } else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            gs.removeGrade(id);
            list = gs.getAll();
            request.setAttribute("listegrade", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listegrade.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("upgrade")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String libelle = request.getParameter("libelle");
            float prix_c = Float.parseFloat(request.getParameter("prix_c"));
            float prix_td = Float.parseFloat(request.getParameter("prix_td"));
            float prix_tp = Float.parseFloat(request.getParameter("prix_tp"));
            
            Grade a = new Grade(id, libelle, prix_c, prix_td, prix_tp);
                        
            gs.updateGrade(a);
            list = gs.getAll();
            request.setAttribute("listegrade", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listegrade.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            Grade a = gdaoo.getGradeByID(id);
            request.setAttribute("grade", a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./editgrade.jsp");
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listegrade.jsp");
            request.setAttribute("listegrade", list);
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
