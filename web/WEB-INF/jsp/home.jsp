<%-- 
    Document   : home
    Created on : Feb 23, 2022, 10:56:28 AM
    Author     : Shajaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@page import="com.appweb2projetsession.mvc.model.Utilisateur"%>
<%@page import="com.appweb2projetsession.mvc.model.Patient"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if (request.getAttribute("nbPatient") == null) {
            getServletContext().getRequestDispatcher("/home").forward(request, response);
        }
    %>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="row  p-2" style="background-color:#1f4071;">
            <!-- Clinique -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="images/Clinique.png"/>" style="width: 100px;">
                    <h2 class="text-white text-center"><c:out value="${nbClinique}"/> CLINIQUES</h2>
                </div>
            </div>
            <!-- Medecin -->
            <div class="col " align="center">
                <div class="col-3 text-center align-content-center" align="center">
                    <img src="<c:url value="images/Medecin.png"/>" style="width: 100px;">
                    <h2 class="text-white"><c:out value="${nbMedecin}"/> MÉDECINS</h2>
                </div>
            </div>
            <!-- Patient -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="images/Patient.png"/>" style="width: 100px;">
                    <h2 class="text-white"><c:out value="${nbPatient}"/> PATIENTS</h2>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
