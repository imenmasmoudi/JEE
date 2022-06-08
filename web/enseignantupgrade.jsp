<%-- 
    Document   : editgrade
    Created on : 30 mai 2021, 15:43:32
    Author     : tunin
--%>

<%@page import="java.util.Date"%>
<%@page import="tn.iit.persistance.MatiereDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="tn.iit.entities.Seance"%>
<%@page import="tn.iit.entities.Niveau"%>
<%@page import="tn.iit.persistance.NiveauDAO"%>
<%@page import="tn.iit.entities.Departement"%>
<%@page import="tn.iit.persistance.DepartementDAO"%>
<%@page import="tn.iit.persistance.EnseignantDAO"%>
<%@page import="tn.iit.entities.Matiere"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier Seance</title>
    </head>
    <body>
        <h1>Modifier Seance</h1>

        <form action="SeanceController" method="POST">
            <table>
                <%
                    Seance a = (Seance) request.getAttribute("seance");

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date = formatter.format(a.getDate());

                    formatter = new SimpleDateFormat("HH:mm");
                    String heure = formatter.format(a.getH_debut());
                %>
                <input type="hidden" name="action" value="upgradeEns"/>
                <tr><td hidden>ID :</td></tr>
                <tr><td><input hidden type="number" name="id" value="<%= a.getId_seance()%>" readonly="true"></td></tr>
                <tr><td hidden>Date :</td></tr>
                <tr><td><input hidden type="date" name="date" value="<%= date%>" readonly="true"></td></tr>
                <tr><td hidden>Heure Debut :</td></tr>
                <tr><td><input hidden type="time" name="h_debut" value="<%= heure%>" readonly="true"></td></tr>
                <tr><td>Durée :</td></tr>
                <tr><td><input type="number" name="duree" value="<%= a.getDuree()%>"></td></tr>
                <tr><td>Methode d'Enseignement :</td></tr>
                <tr>
                    <td>
                        <select name="method">
                            <option disabled selected value>---Choisir Methode d'enseignement---</option>
                            <option value="A distance">A distance</option>
                            <option value="Presentiel">Presentiel</option>
                        </select>
                    </td>
                </tr>
                <tr><td hidden>Validité :</td></tr>
                <tr><td hidden>Valid : <input hidden type="radio" name="valide" value="1" checked="<%= a.isValide()%>" readonly="true">
                        Non Valid : <input hidden   type="radio" name="valide" value="0" checked="<%= a.isValide()%>" readonly="true">
                    </td><tr>
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
                <tr><td><select hidden name="matiere_lib" readonly="true">
                            <%
                                MatiereDAO mdao = new MatiereDAO();
                                List<Matiere> list = (List<Matiere>) mdao.getMatieres();
                                for (Matiere m : list) {
                            %>
                            <option value="<%= m.getId_matiere()%>"><%= m.getLibelle()%></option>");
                            <%}%>
                        </select>
                    </td></tr>

                <tr hidden><td>Enseignant :</td></tr>
                <tr><td><select hidden name="enseignant_lib" readonly="true">
                            <%
                                EnseignantDAO edao = new EnseignantDAO();
                                List<Enseignant> list2 = (List<Enseignant>) edao.getEnseignants();
                                for (Enseignant e : list2) {
                            %>
                            <option value="<%= a.getId_enseignant()%>"><%= e.getPrenom() + " " + e.getNom()%></option>");
                            <%}%>

                        </select>
                    </td></tr>
                <tr><td> <input type="submit" value="OK" name="OK"> </input> </td></tr>
            </table>
        </form>
    </body>
</html>