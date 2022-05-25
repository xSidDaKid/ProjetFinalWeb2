<%-- 
    Document   : emailForm
    Created on : May 17, 2022, 09:28 PM
    Author     : Shajaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.appweb2projetsession.mvc.model.RendezVous"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title><fmt:message key="label.envoieEmailTitre" /></title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <c:if test="${not empty requestScope.Message}">
                        <div class="alert alert-success text-center" role="alert">
                            <h4>${requestScope.Message}</h4>
                        </div>
                    </c:if> 
                    <div class="card m-3">
                        <div class="card-header text-center" style="font-size: 150%"><strong><fmt:message key="label.newEmail" /></strong></div>
                        <div class="card-body">
                            <form action="envoyerEmail" method="get" enctype="multipart/form-data" class="p-2">
                                <label><fmt:message key="label.destinataire" /></label>
                                <input class="form-control" type="email" name="destinataire" size="50" value="${user.email}"/>

                                <label><fmt:message key="label.obj" /></label>
                                <input class="form-control" type="text" name="objet" size="50" required/>

                                <label><fmt:message key="label.content" /></label>
                                <textarea class="form-control" rows="10" cols="39" name="contenu" required>${lstRV}</textarea>

<!--                                <label>Attacher fichier </label>
                                <input class="form-control" type="file" name="file" size="50"/>
-->
                                <input class="btn btn-primary p-2 mt-2" type="submit" value="<fmt:message key="label.send" />"/>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
