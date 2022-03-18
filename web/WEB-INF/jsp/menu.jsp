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
            <li class="nav-item active">
                <a class="nav-link" href="home">Home</a>
            </li>
            <li class="nav-item">
                <c:if test="${sessionScope.username == 'admin'}">
                    <a class="nav-link" href="admin">Admnistration</a>
                </c:if>
            </li>
            <!--            <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">Disabled</a>
                        </li>-->
        </ul>
    </div>

    <div class="dropdown mx-5">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <c:choose>
                <c:when test="${not empty sessionScope.User}">
                    ${sessionScope.User.username}
                </c:when>
                <c:otherwise>
                    Bonjour!
                </c:otherwise>
            </c:choose>
        </button>
        <ul class="mr-5 pr-5 dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <c:choose>
                <c:when test="${not empty sessionScope.User}">
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

    <div class="mx-4">

    </div>
</nav>