/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesabstractas;

/**
 *
 * @author zeus0
 */
public class TV extends ProductoElectronico{
    private int tam;

    public TV(int tam, String madeIn, double precioNormal, String calidad) {
        super(madeIn, precioNormal, calidad);
        this.tam = tam;
    }

    @Override
    public int tiempoGarantia() {
        return 4;
    }

    @Override
    public double precioConDescuento(int descuento) {
        return this.getPrecioNormal()*((((double)descuento)/100)-100);
    }
    
    
}
