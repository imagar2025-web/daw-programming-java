/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjercicioGaraje;

import java.util.Random;

public class App {
    
    public static void reparaciones(Garaje garaje,Coche cohe,double importe){
        if (garaje.cocheAtendible()) {
            cohe.acumularAveria(importe);
            if (garaje.getAveriaAsociada().equalsIgnoreCase("Aceite")) {
                cohe.getMotorCoche().setLitrosAcite(cohe.getMotorCoche().getLitrosAcite()+10);
            }
        }
        garaje.setAveriaAsociada(null);
    }
    
    public static void main(String[] args) {
        Motor motor1=new Motor(80);
        Motor motor2=new Motor(100);
        Coche coche1=new Coche(motor1, "Seat", "Leon");
        Coche coche2=new Coche(motor2, "Seat", "Ibiza");
        Garaje garaje=new Garaje();
        Random radomizer=new Random();
        double precioAleatorio=radomizer.nextDouble(10, 2000);
        garaje.atenderCoche("Aceite", coche2);
        reparaciones(garaje, coche2, precioAleatorio);
        garaje.devolverCoche();
    }
    
}
