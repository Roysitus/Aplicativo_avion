/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import Controllador.Asiento;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface Iasiento {
    public boolean crear(Asiento u);
    public boolean actualizar(Asiento u);
    public boolean borrar(String usuario);
    public List<Asiento> obtener();
}
