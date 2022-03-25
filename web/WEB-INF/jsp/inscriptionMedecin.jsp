<%-- 
    Document   : inscriptionMedecin
    Created on : Mar 24, 2022, 10:00:05 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp" />  
        <title>Inscription Medecin</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card mt-3">
                        <div class="card-header text-center">Inscription Medecin</div>
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
                                        <label for="inputEmail4">Nom</label>
                                        <input type="text" class="form-control" placeholder="nom" name="nom">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputPassword4">Prenom</label>
                                        <input type="text" class="form-control" placeholder="Prenom" name="prenom">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress">Profession</label>
                                        <input type="text" class="form-control" placeholder="Profession" name="profession">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputAddress2">Numero Professionnel</label>
                                        <input type="text" class="form-control" placeholder="0123456789" name="nbProfessionnel">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity">Ententes</label>
                                        <input type="text" class="form-control" placeholder="123$" name="ententes">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity">Adresse</label>
                                        <input type="text" class="form-control" placeholder="1324 Rue ABC" name="adresse">
                                    </div>
                                    <div class="form-group col-sm-7 p-2">
                                        <label for="inputCity">Lieu de profession</label>
                                        <input type="text" class="form-control" placeholder="Rosemont" name="lieuProfession">
                                    </div>
                                    
                                    <!--  <div class="form-group">
                                          <label for="inputCity">Clinique ID</label>
                                          <input type="text" class="form-control" name="dateNaissance">
                                      </div>
                                      <div class="form-group">
                                          <label for="inputCity">Medecin ID</label>
                                          <input type="text" class="form-control" name="dateNaissance">
                                      </div>-->

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
