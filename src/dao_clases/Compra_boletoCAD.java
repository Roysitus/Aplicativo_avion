
package dao_clases;

import Conexion.Conectar;
import Controllador.Compra_boleto;
import Controllador.Servicios;
import dao_interfaces.Icompra_boleto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compra_boletoCAD extends Conectar implements Icompra_boleto{
        @Override
    public boolean crear(Compra_boleto u) {
        int tamaño = obtener().size();
        u.setCont(tamaño);
        u.setId_boleto(u.generar_boleto());
        System.out.println("" + u.getId_boleto());
        conectar();
        String sql = "insert into compra_boleto (id_boleto , costo , idServicios, idViaje, idUsuario, nroAsiento) values('" + u.getId_boleto()+ "','" + u.getCosto()+ "','" + u.getIdServicios()+ "','" + u.getIdViaje()+ "','" + u.getIdUsuario()+ "','" + u.getNroAsiento()+ "')";
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
    public boolean actualizar(Compra_boleto u) {
        conectar();
        String sql = "update compra_boleto set costo='" + u.getCosto()+ "', idServicios='" + u.getIdServicios()+ "', idViaje='" + u.getIdViaje()+ "', idUsuario='" + u.getIdUsuario()+ "', nroAsiento='" + u.getNroAsiento()+ "' where id_boleto ='" + u.getId_boleto()+ "'";
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
    public boolean borrar(String id_boleto) {
        conectar();
        String sql = "delete from compra_boleto where id_boleto='" + id_boleto + "'";
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
    public List<Compra_boleto> obtener() {
        conectar();
        List<Compra_boleto> consumos = new ArrayList<>();

        String sql = "SELECT * FROM `compra_boleto`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compra_boleto d = new Compra_boleto(rs.getString("id_boleto"), rs.getDouble("costo"), rs.getString("idServicios"),rs.getString("idViaje"),rs.getString("idUsuario"),rs.getString("nroAsiento"));
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

    public Compra_boleto buscar(String id_boleto) {
        for (Compra_boleto ad : obtener()) {
            if (ad.getId_boleto().equals(id_boleto)) {
                return ad;
            }
        }
        return null;
    }
}
