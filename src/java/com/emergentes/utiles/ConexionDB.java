/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AMD A4
 */
public class ConexionDB {
    static String url = "jdbc:mysql://localhost:3306/bd_practica";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =  DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion ok:" + conn);
                
            }
        }catch (SQLException ex) {
             System.out.println("Error de SQL:" + ex.getMessage());
        }catch (ClassNotFoundException ex) {
           System.out.println("Falta Driver" + ex.getMessage());  
        }
    }
    
    public Connection conectar()
    {
      return conn;  
    }
    public void desconectar()
    {
         System.out.println("Cerrando la bd:" + conn);
         try {
             conn.close();
         }catch (SQLException ex) {
             System.out.println("Error de SQL:" + ex.getMessage());
         }
    }
}
