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
                        <div class="card-header text-center">Inscription Utilisateur</div>
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
                                    <label>Nom d'utilisateur</label>
                                    <input  type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Nom d'utilisateur" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Mot de passe</label>
                                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Mot de passe" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Retapper le mot de passe</label>
                                    <input type="password" name="password2" class="form-control" id="exampleInputPassword1" placeholder="Retaper le mot de passe" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Email</label>
                                    <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="Email" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Role</label>
                                    <select id="cars" class="form-select" name="role" required>
                                        <c:if test="${not empty listeClinique}">
                                            <c:if test="${not empty listeMedecin}">
                                                <option value="patient">Patient</option>
                                            </c:if> 
                                            <option value="medecin">Medecin</option>
                                        </c:if>
                                        <option value="clinique">Clinique</option>
                                    </select>
                                    <p><br><strong>Info:</strong> Une medecin et un patient peut juste être créé si une clinique existe. 
                                        Un patient peut juste être créé si une clinique ET un médecin existe</p>
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

