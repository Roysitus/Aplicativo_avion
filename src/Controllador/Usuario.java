
package Controllador;


public class Usuario extends persona{
    
    private String id_usuario;
    private int cont = 0;

    public Usuario(String id_usuario, String nombre, String apellido, String dni, String estado, String contraseña, int edad, int intentos) {
        super(nombre, apellido, dni, estado, contraseña, edad, intentos);
        this.id_usuario = id_usuario;
    }

    public String generar_idUsuario(){
        return "USER2022-"+cont++;
    }
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

}
