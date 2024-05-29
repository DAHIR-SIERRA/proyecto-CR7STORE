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
public class Productos {
    private int idProducto;
    private String ProductoCategoria;
    private int ProductoPrecio;
    private String ProductoTalla;
    private int ProductoStock;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProductoCategoria() {
        return ProductoCategoria;
    }

    public void setProductoCategoria(String ProductoCategoria) {
        this.ProductoCategoria = ProductoCategoria;
    }

    public int getProductoPrecio() {
        return ProductoPrecio;
    }

    public void setProductoPrecio(int ProductoPrecio) {
        this.ProductoPrecio = ProductoPrecio;
    }

    public String getProductoTalla() {
        return ProductoTalla;
    }

    public void setProductoTalla(String ProductoTalla) {
        this.ProductoTalla = ProductoTalla;
    }

    public int getProductoStock() {
        return ProductoStock;
    }

    public void setProductoStock(int ProductoStock) {
        this.ProductoStock = ProductoStock;
    }

    @Override
    public String toString() {
        return ProductoCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        return this.idProducto == other.idProducto;
    }
  
    public Iterator<Productos> Listar() {
        ArrayList<Productos> LosProductos = new ArrayList<>();
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement(" SELECT * FROM Producto ");
            ResultSet rs = sql.executeQuery();
            Productos unProducto;
            while (rs.next()) {
                unProducto = new Productos();
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setProductoCategoria(rs.getString("ProductoCategoria"));
                unProducto.setProductoTalla(rs.getString("ProductoTalla"));
                unProducto.setProductoPrecio(rs.getInt("ProductoPrecio"));
                unProducto.setProductoStock(rs.getInt("ProductoStock"));
                LosProductos.add(unProducto);
            }
        }
         catch (SQLException ex) {
            System.err.println("error al listar " + ex.getMessage());
        }
        if (LosProductos.isEmpty()) {
            Productos miproducto = new Productos();
            miproducto.setProductoCategoria("No hay Productos");
            LosProductos.add(miproducto);
        }
        return LosProductos.iterator();

    }
    
            public void Agregar() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement(" INSERT INTO Producto VALUES (NULL,?,?,?,?)");
            sql.setString(1, this.getProductoCategoria());
            sql.setString(3, this.getProductoTalla());
            sql.setInt(2, this.getProductoPrecio());            
            sql.setInt(4, this.getProductoStock());

            sql.executeLargeUpdate();
            System.out.println("agregado  Correctamente");
        } catch (SQLException ex) {
            System.err.println("error no se puede ingresar" + this.getClass().getSimpleName() + ex.getMessage());
        }
    }
             public void modificarr() {
        try {
            System.out.println("entra a la clase");
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("UPDATE Producto SET ProductoCategoria= ?, ProductoTalla = ?, ProductoPrecio = ?, ProductoStock= ? WHERE IdProducto= ?");
            sql.setString(1, this.getProductoCategoria());
            sql.setString(2, this.getProductoTalla());
            sql.setInt(3, this.getProductoPrecio());
            sql.setInt(4, this.getProductoStock());
            sql.setInt(5, this.getIdProducto());
            System.out.println("sql " + sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName() + "modificado correctamente");
        } catch (SQLException ex) {
            System.err.println("error al modificar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    public void eliminar() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("DELETE FROM Producto WHERE IdProducto= ? ");
            sql.setInt(1, this.getIdProducto());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName() + "eliminado correctamente");
        } catch (SQLException ex) {
            System.err.println("error al eliminar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }
    public Iterator<Productos> buscar(String busqueda) {
        ArrayList<Productos> losProductos = new ArrayList<>();
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("SELECT * FROM Producto WHERE ProductoCategoria LIKE ? OR ProductoPrecio LIKE ? OR ProductoTalla LIKE ? OR ProductoStock LIKE ?");
            sql.setString(1, "%" + busqueda + "%");
            sql.setString(2, "%" + busqueda + "%");
            sql.setString(3, "%" + busqueda + "%");
            sql.setString(4, "%" + busqueda + "%");
            ResultSet rs = sql.executeQuery();
            Productos unProducto;
            while (rs.next()) {
                unProducto = new Productos();
                unProducto.setProductoCategoria(rs.getString("ProductoCategoria"));
                unProducto.setProductoPrecio(rs.getInt("ProductoPrecio"));
                unProducto.setProductoTalla(rs.getString("ProductoTalla"));
                unProducto.setProductoStock(rs.getInt("ProductoStock"));
                losProductos.add(unProducto);
                System.err.println("añadio");
            }
        } catch (SQLException ex) {
            System.err.println("error al buscar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
        return losProductos.iterator();
    }
}

    


