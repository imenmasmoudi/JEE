<%-- 
    Document   : approvisionnerGrade
    Created on : 27 mai 2021, 22:27:00
    Author     : tunin
--%>

<%@page import="tn.iit.entities.Matiere"%>
<%@page import="tn.iit.persistance.MatiereDAO"%>
<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.persistance.EnseignantDAO"%>
<%@page import="tn.iit.entities.Niveau"%>
<%@page import="tn.iit.persistance.NiveauDAO"%>
<%@page import="tn.iit.entities.Departement"%>
<%@page import="tn.iit.persistance.DepartementDAO"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seance</title>
    </head>
    <body>
        <h1>Ajouter Seance</h1>

        <form action="SeanceController" method="POST">
            <table>
                <input type="hidden" name="action" value="add"/>
                <tr><td>ID :</td></tr>
                <tr><td><input type="number" name="id"></td></tr>
                <tr><td>Date :</td></tr>
                <tr><td><input type="date" name="date"></td></tr>
                <tr><td>Heure Debut :</td></tr>
                <tr><td><input type="time" name="h_debut"></td></tr>
                <tr><td>Durée :</td></tr>
                <tr><td><input type="number" name="duree"></td></tr>
                <tr><td>Méthode Enseignement :</td></tr>
                <tr>
                    <td>
                        <select name="method">
                            <option disabled selected value>---Choisir Methode d'enseignement---</option>
                            <option value="A distance">A distance</option>
                            <option value="Presentiel">Presentiel</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Type :</td></tr>
                <tr>
                    <td><select name="type">
                            
                            <option disabled selected value>---Choisir Type :---</option>
                            <option value="cours">Cours</option>
                            <option value="td">TD</option>
                            <option value="tp">TP</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Matière :</td></tr>
                <tr><td><select name="matiere_lib">
                            <%
                                MatiereDAO mdao = new MatiereDAO();
                                List<Matiere> list = (List<Matiere>) mdao.getMatieres();
                                for (Matiere a : list) {
                            %>
                            <option value="<%= a.getId_matiere()%>"><%= a.getLibelle()%></option>");
                            <%}%>
                        </select>
                    </td></tr>

                <tr><td>Enseignant :</td></tr>
                <tr><td><select name="enseignant_lib">
                            <%
                                EnseignantDAO edao = new EnseignantDAO();
                                List<Enseignant> list2 = (List<Enseignant>) edao.getEnseignants();
                                for (Enseignant a : list2) {
                            %>
                            <option value="<%= a.getId()%>"><%= a.getPrenom() + " " + a.getNom()%></option>");
                            <%}%>


                        </select>
                    </td></tr>

                <tr><td><input type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
    </body>
</html>
