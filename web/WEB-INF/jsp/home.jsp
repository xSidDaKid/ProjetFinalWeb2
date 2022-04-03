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
        /*if (request.getAttribute("nbPatient") == null) {
            getServletContext().getRequestDispatcher("/home").forward(request, response);
        }*/
    %>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>

        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row">
                <br>
            </div>
        </div>
        <!-- BIENVENUE -->
        <div class="container text-center mt-2">
            <div class="row" style="background-color:#1f4071;">
                <h1 class="text-center text-white">Bienvenue à __!</h1>
                <h3 class="text-center text-white">Des cliniques, des médecins et des patients peuvent s'inscrire pour pouvoir faire des rendez-vous très rapide et simple.</h3>
            </div>
        </div>
        <!-- LOGIN/INSCRIPTION -->
        <c:if test="${empty sessionScope.User}">
            <div class="container text-center my-3">
                <div class="row">
                    <div class="col-6">
                        <button class="p-3 bg-black"><a class="text-white" href="inscriptionUser">Inscrire</a></button>
                    </div>
                    <div class="col-6">
                        <button class="p-3 btn-primary"><a class="text-white" href="login">Login</a></button>
                    </div>
                </div>
            </div>
        </c:if>
        <!-- NOMBRE DE UTILISATEUR/CLINIQUE/MEDECIN/PATIENT -->
        <div class="row m-1 p-2" style="background-color:#1f4071;">
            <h2 class="text-center text-white p-2">Déjà <span id="user"></span> utilisateurs!</h2> 
            <br>
            <!-- Clinique -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="images/Clinique.png"/>" style="width: 100px;">
                    <h2 class="text-white text-center"><span id="clinique"></span><br>CLINIQUES</h2>
                </div>
            </div>
            <!-- Medecin -->
            <div class="col " align="center">
                <div class="col-3 text-center align-content-center" align="center">
                    <img src="<c:url value="images/Medecin.png"/>" style="width: 100px;">
                    <h2 class="text-white"><span id="medecin"></span><br>MÉDECINS</h2>
                </div>
            </div>
            <!-- Patient -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="images/Patient.png"/>" style="width: 100px;">
                    <h2 class="text-white"><span id="patient"></span><br>PATIENTS</h2>
                </div>
            </div>
        </div>

    <jsp:include page="footer.jsp"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'clinique',
                success: function (nbClinique) {
                    $('#clinique').html(nbClinique);
                }
            });
            $.ajax({
                type: 'GET',
                url: 'medecin',
                success: function (nbMedecin) {
                    $('#medecin').html(nbMedecin);
                }
            });
            $.ajax({
                type: 'GET',
                url: 'patient',
                success: function (nbPatient) {
                    $('#patient').html(nbPatient);
                }
            });
            $.ajax({
                type: 'GET',
                url: 'user',
                success: function (nbUser) {
                    $('#user').html(nbUser);
                }
            });
        });

    </script>
</body>
</html>
