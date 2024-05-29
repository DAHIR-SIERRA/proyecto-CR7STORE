/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Productos;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class ControladorProductos {
    
      public static void controlarAccion (ActionEvent evento, Productos unProducto){
        String accion = evento.getActionCommand();
        System.out.println("controlador "+accion);
        switch(accion){
            case "Agregar" -> unProducto.Agregar();
            case "Modificar" -> {
                unProducto.modificarr();
            
            }
            case "Eliminar" -> unProducto.eliminar();
                
            
        }
    }
    
    
}
