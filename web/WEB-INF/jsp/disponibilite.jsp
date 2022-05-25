<%-- 
    Document   : disponibilite
    Created on : Mar 25, 2022, 11:09:16 PM
    Author     : Shajaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.RendezVous"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<%
    ArrayList<RendezVous> listeRendezVousMedecin = (ArrayList) request.getAttribute("listeRendezVousMedecin");
%>
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title><fmt:message key="label.dispo2" /></title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <c:if test="${not empty requestScope.erreurDispo}">
                <div class="alert alert-danger text-center" role="alert">
                    <h4>${requestScope.erreurDispo}</h4>
                </div>
            </c:if> 
            <c:if test="${not empty requestScope.deleted}">
                <div class="alert alert-success text-center" role="alert">
                    <h4>${requestScope.deleted}</h4>
                </div>
            </c:if> 
            <c:if test="${not empty requestScope.DispoCreer}">
                <div class="mt-3 alert alert-success text-center" role="alert">
                    <h4>${requestScope.DispoCreer}</h4>
                </div>
            </c:if> 
            <div class="card p-3">

                <!-- LISTE DES TABS -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Definir-tab" data-bs-toggle="tab" data-bs-target="#Definir" type="button" ><fmt:message key="label.dispo" /></button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Voir-tab" data-bs-toggle="tab" data-bs-target="#Voir" type="button" ><fmt:message key="label.voirDispo" /></button>
                    </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                    <!-- TAB Definir -->
                    <div class="tab-pane fade show active" id="Definir" role="tabpanel" aria-labelledby="Definir-tab">

                        <form class="p-2" action="disponibilite" method="GET">
                            <label  class="p-1">Date</label>
                            <input class="form-control" type="date" name="date" name="id" placeholder="YYYY-MM-DD hh:mm:ss">
                            <label  class="mt-2"><fmt:message key="label.choose" /></label>
                            <br>
                            <input type="radio" name="time" value="08:00" required>
                            <label class="p-1">8h</label>

                            <input type="radio" name="time" value="08:30" required>
                            <label class="p-1">8h30</label>

                            <input type="radio" name="time" value="09:00" required>
                            <label class="p-1">9h</label>

                            <input type="radio" name="time" value="09:30" required>
                            <label class="p-1">9h30</label>

                            <input type="radio" name="time" value="10:00" required>
                            <label class="p-1">10h</label>

                            <input type="radio" name="time" value="10:30" required>
                            <label class="p-1">10h30</label>

                            <input type="radio" name="time" value="11:00" required>
                            <label class="p-1">11h</label>

                            <input type="radio" name="time" value="11:30" required>
                            <label class="p-1">11h30</label>

                            <input type="radio" name="time" value="12:00" required>
                            <label class="p-1">12h</label>

                            <input type="radio" name="time" value="12:30" required>
                            <label class="p-1">12h30</label>

                            <input type="radio" name="time" value="13:00" required>
                            <label class="p-1">13h</label>

                            <input type="radio" name="time" value="13:30" required>
                            <label class="p-1">13h30</label>

                            <input type="radio" name="time" value="14:00" required>
                            <label class="p-1">14h</label>

                            <input type="radio" name="time" value="14:30" required>
                            <label class="p-1">14h30</label>

                            <input type="radio" name="time" value="15:00" required>
                            <label class="p-1">15h</label>

                            <input type="radio" name="time" value="15:30" required>
                            <label class="p-1">15h30</label>

                            <input type="radio" name="time" value="16:00" required>
                            <label class="p-1">16h</label>
                            <br>
                            <button type="submit" class="btn btn-primary"><fmt:message key="label.add2" /></button>
                        </form>
                    </div>
                    <!-- TAB Voir -->
                    <div class="tab-pane fade m-3" id="Voir" role="tabpanel" aria-labelledby="Voir-tab">
                        <table id="dispoMedecin" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Date</th>
                                    <th><fmt:message key="label.medicID" /></th>
                                    <th><fmt:message key="label.patientID" /></th>
                                    <th>Raison</th>
                                    <th><fmt:message key="label.reason" /></th>
                                    <th><fmt:message key="label.modify" /></th>
                                    <th>Supprimer</th>
                                </tr>
                            </thead>
                            <c:forEach items="${listeRendezVousMedecin}" var="rV">
                                <tr>
                                    <td>${rV.id}</td>
                                    <td>${rV.date}</td>
                                    <td>${rV.medecin_id}</td>
                                    <td>${rV.patient_id}</td>
                                    <td>${rV.raison}</td>
                                    <td>${rV.description}</td>
                                    <td><a data-toggle="modal" data-target="#exampleModal" href="<c:url value='?modifId=${rV.id}'/>"/>Modification</a>
                                    </td>
                                    <td><a href="<c:url value='?deletedId=${rV.id}'/>"/>Delete</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <br><br>
        </div>
        <jsp:include page="footer.jsp"/>
        <script>
            $(document).ready(function () {
                $('#dispoMedecin').DataTable();
            });
        </script>
    </body>
</html>

