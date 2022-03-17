<%-- 
    Document   : inscriptionUser
    Created on : Mar 13, 2022, 11:49:01 PM
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
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card mt-3">
                        <div>
                            <c:if test="${not empty requestScope.existe}">
                                <div class="alert alert-danger text-center" role="alert">
                                    <h4>${requestScope.existe}</h4>
                                </div>
                            </c:if> 
                        </div>
                        <form action="inscriptionUser" method="GET">
                            <div class="form-group p-2">
                                <label>Nom d'utilisateur</label>
                                <input  type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nom d'utilisateur" required>
                            </div>
                            <div class="form-group p-2">
                                <label>Password</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
                            </div>
                            <div class="form-group p-2">
                                <label>Email</label>
                                <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="Email" required>
                            </div>
                            <div class="form-group p-2">
                                <label>Role</label>
                                <select id="cars" name="role" required>
                                    <option value="patient">Patient</option>
                                    <option value="docteur">Docteur</option>
                                    <option value="clinique">Clinique</option>
                                </select>
                            </div>
                            <div class="text-center p-3">
                                <button type="submit" class="btn btn-primary p-2 align-content-center">Suivant</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>

