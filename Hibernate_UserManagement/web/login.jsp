<%-- 
    Document   : login
    Created on : 26 May, 2021, 6:50:59 PM
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
  background-color: lightgray;
}


</style>
</head>
<body>

<form action="http://localhost:8080/UserManagement/Login">
  <div class="container">
    <h1>Login</h1>
    <p>Please fill in this form to Login an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <button type="submit" class="registerbtn">Login</button>
  </div>
  
  <div class="container signin">
    <p>Register Your Account? <a href="index.html">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
