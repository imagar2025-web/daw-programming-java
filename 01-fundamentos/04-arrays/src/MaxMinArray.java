
package array.s;

import java.util.Scanner;

public class Ejercicio4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        System.out.println("Introduce 10 números:");
        for (int x=0; x < 10; x++) {
            System.out.print("Número " + (x + 1) + ": ");
            numeros[x] = scanner.nextInt();
        }
        int max = numeros[0];
        int min = numeros[0];
        for (int x = 1; x < numeros.length; x++) {
            if (numeros[x] > max) {
                max = numeros[x];
            }
            if (numeros[x] < min) {
                min = numeros[x];
            }
        }
        System.out.println("Máximo valor: " + max);
        System.out.println("Mínimo valor: " + min);
        System.out.print("Posiciones del máximo: ");
        for (int x = 0; x < numeros.length; x++) {
            if (numeros[x] == max) {
                System.out.print(x + " ");
            }
        }
        System.out.print("Posiciones del mínimo: ");
        for (int x = 0; x < numeros.length; x++) {
            if (numeros[x] == min) {
                System.out.print(x + " ");
            }
        }
    }    
}      
    


        
    
    
