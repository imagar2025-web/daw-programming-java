/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioGaraje;

public class Coche{
    private Motor motorCoche;
    private String marca;
    private String modelo;
    private double cantReparaciones;

    public Coche(Motor motorCoche, String marca, String modelo) {
        this.motorCoche = motorCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.cantReparaciones = 0;
    }
    
    public void acumularAveria(double importe){
        cantReparaciones+=importe;
    }

    public Motor getMotorCoche() {
        return motorCoche;
    }

    public void setMotorCoche(Motor motorCoche) {
        this.motorCoche = motorCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCantReparaciones() {
        return cantReparaciones;
    }

    public void setCantReparaciones(double cantReparaciones) {
        this.cantReparaciones = cantReparaciones;
    }
    
    
    
}
