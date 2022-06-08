<%-- 
    Document   : listegrade
    Created on : 25 mai 2021, 21:21:06
    Author     : tunin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="tn.iit.entities.Seance"%>
<%@page import="tn.iit.persistance.SeanceDAO"%>
<%@page import="tn.iit.persistance.MatiereDAO"%>
<%@page import="tn.iit.entities.Departement"%>
<%@page import="tn.iit.persistance.EnseignantDAO"%>
<%@page import="tn.iit.persistance.NiveauDAO"%>
<%@page import="tn.iit.persistance.DepartementDAO"%>
<%@page import="tn.iit.entities.Matiere"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.entities.Niveau"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seance</title>
         <!-- MDB icon -->
            <link rel="icon" href="assets/img/logoIIt.png" type="image/png" />
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

        
        
        
        <div class="row  px-5 my-5" >
            <div class="col-3 " >
                  
               <h1 class="">Liste des Seances</h1>
            </div>
            
            <div class="col-6">
                
            </div>
            
            <div class="col-3  " >
                <a type="button" style="float:right;" class="btn btn-danger " href="./logout">deconnectez</a>
            </div>
            
        </div>
        
        
        
         <table class="table text-center">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th>Date.</th>
                <th>Heure Debut.</th>
                <th>Durée.</th>
                <th>Methode Enseignement.</th>
                <th>Valide.</th>
                <th>Type.</th>
                <th>Matiere.</th>
    </tr>
  </thead>
  <tbody>
     <%

                MatiereDAO mdao = new MatiereDAO();
                EnseignantDAO edao = new EnseignantDAO();

                List<Seance> list = (List<Seance>) request.getAttribute("liste_s");

                int i = 0;

                for (Seance a : list) {
                    Matiere m = mdao.getMatiereByID(a.getId_matiere());
                    Enseignant e = edao.getEnseignantByID(a.getId_enseignant());
                    i++;
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date = formatter.format(a.getDate());

                    formatter = new SimpleDateFormat("HH:mm");
                    String heure = formatter.format(a.getH_debut());

                    out.print("<tr><td>" + i + "</td><td>" + date + "</td><td>" + heure + "</td><td>" + a.getDuree() + "</td><td>" + a.getMethode() + "</td><td>" + a.isValide() + "</td><td>" + a.getType() + "</td><td>" + m.getLibelle() + " </td><td><a class='btn btn-primary mx-1' href=\"./SeanceController?action=editEns&id=" + a.getId_seance() + "\">Valider la séance</a></td></tr>" );

                }
            %>
     
  </tbody>
  </table>
        
        
        

          
         <!-- MDB -->
    <script type="text/javascript" src="assets/js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript"></script>
    </body>
</html>
