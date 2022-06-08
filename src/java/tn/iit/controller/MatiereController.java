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
import tn.iit.entities.Matiere;
import tn.iit.persistance.DepartementDAO;
import tn.iit.persistance.EnseignantDAO;
import tn.iit.persistance.MatiereDAO;
import tn.iit.persistance.NiveauDAO;
import tn.iit.service.MatiereService;

/**
 *
 * @author tunin
 */
public class MatiereController extends HttpServlet {

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
        
        
        DepartementDAO ddao = new DepartementDAO();
        NiveauDAO ndao = new NiveauDAO();
        EnseignantDAO edaoo = new EnseignantDAO();
        MatiereDAO mdao = new MatiereDAO();
        MatiereService ms = new MatiereService();
        
        String action = request.getParameter("action");
        
        List<Matiere> list = ms.getAll();

        if (request.getParameter("action").equalsIgnoreCase("add")) {
            Matiere a = ms.addMatiere(Integer.parseInt(request.getParameter("id_matiere")), request.getParameter("libelle"), Float.parseFloat(request.getParameter("ch_cours")),Float.parseFloat(request.getParameter("ch_tp")), Float.parseFloat(request.getParameter("ch_td")),Integer.valueOf(request.getParameter("departement_lib")), Integer.valueOf(request.getParameter("niveau_lib")), Integer.valueOf(request.getParameter("enseignant_lib")));
            RequestDispatcher dispatch = request.getRequestDispatcher("./listematiere.jsp");
            list.add(a);
            request.setAttribute("listematiere", list);
            request.setAttribute("matiere", a);
            request.setAttribute("action", "add");
            dispatch.forward(request, response);
        } else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            ms.removeMatiere(id);
            list = ms.getAll();
            request.setAttribute("listematiere", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listematiere.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("upgrade")) {
            int id_matiere = Integer.parseInt(request.getParameter("id"));
            String libelle = request.getParameter("libelle");
            float ch_cours = Float.parseFloat(request.getParameter("ch_cours"));
            float ch_tp = Float.parseFloat(request.getParameter("ch_tp"));
            float ch_td = Float.parseFloat(request.getParameter("ch_td"));
            int id_departement = Integer.parseInt(request.getParameter("departement_lib"));
            int id_niveau = Integer.parseInt(request.getParameter("niveau_lib"));
            int id_enseignant = Integer.parseInt(request.getParameter("enseignant_lib"));
            
            Matiere a = new Matiere(id_matiere, libelle, ch_cours, ch_td, ch_tp, id_departement, id_niveau, id_enseignant);
                                
            ms.updateMatiere(a);
            list = ms.getAll();
            request.setAttribute("listematiere", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listematiere.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            Matiere a = mdao.getMatiereByID(id);
            request.setAttribute("matiere", a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./editematiere.jsp");
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listematiere.jsp");
            request.setAttribute("listematiere", list);
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
