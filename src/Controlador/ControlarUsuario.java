/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class ControlarUsuario {

      public static void controlarAccion (ActionEvent evento, Usuario unUsuarioModelo){
        String accion = evento.getActionCommand();
        System.out.println("controlador "+accion);
        switch(accion){
            case "Insertar" -> unUsuarioModelo.insertar();
            case "Modificar" -> {
                unUsuarioModelo.modificar();
            
            }
            case "Eliminar" -> unUsuarioModelo.eliminar();
                
            
        }
    }
    
    
}
