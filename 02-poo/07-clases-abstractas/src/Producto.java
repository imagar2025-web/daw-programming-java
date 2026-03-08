/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesabstractas;

/**
 *
 * @author zeus0
 */
public abstract class Producto {
    private double precioNormal;
    private String calidad;

    public Producto(double precioNormal, String calidad) {
        this.precioNormal = precioNormal;
        this.calidad = calidad;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    
    public void mostrarAtributos(){
        System.out.println(this.getCalidad()+", "+this.getPrecioNormal());
        
    }
    
    public abstract double precioConDescuento(int descuento);
}
