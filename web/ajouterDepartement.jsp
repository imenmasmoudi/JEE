<%-- 
    Document   : approvisionnerGrade
    Created on : 27 mai 2021, 22:27:00
    Author     : tunin
--%>

<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.persistance.EnseignantDAO"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departement</title>
    </head>
    <body>
        <h1>Ajouter Departement</h1>

        <form action="DepartementController" method="POST">
            <table>
                <input type="hidden" name="action" value="add"/>
                <tr><td>ID :</td></tr>
                <tr><td><input type="number" name="id"></td></tr>
                <tr><td>Libelle :</td></tr>
                <tr><td><input type="text" name="libelle"></td></tr>
                
                <tr><td>Enseignant :</td></tr>
                <tr><td><select name="enseignant_lib">
                            <%
                                EnseignantDAO ed = new EnseignantDAO();
                                List<Enseignant> list = (List<Enseignant>) ed.getEnseignants();
                                for (Enseignant a : list) {
                            %>
                            <option value="<%= a.getId() %>"><%= a.getPrenom()+ " " +a.getNom() %></option>");
                            <%}%>


                        </select>
                    </td></tr>
                <tr><td><input type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
    </body>
</html>
