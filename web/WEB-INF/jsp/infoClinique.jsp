<%-- 
    Document   : infoClinique
    Created on : May 23, 2022, 1:58:10 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Informations Clinique</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {
                $('#patientTable').DataTable();
            });
            $(document).ready(function () {
                $('#medecinTable').DataTable();
            });
        </script>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <div class="card">
                <div class="card-header text-center"><strong>Bienvenue au clinique ${sessionScope.Clinique.nom}</strong></div>
                <div class="card-body">
                    <div>
                    Nom: ${sessionScope.Clinique.nom}<br>
                    Adresse: ${sessionScope.Clinique.adresse}<br>
                    Numéro de téléphone: ${sessionScope.Clinique.tel}<br>
                    Services: ${sessionScope.Clinique.services}<br>
                    </div>
                    <hr>
                    <!-- LISTE DES TABS -->
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="Patient-tab" data-bs-toggle="tab" data-bs-target="#Patient" type="button" >Patient</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="Medecin-tab" data-bs-toggle="tab" data-bs-target="#Medecin" type="button" >Medecin</button>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <!-- TAB PATIENT -->
                        <div class="tab-pane fade show active" id="Patient" role="tabpanel" aria-labelledby="Patient-tab">

                            <table id="patientTable" class="mt-2 table">

                                <thead class="thead-dark mt-2">
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
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Profession</th>
                                        <th>Numero professionnel</th>
                                        <th>Ententes</th>
                                        <th>Adresse</th>
                                        <th>Lieu de profession</th>
                                        <th>ID clinique</th>
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
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
