
package ejemplosstring.s;

import java.util.Scanner;

public class Ejercicio11_1 {
    public static void main(String[] args) {
        Scanner datosScanner=new Scanner(System.in);
        System.out.println("Introducca una cadena de texto");
        String principal=datosScanner.nextLine();
        System.out.println("Ahora introducca la subcadena para comprobar");
        String subcadena=datosScanner.next();
        if(principal.startsWith(subcadena)){
            System.out.println("Concuerda la subcadena con la cadena principal");
        }else {
            System.out.println("No concuerda con la cadena principal");
        }
        
        
    }
    
}
