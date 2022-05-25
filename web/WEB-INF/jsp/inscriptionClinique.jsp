<%-- 
    Document   : inscriptionClinique
    Created on : Mar 3, 2022, 8:23:32 AM
    Author     : Robydul  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Clinique</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card m-3">
                        <div class="card-header text-center" style="font-size: 150%"><img src="<c:url value="./static/images/form.png"/>" style="width: 30px;"><strong> Inscription Clinique</strong></div>
                        <div class="card-body">
                            <div>
                                <c:if test="${not empty requestScope.existe}">
                                    <div class="alert alert-danger text-center" role="alert">
                                        <h4>${requestScope.existe}</h4>
                                    </div>
                                </c:if> 
                            </div>
                            <form id="signupForm" method="get" class="form-horizontal p-2" action="inscriptionClinique">
                                <div class="form-row">
                                    <div class="form-group col-md-6 p-1">
                                        <label for="nom">Nom:</label>
                                        <input type="text" class="form-control" name="nom" placeholder="Nom de la clinique" required>
                                    </div>
                                    <div class="form-group p-1">
                                        <label for="adresse">Address:</label>
                                        <input type="text" class="form-control" name="adresse" placeholder="1234 Main St" required>
                                    </div>
                                    <div class="form-group p-1">
                                        <label for="tel">Telephone:</label>
                                        <input type="tel" class="form-control" name="tel" placeholder="514-784-8542" required>
                                    </div>
                                    <div class="form-group p-1">
                                        <label for="services">Services:</label>
                                        <input type="text" class="form-control" name="services" placeholder="Tests diagnostiques" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary mt-2">Inscrire</button>
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
