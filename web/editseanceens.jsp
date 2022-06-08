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
         <!-- MDB icon -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link
          rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
        />
        <!-- MDB -->
        <link rel="stylesheet" href="assets/css/mdb.min.css" />
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
                <input type="hidden" name="action" value="upgradeens"/>
              
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
                <tr><td><input class="btn btn-primary btn-lg" type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
                
                <!-- MDB -->
                <script type="text/javascript" src="assets/js/mdb.min.js"></script>
                <!-- Custom scripts -->
                <script type="text/javascript"></script>
    </body>
</html>
