
package Interfaces;

import Controllador.Compra_boleto;

public interface interface_lista_CompraBoletos {
    public void addBoleto(Compra_boleto c);
    public void obtenerBoleto(int pos);
    public Compra_boleto buscar_boleto(String id_boleto);
}
