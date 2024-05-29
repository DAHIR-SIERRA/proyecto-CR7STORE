/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class DetalleFactura {
    private int idDetalle;
    private int idUsuario;
    private int  idProductos;
    private int Cantidad;
    private double PrecioUnitario;
    private double  SubTotal;
    private int  idFactura;
    private String Categoria;
    private String Talla;
    private String UsuarioNombre;
    private String Documento;
   
    
    
    // Constructor
    public DetalleFactura (){
        this.idDetalle = 0;
        this.idUsuario = 0;
        this.idProductos = 0;
        this.Categoria = "";
        this.PrecioUnitario = 0.0;
        this.SubTotal = 0.0;
        this.idFactura = 0;
        this.Talla = "";
        this.UsuarioNombre = "";
        this.Documento = "";
        
}
     // constructor sobre cargado
    public DetalleFactura(int idDetalle, int idUsuario, int idProductos, int Cantidad, int PrecioUnitario, int SubTotal, int idFactura, String Categoria, String Talla, String UsuarioNombre, String Documento) {
        this.idDetalle = idDetalle;
        this.idUsuario = idUsuario;
        this.idProductos = idProductos;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.SubTotal = SubTotal;
        this.idFactura = idFactura;
        this.Categoria = Categoria;
        this.Talla = Talla;
        this.UsuarioNombre = UsuarioNombre;
        this.Documento = Documento;
    }
    // geter and setter

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getUsuarioNombre() {
        return UsuarioNombre;
    }

    public void setUsuarioNombre(String UsuarioNombre) {
        this.UsuarioNombre = UsuarioNombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "idDetalle=" + idDetalle + ", idUsuario=" + idUsuario + ", idProductos=" + idProductos + ", Cantidad=" + Cantidad + ", PrecioUnitario=" + PrecioUnitario + ", SubTotal=" + SubTotal + ", idFactura=" + idFactura + ", Categoria=" + Categoria + ", Talla=" + Talla + ", UsuarioNombre=" + UsuarioNombre + ", Documento=" + Documento + '}';
    }
    public Iterator<DetalleFactura> Listar() {
        ArrayList<DetalleFactura> LosDetalles = new ArrayList<>();
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement(" SELECT * FROM Detalle ");
            ResultSet rs = sql.executeQuery();
            DetalleFactura unDetalle;
            while (rs.next()) {
                unDetalle = new DetalleFactura();
                unDetalle.setIdUsuario(rs.getInt("idUsuario"));
                unDetalle.setIdProductos(rs.getInt("IdProducto"));
                unDetalle.setCantidad(rs.getInt("ProductoStock"));
                unDetalle.setPrecioUnitario(rs.getDouble("PrecioU"));
                unDetalle.setSubTotal(rs.getDouble("subtotal"));
                unDetalle.setUsuarioNombre(rs.getString("UsuarioNombre"));
                unDetalle.setDocumento(rs.getString("UsuarioDocumento"));
                unDetalle.setTalla(rs.getString("ProductoTalla"));
                unDetalle.setCategoria(rs.getString("ProductoCategoria"));
               
                LosDetalles.add(unDetalle);
            }
        }
        catch (SQLException ex) {
            System.err.println("error al listar " + ex.getMessage());
        }
        if (LosDetalles.isEmpty()) {
            DetalleFactura miDetalle = new DetalleFactura();
            miDetalle.setCategoria(" no hay detalles ");
            LosDetalles.add(miDetalle);
        }
        return LosDetalles.iterator();

    }



    
     
    
    
}

