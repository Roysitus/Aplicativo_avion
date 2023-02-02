
package Controllador;

public class Asiento {
    
    private String nroAsiento, dimension, clase;
    private int cont = 0;
    
    public Asiento(String nroAsiento, String dimension, String clase) {
        this.nroAsiento = generar_NroAsiento();
        this.dimension = dimension;
        this.clase = clase;
    }
    
    public String generar_NroAsiento(){
        return "AS2022-"+cont++;
    }
    
    public double asignar_extraClase(){
        switch(clase){
            case "Primera Clase":
                return 190;
            case "Clase Ejecutivo":
                return 120;
            case "Clase Economica":
                return 85;
        }
        return 0;
    }

    public String getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(String nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
