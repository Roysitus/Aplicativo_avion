
package dao_clases;

import Conexion.Conectar;
import Controllador.Servicios;
import Controllador.Viaje;
import dao_interfaces.Iservicios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serviciosCAD extends Conectar implements Iservicios{
    @Override
    public boolean crear(Servicios u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setId_servicios(u.generar_IDservicio());
        System.out.println("" + u.getId_servicios());
        conectar();
        String sql = "insert into servicios (id_servicios , descripcion	, monto_servicio) values('" + u.getId_servicios()+ "','" + u.getDescripcion()+ "','" + u.getMonto_servicio()+ "')";
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
    public boolean actualizar(Servicios u) {
        conectar();
        String sql = "update servicios set descripcion='" + u.getDescripcion()+ "', monto_servicio='" + u.getMonto_servicio() + "' where id_servicios ='" + u.getId_servicios()+ "'";
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
    public boolean borrar(String id_viaje) {
        conectar();
        String sql = "delete from servicios where id_viaje='" + id_viaje + "'";
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
    public List<Servicios> obtener() {
        conectar();
        List<Servicios> consumos = new ArrayList<>();

        String sql = "SELECT * FROM `servicios`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Servicios d = new Servicios(rs.getString("id_servicios"), rs.getString("descripcion"), rs.getDouble("monto_servicio"));
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

    public Servicios buscar(String id_servicios) {
        for (Servicios ad : obtener()) {
            if (ad.getId_servicios().equals(id_servicios)) {
                return ad;
            }
        }
        return null;
    }
}
