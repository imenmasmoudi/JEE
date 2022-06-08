<%-- 
    Document   : editgrade
    Created on : 30 mai 2021, 15:43:32
    Author     : tunin
--%>

<%@page import="tn.iit.persistance.EnseignantDAO"%>
<%@page import="tn.iit.entities.Departement"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.entities.Enseignant"%>
<%@page import="tn.iit.persistance.GradeDAO"%>
<%@page import="tn.iit.entities.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier Departement</title>
        
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
     <h3>Modifier Departement</h3>
                <form action="DepartementController" method="POST">
    <%
                    Departement a = (Departement) request.getAttribute("departement");
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
        <input type="text" name="libelle" value="<%= a.getLibelle() %>" class="form-control" />
        <label class="form-label" for="form6Example2">Libelle</label>
      </div>
    </div>
  </div>
    
    
    <select class="form-select my-1"  name="departement_lib" >
                            <%
                                EnseignantDAO ed = new EnseignantDAO();
                                List<Enseignant> list = (List<Enseignant>) ed.getEnseignants();
                                for (Enseignant e : list) {
                            %>
                            <option value="<%=e.getId() %>"><%= e.getPrenom()+" "+e.getNom() %></option>");
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
