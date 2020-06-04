<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Noticias"%>
<%
    Noticias noticia = (Noticias)request.getAttribute("noticia");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Nueva / Editar entrada</h1>
        <form action="MainController" method="post">
            <table>
                <input type="hidden" name="id" value="${noticia.id}">
                <tr>
                    <td>fecha:</td>
                    <td><input type="date" name="fecha" value="${noticia.fecha}"></td>
                </tr>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${noticia.titulo}"></td>
                </tr>
                <tr>
                    <td>Contenido:</td>
                    <td><input type="text" name="contenido" value="${noticia.contenido}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
