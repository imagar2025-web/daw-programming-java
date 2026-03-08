
package eejerciciosbasicos;

import java.util.Scanner;

public class EntradaYSalida {

    public static void main(String[] args) {
       Scanner datos=new Scanner(System.in);
        System.err.println("Ingrese su nombre:");
        String nombre=datos.next();
        System.out.println("Buenos dias " + nombre);
        System.out.println("Introduca un numero entero");
        int n1=datos.nextInt();
        System.out.println("Introducca otro numero entero");
        int n2=datos.nextInt();
        System.out.println("Su suma de " + n1 + " y " + n2 + " es " + (n1+n2));
        System.out.println("Ingresa un numero decimal");
        double dec=datos.nextDouble();
        System.out.println("Su cuadrado es " + (dec*dec));
        // si quiero declarar muchas variables en una sola linea 
        //puedo separarlas por comas, pero no puedo inicializarlas
       /* System.out.println("Ingresa un valor:");
        String a=datos.next();
        System.out.println("Ingresa un valor:");
        String b=datos.next();
        System.out.println("Ingresa un valor:");
        String c=datos.next();
        System.out.println("Ingresa un valor:");
        String d=datos.next();
        System.out.println("Ingresa un valor:");
        String e=datos.next();
        System.out.println("Ingresa un valor:");
        String f=datos.next();
        System.out.println("Ingresa un valor:");
        String g=datos.next();
        System.out.println("Ingresa un valor:");
        String h=datos.next();
        System.out.println("Ingresa un valor:");
        String i=datos.next();
        System.out.println("Ingresa un valor:");
        String j=datos.next();
        System.out.println("La unión de todos estos caracteres"
        + " resultan de esta manera " + a + "\n" +
        b + "\n" + c + "\n" + d + "\n" + e + "\n"
        + f + "\n" + g + "\n" + h + "\n" + i +"\n" + j);
        */
       // Esta es otr forma de delcarar varias variables sin iniciarlas
      /* String a,b,c,d,e,f,g,h,i,j;
       //Como ya esta declarada 
       a=datos.nextLine();
       b=datos.nextLine();
       c=datos.nextLine();
       d=datos.nextLine();
       e=datos.nextLine();
       f=datos.nextLine();
       g=datos.nextLine();
       h=datos.nextLine();
       i=datos.nextLine();
       j=datos.nextLine();
        */
         

    }
    
}
