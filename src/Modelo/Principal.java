
package Modelo;

import Controllador.Usuario;
import Arreglos.Lista_cuentas;
import Vista.Inicio;

public class Principal {

    public static void main(String[] args) {
        Lista_cuentas lista = new Lista_cuentas();
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        Usuario bus = lista.buscar_Usuario("USER2022-0");
        int pos = lista.getCuentas().indexOf(bus);
        System.out.println(pos);
    }
    
}
