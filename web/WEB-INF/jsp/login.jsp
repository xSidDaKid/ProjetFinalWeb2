<%-- 
    Document   : login
    Created on : Mar 13, 2022, 10:46:13 PM
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
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="login-wrap p-4 p-md-5">
                        <c:if test="${not empty requestScope.erreur}">
                            <div class="alert alert-danger text-center" role="alert">
                                <h4>${requestScope.erreur}</h4>
                            </div>
                        </c:if>
                        <div class="card">
                            <div class="card-header text-center" style="font-size: 150%"><strong>Login</strong></div>
                            <div class="card-body">
                                <form action="login" method="POST">
                                    <div class="form-group p-2">
                                        <label>Email</label>
                                        <input  name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
                                    </div>
                                    <div class="form-group p-2">
                                        <label><fmt:message key="label.pass" /></label>
                                        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required >
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary p-2 align-content-center">Login</button>
                                    </div>
                                </form>
                                <hr>
                                <div class="text-center">
                                <p class="text-center"><fmt:message key="label.login" /></p>
                                <a class="link-primary" href="<c:url value="/inscriptionUser"/>"><fmt:message key="label.inscrire" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
