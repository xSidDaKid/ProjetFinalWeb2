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

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <%
        /*if (request.getAttribute("nbPatient") == null) {
            getServletContext().getRequestDispatcher("/home").forward(request, response);
        }*/
    %>
    <head>
        <jsp:include page="head.jsp"/>
        <title><fmt:message key="label.home" /></title>
    </head>
    <body>

        <jsp:include page="menu.jsp"/>
        <p class="text-white"><fmt:message key="label.lg" /></p>
        <button class="btn-primary" value="en"><a class="text-black" href="?langage=en">English</a></button>
        <button class="btn-primary" value="fr"><a class="text-black" href="?langage=fr">Français</a></button>
        <div class="container">
            <div class="row">
                <br>
            </div>
        </div>
        <!-- BIENVENUE -->
        <div class="container text-center mt-2">
            <div class="row rounded" style="background-color:#1f4071;">
                <h1 class="text-center text-white"><fmt:message key="label.welcome" /></h1>
                <h3 class="text-center text-white"><fmt:message key="label.intro" /></h3>
            </div>
        </div>
        <!-- LOGIN/INSCRIPTION -->
        <c:if test="${empty sessionScope.User}">
            <div class="container text-center my-3">
                <div class="row">
                    <div class="col-6">
                        <button class="p-3 btn-primary"><a class="text-white" href="inscriptionUser"><fmt:message key="label.inscrire" /></a></button>
                    </div>
                    <div class="col-6">
                        <button class="p-3 btn-primary"><a class="text-white" href="login">Login</a></button>
                    </div>
                </div>
            </div>
        </c:if>
        <!-- NOMBRE DE UTILISATEUR/CLINIQUE/MEDECIN/PATIENT -->
        <div class="row m-1 p-2 rounded" style="background-color:#1f4071;">
            <h2 class="text-center text-white p-2"><fmt:message key="label.userNb" /></h2> 
            <br>
            <!-- Clinique -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="./static/images/Clinique.png"/>" style="width: 100px;">
                    <h2 class="text-white text-center"><span id="clinique"></span><br><fmt:message key="label.clinic" /></h2>
                </div>
            </div>
            <!-- Medecin -->
            <div class="col " align="center">
                <div class="col-3 text-center align-content-center" align="center">
                    <img src="<c:url value="./static/images/Medecin.png"/>" style="width: 100px;">
                    <h2 class="text-white"><span id="medecin"></span><br><fmt:message key="label.medecin" /></h2>
                </div>
            </div>
            <!-- Patient -->
            <div class="col" align="center">
                <div class="col-3 text-center">
                    <img src="<c:url value="./static/images/Patient.png"/>" style="width: 100px;">
                    <h2 class="text-white"><span id="patient"></span><br><fmt:message key="label.patient" /></h2>
                </div>
            </div>
        </div>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-header text-center"><img src="<c:url value="./static/images/clock.png"/>" style="width: 30px;"><strong> <fmt:message key="label.heure" /></strong></div>
                        <div class="card-body">
                            <table class="overview">
                                <tbody>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour1" /> </td>
                                        <td class="time">08:00 - 16:00</td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour2" /> </td>
                                        <td class="time">08:00 - 16:00</td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour3" />  </td>
                                        <td class="time">08:00 - 16:00</td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour4" /> </td>
                                        <td class="time">08:00 - 16:00</td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour5" /> </td>
                                        <td class="time">08:00 - 16:00</td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour6" /> </td>
                                        <td class="time"><fmt:message key="label.ferme" /></td>
                                    </tr>
                                    <tr>
                                        <td class="day"><fmt:message key="label.jour7" />  </td>
                                        <td class="time day-off"> <fmt:message key="label.ferme" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-header text-center"><img src="<c:url value="./static/images/contact.png"/>" style="width: 30px;"><strong> Contact</strong></div>
                        <div class="card-body">
                            <section id="contacts" class="section">

                                <div class="info">
                                    <ul class="p-2">
                                        <li>

                                            <div class="cls-info-name">
                                                <fmt:message key="label.nom" />
                                            </div>

                                            <div class="icon">
                                                <i class="fa fa-at" aria-hidden="true"></i>
                                            </div>
                                            <div class="links emails">
                                                Shajaan Balasingam
                                            </div>
                                        </li>
                                        <li>

                                            <div class="cls-info-name">
                                                Email
                                            </div>

                                            <div class="icon">
                                                <i class="fa fa-at" aria-hidden="true"></i>
                                            </div>
                                            <div class="links emails">
                                                <a href="">email@crosemont.qc.ca</a>
                                            </div>
                                        </li>
                                        <li>

                                            <div class="cls-info-name">
                                                <fmt:message key="label.adresse" />
                                            </div>

                                            <div class="icon">
                                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                                            </div>
                                            <div class="links">
                                                6400 16e Avenue, Montréal, QC
                                            </div>
                                        </li>
                                        <li>

                                            <div class="cls-info-name">
                                                <fmt:message key="label.site" />
                                            </div>

                                            <div class="icon">
                                                <i class="fa fa-globe" aria-hidden="true"></i>
                                            </div>
                                            <div class="links website">
                                                <a href="" rel="nofollow">
                                                    localhost
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br><br><br>
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
