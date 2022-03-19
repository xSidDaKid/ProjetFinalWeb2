<%-- 
    Document   : afficherClinique
    Created on : Mar 16, 2022, 1:49:43 PM
    Author     : Robydul  
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    ArrayList<Clinique> listeClinique = (ArrayList)request.getAttribute("listeClinique");
     Clinique clinique = (Clinique)request.getAttribute("clinique");
%>

         <jsp:include page="head.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste de clinique </title>
    </head>
    <body>

         
            <jsp:include page="menu.jsp"/>
            
            
    
        
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nom</th>
      <th scope="col">Adresse</th>
      <th scope="col">Telephone</th>
      <th scope="col">Services</th>
    </tr>
  
    
    <% if(clinique!=null ){%>
      <td> <%=clinique.getId() %> </td>
      <td> <%=clinique.getNom() %> </td>
     <td> <%=clinique.getAdresse() %> </td>
      <td> <%=clinique. getTel() %> </td>
      <td> <%=clinique.getServices()%> </td>
     </tr>
     
     
     
     <% }else { 
         for(Clinique cli : listeClinique){%>
           <td> <%=cli.getId() %> </td>
      <td> <%=cli.getNom() %> </td>
     <td> <%=cli.getAdresse() %> </td>
      <td> <%=cli. getTel() %> </td>
      <td> <%=cli.getServices()%> </td>
     </tr>
   
   <% } }%>
 
   </table>
     
     
        
    </body>         
    
   <jsp:include page="footer.jsp"/>
</html>
