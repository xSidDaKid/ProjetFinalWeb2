<%-- 
    Document   : envoieInfo
    Created on : Apr 5, 2022, 6:30:18 PM
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
        <div class="container mt-3">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header text-center" style="font-size: 150%"><img src="<c:url value="./static/images/send.png"/>" style="width: 30px;"><strong> Envoie d'info</strong></div>
                        <div class="card-body">
                            <form action="envoieInfo" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">Information</label>
                                    <input type="text" class="form-control" name="info" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlFile1" class="mt-2">Choisir le fichier que vous voulez envoyer</label>
                                    <br>
                                    <input class="form-control" type="file" class="mt-2 form-control-file" name="fichier">
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
