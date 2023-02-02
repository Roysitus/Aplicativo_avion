
package Controllador;

public class Viaje {
    
    private String id_viaje, destino, fecha, tiempo;
    private int cont = 0;
    
    public Viaje(String id_viaje, String destino, String fecha, String tiempo) {
        this.id_viaje = generar_IDviaje();
        this.destino = destino;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }
    
    public String generar_IDviaje(){
        return "VJ2022-"+cont++;
    }
    
    public double asignar_monto(){
        switch(destino){
            case "Lima - Tarapoto":
                return 500;
            case "Tarapoto - Lima":
                return 625;
            case "Lima - Cuzco":
                return 900;
            case "Cuzco - Lima":
                return 850;
            case "Lima - Piura":
                return 150;
            case "Piura - Lima":
                return 175;
            case "Arequipa - Lima":
                return 385;
            case "Lima - Arequipa":
                return 400;
        }
        return 0;
    }
    
    public void asignar_tiempo(){
        switch(destino){
            case "Lima - Tarapoto":
                setTiempo("2h 25min 15s - Aprox");
            case "Tarapoto - Lima":
                setTiempo("3h 35min 17s - Aprox");
            case "Lima - Cuzco":
                setTiempo("1h 55min 28s - Aprox");
            case "Cuzco - Lima":
                setTiempo("2h 45min 31s - Aprox");
            case "Lima - Piura":
                setTiempo("1h 35min 45s - Aprox");
            case "Piura - Lima":
                setTiempo("5h 25min 51s - Aprox");
            case "Arequipa - Lima":
                setTiempo("4h 15min 34s - Aprox");
            case "Lima - Arequipa":
                setTiempo("2h 21min 41s - Aprox");
        }
    }
    
    public String getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(String id_viaje) {
        this.id_viaje = id_viaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
    
}
