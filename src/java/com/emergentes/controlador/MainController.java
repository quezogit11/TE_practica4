
package com.emergentes.controlador;

import com.emergentes.modelo.Noticias;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<Noticias> lista = new ArrayList<Noticias>();
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (op.equals("list")) {
            try {
                String sql = "SELECT * FROM noticias";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    Noticias noti = new Noticias();
                    noti.setId(rs.getInt("id"));
                    noti.setFecha(rs.getString("fecha"));
                    noti.setTitulo(rs.getString("titulo"));
                    noti.setContenido(rs.getString("contenido"));
                    lista.add(noti);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }catch (SQLException ex) {
                System.out.println("error de sql: " + ex.getMessage());
            }finally {
                canal.desconectar();
            }
        }
        if (op.equals("nuevo")) {
            Noticias n = new Noticias();
                request.setAttribute("noticias", n);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                String sql = "delete from noticias where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
             } catch (SQLException ex) {
                System.out.println("error de sql: " + ex.getMessage());
            }finally {
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }
        if (op.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                String sql = "update from noticias SET " + " fecha= ? " + ",titulo=?" + ",contenido=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
             } catch (SQLException ex) {
                System.out.println("error de sql: " + ex.getMessage());
            }finally {
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Noticias n = new Noticias();
        
        n.setId(id);
        n.setFecha(fecha);
        n.setTitulo(titulo);
        n.setContenido(contenido);
        
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            try {
            String sql = "insert into noticias ( ,titulo,contenido) values (,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, n.getFecha());
            ps.setString(2, n.getTitulo());
            ps.setString(3, n.getContenido());
            ps.executeUpdate();
            }catch (SQLException ex)  {
                System.out.println("error en sql: " + ex.getMessage());
            }finally {
                canal.desconectar();
            }
        }
        response.sendRedirect("MainController");
    }

}
