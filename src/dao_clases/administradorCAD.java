
package dao_clases;

import Controllador.Administrador;
import Conexion.Conectar;
import dao_interfaces.Iadministrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class administradorCAD extends Conectar implements Iadministrador{
    @Override
    public boolean crear(Administrador u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setId_administrador(u.generar_idAdministrador());
        System.out.println(""+u.getId_administrador());
        conectar();
        String sql = "insert into administrador (id_administrador , nombre, apellido, dni, estado, contraseña, edad, intentos) values('" + u.getId_administrador() + "','" + u.getNombre() + "','" + u.getApellido()+ 
                "','" + u.getDni()+ "','" + u.getEstado()+ "','" + u.getContraseña()+ "','" + u.getEdad()+ "','" + u.getIntentos()+ "')";
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
    public boolean actualizar(Administrador u) {
        conectar();
        String sql = "update administrador set nombre='" + u.getNombre()+ "', apellido='" + u.getApellido()+ "', dni='" + u.getDni()+ "', estado='" + u.getEstado()+ "', contraseña='" + u.getContraseña()+ "', edad='" + u.getEdad()+ "', intentos='" + u.getIntentos()+
                "' where id_administrador ='" + u.getId_administrador()+ "'";
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
    public boolean borrar(String id_administrador) {
        conectar();
        String sql = "delete from administrador where id_administrador='" + id_administrador + "'";
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
    public List<Administrador> obtener() {
        conectar();
        List<Administrador> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `administrador`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Administrador d = new Administrador(rs.getString("id_administrador"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("estado"), rs.getString("contraseña"), rs.getInt("edad"), rs.getInt("intentos"));
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
    
    public Administrador buscar(String usuario){
        for(Administrador ad : obtener()){
            if(ad.getId_administrador().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}
