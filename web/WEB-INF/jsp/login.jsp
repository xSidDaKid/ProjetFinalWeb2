<%-- 
    Document   : login
    Created on : Mar 13, 2022, 10:46:13 PM
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
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="login-wrap p-4 p-md-5">
                        <div class="card p-3">
                            <form action="login" method="POST">
                                <div class="form-group p-2">
                                    <label>Email</label>
                                    <input  name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
                                </div>
                                <div class="form-group p-2">
                                    <label>Password</label>
                                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required >
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary p-2 align-content-center">Login</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>