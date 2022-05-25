<%-- 
    Document   : inscriptionPatient
    Created on : Feb 21, 2022, 11:34:18 PM
    Author     : Shajaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@page import="com.appweb2projetsession.mvc.model.Medecin"%>
<%@page import="com.appweb2projetsession.mvc.model.Medecin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ArrayList<Medecin> listeMedecin = (ArrayList) request.getAttribute("listeMedecin");
    ArrayList<Clinique> listeClinique = (ArrayList) request.getAttribute("listeClinique");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp" />  
        <title>Inscription Patient</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card m-3">
                        <div class="card-header text-center" style="font-size: 150%"><strong>Inscription Patient</strong></div>
                        <div class="card-body">
                            <div>
                                <c:if test="${not empty requestScope.existeNAM}">
                                    <div class="alert alert-danger text-center" role="alert">
                                        <h4>${requestScope.existeNAM}</h4>
                                    </div>
                                </c:if> 
                                <c:if test="${not empty requestScope.existeNB}">
                                    <div class="alert alert-danger text-center" role="alert">
                                        <h4>${requestScope.existeNB}</h4>
                                    </div>
                                </c:if> 
                            </div>
                            <form action="inscriptionPatient" method="GET" class="p-2">
                                <div class="form-row">
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputEmail4">Nom</label>
                                        <input type="text" class="form-control" placeholder="nom" name="nom" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputPassword4">Prenom</label>
                                        <input type="text" class="form-control" placeholder="Prenom" name="prenom" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress">Numero d'assurance maladie</label>
                                        <input type="text" class="form-control" placeholder="ABCD 1234 5678" name="nam" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress2">Numero Sequentiel</label>
                                        <input type="number" class="form-control" placeholder="123" name="nbSequentiel" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity">Date de naissance</label>
                                        <input type="date" class="form-control" placeholder="JJ-MM-AAAA" name="dateNaissance" required>
                                    </div>
                                    <div class="form-group p-2">
                                        <label for="inputZip">Sexe</label>
                                        <select name="sexe" required>
                                            <option value="f">F</option>
                                            <option value="m">M</option>
                                            <option value="o">O</option>
                                        </select>
                                    </div>
                                    <div class="form-group p-2">
                                        <label for="inputZip">Choisissez une medecin</label>
                                        <br>
                                        <c:forEach items="${listeMedecin}" var="medecin">
                                            <input type="radio" name="medecin_id" value="${medecin.id}" required>
                                              <label>Nom: ${medecin.nom}</label>
                                              <label>Adresse: ${medecin.lieuProfession}</label><br>

                                        </c:forEach>
                                    </div>
                                    <div class="form-group p-2">
                                        <label for="inputZip">Choisissez une clinique</label>
                                        <br>
                                        <c:forEach items="${listeClinique}" var="clinique">
                                            <input type="radio" name="clinique_id" value="${clinique.id}" required>
                                              <label>Nom: ${clinique.nom}</label>
                                              <label>Adresse: ${clinique.adresse}</label><br>

                                        </c:forEach>
                                    </div>

                                    <button type="submit" class="btn btn-primary p-2">Inscrire</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
