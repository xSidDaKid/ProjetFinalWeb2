<%-- 
    Document   : menu
    Created on : Feb 23, 2022, 10:52:56 AM
    Author     : Shajaan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="contenu"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="./">AppWeb2</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <!-- Pages Common A Tous -->
            <li class="nav-item active">
                <a class="nav-link" href="/AppWeb2ProjetSession/">Home</a>
            </li>

            <!-- Pages Admin -->
            <c:if test="${sessionScope.username == 'admin'}">
                <li class="nav-item">
                    <a class="nav-link" href="admin">Admnistration</a>
                </li>
            </c:if>

            <!-- Pages Patient -->
            <c:if test="${sessionScope.User.role == 'patient'}">
                <li class="nav-item">
                    <a class="nav-link" href="priseDeRendezVous"><fmt:message key="label.take" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="envoieInfo"><fmt:message key="label.send2" /></a>
                </li>
            </c:if>

            <!-- Pages Medecin -->
            <c:if test="${sessionScope.User.role == 'medecin'}">
                <li class="nav-item">
                    <a class="nav-link" href="disponibilite"><fmt:message key="label.dispo2" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="espacePatient"><fmt:message key="label.espaceTitre" /></a>
                </li>
            </c:if>

            <!-- Pages Clinique -->
            <c:if test="${sessionScope.User.role == 'clinique'}">
                <li class="nav-item">
                    <a class="nav-link" href=""></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="infoClinique"><fmt:message key="label.infoClinique" /></a>
                </li>
            </c:if>
        </ul>
    </div>

    <!-- INSCRIPTION LOGIN  -->
    <div class="dropdown mx-5">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <c:choose>
                <c:when test="${ not empty sessionScope.username }">
                    
                    ${sessionScope.username }
                </c:when>
                <c:when test="${not empty sessionScope.User }">
                    ${sessionScope.User.username}
                    
                </c:when>
                <c:otherwise>
                    <fmt:message key="label.welcome" />
                </c:otherwise>
            </c:choose>
        </button>
        <ul class="mr-5 pr-5 dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <c:choose>
                <c:when test="${not empty sessionScope.User || not empty sessionScope.username}">
                    <li><a class="dropdown-item" href="profile">Profile</a></li>
                    <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                    <li><a class="dropdown-item" href="login">Login</a></li>
                    <li><a class="dropdown-item" href="inscriptionUser"><fmt:message key="label.inscrire" /></a></li>
                    </c:otherwise>
                </c:choose>
        </ul>
    </div>

    <div class="mx-4"></div>
</nav>