<%-- 
    Document   : envoieInfo
    Created on : Apr 5, 2022, 6:30:18 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">Envoie d'info</div>
                        <div class="card-body">
                            <form action="envoieInfo" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Information</label>
                                    <input type="text" class="form-control" name="info" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlFile1" class="mt-2">Choisir le fichier que vous voulez envoyer</label>
                                    <br>
                                    <input type="file" class="mt-2 form-control-file" name="fichier">
                                </div>
                                <button type="submit" class="mt-2 btn btn-primary p-2 align-content-center">Envoyer</button>

                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
