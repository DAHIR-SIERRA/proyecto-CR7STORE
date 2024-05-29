/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class ConectarBD {
    
     public static Connection conectar;
    
    private ConectarBD() {
        
         try {
            String driverBD = "com.mysql.cj.jdbc.Driver";
            String urlBD = "jdbc:mysql://localhost/cr7store";
            String usuarioBD = "root";
            String contraseñaBD = "";
            Class.forName(driverBD);
            conectar = DriverManager.getConnection(urlBD, usuarioBD, contraseñaBD);
        } catch (ClassNotFoundException ex) {
            System.err.println("no encuentro el driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("");

        }
    }
        
    public static void desconectar() {
        try {
            conectar.close();
        } catch (SQLException ex) {
            System.err.println("error al desconectarme" + ex.getMessage());
        }
    }
    
    public static ConectarBD getInstance() {
        return ConectarBDHolder.INSTANCE;
    }
    
    private static class ConectarBDHolder {

        private static final ConectarBD INSTANCE = new ConectarBD();
    }
}
