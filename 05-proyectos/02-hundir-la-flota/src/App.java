/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package destruirlaflota_ivan_martin_garcia;

import java.util.Scanner;

/**
 *
 * @author zeus0
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner main=new Scanner(System.in);
        //Testeo sistema de disparos 
        
        /*MapaDeBatalla bat=new MapaDeBatalla();
        MapaJugador2 maquina=new MapaJugador2();
        maquina.mapeoIA();
        maquina.pintarse();
        while (true) {            
            bat.pintarse();
            bat.disparoJugador(maquina.getMiMapa());
        }/*
        
        */
        boolean salida=false;
        System.out.println("BIENVENIDO A HUNDIR LA FLOTA 1DAW");
        do {
            main=new Scanner(System.in);
            System.out.println(" Elija que quiere hacer"
                                + "\n 1º Iniciar Partida 'I'"
                                + "\n 2º Salir 'S'" );
            try {
                System.out.println("Elija que quiere hacer");
                String opcion=main.next().toUpperCase();
                if (opcion.isBlank() || opcion.length()!=1) {
                    throw new MiExcepcion("Has elegido un formato no valido");
                }
                switch (opcion.charAt(0)) {
                    case 'I' -> {
                        new Juego().iniciarPartida();
                    }
                    case 'S' -> {
                        salida=true;
                        System.out.println("Gracias por jugar a Hundir la flota de 1ºDAW");
                    }
                    default -> {
                        System.out.println("No has introducido ninguna opcion valida");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() +" ,vuelva a introcucir la opcion");
            }
        } while (!salida);
                
        
    }
    
}
