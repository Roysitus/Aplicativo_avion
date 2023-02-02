package Arreglos;

import Controllador.Compra_boleto;
import Interfaces.interface_lista_CompraBoletos;
import java.util.ArrayList;

public class Lista_CompraBoletos implements interface_lista_CompraBoletos{

    private static ArrayList<Compra_boleto> listaBoletos = new ArrayList();

    public Lista_CompraBoletos() {
    }
    
    @Override
    public void addBoleto(Compra_boleto c){
        listaBoletos.add(c);
    }
    
    @Override
    public void obtenerBoleto(int pos){
        listaBoletos.get(pos);
    }
    
    @Override
    public Compra_boleto buscar_boleto(String id_boleto){
        for(Compra_boleto cb : listaBoletos){
            if(cb.getId_boleto().equals(id_boleto)){
                return cb;
            }
        }
        return null;
    }
    
     public static ArrayList<Compra_boleto> getListaBoletos() {
        return listaBoletos;
    }

    public static void setListaBoletos(ArrayList<Compra_boleto> aListaBoletos) {
        listaBoletos = aListaBoletos;
    }
    
}
