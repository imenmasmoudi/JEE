<%-- 
    Document   : editgrade
    Created on : 30 mai 2021, 15:43:32
    Author     : tunin
--%>

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
        <title>Modifier Matiere</title>
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
        
                     <div class="row my-5">
                    <div class="col-4"></div>
                    <div class="col-4">  
                         <div class="card">
                    <div class="card-body">
                       <h3>Modifier Matiere</h3>
                                  <form action="MatiereController" method="POST">
                      <%
                                      Matiere a = (Matiere) request.getAttribute("matiere");
                                  %>
                               <input type="hidden" name="action" value="upgrade"/>
                    <div class="row mb-4">
                        
                        <div class="form-outline my-3">
                          <input  type="number" name="id" value="<%= a.getId_matiere()%>" class="form-control" />
                          <label class="form-label" for="form6Example1">ID</label>
                        </div>
                          
                        <div class="form-outline my-3">
                          <input type="text" name="libelle" value="<%= a.getLibelle()%>" class="form-control" />
                          <label class="form-label" for="form6Example2">Libelle</label>
                        </div>
                          
                        <div class="form-outline my-3">
                          <input type="number" name="ch_cours" value="<%= a.getCh_cours()%>" class="form-control" />
                          <label class="form-label" for="form6Example2">Ch.Horaire Cours</label>
                        </div>
                          
                        <div class="form-outline my-3">
                          <input type="number" name="ch_tp" value="<%= a.getCh_tp()%>" class="form-control" />
                          <label class="form-label" for="form6Example2">Ch.Horaire TP</label>
                        </div>
                          
                          
                        <div class="form-outline my-3">
                          <input type="number" name="ch_td" value="<%= a.getCh_td()%>" class="form-control" />
                          <label class="form-label" for="form6Example2">Ch.Horaire TD</label>
                        </div>
                          
                    </div>


                      <select class="form-select my-1"  name="departement_lib" >
                                             <%
                                DepartementDAO ddao = new DepartementDAO();
                                List<Departement> list = (List<Departement>) ddao.getDepartements();
                                for (Departement d : list) {
                            %>
                            <option value="<%= d.getId()%>"><%=d.getLibelle()%></option>");
                            <%}%>
                        </select>
                        
                        
                        <select class="form-select my-1" name="niveau_lib">
                            <%
                                NiveauDAO ndao = new NiveauDAO();
                                List<Niveau> list1 = (List<Niveau>) ndao.getNiveaux();
                                for (Niveau n : list1) {
                            %>
                            <option value="<%= n.getId()%>"><%=n.getLibelle()%></option>");
                            <%}%>


                        </select>
                            
                            
                               <select class="form-select my-1" name="enseignant_lib">
                            <%
                                EnseignantDAO edao = new EnseignantDAO();
                                List<Enseignant> list2 = (List<Enseignant>) edao.getEnseignants();
                                for (Enseignant e : list2) {
                            %>
                            <option value="<%= e.getId()%>"><%= e.getPrenom() + " " + e.getNom()%></option>");
                            <%}%>


                        </select>
                    <!-- Submit button -->
                    <input type="submit" value="Modifier la matiére" name="OK" class="btn btn-primary btn-block mb-4">
                  </form>
                    </div>
                  </div></div>
                    <div class="col-4"></div>
                  </div>
                                     
                             <!-- MDB -->
    <script type="text/javascript" src="assets/js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript"></script>
    </body>
</html>
