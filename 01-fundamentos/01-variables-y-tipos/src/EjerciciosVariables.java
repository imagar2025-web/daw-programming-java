
package eejerciciosbasicos;

import java.util.Scanner;

public class EjerciciosVaribales {

    
    public static void main(String[] args) {
      
        Scanner entrada=new Scanner(System.in);
        //ACT 1
        //ACT A
        int edad=20;
        System.out.println("Introduce precio");
        int precio=entrada.nextInt();
        int nacimiento=2004;
        //ATC B
        boolean esPrimo=false;
        //ACT C
        System.out.println("Introduce la letra");
        String letraCarnet=entrada.next();
        String tipoSangre="??";
        //ACT D
        double precioJuego=79.99;
        System.out.println("Introduce tu altura");
        double altura=entrada.nextDouble();
        //ACT E
        final double PI=3.1426;
        //Los nombres de las constantes en java se escriben en 
        //Mayusculas
        //ACT F
        System.out.println("El valor de la variable de tipo int llamada edad es " + edad );
        System.out.println("El valor de la variable de tipo int llamada precio es " + precio );
        System.out.println("El valor de la variable de tipo int llamada nacimiento es " + nacimiento );
        System.out.println("El valor de la variable de tipo boolean llamada esPrimo es " + esPrimo );
        System.out.println("El valor de la variable de tipo String llamada letraCarnet es " + letraCarnet );
        System.out.println("El valor de la variable de tipo String llamada tipoSangre es " + tipoSangre );
        System.out.println("El valor de la variable de tipo double llamada precioJuego es " + precioJuego );
        System.out.println("El valor de la variable de tipo double llamada altura es " + altura );
        System.out.println("El valor de la variable de tipo final double llamada PI es " + PI );
        
    }
    
}
