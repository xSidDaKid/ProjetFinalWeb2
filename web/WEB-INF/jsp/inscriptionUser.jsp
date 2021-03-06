<%-- 
    Document   : inscriptionUser
    Created on : Mar 13, 2022, 11:49:01 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title><fmt:message key="label.insUser" /></title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card mt-3">
                        <div class="card-header text-center" style="font-size: 150%"><img src="<c:url value="./static/images/form.png"/>" style="width: 30px;"><strong> <fmt:message key="label.insUser" /></strong></div>
                        <div class="card-body">
                            <div>
                                <c:if test="${not empty requestScope.existe}">
                                    <div class="alert alert-danger text-center" role="alert">
                                        <h4>${requestScope.existe}</h4>
                                    </div>
                                </c:if> 
                                <c:if test="${not empty requestScope.motDePasse}">
                                    <div class="alert alert-danger text-center" role="alert">
                                        <h4>${requestScope.motDePasse}</h4>
                                    </div>
                                </c:if> 
                            </div>
                            <form action="inscriptionUser" method="POST">
                                <div class="form-group p-2">
                                    <label><fmt:message key="label.username" /></label>
                                    <input  type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Nom d'utilisateur" required>
                                </div>
                                <div class="form-group p-2">
                                    <label><fmt:message key="label.pass" /></label>
                                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Mot de passe" required>
                                </div>
                                <div class="form-group p-2">
                                    <label><fmt:message key="label.pass2" /></label>
                                    <input type="password" name="password2" class="form-control" id="exampleInputPassword1" placeholder="Retaper le mot de passe" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Email</label>
                                    <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="Email" required>
                                </div>
                                <div class="form-group p-2">
                                    <label><fmt:message key="label.role" /></label>
                                    <select id="cars" class="form-select" name="role" required>
                                        <c:if test="${not empty listeClinique}">
                                            <c:if test="${not empty listeMedecin}">
                                                <option value="patient"><fmt:message key="label.patient3" /></option>
                                            </c:if> 
                                            <option value="medecin"><fmt:message key="label.medecin3" /></option>
                                        </c:if>
                                        <option value="clinique"><fmt:message key="label.clinic3" /></option>
                                    </select>
                                    <p><br><strong>Info:</strong> <fmt:message key="label.info" /></p>
                                </div>
                                <div class="text-center p-3">
                                    <button type="submit" class="btn btn-primary p-2 align-content-center">Suivant</button>
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

