<%-- 
    Document   : inscriptionClinique
    Created on : Mar 3, 2022, 8:23:32 AM
    Author     : Robydul  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Clinique</title>
    </head>
    <body>
       <jsp:include page="menu.jsp"/>
        <div class="container pt-5 mt-5">
            <form id="signupForm" method="get" class="form-horizontal"
							action="InscriptionCliniqueServlet">>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nom">Nom:</label>
                        <input type="text" class="form-control" id="nom" placeholder="Nom de la clinique">
                    </div>
                <div class="form-group">
                    <label for="adresse">Address:</label>
                    <input type="text" class="form-control" id="adresse" placeholder="1234 Main St">
                </div>
            <div class="form-group">
                    <label for="tel">Telephone:</label>
                    <input type="tel" class="form-control" id="tel" placeholder="514-784-8542">
                </div>
                    <div class="form-group">
                    <label for="services">Services:</label>
                    <input type="text" class="form-control" id="services" placeholder="Tests diagnostiques">
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
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
