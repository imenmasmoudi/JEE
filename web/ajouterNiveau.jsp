<%-- 
    Document   : approvisionnerGrade
    Created on : 27 mai 2021, 22:27:00
    Author     : tunin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Niveau</title>
    </head>
    <body>
        <h1>Ajouter Niveau</h1>

        <form action="NiveauController" method="POST">
            <table>
                <input type="hidden" name="action" value="add"/>
                <tr><td>ID :</td></tr>
                <tr><td><input type="number" name="id"></td></tr>
                <tr><td>Libelle :</td></tr>
                <tr><td><input type="text" name="libelle"></td></tr>
                <tr><td><input type="submit" value="OK" name="OK"/></td></tr>
            </table>
        </form>
    </body>
</html>
