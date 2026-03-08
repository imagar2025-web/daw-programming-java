package array.s;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner datosScanner = new Scanner(System.in);
        int tamaño;
        System.out.println("Introduca el tamaño de la lista");
        tamaño = datosScanner.nextInt();
        int[] miArray = new int[tamaño];
        System.out.println("A continuacion introduca los valores");
        for (int x = 0; x < miArray.length; x++) {
            System.out.println("En " + (x + 1) + "º");
            miArray[x] = datosScanner.nextInt();
        }
        System.out.println("Haciendo unos cambios.");
        if (tamaño > 0) {
            int ultimoValor = miArray[tamaño - 1];
            for (int x = tamaño - 1; x > 0; x--) {
                miArray[x] = miArray[x - 1];
            }
            miArray[0] = ultimoValor;
        }
        for (int x = 0; x < miArray.length; x++) {
            System.out.println((x+1) + "º " + miArray[x]);

        }
    }

}
