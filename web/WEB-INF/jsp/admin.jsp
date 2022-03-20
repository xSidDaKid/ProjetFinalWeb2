<%-- 
    Document   : admin
    Created on : Mar 14, 2022, 4:43:01 PM
    Author     : Shajaan
--%>

<%@page import="com.appweb2projetsession.mvc.model.Utilisateur"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="view" value="/admin" scope="session" />

<%
    ArrayList<Patient> listePatient = (ArrayList) request.getAttribute("listePatient");
    ArrayList<Clinique> listeClinique = (ArrayList) request.getAttribute("listeClinique");
    ArrayList<Utilisateur> listeUtilisateur = (ArrayList) request.getAttribute("listeUtilisateur");
    Patient patientModif = (Patient) request.getAttribute("patient");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Admin</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <div class="card p-3">
                <!-- LISTE DES TABS -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Patient-tab" data-bs-toggle="tab" data-bs-target="#Patient" type="button" >Patient</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Medecin-tab" data-bs-toggle="tab" data-bs-target="#Medecin" type="button" >Medecin</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Clinique-tab" data-bs-toggle="tab" data-bs-target="#Clinique" type="button" >Clinique</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="User-tab" data-bs-toggle="tab" data-bs-target="#User" type="button" >Utilisateur</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <!-- TAB PATIENT -->
                    <div class="tab-pane fade show active" id="Patient" role="tabpanel" aria-labelledby="Patient-tab">
                        <c:if test="${not empty requestScope.erreurDelete}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurDelete}</h4>
                            </div>
                        </c:if> 
                        <table class="table table-bordered">

                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>Numero D'assurance Maladie</th>
                                    <th>Numero Sequentiel</th>
                                    <th>Date de Naissance</th>
                                    <th>Sexe</th>
                                    <th>Clinique ID</th>
                                    <th>Medecin ID</th>
                                    <th>User ID</th>
                                    <th colspan="2">Actions</th>
                                </tr>
                            </thead>
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
                                    <td><a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifId=${patient.id}'/>"/>Modification</a>
                                    </td>
                                    <td><a href="<c:url value='?deletedId=${patient.id}'/>"/>Delete</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreur}</h4>
                            </div>
                        </c:if> 
                    </div>
                    <!-- TAB MEDECIN -->
                    <div class="tab-pane fade" id="Medecin" role="tabpanel" aria-labelledby="Medecin-tab">...</div>
                    <!-- TAB CLINIQUE -->
                    <div class="tab-pane fade" id="Clinique" role="tabpanel" aria-labelledby="Clinique-tab">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Nom</th>
                                    <th>Adresse</th>
                                    <th>Numero de Telephone</th>
                                    <th>Services</th>
                                    <th>User ID</th>
                                    <th colspan="2">Actions</th>
                                </tr>
                            </thead>
                            <c:forEach items="${listeClinique}" var="clinique">
                                <tr>
                                    <td>${clinique.id}</td>
                                    <td>${clinique.nom}</td>
                                    <td>${clinique.adresse}</td>
                                    <td>${clinique.tel}</td>
                                    <td>${clinique.services}</td>
                                    <td>${clinique.id_user}</td>
                                    <td>
                                        <a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifId=${clinique.id}'/>"/>Modification</a>
                                    </td>
                                    <td><a href="<c:url value='?deletedId=${clinique.id}'/>"/>Delete</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreur}</h4>
                            </div>
                        </c:if>
                    </div>
                    <!-- TAB USER -->
                    <div class="tab-pane fade" id="User" role="tabpanel" aria-labelledby="User-tab">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                    <th colspan="2">Actions</th>
                                </tr>
                            </thead>
                            <c:forEach items="${listeUtilisateur}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td>${user.email}</td>
                                    <td>${user.role}</td>
                                    <td>
                                        <a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifId=${clinique.id}'/>"/>Modification</a>
                                    </td>
                                    <td><a href="<c:url value='?deletedId=${user.id}'/>"/>Delete</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreur}</h4>
                            </div>
                        </c:if> 
                    </div>
                </div>
                <button class="btn-primary"><a class="text-white" href="inscriptionUser"><strong>Ajouter un utilisateur</strong></a></button>
            </div>
        </div>
        <!-- Button trigger modal -->

        <jsp:include page="footer.jsp"/>
    </body>
</html>
