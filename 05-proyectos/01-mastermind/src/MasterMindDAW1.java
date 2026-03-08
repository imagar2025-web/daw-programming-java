package masterminddaw1;

import java.util.Random;
import java.util.Scanner;

public class MasterMindDAW1 {

    public static Scanner datos = new Scanner(System.in);

    public static final Random coloresAleatorios = new Random();
    //Esto alternara en el modo de dificultad elegida
    public static int vidas = 0;

    public static int canridadAdivinar = 5;

    public static int nPartidas = 0;

    public static int jugador = 1;

    public static int Dificultadad() {
        boolean dificultadErronea = true;
        int vidas1;
        System.out.println("Antes de empezar la partida seleccione el modo de dificulta:");
        System.out.println("Dificíl(D): 3 Vidas " + "\n" + "Media(M): 5 Vidas" + "\n"
                + "Facíl(F):10 Vidas");
        while (dificultadErronea == true) {
            System.out.println("Introduzca Una de las 3 letras");
            String dificultad = datos.next();
            if (dificultad.equalsIgnoreCase("F")) {
                vidas1 = 10;
                dificultadErronea = false;
            } else if (dificultad.equalsIgnoreCase("M")) {
                vidas1 = 5;
                dificultadErronea = false;
            } else if (dificultad.equalsIgnoreCase("D")) {
                vidas1 = 3;
                dificultadErronea = false;
            } else {
                System.out.println("Has introducido caracter no valido");
            }
        }
        return vidas;
    }

    public static String[] ArrayDeJuego() {
        String[] Adivinanza = new String[canridadAdivinar];
        String[] Colores = {"Amarillo", "Rojo", "Azul", "Verde", "Morado", "Naranja", "Magenta", "Cian", "Rosa", "Granate"};
        //Aqui se crea el array con el que se va a jugar 
        System.out.println("Bienvenido a Master Mind DAW. Vamos a empezar el juego");
        for (int i = 0; i < Adivinanza.length; i++) {
            int numeros = coloresAleatorios.nextInt(10);
            Adivinanza[i] = Colores[numeros];
        }
        for (int i = 0; i < Colores.length; i++) {
            Colores[i] = Colores[i].toLowerCase();
        }
        //Le muestras todos los colores posibles al usuario
        for (int j = 0; j < Colores.length; j++) {
            if (j != Colores.length - 1) {
                System.out.print(Colores[j] + ", ");
            } else {
                System.out.print(Colores[j]);
            }

        }

        System.out.println(" \n Esto son los colores posibles dentro del juego. IMPORTANTE:"
                + " PUEDEN SALIR COLORES REPETIDOS Y MÁS DE UNA VEZ");

        return Adivinanza;
    }

    public static void Logros(int numeroDeVictorias, int modoDificultad, int VidasDesContadas, int sumaJuego) {

    }

    public static void Partidas(int numeroVidas, String[] ArrayJuego) {
        boolean victoria = false;
        while (vidas != 0 && victoria == false) {

            String[] Jugador = new String[canridadAdivinar];
            //Evitarnos de repeticiones y errores
            boolean[] Comprobador = {false, false, false, false, false};
            //Esto son los contadores comparativos para el juego
            int aciertos = 0;
            int colorAciertos = 0;
            //Muestra para el testeo 
            for (int i = 0; i < ArrayJuego.length; i++) {
                System.out.print(ArrayJuego[i] + " ");
            }
            System.out.println("");
            System.out.println("Vidas:" + vidas);
            System.out.println("");
            System.out.println("Introduzca 5 colores en el orden que usted crea para adivinar");
            //Aqui el usuario pasara a ingresar su array para comparar
            for (int i = 0; i < Jugador.length; i++) {
                System.out.println((i + 1) + "º");
                //Lo hacemos minusculas para evitar errores de comparación
                Jugador[i] = datos.next().toLowerCase();
            }

            for (int i = 0; i < Jugador.length; i++) {
                if (Jugador[i].equalsIgnoreCase(ArrayJuego[i])) {
                    Comprobador[i] = true;
                    aciertos++;
                }
            }
            for (int i = 0; i < Jugador.length; i++) {
                boolean comprobadorMedioAciertos = false;
                for (int j = 0; j < ArrayJuego.length; j++) {
                    if (Jugador[i].equalsIgnoreCase(ArrayJuego[j]) && comprobadorMedioAciertos == false && Comprobador[j] == false) {
                        colorAciertos++;
                        Comprobador[j] = true;
                        comprobadorMedioAciertos = true;
                    }
                }
            }
            if (aciertos == 5 &&) {
                victoria = true;
                System.out.println("Muy bien has ganado!!");
            } else {
                vidas--;
                System.out.println("numero de aciertos:" + aciertos);
                System.out.println("numero de medio Aciertos: " + colorAciertos);
            }
        }

        otherParty();

    }

    public static void otherParty() {
        System.out.println("Quieres jugar otra partida?");
        System.out.println("T/F");
        boolean valorCorrecto = false;
        while (valorCorrecto == false) {
            char otraPartida = datos.next().charAt(0);
            if (otraPartida == 'T') {
                Partidas(Dificultadad(), ArrayDeJuego());
                valorCorrecto = true;
            } else if (otraPartida == 'F') {
                System.out.println("Gracias por jugar a MasterMindDAW \n Desarrolladora:Blizzar");
                valorCorrecto = true;
            } else {
                System.out.println("Has introducido un Caracter no valido");
                System.out.println("Seleccione una de las opciones");
            }
        }

    }

    public static void main(String[] args) {

        Partidas(Dificultadad(), ArrayDeJuego());

    }
}
