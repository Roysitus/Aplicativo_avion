
package Controllador;

public class Servicios {
    
    private String id_servicios, descripcion;
    private double monto_servicio;
    private int cont = 0;

    public Servicios(String id_servicios, String descripcion, double monto_servicio) {
        this.id_servicios = generar_IDservicio();
        this.descripcion = descripcion;
        this.monto_servicio = monto_servicio;
    }
    
    public String generar_IDservicio(){
        return "SV2022-"+cont++;
    }

    public String getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(String id_servicios) {
        this.id_servicios = id_servicios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto_servicio() {
        return monto_servicio;
    }

    public void setMonto_servicio(double monto_servicio) {
        this.monto_servicio = monto_servicio;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
