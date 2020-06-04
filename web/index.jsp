
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Noticias"%>
<%@page import="java.util.List" %>
<%
    List<Noticias> lista = (List<Noticias>) request.getAttribute("lista");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2><b><center><u>BLOG DE INFORMACION</u></center></b></h2>
     
        <p><a href="MainController?op=nuevo">Nuevo</a></p>
       
            
            <c:forEach var="item" items="${lista}">
           
            <i>${item.fecha}</i><br>
            <br>
                <b>${item.titulo}</b><br>
                <br>
                <i>${item.contenido}</i><br>
                <br><br><br>
                <i><a href="MainController?op=eliminar&id=${item.id}">Eliminar</a>
               
                <a href="MainController?op=editar&id=${item.id}">Editar</a></i><br>
                <hr><br>
                <br><br><br>
                
           
            </c:forEach>
            
       
    </body>
</html>
