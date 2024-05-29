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
public class Usuario {

    private int idUSuario;
    private String UsuarioNombre;
    private String UsuarioTelefono;
    private String UsuarioCorreo;
    private String UsuarioDocumento;
    private String UsuarioRol;

    public int getIdUSuario() {
        return idUSuario;
    }

    public void setIdUSuario(int idUSuario) {
        this.idUSuario = idUSuario;
    }

    public String getUsuarioNombre() {
        return UsuarioNombre;
    }

    public void setUsuarioNombre(String UsuarioNombre) {
        this.UsuarioNombre = UsuarioNombre;
    }

    public String getUsuarioTelefono() {
        return UsuarioTelefono;
    }

    public void setUsuarioTelefono(String UsuarioTelefono) {
        this.UsuarioTelefono = UsuarioTelefono;
    }

    public String getUsuarioCorreo() {
        return UsuarioCorreo;
    }

    public void setUsuarioCorreo(String UsuarioCorreo) {
        this.UsuarioCorreo = UsuarioCorreo;
    }

    public String getUsuarioDocumento() {
        return UsuarioDocumento;
    }

    public void setUsuarioDocumento(String UsuarioDocumento) {
        this.UsuarioDocumento = UsuarioDocumento;
    }

    public String getUsuarioRol() {
        return UsuarioRol;
    }

    public void setUsuarioRol(String UsuarioRol) {
        this.UsuarioRol = UsuarioRol;
    }

    @Override
    public String toString() {
        return UsuarioNombre ;
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
        final Usuario other = (Usuario) obj;
        return this.idUSuario == other.idUSuario;
    }

    public Iterator<Usuario> Listar() {
        ArrayList<Usuario> LosUsuarios = new ArrayList<>();
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement(" SELECT * FROM "
                + this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Usuario unUsuario;
            while (rs.next()) {
                unUsuario = new Usuario();
                unUsuario.setIdUSuario(rs.getInt("idUsuario"));
                unUsuario.setUsuarioNombre(rs.getString("UsuarioNombre"));
                unUsuario.setUsuarioTelefono(rs.getString("UsuarioTelefono"));
                unUsuario.setUsuarioCorreo(rs.getString("UsuarioCorreo"));
                unUsuario.setUsuarioDocumento(rs.getString("UsuarioDocumento"));
                unUsuario.setUsuarioRol(rs.getString("UsuarioRol"));
                LosUsuarios.add(unUsuario);
            }
        } catch (SQLException ex) {
            System.err.println("error al listar " + ex.getMessage());
        }
        if (LosUsuarios.isEmpty()) {
            Usuario miUsuario = new Usuario();
            miUsuario.setUsuarioNombre("No hay Usuario");
            LosUsuarios.add(miUsuario);
        }
        return LosUsuarios.iterator();

    }

    public void insertar() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement(" INSERT INTO "
                    + this.getClass().getSimpleName() + " VALUES ( NULL ,?,?,?,?,?)");
            sql.setString(1, this.getUsuarioNombre());
            sql.setString(4, this.getUsuarioTelefono());
            sql.setString(3, this.getUsuarioCorreo());
            sql.setString(2, this.getUsuarioDocumento());
            sql.setString(5, this.getUsuarioRol());
            sql.executeLargeUpdate();
            
            System.out.println("Insertado Correctamente");
        } catch (SQLException ex) {
            System.err.println("error no se puede ingresar" + this.getClass().getSimpleName() + ex.getMessage());
        }
    }

    public void modificar() {
        try {
            System.out.println("entra a la clase");
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("UPDATE " + this.getClass().getSimpleName()
                    + " SET UsuarioNombre= ?, UsuarioTelefono = ?, UsuarioCorreo = ?, UsuarioDocumento= ?, UsuarioRol= ? WHERE IdUSuario= ?");
            sql.setString(1, this.getUsuarioNombre());
            sql.setString(4, this.getUsuarioTelefono());
            sql.setString(3, this.getUsuarioCorreo());
            sql.setString(2, this.getUsuarioDocumento());
            sql.setString(5, this.getUsuarioRol());
            sql.setInt(6, this.getIdUSuario());
            System.out.println("sql " + sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName() + "modificado correctamente");
        } catch (SQLException ex) {
            System.err.println("error al modificar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    public void eliminar() {
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("DELETE FROM "
                    + this.getClass().getSimpleName() + " WHERE IdUSuario= ? ");
            sql.setInt(1, this.getIdUSuario());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName() + "eliminado correctamente");
        } catch (SQLException ex) {
            System.err.println("error al eliminar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    public Iterator<Usuario> buscar(String busqueda) {
        ArrayList<Usuario> losUsuario = new ArrayList<>();
        try {
            PreparedStatement sql = ConectarBD.conectar.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName() + " WHERE UsuarioNombre LIKE ? OR UsuarioTelefono LIKE ? OR UsuarioCorreo LIKE ? OR UsuarioDocumento LIKE ? OR UsuarioRol LIKE ?");
            sql.setString(1, "%" + busqueda + "%");
            sql.setString(2, "%" + busqueda + "%");
            sql.setString(3, "%" + busqueda + "%");
            sql.setString(4, "%" + busqueda + "%");
            
            ResultSet rs = sql.executeQuery();
            Usuario unUsuario;
            while (rs.next()) {
                unUsuario = new Usuario();
                unUsuario.setUsuarioNombre(rs.getString("UsuarioNombre"));
                unUsuario.setUsuarioTelefono(rs.getString("UsuarioTelefono"));
                unUsuario.setUsuarioCorreo(rs.getString("UsuarioCorreo"));
                unUsuario.setUsuarioDocumento(rs.getString("UsuarioDocumento"));
                unUsuario.setUsuarioRol(rs.getString("UsuarioRol"));
                losUsuario.add(unUsuario);
                System.err.println("añadio");
            }
        } catch (SQLException ex) {
            System.err.println("error al buscar " + this.getClass().getSimpleName() + ": " + ex.getMessage());
        }
        return losUsuario.iterator();
    }
}
