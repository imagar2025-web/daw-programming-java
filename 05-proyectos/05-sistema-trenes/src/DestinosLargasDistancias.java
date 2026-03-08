/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaexamen;

/**
 *
 * @author daw1
 */
public class DestinosLargasDistancias extends Destinos {
    private String pais;

    public DestinosLargasDistancias(String pais, String nombreDestino, int numeroBilletes, double precioDelBillete) {
        super(nombreDestino, numeroBilletes, precioDelBillete);
        this.pais = pais;
    }
    @Override
    public String toString() {
        return super.toString()+"\nPais: "+pais; 
    }
    
}
