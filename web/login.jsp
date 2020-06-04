<%-- 
    Document   : login
    Created on : 22-05-2020, 08:13:38 PM
    Author     : AMD A4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>login</h1>
        <form action="LoginControlador" method="post"> 
            <label>usuario</label>
            <input type="text" name="usuario">
            <br><br>
            <label>password</label>
            <input type="password" name="password">
            <br>
            <input type="submit" values="Ingresar">
        </form>
    </body>
</html>
