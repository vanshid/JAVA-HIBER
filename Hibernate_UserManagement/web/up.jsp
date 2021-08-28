<%-- 
    Document   : up
    Created on : 10 Jun, 2021, 7:30:32 PM
    Author     : DHAVAL PANCHAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: lightcoral;
}
</style>
</head>
<body>
    <%
        //id=1name=dhaval&email=app@gmail.com&gender=123456&Contact_Number=M
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String Contact_Number=request.getParameter("Contact_Number");
    %>

    <form action="http://localhost:8080/UserManagement/UP" method="get">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
    <input  placeholder="Enter Email" name="id" id="email" value="<%out.print(id);%>" required="" readonly="" type="hidden">
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" value="<%out.print(email);%>" required>


    <label for="psw"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="nam" value="<%out.print(name);%>" id="psw" required>
    <br>
    <label for="psw"><b>Contact Number</b></label>
    <input type="number" placeholder="Enter Contact Number" value="<%out.print(Contact_Number);%>" name="cnum" id="psw" required>
    <br>
    <label for="psw"><b>Select Gender</b></label>    
    Male:<input type="radio"  name="cgen" value="M" id="psw" required>
    FeMale:<input type="radio"  name="cgen" value="F" id="psw" required>
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Update</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
