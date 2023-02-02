
package dao_clases;

import Controllador.Asiento;
import Controllador.Usuario;
import Conexion.Conectar;
import dao_interfaces.Iasiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class asientoCAD extends Conectar implements Iasiento{
    @Override
    public boolean crear(Asiento u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setNroAsiento(u.generar_NroAsiento());
        System.out.println("" + u.getNroAsiento());
        conectar();
        String sql = "insert into asiento (nroAsiento , dimension, clase) values('" + u.getNroAsiento()+ "','" + u.getDimension()+ "','" + u.getClase() + "')";
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
    public boolean actualizar(Asiento u) {
        conectar();
        String sql = "update asiento set dimension='" + u.getDimension()+ "', clase='" + u.getClase()+ "' where nroAsiento ='" + u.getNroAsiento()+ "'";
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
    public boolean borrar(String nroAsiento) {
        conectar();
        String sql = "delete from asiento where nroAsiento='" + nroAsiento + "'";
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
    public List<Asiento> obtener() {
        conectar();
        List<Asiento> consumos = new ArrayList<>();

        String sql = "SELECT * FROM `asiento`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Asiento d = new Asiento(rs.getString("nroAsiento"), rs.getString("dimension"), rs.getString("clase"));
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

    public Asiento buscar(String nroAsiento) {
        for (Asiento ad : obtener()) {
            if (ad.getNroAsiento().equals(nroAsiento)) {
                return ad;
            }
        }
        return null;
    }
}
