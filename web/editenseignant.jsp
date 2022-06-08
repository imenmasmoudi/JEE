<%-- 
    Document   : editgrade
    Created on : 30 mai 2021, 15:43:32
    Author     : tunin
--%>

<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier Enseignant</title>
        
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
     <h3>Modifier Enseignant</h3>
                <form action="EnseignantController" method="POST">
  <%
                    Enseignant a = (Enseignant) request.getAttribute("enseignant");
                %>
             <input type="hidden" name="action" value="upgrade"/>
  <div class="row mb-4">
    <div class="col">
      <div class="form-outline">
        <input type="number" name="id" value="<%= a.getId()%>" class="form-control" />
        <label class="form-label" for="form6Example1">ID</label>
      </div>
    </div>
    <div class="col">
      <div class="form-outline">
        <input type="number" name="cin" value="<%= a.getCin() %>" class="form-control" />
        <label class="form-label" for="form6Example2">CIN</label>
      </div>
    </div>
  </div>

  <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="text" name="prenom" value="<%= a.getPrenom() %>" class="form-control" />
    <label class="form-label" for="form6Example3">Prénom</label>
  </div>

  <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="text" name="nom" value="<%= a.getNom() %>" class="form-control" />
    <label class="form-label" for="form6Example4">Nom</label>
  </div>

  <!-- Email input -->
  <div class="form-outline mb-4">
    <input  type="text" name="adresse" value="<%= a.getAdresse() %>" class="form-control" />
    <label class="form-label" for="form6Example5">Adresse</label>
  </div>
    
    
     <div class="form-outline mb-4">
    <input  type="email" name="email" value="<%= a.getEmail() %>" class="form-control" />
    <label class="form-label" for="form6Example5">Email</label>
  </div>
    
    <div class="form-outline mb-4">
    <input  type="number" name="phone" value="<%= a.getPhone() %>" class="form-control" />
    <label class="form-label" for="form6Example5">Phone</label>
  </div>
    
    
    <div class="form-outline mb-4">
    <input  type="text" name="login" value="<%= a.getLogin() %>" class="form-control" />
    <label class="form-label" for="form6Example5">Login</label>
  </div>
    
    
    <div class="form-outline mb-4">
    <input  type="password" name="password" value="<%= a.getPassword() %>" class="form-control" />
    <label class="form-label" for="form6Example5">Password</label>
  </div>
    
    
    <select class="form-select my-1"  name="grade_lib" >
                            <%
                                GradeDAO gd = new GradeDAO();
                                List<Grade> list = (List<Grade>) gd.getGrades();
                                for (Grade g : list) {
                            %>
                            <option value="<%=g.getId_grade()%>"><%=g.getLibelle()%></option>");
                            <%}%>


                        </select>
  <!-- Submit button -->
  <input type="submit" value="Modifier l'enseignat" name="OK" class="btn btn-primary btn-block mb-4">
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
