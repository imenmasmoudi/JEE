<%-- 
    Document   : approvisionnerGrade
    Created on : 27 mai 2021, 22:27:00
    Author     : tunin
--%>

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
        <title>Matiere</title>
    </head>
    <body>
        <h1>Ajouter Matiere</h1>

        <form action="MatiereController" method="POST">
            <table>
                <input type="hidden" name="action" value="add"/>
                <tr><td>ID :</td></tr>
                <tr><td><input type="number" name="id_matiere"></td></tr>
                <tr><td>Libelle :</td></tr>
                <tr><td><input type="text" name="libelle"></td></tr>
                <tr><td>Ch.Horaire Cours :</td></tr>
                <tr><td><input type="number" name="ch_cours"></td></tr>
                <tr><td>Ch.Horaire TP :</td></tr>
                <tr><td><input type="number" name="ch_tp"></td></tr>
                <tr><td>Ch.Horaire TD :</td></tr>
                <tr><td><input type="number" name="ch_td"></td></tr>
                <tr><td>Departement :</td></tr>
                <tr><td><select name="departement_lib">
                <%
                    DepartementDAO ddao = new DepartementDAO();
                    List<Departement> list = (List<Departement>) ddao.getDepartements();
                    for (Departement a : list) {
                %>
                <option value="<%= a.getId()%>"><%=a.getLibelle()%></option>");
                <%}%>
                </select>
                </td></tr>
                <tr><td>Niveau :</td></tr>
                <tr><td><select name="niveau_lib">
                <%
                    NiveauDAO ndao = new NiveauDAO();
                    List<Niveau> list1 = (List<Niveau>) ndao.getNiveaux();
                    for (Niveau a : list1) {
                %>
                <option value="<%= a.getId()%>"><%=a.getLibelle()%></option>");
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
                <option value="<%= a.getId()%>"><%= a.getPrenom()+" "+a.getNom() %></option>");
                <%}%>


                </select>
                </td></tr>

                <tr><td><input type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
    </body>
</html>
