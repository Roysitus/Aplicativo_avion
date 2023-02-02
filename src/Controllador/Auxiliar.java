package Controllador;

public class Auxiliar {

    private static Usuario usuario;

    public Auxiliar() {
    }

    public Auxiliar(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }

}
