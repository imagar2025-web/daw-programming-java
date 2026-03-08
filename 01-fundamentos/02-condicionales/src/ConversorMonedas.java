
package fichadecondicionalesii;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner datosScanner= new Scanner(System.in);
        double euros,pesetas;
        System.out.println("Selecione un tipo de moneda para indicar su conversion euros/pesetas ");
        String moneda=datosScanner.next();
        switch(moneda){
            case "euros":
                System.out.println("Introduce la cantidad de euros para la conversion");
                euros=datosScanner.nextDouble();
                euros=euros*166.386;
                System.out.println("La cantidad correspondientes en pesetas serian: "
                + euros);
                break;
            case "pesetas":
                System.out.println("A continuación introducca la cantidad "
                        + "de pesetas para la conversión");
                pesetas=datosScanner.nextDouble();
                pesetas=pesetas/166.386;
                System.out.println("La cantidad correspondientes en pesetas serian: "
                + pesetas);
            default:
                System.out.println("Has introducido una moneda no admitida.");
        }
        
        
    }
    
}
