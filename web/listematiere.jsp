<%-- 
    Document   : listegrade
    Created on : 25 mai 2021, 21:21:06
    Author     : tunin
--%>

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
        <title>Matiere</title>
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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
           
            <button
              class="navbar-toggler"
              type="button"
              data-mdb-toggle="collapse"
              data-mdb-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse row justify-content-between" id="navbarNav"> 
              
                <div class="col-9">
                  <ul class="navbar-nav ">
                      
                      <li class="nav-item">
                        <a class="nav-link " aria-current="page"  href="./gradeController?action=getAll">Liste des grades</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link " href="./NiveauController?action=getAll">liste des niveaux</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link " href="./EnseignantController?action=getAll">liste des Enseignants</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link " href="./DepartementController?action=getAll">liste des Departements</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link active" href="./MatiereController?action=getAll">liste des Matieres</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./SeanceController?action=getAll">liste des Seances</a>
                      </li>
                  </ul>
                </div>
                <div class="col-2  d-flex justify-content-end m-2 ">
                  <a type="button" class="btn btn-danger ml-auto" href="./logout">Déconnectez</a>
                </div>
              
            </div>
          </div>
        </nav>
        <h1 class="text-center mt-5">Liste des Matiere</h1>
        
        <div class="row  px-5 my-3" >
            <div class="col-3 " >
                  <a type="button" class="btn btn-warning " href="./menu.jsp"> Retour au menu</a>
                  
               
            </div>
            
            <div class="col-6">
                
            </div>
            
            <div class="col-3  " >
                <a href="./ajouterMatiere.jsp" style="float:right" class="btn btn-success " > Ajouter </a>
            </div>
            
        </div>
        
        <table class="table text-center">
  <thead>
    <tr>
      <th scope="col">#</th>
                <th>Libelle</th>
                <th>Ch Horaire cours</th>
                <th>Ch Horaire TP</th>
                <th>Ch Horaire TD</th>
                <th>Departement</th>
                <th>Niveau</th>
                <th>Enseignant</th>
                <th>Action</th>
    </tr>
  </thead>
  <tbody>
     <%
                DepartementDAO ddao = new DepartementDAO();
                NiveauDAO ndao = new NiveauDAO();
                EnseignantDAO edao = new EnseignantDAO();
                
                List<Matiere> list_mat = (List<Matiere>) request.getAttribute("listematiere");
                                
                int i = 0;
                
                for (Matiere a : list_mat) {
                    Departement d = ddao.getDepartementByID(a.getId_departement());
                    Niveau n = ndao.getNiveauByID(a.getId_niveau());
                    Enseignant e = edao.getEnseignantByID(a.getId_enseignant());
                    i++;
                    out.print("<tr><td>" + i +"</td><td>"+a.getLibelle() + "</td><td>"+a.getCh_cours() + "</td><td>"+a.getCh_tp() + "</td><td>"+a.getCh_td() + "</td><td>"+d.getLibelle() + "</td><td>"+n.getLibelle()+ "</td><td>"+e.getPrenom()+" "+e.getNom() + "</td><td><a class='btn btn-danger mx-1' href=\"./MatiereController?action=remove&id="+a.getId_matiere()+"\">Supprimer</a><a class='btn btn-primary mx-1' href=\"./MatiereController?action=edit&id="+a.getId_matiere()+"\">Modifier</a></td></tr>");
    
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
