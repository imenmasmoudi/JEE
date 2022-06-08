/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.iit.entities.Departement;
import tn.iit.entities.Enseignant;
import tn.iit.persistance.DepartementDAO;
import tn.iit.persistance.EnseignantDAO;
import tn.iit.service.DepartementService;
import tn.iit.service.EnseignantService;
import tn.iit.service.GradeService;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class DepartementController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        EnseignantService es = new EnseignantService();
        DepartementService ds = new DepartementService();

        EnseignantDAO edaoo = new EnseignantDAO();
        String action = request.getParameter("action");
        List<Departement> list = ds.getAll();
        DepartementDAO ddao = new DepartementDAO();

        if (request.getParameter("action").equalsIgnoreCase("add")) {
            Statement st = JdbcUtils.getStatement();
            ResultSet resultset = st.executeQuery("SELECT * FROM departement");
            boolean unique = true;
            Departement a = new Departement(Integer.parseInt(request.getParameter("id")), request.getParameter("libelle"), Integer.valueOf(request.getParameter("enseignant_lib")));
            int id_n = a.getId();
            while (resultset.next()) {
                //System.out.println("------resultset-----"+resultset.getInt("id_departement"));
                //System.out.println("------resultset******"+resultset.getInt(1));
                if (resultset.getInt("id_departement") == id_n) {
                    unique = false;
                    response.setContentType("text/html;charset=UTF-8");

                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Erreur!!</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Duplication ID</h1>");
                        out.println("</body>");
                        out.println("</html>");
                        response.setHeader("refresh", "5; ./ajouterDepartement.jsp");
                    }
                }
            }
            
            // IF value to be added is unique
            if (unique) {
                Departement d = ds.addDepartement(Integer.parseInt(request.getParameter("id")), request.getParameter("libelle"), Integer.valueOf(request.getParameter("enseignant_lib")));
                RequestDispatcher dispatch = request.getRequestDispatcher("./listedepartement.jsp");
                list.add(a);
                request.setAttribute("listedepartement", list);
                request.setAttribute("departement", a);
                request.setAttribute("action", "add");
                dispatch.forward(request, response);
            }
            
        } else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            ds.removeDepartement(id);
            list = ds.getAll();
            request.setAttribute("listedepartement", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listedepartement.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter(
                "action").equalsIgnoreCase("upgrade")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String libelle = request.getParameter("libelle");
            int id_enseignant = Integer.valueOf(request.getParameter("departement_lib"));

            Departement a = new Departement(id, libelle, id_enseignant);

            ds.updateDepartement(a);
            list = ds.getAll();
            request.setAttribute("listedepartement", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listedepartement.jsp");
            dispatch.forward(request, response);

        } else if (request.getParameter(
                "action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            Departement a = ddao.getDepartementByID(id);
            request.setAttribute("departement", a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./editedepartement.jsp");
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase(
                "getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listedepartement.jsp");
            request.setAttribute("listedepartement", list);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
