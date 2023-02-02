package Controllador;

public class Administrador extends persona {

    private String id_administrador;
    private int cont = 0;

    public Administrador(String id_administrador, String nombre, String apellido, String dni, String estado, String contraseña, int edad, int intentos) {
        super(nombre, apellido, dni, estado, contraseña, edad, intentos);
        this.id_administrador = id_administrador;
    }
    
    public String generar_idAdministrador(){
        return "ADMIN2022-"+cont;
    }

    public String getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(String id_administrador) {
        this.id_administrador = id_administrador;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
