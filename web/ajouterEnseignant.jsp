<%-- 
    Document   : approvisionnerGrade
    Created on : 27 mai 2021, 22:27:00
    Author     : tunin
--%>

<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enseignant</title>
    </head>
    <body>
        <h1>Ajouter Enseignant</h1>

        <form action="EnseignantController" method="POST">
            <table>
                <input type="hidden" name="action" value="add"/>
                <tr><td>ID :</td></tr>
                <tr><td><input type="number" name="id"></td></tr>
                <tr><td>CIN :</td></tr>
                <tr><td><input type="number" name="cin"></td></tr>
                <tr><td>Prenom :</td></tr>
                <tr><td><input type="text" name="prenom"></td></tr>
                <tr><td>Nom :</td></tr>
                <tr><td><input type="text" name="nom"></td></tr>
                <tr><td>Adresse :</td></tr>
                <tr><td><input type="text" name="adresse"></td></tr>
                <tr><td>Email :</td></tr>
                <tr><td><input type="email" name="email"></td></tr>
                <tr><td>Phone :</td></tr>
                <tr><td><input type="number" name="phone"></td></tr>
                <tr><td>Login :</td></tr>
                <tr><td><input type="text" name="login"></td></tr>
                <tr><td>Password :</td></tr>
                <tr><td><input type="password" name="password"></td></tr>
                <tr><td>Grade :</td></tr>
                <tr><td><select name="grade_lib">
                            <%
                                GradeDAO gd = new GradeDAO();
                                List<Grade> list = (List<Grade>) gd.getGrades();
                                for (Grade a : list) {
                            %>
                            <option value="<%=a.getId_grade()%>"><%=a.getLibelle()%></option>");
                            <%}%>


                        </select>
                    </td></tr>
                <tr><td><input type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
    </body>
</html>
