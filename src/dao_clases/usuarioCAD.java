package dao_clases;

import Controllador.Administrador;
import Controllador.Usuario;
import Conexion.Conectar;
import dao_interfaces.Iusuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioCAD extends Conectar implements Iusuario {

    @Override
    public boolean crear(Usuario u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setId_usuario(u.generar_idUsuario());
        System.out.println("" + u.getId_usuario());
        conectar();
        String sql = "insert into usuario (id_usuario , nombre, apellido, dni, estado, contraseña, edad, intentos) values('" + u.getId_usuario()+ "','" + u.getNombre() + "','" + u.getApellido()
                + "','" + u.getDni() + "','" + u.getEstado() + "','" + u.getContraseña() + "','" + u.getEdad() + "','" + u.getIntentos() + "')";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Usuario u) {
        conectar();
        String sql = "update usuario set nombre='" + u.getNombre() + "', apellido='" + u.getApellido() + "', dni='" + u.getDni() + "', estado='" + u.getEstado() + "', contraseña='" + u.getContraseña() + "', edad='" + u.getEdad() + "', intentos='" + u.getIntentos()
                + "' where id_usuario ='" + u.getId_usuario()+ "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String id_usuario) {
        conectar();
        String sql = "delete from usuario where id_usuario='" + id_usuario + "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Usuario> obtener() {
        conectar();
        List<Usuario> consumos = new ArrayList<>();

        String sql = "SELECT * FROM `usuario`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario d = new Usuario(rs.getString("id_usuario"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("estado"), rs.getString("contraseña"), rs.getInt("edad"), rs.getInt("intentos"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }

    public Usuario buscar(String usuario) {
        for (Usuario ad : obtener()) {
            if (ad.getId_usuario().equals(usuario)) {
                return ad;
            }
        }
        return null;
    }
    
}
