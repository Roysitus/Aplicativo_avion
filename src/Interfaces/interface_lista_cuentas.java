package Interfaces;

import Controllador.Administrador;
import Controllador.Usuario;

public interface interface_lista_cuentas {

    public void add_Usuario(Usuario u);

    public void add_Administrador(Administrador a);

    public Administrador obtener_Administrador(int pos);

    public Usuario obtener_Usuario(int pos);

    public void eliminar_cuenta(int pos);

    public Usuario buscar_Usuario(String user);

    public Administrador buscar_Administrador(String user);
}
