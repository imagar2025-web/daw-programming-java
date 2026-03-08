/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaexamen;

/**
 *
 * @author daw1
 */
public abstract class Destinos {
    private String nombreDestino;
    private int numeroBilletes;
    private double precioDelBillete;

    public Destinos(String nombreDestino, int numeroBilletes, double precioDelBillete) {
        this.nombreDestino = nombreDestino;
        this.numeroBilletes = numeroBilletes;
        this.precioDelBillete = precioDelBillete;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public int getNumeroBilletes() {
        return numeroBilletes;
    }

    public double getPrecioDelBillete() {
        return precioDelBillete;
    }

    @Override
    public String toString() {
        return "Destino: " + nombreDestino +"\nBilletes Restantes: " + numeroBilletes + "\nPrecio: " + precioDelBillete;
    }

    public void setNumeroBilletes(int numeroBilletes) {
        this.numeroBilletes = numeroBilletes;
    }

    
    
}
