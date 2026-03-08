/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesabstractas;

/**
 *
 * @author zeus0
 */
public class MP3 extends ProductoElectronico{
    private String color;

    public MP3(String color, String madeIn, double precioNormal, String calidad) {
        super(madeIn, precioNormal, calidad);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int tiempoGarantia() {
        return 2;
    }

    @Override
    public double precioConDescuento(int descuento) {
        return this.getPrecioNormal()*((((double)descuento)/100)-100);
    }
    @Override
    public void mostrarAtributos(){
        System.out.println(this.getMadeIn()+"\n"+this.getCalidad()+"\n"+this.getColor()+"\n"+this.getPrecioNormal());
    }
}
