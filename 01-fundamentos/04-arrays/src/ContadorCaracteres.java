
package array.s;

import java.util.Scanner;

public class Ejercicio6 {


    public static void main(String[] args) {
        Scanner datosScanner=new Scanner(System.in);
        System.out.println("Escriba un valor para el tamaño de su array");
        int tamaño=datosScanner.nextInt();
        char [] miArray= new char[tamaño];
        System.out.println("Introducca los valores");
        for(int x=0;x<miArray.length;x++){
            System.out.print((x+1) + "º: ");
            miArray[x]=datosScanner.next().charAt(0);
        }
        System.out.print("La lista sería: ");
        for(int x=0;x<miArray.length;x++){
            System.out.print( "" + (x+1) + "º " + miArray[x]);
        }
        System.out.println("Ahora solicita un caracter para recontarlo en la lista anterior");
        char entrada=datosScanner.next().charAt(0);
        int recuento=0;
        for(int x=0; x<miArray.length;x++){
            if(entrada==miArray[x]){
                recuento++;
            }
        }
        System.out.println("El valor que has introducido aparece un total de " + recuento);
        System.out.println("Ahora introducca un valor de sustitución");
        char sustitución=datosScanner.next().charAt(0);
        for(int x=0;x<miArray.length;x++){
            if(entrada==miArray[x]){
                miArray[x]=sustitución;
            }
        }
        System.out.println("La nueva lista quedaría de la siguiente manera:");
         for(int x=0;x<miArray.length;x++){
            System.out.println( (x+1) + "º " + miArray[x]);
        }
    }
    
}
