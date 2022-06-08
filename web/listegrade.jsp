<%-- 
    Document   : listegrade
    Created on : 25 mai 2021, 21:21:06
    Author     : tunin
--%>

<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <a class="nav-link active" aria-current="page"  href="./gradeController?action=getAll">Liste des grades</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./NiveauController?action=getAll">liste des niveaux</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./EnseignantController?action=getAll">liste des Enseignants</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./DepartementController?action=getAll">liste des Departements</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./MatiereController?action=getAll">liste des Matieres</a>
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
        
        <h1 class="text-center mt-5">liste des Grades</h1>
        <div class="row  px-5 my-3" >
            <div class="col-3 " >
                  <a type="button" class="btn btn-warning " href="./menu.jsp"> Retour au menu</a>
               
            </div>
            
            <div class="col-6">
                
            </div>
            
            <div class="col-3  " >
                  
                  <a type="button" style="float:right" class="btn btn-success " href="./ajouterGrade.jsp"> Ajouter</a>
                
            </div>
            
        </div>
        
       
       
<table class="table text-center">
  <thead>
    <tr>
      <th scope="col">#</th>
    <th>Libelle</th>
    <th>Prix cours</th>
    <th>Prix TD</th>
    <th>Prix TP</th>
    <th>Action</th>
    </tr>
  </thead>
  <tbody>
       <%
                List<Grade> list = (List<Grade>) request.getAttribute("listegrade");

                int i = 0;

                for (Grade a : list) {
                    i++;
                    out.print("<tr><th scope='row'>" + i+"</th><td>"+a.getLibelle() + "</td><td>" + a.getPrix_c() + "</td><td>" + a.getPrix_td() + "</td><td>" + a.getPrix_tp()+"</td><td><a class='btn btn-danger mx-1' href=\"./gradeController?action=remove&id="+a.getId_grade()+"\">Supprimer</a><a class='btn btn-primary mx-1' href=\"./gradeController?action=edit&id="+a.getId_grade()+"\">Modifier</a></td></tr>");
    
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
