<%-- 
    Document   : inscriptionMedecin
    Created on : Mar 19, 2022, 7:45:41 AM
    Author     : Robydul  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:include page="head.jsp" />  
        <title>Inscription Patient</title>
    </head>
    <body>
          <jsp:include page="menu.jsp"/>
        <div class="container pt-5 mt-5 card">
            <form id="signupForm" method="get" class="form-horizontal" action="InscriptionMedecin">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nom">Nom:</label>
                        <input type="text" class="form-control" id="nom" placeholder="nom">
                    </div>
                    <div class="form-group">
                        <label for="prenom">Prenom:</label>
                        <input type="text" class="form-control" id="prenom" placeholder="prenom">
                    </div>
                    <div class="form-group">
                        <label for="profession">Profession:</label>
                        <input type="tel" class="form-control" id="tel" placeholder="profession">
                    </div>
                    <div class="form-group">
                        <label for="ndp">Numero de professionnel:</label>
                        <input type="text" class="form-control" id="ndp" placeholder="Numero de professionnel">
                    </div>
                          <div class="form-group">
                        <label for="ententes">Ententes:</label>
                        <input type="text" class="form-control" id="ententes" placeholder="Ententes">
                    </div>
                          <div class="form-group">
                        <label for="adresse">Adresse:</label>
                        <input type="text" class="form-control" id="Adresse" placeholder="Adresse">
                    </div>
                           <div class="form-group">
                        <label for="tel">Numero de telephone:</label>
                        <input type="tel" class="form-control" id="tel" placeholder="514-784-8542">
                    </div>
                         <div class="form-group">
                        <label for="ldp">Lieu de profession:</label>
                        <input type="text" class="form-control" id="ndp" placeholder="Lieu de profession">
                    </div>                    
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Check me out
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </form>
        </div>
            <jsp:include page="footer.jsp"/>
    </body>
</html>
