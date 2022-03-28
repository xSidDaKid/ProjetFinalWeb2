<%-- 
    Document   : profileClinque
    Created on : Mar 27, 2022, 8:28:57 AM
    Author     : RbAwa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <jsp:include page="head.jsp"/>
        <title>ProfileClinique</title>
    </head>
    <body>
            <jsp:include page="menu.jsp"/>
        <div class="container-xl px-4 mt-4">
            <div class="row">
                <div class="col-xl-2">
                </div>
                <div class="col-xl-8">
                    <div class="card mb-4">
                        <div class="card-header text-center">Bonjour ${sessionScope.Clinique.nom}!!</div>
                        <div class="card-body">
                            <form action="profileClinique" method="GET">
                                <!-- Form User -->
                                <div>
                                    <div class="mb-3" hidden>
                                        <label class="small mb-1">Id</label>
                                        <input class="form-control" type="text" value="${UserID}" name="id" disabled>
                                    </div>
                                    <div class="mb-3">
                                        <label class="small mb-1">Role</label>
                                        <input class="form-control" type="text" value="${sessionScope.User.role}${userModif.role}" name="role" disabled>
                                    </div>
                                    <hr>
                                    <div class="mb-3">
                                        <label class="small mb-1">Username</label>
                                        <input class="form-control" type="text" value="${sessionScope.User.username}${userModif.username}" name="username">
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-6">
                                            <label class="small mb-1">Email</label>
                                            <input class="form-control" type="text" value="${sessionScope.User.email}${userModif.email}" name="email">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="small mb-1">Password</label>
                                            <input class="form-control" id="pwd" type="password" value="${sessionScope.User.password}${userModif.password}" name="password">
                                            <input type="checkbox" onclick="myFunction()"> Show Password
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                
                                <div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-6">
                                            <label class="small mb-1">Nom</label>
                                            <input class="form-control" type="text" value="${sessionScope.Clinique.nom} ${cliniqueModif.nom}" name="nom">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="small mb-1">Adresse</label>
                                            <input class="form-control" type="text" value="${sessionScope.Clinique.adresse}${cliniqueModif.adresse}" name="adresse">
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-6">
                                            <label class="small mb-1">Telephone</label>
                                            <input class="form-control" type="text" value="${sessionScope.Clinique.tel} ${cliniqueModif.tel}" name="telephone">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="small mb-1">Services</label>
                                            <input class="form-control" type="text" value="${sessionScope.Clinique.services}${cliniqueModif.services}" name="services">
                                        </div>
                                    </div>
                                    <button class="btn btn-primary" type="submit">Save changes</button>
                                </div>
                                 <jsp:include page="footer.jsp"/>
                                </body>
                                </html>
