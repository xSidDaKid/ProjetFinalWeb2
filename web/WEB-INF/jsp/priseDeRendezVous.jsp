<%-- 
    Document   : priseDeRendezVous
    Created on : Mar 19, 2022, 11:52:22 PM
    Author     : Shajaan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title><fmt:message key="label.take" /></title>
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
                        <button class="nav-link active" id="Definir-tab" data-bs-toggle="tab" data-bs-target="#Definir" type="button" ><fmt:message key="label.take" /></button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Voir-tab" data-bs-toggle="tab" data-bs-target="#Voir" type="button" ><fmt:message key="label.prise" /></button>
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
                            <label  class="p-1"><fmt:message key="label.reason" /></label>
                            <select class="form-select" name="raison" required>
                                <option><fmt:message key="label.urgent" /></option>
                                <option><fmt:message key="label.consult" /></option>
                                <option><fmt:message key="label.perio" /></option>
                                <option><fmt:message key="label.regulier" /></option>
                                <option><fmt:message key="label.gros" /></option>
                                <option><fmt:message key="label.kid" /></option>
                                <option><fmt:message key="label.autre" /></option>
                            </select>

                            <br>

                            <label  class="p-1">Description</label>
                            <textarea cols="3" rows="3" name="description" class="form-control" placeholder="<fmt:message key="label.desc" />" required></textarea>

                            <br>

                            <label class="mb-1"><fmt:message key="label.dispo3" /> ${medecinPatient.nom} ${medecinPatient.prenom}</label>
                            <select class="form-select" name="date" required>
                                <c:forEach items="${listeRendezVous}" var="rV">
                                    <option>${rV.date}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <button type="submit" class="btn btn-primary"><fmt:message key="label.add2" /></button>
                        </form>
                    </div>
                    <!-- TAB Voir -->
                    <div class="tab-pane fade" id="Voir" role="tabpanel" aria-labelledby="Voir-tab">
                        <table id="rVPatient" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Date</th>
                                    <th><fmt:message key="label.medicID" /></th>
                                    <th><fmt:message key="label.patientID" /></th>
                                    <th><fmt:message key="label.reason" /></th>
                                    <th>Description</th>
                                    <th><fmt:message key="label.modify" /></th>
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
