<%-- 
    Document   : inscriptionMedecin
    Created on : Mar 24, 2022, 10:00:05 PM
    Author     : Shajaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.Clinique"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<%
    ArrayList<Clinique> listeClinique = (ArrayList) request.getAttribute("listeClinique");
%>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp" />  
        <title><fmt:message key="label.insMedecin" /></title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card m-3">
                        <div class="card-header text-center" style="font-size: 150%"><img src="<c:url value="./static/images/form.png"/>" style="width: 30px;"><strong> <fmt:message key="label.insMedecin" /></strong></div>
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
                            <form action="inscriptionMedecin" method="GET" class="p-2">
                                <div class="form-row">
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputEmail4"><fmt:message key="label.nom2" /></label>
                                        <input type="text" class="form-control" placeholder="Nom" name="nom" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputPassword4"><fmt:message key="label.prenom" /></label>
                                        <input type="text" class="form-control" placeholder="Prenom" name="prenom" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress">Profession</label>
                                        <input type="text" class="form-control" placeholder="Profession" name="profession" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress2"><fmt:message key="label.nbPro" /></label>
                                        <input type="text" class="form-control" placeholder="0123456789" name="nbProfessionnel" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity"><fmt:message key="label.entente" /></label>
                                        <input type="text" class="form-control" placeholder="123$" name="ententes" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity"><fmt:message key="label.adresse" /></label>
                                        <input type="text" class="form-control" placeholder="1324 Rue ABC" name="adresse" required>
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity"><fmt:message key="label.lieuPro" /></label>
                                        <input type="text" class="form-control" placeholder="Rosemont" name="lieuProfession" required>
                                    </div>
                                    <div class="form-group p-2">
                                        <label for="inputZip"><fmt:message key="label.choiceClinic" /></label>
                                        <br>
                                        <c:forEach items="${listeClinique}" var="clinique">
                                            <input type="radio" name="clinique_id" value="${clinique.id}" required>
                                              <label><fmt:message key="label.nom" />: ${clinique.nom}</label>
                                              <label><fmt:message key="label.adresse" />: ${clinique.adresse}</label><br>

                                        </c:forEach>
                                    </div>

                                    <button type="submit" class="btn btn-primary p-2"><fmt:message key="label.inscrire" /></button>
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
