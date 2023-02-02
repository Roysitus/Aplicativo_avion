/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import Controllador.Servicios;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface Iservicios {
    public boolean crear(Servicios u);
    public boolean actualizar(Servicios u);
    public boolean borrar(String usuario);
    public List<Servicios> obtener();
}
