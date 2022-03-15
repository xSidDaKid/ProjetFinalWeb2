<%-- 
    Document   : inscriptionPatient
    Created on : Feb 21, 2022, 11:34:18 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp" />  
        <title>Inscription Patient</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container pt-5 mt-5">
            <div class="card p-3">
                <form action="inscriptionPatient" method="GET" class="p-2">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Nom</label>
                            <input type="text" class="form-control" placeholder="nom" name="nom">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Prenom</label>
                            <input type="text" class="form-control" placeholder="Prenom" name="prenom">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress">Numero d'assurance maladie</label>
                            <input type="text" class="form-control" placeholder="ABCD 1234 5678" name="nam">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress2">Numero Sequentiel</label>
                            <input type="number" class="form-control" placeholder="123" name="nbSequentiel">
                        </div>
                        <div class="form-group">
                            <label for="inputCity">Date de naissance</label>
                            <input type="date" class="form-control" placeholder="JJ-MM-AAAA" name="dateNaissance">
                        </div>
                        <div class="form-group">
                            <label for="inputZip">Sexe</label>
                            <select name="sexe" required>
                                <option value="f">F</option>
                                <option value="m">M</option>
                                <option value="o">O</option>
                            </select>
                        </div>
                      <!--  <div class="form-group">
                            <label for="inputCity">Clinique ID</label>
                            <input type="text" class="form-control" name="dateNaissance">
                        </div>
                        <div class="form-group">
                            <label for="inputCity">Medecin ID</label>
                            <input type="text" class="form-control" name="dateNaissance">
                        </div>-->
                        
                        <button type="submit" class="btn btn-primary">Inscrire</button>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
