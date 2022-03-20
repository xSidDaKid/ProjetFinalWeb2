<%-- 
    Document   : priseDeRendezVous
    Created on : Mar 19, 2022, 11:52:22 PM
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
        <div class="content-body m-5"><!-- Book Appointment -->
            <section id="book-appointment">
                <div class="card">
                    <div class="card-header">
                        <h2 class="card-title">Prendre un rendez-vous</h2>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="firstname">First Name: <span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" placeholder="First Name" required="" id="firstname">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="lastname">Last Name: <span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" placeholder="Last Name" id="lastname" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-6">
                                    <div class="form-group">
                                        <label for="dob">Date Of Birth: <span class="text-danger">*</span></label>
                                        <input type="date" class="form-control" id="dob" name="dob" required="">
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="form-group">
                                        <label for="gender">Gender:</label>
                                        <select name="gender" id="gender" class="form-control">
                                            <option value="gender">Gender</option>
                                            <option value="male">Male</option>
                                            <option value="female">Female</option>
                                            <option value="notsay">Rather not Say</option>
                                        </select></div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="form-group">
                                        <label for="service">Service <span class="text-danger">*</span></label>
                                        <select name="Service" class="form-control" id="service" required="">
                                            <option value="">Service</option>
                                            <option value="dental">Dental Checkup</option>
                                            <option value="body">Full Body Checkup</option>
                                            <option value="heart">Heart Checkup</option>
                                            <option value="ent">ENT Checkup</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="form-group">
                                        <label for="date">Appointment Date <span class="text-danger">*</span></label>
                                        <input type="date" class="form-control" id="date" name="date" required="">
                                        <input type="time" class="form-control" id="date" name="date" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="email">Email: <span class="text-danger">*</span></label>
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Enter Email" required="">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="phone">Contact Number:</label>
                                        <input type="number" class="form-control" id="phone" name="phone" placeholder="Enter Contact Number" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="symptoms">Tell Us About Your Problems:</label>
                                        <textarea cols="3" rows="3" id="symptoms" class="form-control" placeholder="Tell us about problems you are facing"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer ml-auto">
                                <button type="submit" class="btn btn-outline-success mr-1">Submit</button> <button type="submit" class="btn btn-outline-danger">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
