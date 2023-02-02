package Arreglos;

import Controllador.Administrador;
import Controllador.persona;
import Controllador.Usuario;
import Interfaces.interface_lista_cuentas;
import java.util.ArrayList;

public class Lista_cuentas implements interface_lista_cuentas {

    private static ArrayList<persona> cuentas = new ArrayList();
    static boolean interrupcion = true;

    public Lista_cuentas() {
        //String id_administrador, String nombre, String apellido, String dni, String estado, int edad, int intentos
        if (interrupcion) {
            cuentas.add(new Administrador("", "Anonimo", "Linux", "76511489", "HABILITADO", "12345", 25, 3));
            cuentas.add(new Usuario("", "UTP", "Sistemas", "74158414", "HABILITADO", "12345", 21, 3));
            interrupcion = false;
        }
    }

    @Override
    public void add_Usuario(Usuario u) {
        cuentas.add(u);
    }

    @Override
    public void add_Administrador(Administrador a) {
        cuentas.add(a);
    }

    @Override
    public Administrador obtener_Administrador(int pos) {
        return (Administrador) cuentas.get(pos);
    }

    @Override
    public Usuario obtener_Usuario(int pos) {
        return (Usuario) cuentas.get(pos);
    }

    @Override
    public void eliminar_cuenta(int pos) {
        cuentas.remove(pos);
    }

    @Override
    public Usuario buscar_Usuario(String user) {
        for (persona p : cuentas) {
            if (p instanceof Usuario) {
                if (((Usuario) p).getId_usuario().equals(user)) {
                    return (Usuario) p;
                }
            }
        }
        return null;
    }

    @Override
    public Administrador buscar_Administrador(String user) {
        for (persona p : cuentas) {
            if (p instanceof Administrador) {
                if (((Administrador) p).getId_administrador().equals(user)) {
                    return (Administrador) p;
                }
            }
        }
        return null;
    }

    public static ArrayList<persona> getCuentas() {
        return cuentas;
    }

    public static void setCuentas(ArrayList<persona> aCuentas) {
        cuentas = aCuentas;
    }

}
