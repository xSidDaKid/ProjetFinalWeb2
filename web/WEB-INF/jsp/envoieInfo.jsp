<%-- 
    Document   : envoieInfo
    Created on : Apr 5, 2022, 6:30:18 PM
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
        <title><fmt:message key="label.envoieInfo" /></title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3">
            <div class="row">
                <div class="col">
                    <c:if test="${not empty requestScope.sent}">
                        <div class="alert alert-success text-center" role="alert">
                            <h4>${requestScope.sent}</h4>
                        </div>
                    </c:if>
                    <div class="card">
                        <div class="card-header text-center" style="font-size: 150%"><img src="<c:url value="./static/images/send.png"/>" style="width: 30px;"><strong> <fmt:message key="label.envoieInfo" /></strong></div>
                        <div class="card-body">
                            <form action="envoieInfo" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleFormControlInput1"><fmt:message key="label.m1" /></label>
                                    <input type="text" class="form-control" name="info" placeholder="${requestScope.m1.nom}" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Information</label>
                                    <input type="text" class="form-control" name="info" placeholder="" required>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlFile1" class="mt-2"><fmt:message key="label.choose" /></label>
                                    <br>
                                    <input class="form-control" type="file" class="mt-2 form-control-file" name="fichier" required>
                                </div>
                                <button type="submit" class="mt-2 btn btn-primary p-2 align-content-center"><fmt:message key="label.send" /></button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
