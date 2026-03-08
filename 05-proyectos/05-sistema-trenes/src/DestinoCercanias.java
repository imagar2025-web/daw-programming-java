/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaexamen;

/**
 *
 * @author daw1
 */
public class DestinoCercanias extends Destinos{
    private String comuni;

    public DestinoCercanias(String comuni, String nombreDestino, int numeroBilletes, double precioDelBillete) {
        super(nombreDestino, numeroBilletes, precioDelBillete);
        this.comuni = comuni;
    }

    @Override
    public String toString() {
        return super.toString()+"\nComunidad: "+comuni; 
    }
    
    
}
