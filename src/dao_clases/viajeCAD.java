
package dao_clases;

import Controllador.Asiento;
import Controllador.Viaje;
import Conexion.Conectar;
import dao_interfaces.Iviaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viajeCAD extends Conectar implements Iviaje{
    @Override
    public boolean crear(Viaje u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setId_viaje(u.generar_IDviaje());
        System.out.println("" + u.getId_viaje());
        conectar();
        String sql = "insert into viaje (id_viaje , destino, fecha, tiempo) values('" + u.getId_viaje()+ "','" + u.getDestino()+ "','" + u.getFecha()+"','" + u.getTiempo()+ "')";
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
    public boolean actualizar(Viaje u) {
        conectar();
        String sql = "update viaje set destino='" + u.getDestino()+ "', fecha='" + u.getFecha()+ "', tiempo='" + u.getTiempo()+ "' where id_viaje ='" + u.getId_viaje()+ "'";
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
        String sql = "delete from viaje where id_viaje='" + id_viaje + "'";
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
    public List<Viaje> obtener() {
        conectar();
        List<Viaje> consumos = new ArrayList<>();

        String sql = "SELECT * FROM `viaje`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Viaje d = new Viaje(rs.getString("id_viaje"), rs.getString("destino"), rs.getString("fecha"), rs.getString("tiempo"));
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

    public Viaje buscar(String id_viaje) {
        for (Viaje ad : obtener()) {
            if (ad.getId_viaje().equals(id_viaje)) {
                return ad;
            }
        }
        return null;
    }
}
