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
import tn.iit.entities.Niveau;
import tn.iit.persistance.NiveauDAO;
import tn.iit.service.NiveauService;

/**
 *
 * @author tunin
 */
public class NiveauController extends HttpServlet {

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
        
        NiveauService ns = new NiveauService();
        NiveauDAO ndaoo = new NiveauDAO();
        String action = request.getParameter("action");
        List<Niveau> list = ns.getAll();

        if (request.getParameter("action").equalsIgnoreCase("add")) {
            Niveau a = ns.addNiveau(Integer.parseInt(request.getParameter("id")),(request.getParameter("libelle")));

            RequestDispatcher dispatch = request.getRequestDispatcher("./listeniveau.jsp");
            list.add(a);
            request.setAttribute("listeniveau", list);
            request.setAttribute("niveau", a);
            request.setAttribute("action", "add");
            dispatch.forward(request, response);
        } else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            ns.removeNiveau(id);
            list = ns.getAll();
            request.setAttribute("listeniveau", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listeniveau.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("upgrade")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String libelle = request.getParameter("libelle");
                       
            Niveau a = new Niveau(id, libelle);
                        
            ns.updateNiveau(a);
            list = ns.getAll();
            request.setAttribute("listeniveau", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listeniveau.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            Niveau a = ndaoo.getNiveauByID(id);
            request.setAttribute("niveau", a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./editniveau.jsp");
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeniveau.jsp");
            request.setAttribute("listeniveau", list);
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
