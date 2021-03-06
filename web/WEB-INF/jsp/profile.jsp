<%-- 
    Document   : profile
    Created on : Mar 18, 2022, 3:11:42 PM
    Author     : Shajaan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
    <head>
        <jsp:include page="head.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container-xl px-4 m-4">
            <div class="row">
                <div class="col-xl-5">
                </div>
                <div class="col-xl-7">
                    <div class="card mb-4">
                        <div class="card-header text-center" style="font-size: 150%"><strong>Bonjour ${sessionScope.Medecin.nom} ${sessionScope.Medecin.prenom} ${sessionScope.Clinique.nom} ${sessionScope.Patient.nom} ${sessionScope.Patient.prenom} ${sessionScope.username}!!</strong></div>
                        <div class="card-body">
                            <form action="profile" method="GET">
                                <!-- Form User -->
                                <div>
                                    <div class="mb-3" hidden>
                                        <label class="small mb-1">Id</label>
                                        <input class="form-control" type="text" value="${UserID}" name="id" disabled>
                                    </div>
                                    <div class="mb-3">
                                        <label class="small mb-1"><fmt:message key="label.role" /></label>
                                        <input class="form-control" type="text" value="${sessionScope.User.role}${sessionScope.userModif.role}" name="role" disabled>
                                    </div>
                                    <hr>
                                    <div class="mb-3">
                                        <label class="small mb-1"><fmt:message key="label.username" /></label>
                                        <input class="form-control" type="text" value="${sessionScope.User.username}${sessionScope.userModif.username}" name="username">
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-6">
                                            <label class="small mb-1">Email</label>
                                            <input class="form-control" type="text" value="${sessionScope.User.email}${sessionScope.userModif.email}" name="email">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="small mb-1"><fmt:message key="label.pass" /></label>
                                            <input class="form-control" id="pwd" type="password" value="${sessionScope.User.password}${sessionScope.userModif.password}" name="password">
                                            <input type="checkbox" onclick="myFunction()"> <fmt:message key="label.show" />
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <!-- Form Patient/Medecin/Clinique -->
                                <c:choose>
                                    <c:when test="${sessionScope.User.role == 'patient' || sessionScope.patientModif != null }">
                                        <div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nom2" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Patient.nom}${patientModif.nom}" name="nomPatient">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.prenom" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Patient.prenom}${patientModif.prenom}" name="prenomPatient">
                                                </div>
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nam" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Patient.nam}${patientModif.nam}" name="nam">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nbSequentiel" /></label>
                                                    <input class="form-control" type="number" value="${sessionScope.Patient.nbSequentiel}${patientModif.nbSequentiel}" name="nbSequentiel">
                                                </div>
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.don" /></label>
                                                    <input class="form-control" type="date" placeholder="JJ-MM-AAAA" value="${sessionScope.Patient.dateNaissance}${sessionScope.patientModif.dateNaissance}" name="dateNaissance">
                                                </div>
                                                <div class="col-md-6 mt-2">
                                                    <label class="small mb-1"><fmt:message key="label.sexe" /></label>
                                                    <br>
                                                    <select name="sexe" required>
                                                        <option>${sessionScope.Patient.sexe}${sessionScope.patientModif.sexe}</option>
                                                        <option value="f">F</option>
                                                        <option value="m">M</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3" hidden>
                                                <label class="small mb-1">Id Clinique</label>
                                                <input class="form-control" type="text" value="${sessionScope.patientModif.id_clinique}" name="id_clinique" disabled>
                                                <label class="small mb-1">Id Medecin</label>
                                                <input class="form-control" type="text" value="${sessionScope.patientModif.id_medecin}" name="id_medecin" disabled>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${sessionScope.User.role == 'medecin' || sessionScope.medecinModif != null }">
                                        <div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nom2" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Medecin.nom}${medecinModif.nom}" name="nomMedecin">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.prenom" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Medecin.prenom}${medecinModif.prenom}" name="prenomMedecin">
                                                </div>
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1">Profession</label>
                                                    <input class="form-control" type="text" value="${sessionScope.Medecin.profession}${medecinModif.nom}" name="profession">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nbPro" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Medecin.nbProfessionnel}${medecinModif.prenom}" name="nbProfessionnel">
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label class="small mb-1"><fmt:message key="label.entente" /></label>
                                                <input class="form-control" type="text" value="${sessionScope.Medecin.ententes}${medecinModif.ententes}" name="ententes">
                                            </div>
                                            <div class="mb-3">
                                                <label class="small mb-1"><fmt:message key="label.adresse" /></label>
                                                <input class="form-control" type="text" value="${sessionScope.Medecin.adresse}${medecinModif.adresse}" name="adresse">
                                            </div>
                                            <div class="mb-3">
                                                <label class="small mb-1"><fmt:message key="label.lieuPro" /></label>
                                                <input class="form-control" type="text" value="${sessionScope.Medecin.lieuProfession}${medecinModif.lieuProfession}" name="lieuProfession">
                                            </div>
                                            <div class="mb-3" hidden>
                                                <label class="small mb-1">Id Clinique</label>
                                                <input class="form-control" type="text" value="${sessionScope.medecinModif.id_clinique}" name="id_clinique_medecin" disabled>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${sessionScope.User.role == 'clinique' || sessionScope.cliniqueModif != null }">
                                        <div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.nom" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Clinique.nom}${cliniqueModif.nom}" name="nomClinique">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.adresse" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Clinique.adresse}${cliniqueModif.adresse}" name="adresseClinique">
                                                </div>
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-6">
                                                    <label class="small mb-1"><fmt:message key="label.tel" /></label>
                                                    <input class="form-control" type="text" value="${sessionScope.Clinique.tel}${cliniqueModif.tel}" name="telephone">
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="small mb-1">Services</label>
                                                    <input class="form-control" type="text" value="${sessionScope.Clinique.services}${cliniqueModif.services}" name="services">
                                                </div>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <button class="btn btn-primary" type="submit"><fmt:message key="label.save" /></button>
                            </form>
                        </div>
                    </div>
                                            <br>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {

                $.get('profile', function (responseJson) {
                    if (responseJson != null) {
                        //  $("#etudianttable").find("tr:gt(0)").remove();
                        var table1 = $("#etudianttable");
                        $.each(responseJson, function (key, value) {
                            $(#inputUsername).appendTo(text(value['username']));
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['username']);
                            rowNew.children().eq(1).text(value['nom']);
                            rowNew.children().eq(2).text(value['prenom']);
                            rowNew.children().eq(3).text(value['email']);
                            rowNew.children().eq(4).text(value['password']);
                            rowNew.children().eq(5).text(value['metier']);
                            rowNew.appendTo(table1);
                        });
                    }
                });

            });
        </script>
        <script>
            function myFunction() {
                var x = document.getElementById("pwd");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
        <jsp:include page="footer.jsp"/>
    </body>
</html>