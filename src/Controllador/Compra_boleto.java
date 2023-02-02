
package Controllador;

public class Compra_boleto {
    
    private String id_boleto;
    private double costo;
    private String idServicios;
    private String idViaje;
    private String idUsuario;
    private String nroAsiento;
    private int cont = 0;

    public Compra_boleto(String id_boleto, double costo, String idServicios, String idViaje, String idUsuario, String nroAsiento) {
        this.id_boleto = generar_boleto();
        this.costo = costo;
        this.idServicios = idServicios;
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.nroAsiento = nroAsiento;
    }
    public String generar_boleto(){
        return "BL2022-"+cont++;
    }

    public String getId_boleto() {
        return id_boleto;
    }

    public void setId_boleto(String id_boleto) {
        this.id_boleto = id_boleto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(String idServicios) {
        this.idServicios = idServicios;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(String nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    
}
