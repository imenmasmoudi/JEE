<%-- 
    Document   : menu
    Created on : 25 mai 2021, 21:08:39
    Author     : tunin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Enseignants</title>
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
                        <a class="nav-link" aria-current="page"  href="./gradeController?action=getAll">Liste des grades</a>
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
        
        
        
    <!-- MDB -->
    <script type="text/javascript" src="assets/js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript"></script>
    </body>
</html>
