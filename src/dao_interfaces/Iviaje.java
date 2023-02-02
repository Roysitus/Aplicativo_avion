/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import Controllador.Viaje;
import java.util.List;


/**
 *
 * @author USUARIO
 */
public interface Iviaje {
    public boolean crear(Viaje u);
    public boolean actualizar(Viaje u);
    public boolean borrar(String usuario);
    public List<Viaje> obtener();
}
