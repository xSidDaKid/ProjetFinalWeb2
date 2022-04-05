<%-- 
    Document   : menu
    Created on : Feb 23, 2022, 10:52:56 AM
    Author     : Shajaan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="./">AppWeb2</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <!-- Pages Common A Tous -->
            <li class="nav-item active">
                <a class="nav-link" href="home">Home</a>
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
                    <a class="nav-link" href="priseDeRendezVous">Prendre un rendez-vous</a>
                </li>
            </c:if>

            <!-- Pages Medecin -->
            <c:if test="${sessionScope.User.role == 'medecin'}">
                <li class="nav-item">
                    <a class="nav-link" href="disponibilite">Disponibilité</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="espacePatient">Espace Médecin-Patient</a>
                </li>
            </c:if>

            <!-- Pages Clinique -->
            <c:if test="${sessionScope.User.role == 'clinique'}">
                <li class="nav-item">
                    <a class="nav-link" href=""></a>
                </li>
            </c:if>
        </ul>
    </div>

    <!-- INSCRIPTION LOGIN  -->
    <div class="dropdown mx-5">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <c:choose>
                <c:when test="${not empty sessionScope.User || not empty sessionScope.username}">
                    ${sessionScope.User.username}
                    ${sessionScope.username }
                </c:when>
                <c:otherwise>
                    Bonjour!
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
                    <li><a class="dropdown-item" href="inscriptionUser">Inscrire</a></li>
                    </c:otherwise>
                </c:choose>
        </ul>
    </div>

    <div class="mx-4"></div>
</nav>