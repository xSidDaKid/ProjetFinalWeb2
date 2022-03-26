<%-- 
    Document   : disponibilite
    Created on : Mar 25, 2022, 11:09:16 PM
    Author     : Shajaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Disponibilite</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container mt-3 p-2">
            <div class="card p-3">

                <!-- LISTE DES TABS -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Definir-tab" data-bs-toggle="tab" data-bs-target="#Definir" type="button" >Definir mes disponibilites</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Modifier-tab" data-bs-toggle="tab" data-bs-target="#Modifier" type="button" >Modifier mes disponibilites</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="Voir-tab" data-bs-toggle="tab" data-bs-target="#Voir" type="button" >Voir mes disponibilites</button>
                    </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                    <!-- TAB Definir -->
                    <div class="tab-pane fade show active" id="Definir" role="tabpanel" aria-labelledby="Definir-tab">
                        <form class="p-2">
                            <label  class="p-1">Date</label>
                            <input class="form-control" type="date" value="" name="id" placeholder="YYYY-MM-DD hh:mm:ss">
                            <label  class="mt-2">Choisissez le temps: </label>
                            <br>
                            <input type="radio" name="clinique_id" value="08:00" required>
                            <label class="p-1">8h</label>

                            <input type="radio" name="clinique_id" value="08:30" required>
                            <label class="p-1">8h30</label>

                            <input type="radio" name="clinique_id" value="09:00" required>
                            <label class="p-1">9h</label>

                            <input type="radio" name="clinique_id" value="09:30" required>
                            <label class="p-1">9h30</label>

                            <input type="radio" name="clinique_id" value="10:00" required>
                            <label class="p-1">10h</label>

                            <input type="radio" name="clinique_id" value="10:30" required>
                            <label class="p-1">10h30</label>

                            <input type="radio" name="clinique_id" value="11:00" required>
                            <label class="p-1">11h</label>

                            <input type="radio" name="clinique_id" value="11:30" required>
                            <label class="p-1">11h30</label>

                            <input type="radio" name="clinique_id" value="12:00" required>
                            <label class="p-1">12h</label>

                            <input type="radio" name="clinique_id" value="12:30" required>
                            <label class="p-1">12h30</label>

                            <input type="radio" name="clinique_id" value="13:00" required>
                            <label class="p-1">13h</label>

                            <input type="radio" name="clinique_id" value="13:30" required>
                            <label class="p-1">13h30</label>

                            <input type="radio" name="clinique_id" value="14:00" required>
                            <label class="p-1">14h</label>

                            <input type="radio" name="clinique_id" value="14:30" required>
                            <label class="p-1">14h30</label>

                            <input type="radio" name="clinique_id" value="15:00" required>
                            <label class="p-1">15h</label>

                            <input type="radio" name="clinique_id" value="15:30" required>
                            <label class="p-1">15h30</label>

                            <input type="radio" name="clinique_id" value="16:00" required>
                            <label class="p-1">16h</label>
                        </form>
                    </div>
                    <!-- TAB Modifier -->
                    <div class="tab-pane fade" id="Modifier" role="tabpanel" aria-labelledby="Modifier-tab">
                        ...
                    </div>
                    <!-- TAB Voir -->
                    <div class="tab-pane fade" id="Voir" role="tabpanel" aria-labelledby="Voir-tab">
                        ...
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>

