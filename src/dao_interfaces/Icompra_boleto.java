/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import Controllador.Compra_boleto;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface Icompra_boleto {
    public boolean crear(Compra_boleto u);
    public boolean actualizar(Compra_boleto u);
    public boolean borrar(String usuario);
    public List<Compra_boleto> obtener();
}
