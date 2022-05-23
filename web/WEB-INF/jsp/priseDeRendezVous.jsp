<%-- 
    Document   : priseDeRendezVous
    Created on : Mar 19, 2022, 11:52:22 PM
    Author     : Shajaan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <c:if test="${not empty requestScope.deletedDispo}">
                <div class="alert alert-success text-center" role="alert">
                    <h4>${requestScope.deletedDispo}</h4>
                </div>
            </c:if> 
            <div class="card p-3">

                <!-- LISTE DES TABS -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Definir-tab" data-bs-toggle="tab" data-bs-target="#Definir" type="button" >Prendre un rendez-vous</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Voir-tab" data-bs-toggle="tab" data-bs-target="#Voir" type="button" >Voir mes rendez-vous</button>
                    </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                    <!-- TAB Definir -->
                    <div class="tab-pane fade show active" id="Definir" role="tabpanel" aria-labelledby="Definir-tab">
                        <c:if test="${not empty requestScope.rvCreer}">
                            <div class="mt-3 alert alert-success text-center" role="alert">
                                <h4>${requestScope.rvCreer}</h4>
                            </div>
                        </c:if> 
                        <form class="p-2" action="priseDeRendezVous" method="GET">
                            <label  class="p-1">Raison</label>
                            <select class="form-select" name="raison" required>
                                <option>Urgence mineure</option>
                                <option>Consultation prioritaire</option>
                                <option>Suivi périodique ou préventif</option>
                                <option>Suivi régulier</option>
                                <option>Suivi de grossesse</option>
                                <option>Suivi d’un enfant de 0 à 5 ans</option>
                                <option>Autre</option>
                            </select>

                            <br>

                            <label  class="p-1">Description</label>
                            <textarea cols="3" rows="3" name="description" class="form-control" placeholder="Donnez nous une courte description de votre condition" required></textarea>

                            <br>

                            <label class="mb-1">Voici les disponiblité de ${medecinPatient.nom} ${medecinPatient.prenom}</label>
                            <select class="form-select" name="date" required>
                                <c:forEach items="${listeRendezVous}" var="rV">
                                    <option>${rV.date}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <button type="submit" class="btn btn-primary">Ajouter</button>
                        </form>
                    </div>
                    <!-- TAB Voir -->
                    <div class="tab-pane fade" id="Voir" role="tabpanel" aria-labelledby="Voir-tab">
                        <table id="rVPatient" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Date</th>
                                    <th>Medecin ID</th>
                                    <th>Patient ID</th>
                                    <th>Raison</th>
                                    <th>Description</th>
                                    <th>Modifier</th>
                                    <th>Supprimer</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${mesRV}" var="rV">
                                    <tr>
                                        <td>${rV.id}</td>
                                        <td>${rV.date}</td>
                                        <td>${rV.medecin_id}</td>
                                        <td>${rV.patient_id}</td>
                                        <td>${rV.raison}</td>
                                        <td>${rV.description}</td>
                                        <td><a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifRvId=${rV.id}'/>"/>Modification</a>
                                        </td>
                                        <td><a href="<c:url value='?deleteRvId=${rV.id}'/>"/>Delete</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty requestScope.erreurDispo}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreurDispo}</h4>
                            </div>
                        </c:if> 
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script>
            $(document).ready(function () {
                $('#rVPatient').DataTable();
            });
        </script>
    </body>
</html>
