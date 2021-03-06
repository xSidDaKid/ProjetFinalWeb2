<%-- 
    Document   : admin
    Created on : Mar 14, 2022, 4:43:01 PM
    Author     : Shajaan
--%>

<%@page import="com.appweb2projetsession.mvc.model.Patient"%>
<%@page import="com.appweb2projetsession.mvc.model.Medecin"%>
<%@page import="com.appweb2projetsession.mvc.model.Utilisateur"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="view" value="/admin" scope="session" />

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<%
    ArrayList<Patient> listePatient = (ArrayList) request.getAttribute("listePatient");
    ArrayList<Medecin> listeMedecin = (ArrayList) request.getAttribute("listeMedecin");
    ArrayList<Clinique> listeClinique = (ArrayList) request.getAttribute("listeClinique");
    ArrayList<Utilisateur> listeUtilisateur = (ArrayList) request.getAttribute("listeUtilisateur");
    Patient patientModif = (Patient) request.getAttribute("patient");
%>
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title>Admin</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('#patientTable').DataTable();
            });
            $(document).ready(function () {
                $('#medecinTable').DataTable();
            });
            $(document).ready(function () {
                $('#cliniqueTable').DataTable();
            });
            $(document).ready(function () {
                $('#userTable').DataTable();
            });
        </script>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <c:if test="${not empty requestScope.erreurDeleteSucces}">
                <div class="alert alert-success text-center" role="alert">
                    <h4>${requestScope.erreurDeleteSucces}</h4>
                </div>
            </c:if> 
            <c:if test="${not empty requestScope.erreurDelete}">
                <div class="alert alert-danger text-center" role="alert">
                    <h4>${requestScope.erreurDelete}</h4>
                </div>
            </c:if> 
            <div class="card p-3">
                <!-- LISTE DES TABS -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Patient-tab" data-bs-toggle="tab" data-bs-target="#Patient" type="button" ><fmt:message key="label.patient2" /></button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Medecin-tab" data-bs-toggle="tab" data-bs-target="#Medecin" type="button" ><fmt:message key="label.medecin2" /></button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Clinique-tab" data-bs-toggle="tab" data-bs-target="#Clinique" type="button" ><fmt:message key="label.clinic2" /></button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="User-tab" data-bs-toggle="tab" data-bs-target="#User" type="button" ><fmt:message key="label.user2" /></button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <!-- TAB PATIENT -->
                    <div class="tab-pane fade show active" id="Patient" role="tabpanel" aria-labelledby="Patient-tab">

                        <table id="patientTable" class="mt-2 table">

                            <thead class="thead-dark mt-2">
                                <tr>
                                    <th>Id</th>
                                    <th><fmt:message key="label.nom2" /></th>
                                    <th><fmt:message key="label.prenom" /></th>
                                    <th><fmt:message key="label.nam" /></th>
                                    <th><fmt:message key="label.nbSequentiel" /></th>
                                    <th><fmt:message key="label.don" /></th>
                                    <th><fmt:message key="label.sexe" /></th>
                                    <th><fmt:message key="label.clinicID" /></th>
                                    <th><fmt:message key="label.medicID" /></th>
                                    <th><fmt:message key="label.userID" /></th>
                                    <th><fmt:message key="label.modify" /></th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listePatient}" var="patient">
                                    <tr>
                                        <td>${patient.id}</td>
                                        <td>${patient.nom}</td>
                                        <td>${patient.prenom}</td>
                                        <td>${patient.nam}</td>
                                        <td>${patient.nbSequentiel}</td>
                                        <td>${patient.dateNaissance}</td>
                                        <td>${patient.sexe}</td>
                                        <td>${patient.id_clinique}</td>
                                        <td>${patient.id_medecin}</td>
                                        <td>${patient.id_user}</td>
                                        <td><a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifPatientId=${patient.id}'/>"/>Modification</a>
                                        </td>
                                        <td><a href="<c:url value='?deletePatientId=${patient.id}'/>"/>Delete</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurP}</h4>
                            </div>
                        </c:if> 
                    </div>
                    <!-- TAB MEDECIN -->
                    <div class="tab-pane fade" id="Medecin" role="tabpanel" aria-labelledby="Medecin-tab">
                        <table id="medecinTable" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th><fmt:message key="label.nom2" /></th>
                                    <th><fmt:message key="label.prenom" /></th>
                                    <th>Profession</th>
                                    <th><fmt:message key="label.nbPro" /></th>
                                    <th><fmt:message key="label.entente" /></th>
                                    <th><fmt:message key="label.adresse" /></th>
                                    <th><fmt:message key="label.lieuPro" /></th>
                                    <th><fmt:message key="label.clinicID" /></th>
                                    <th><fmt:message key="label.userID" /></th>
                                    <th><fmt:message key="label.modify" /></th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listeMedecin}" var="medecin">
                                    <tr>
                                        <td>${medecin.id}</td>
                                        <td>${medecin.nom}</td>
                                        <td>${medecin.prenom}</td>
                                        <td>${medecin.profession}</td>
                                        <td>${medecin.nbProfessionnel}</td>
                                        <td>${medecin.ententes}</td>
                                        <td>${medecin.adresse}</td>
                                        <td>${medecin.lieuProfession}</td>
                                        <td>${medecin.id_clinique}</td>
                                        <td>${medecin.id_user}</td>
                                        <td>
                                            <a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifMedecinId=${medecin.id}'/>"/>Modification</a>
                                        </td>
                                        <td><a href="<c:url value='?deleteMedecinId=${medecin.id}'/>"/>Delete</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurM}</h4>
                            </div>
                        </c:if>
                    </div>
                    <!-- TAB CLINIQUE -->
                    <div class="tab-pane fade" id="Clinique" role="tabpanel" aria-labelledby="Clinique-tab">
                        <table id="cliniqueTable" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th><fmt:message key="label.nom" /></th>
                                    <th><fmt:message key="label.adresse" /></th>
                                    <th><fmt:message key="label.tel" /></th>
                                    <th>Services</th>
                                    <th><fmt:message key="label.userID" /></th>
                                    <th><fmt:message key="label.modify" /></th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listeClinique}" var="clinique">
                                    <tr>
                                        <td>${clinique.id}</td>
                                        <td>${clinique.nom}</td>
                                        <td>${clinique.adresse}</td>
                                        <td>${clinique.tel}</td>
                                        <td>${clinique.services}</td>
                                        <td>${clinique.id_user}</td>
                                        <td>
                                            <a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifCliniqueId=${clinique.id}'/>"/>Modification</a>
                                        </td>
                                        <td><a href="<c:url value='?deleteCliniqueId=${clinique.id}'/>"/>Delete</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurC}</h4>
                            </div>
                        </c:if>
                    </div>
                    <!-- TAB USER -->
                    <div class="tab-pane fade" id="User" role="tabpanel" aria-labelledby="User-tab">
                        <table id="userTable" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th><fmt:message key="label.username" /></th>
                                    <th><fmt:message key="label.pass" /></th>
                                    <th>Email</th>
                                    <th><fmt:message key="label.role" /></th>
                                    <th><fmt:message key="label.modify" /></th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listeUtilisateur}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td style="-webkit-text-security: disc;">${user.password}</td>
                                        <td>${user.email}</td>
                                        <td>${user.role}</td>
                                        <td>
                                            <a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifUserId=${user.id}'/>"/>Modification</a>
                                        </td>
                                        <td><a href="<c:url value='?deleteUserId=${user.id}'/>"/>Delete</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurU}</h4>
                            </div>
                        </c:if> 
                    </div>
                </div>
                <button class="btn-primary"><a class="text-white" href="inscriptionUser"><strong><fmt:message key="label.add" /></strong></a></button>
            </div>
        </div>
        <!-- Button trigger modal -->

        <jsp:include page="footer.jsp"/>
    </body>
</html>
