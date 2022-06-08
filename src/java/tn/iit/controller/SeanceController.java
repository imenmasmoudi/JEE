/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import tn.iit.persistance.MatiereDAO;
import tn.iit.persistance.SeanceDAO;
import tn.iit.service.SeanceService;

/**
 *
 * @author tunin
 */
public class SeanceController extends HttpServlet {

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

        MatiereDAO mdao = new MatiereDAO();
        EnseignantDAO edaoo = new EnseignantDAO();
        SeanceDAO sdao = new SeanceDAO();
        SeanceService ss = new SeanceService();
        String action = request.getParameter("action");

        List<Seance> list = ss.getAll();

        if (request.getParameter("action").equalsIgnoreCase("add")) {

            int id = Integer.parseInt(request.getParameter("id"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;

            //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
            try {
                date = sdf.parse(request.getParameter("date"));

                System.out.println("request.getParameter(\"date\")" + request.getParameter("date"));
                System.out.println("date" + date.toString());

            } catch (ParseException pe) {

            }

            String time = request.getParameter("h_debut");

            java.util.Date date1 = null;
            try {
                date1 = new SimpleDateFormat("HH:mm").parse(time);
            } catch (ParseException e) {
                request.setAttribute("time_error", "Please enter time in format HH:mm");
            }

            float duree = Float.parseFloat(request.getParameter("duree"));
            String methode = request.getParameter("methode");
            int valide = 0;
            String type = request.getParameter("type");
            int id_matiere = Integer.valueOf(request.getParameter("matiere_lib"));

            int id_enseignant = Integer.valueOf(request.getParameter("enseignant_lib"));

            Seance a = new Seance(id, date, date1, duree, methode, false, type, id_matiere, id_enseignant);
            sdao.addSeance(a);
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeseance.jsp");
            list.add(a);
            request.setAttribute("listeseance", list);
            request.setAttribute("seance", a);
            request.setAttribute("action", "add");
            dispatch.forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("upgrade")) {

            int id = Integer.parseInt(request.getParameter("id"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;

            //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
            try {
                date = sdf.parse(request.getParameter("date"));

                System.out.println("request.getParameter(\"date\")" + request.getParameter("date"));
                System.out.println("date" + date.toString());

            } catch (ParseException pe) {

            }

            String time = request.getParameter("h_debut");

            java.util.Date date1 = null;
            try {
                date1 = new SimpleDateFormat("HH:mm").parse(time);
            } catch (ParseException e) {
                request.setAttribute("time_error", "Please enter time in format HH:mm");
            }

            float duree = Float.parseFloat(request.getParameter("duree"));
            String methode = request.getParameter("method");

            boolean bool = (Integer.parseInt(request.getParameter("valide")) == 1);

            String type = request.getParameter("type");
            int id_matiere = Integer.valueOf(request.getParameter("matiere_lib"));
            int id_enseignant = Integer.valueOf(request.getParameter("enseignant_lib"));

            Seance a = new Seance(id, date, date1, duree, methode, bool, type, id_matiere, id_enseignant);

            ss.updateSeance(a);
            list = ss.getAll();
            request.setAttribute("listeseance", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("/listeseance.jsp");
            dispatch.forward(request, response);

        }
        else if (request.getParameter("action").equalsIgnoreCase("upgradeEns")) {

            int id = Integer.parseInt(request.getParameter("id"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = null;

            //Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
            try {
                date = sdf.parse(request.getParameter("date"));

                System.out.println("request.getParameter(\"date\")" + request.getParameter("date"));
                System.out.println("date" + date.toString());

            } catch (ParseException pe) {

            }

            String time = request.getParameter("h_debut");

            java.util.Date date1 = null;
            try {
                date1 = new SimpleDateFormat("HH:mm").parse(time);
            } catch (ParseException e) {
                request.setAttribute("time_error", "Please enter time in format HH:mm");
            }

            float duree = Float.parseFloat(request.getParameter("duree"));
            String methode = request.getParameter("method");

            boolean bool = (Integer.parseInt(request.getParameter("valide")) == 1);

            String type = request.getParameter("type");
            int id_matiere = Integer.valueOf(request.getParameter("matiere_lib"));
            int id_enseignant = Integer.valueOf(request.getParameter("enseignant_lib"));

            Seance a = new Seance(id, date, date1, duree, methode, bool, type, id_matiere, id_enseignant);

            ss.updateSeance(a);
            //list = ss.getAll();
             HttpSession session = request.getSession();
             Enseignant e  = (Enseignant) session.getAttribute("user");
                List<Seance> liste_s = sdao.getSeancesByIdEnseignant(e.getId());

                //HttpSession session = request.getSession();
               // session.setAttribute("user", e);
                //response.sendRedirect("./menuenseignant.jsp");    
                RequestDispatcher dispatch = request.getRequestDispatcher("./menuenseignant.jsp");
                request.setAttribute("liste_s", liste_s);
                dispatch.forward(request, response);

        }else if (request.getParameter("action").equalsIgnoreCase("edit")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            System.out.println(id);
            Seance a = sdao.getSeanceByID(id);
            request.setAttribute("seance", a);
            System.out.println(a.getId_seance());
            System.out.println(a.getDate());
            System.out.println(a.getH_debut());
            System.out.println(a.getDuree());
            RequestDispatcher dispatch = request.getRequestDispatcher("./editeseance.jsp");
            dispatch.forward(request, response);
        } 
         else if (request.getParameter("action").equalsIgnoreCase("editEns")) {
            int id = (Integer.parseInt(request.getParameter("id")));
            System.out.println(id);
            Seance a = sdao.getSeanceByID(id);
            request.setAttribute("seance", a);
            System.out.println(a.getId_seance());
            System.out.println(a.getDate());
            System.out.println(a.getH_debut());
            System.out.println(a.getDuree());
            RequestDispatcher dispatch = request.getRequestDispatcher("./enseignantupgrade.jsp");
            dispatch.forward(request, response);
         }else if (action.equalsIgnoreCase("getAll")) {

            //List<Grade> list = gs.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeseance.jsp");
            request.setAttribute("listeseance", list);
            dispatch.forward(request, response);
        }else if (request.getParameter("action").equalsIgnoreCase("remove")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ss.removeSeance(id);
            list = ss.getAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("./listeseance.jsp");
            request.setAttribute("listeseance", list);
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