<%-- 
    Document   : espacePatient
    Created on : Apr 4, 2022, 10:08:10 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3">
            <div class="row">
                <div class="col">
                    <c:choose>
                        <c:when test="${verif == false}">
                            <!--CHOIX DU PATIENT-->
                            <div class="card">
                                <div class="card-header">Liste de mes patients</div>
                                <div class="card-body">
                                    <ul>
                                        <c:forEach items="${listePatient}" var="patient">
                                            <li>
                                                <a href="<c:url value='?patient=${patient.id}'/>">${patient.id} - ${patient.nom} ${patient.prenom}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <!-- INFO PATIENT -->
                            <div class="card">
                                <div class="card-header">Patient #${infoPatient.id} - ${infoPatient.nom} ${infoPatient.prenom}</div>
                                <div class="card-body">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <th>Nom</th>    
                                                <td>${infoPatient.nom}</td>
                                            </tr>
                                            <tr>
                                                <th>Prénom</th>    
                                                <td>${infoPatient.prenom}</td>
                                            </tr>
                                            <tr>
                                                <th>Numéro d'assurance social</th>    
                                                <td>${infoPatient.nam}</td>
                                            </tr>
                                            <tr>
                                                <th>Date de naissance</th>    
                                                <td>${infoPatient.dateNaissance}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <hr>
                                    <form method="GET" action="espacePatient">
                                        <table id="profil" class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Fichier</th>
                                                    <th>Information</th>
                                                    <th>Date</th>
                                                    <!--<th></th>-->
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${lstProfil}" var="profilPatient">
                                                    <tr>
                                                        <td>${profilPatient.nomFichier}</td>
                                                        <td>${profilPatient.info}</td>
                                                        <td>${profilPatient.date}</td>
                                                        <!--<td>
                                                            <input name="telecharger" value="true" placeholder="true">
                                                            <button type="submit" class="btn btn-primary p-2 align-content-center" >Suivant</button>
                                                        </td>-->
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script>
            $(document).ready(function () {
                $('#profil').DataTable();
            });
        </script>
    </body>

</html>
