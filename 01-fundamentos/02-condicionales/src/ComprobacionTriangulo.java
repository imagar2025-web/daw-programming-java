
package fichadecondicionalesii;

import java.util.Scanner;

public class ComprobacionDeTriangulo {


    public static void main(String[] args) {
        Scanner datosScanner= new Scanner(System.in);
        double l1,l2,l3;
        System.out.println("Introducca tres longitudes");
        l1=datosScanner.nextDouble();
        l2=datosScanner.nextDouble();
        l3=datosScanner.nextDouble();
        if((l1+l2)>l3 && (l1+l3)>l2 && (l2+l3)>l1){
            System.out.println("Estas longitudes forman un triangulo");
            if(l1==l2 && l1==l3){
                System.out.println("Triangulo Equilatero");
            }else if(l1==l2 || l1==l3 || l2==l3){
                
            }else{
                System.out.println("Triangulo escaleno");
            }
        }else System.out.println("Estas longitudes no formarian un triangulo");
        //Debemos ordenar debidamente los condicionales ya que si no esto 
        //podria provocar que se no se realicen todas las comprobaciones
    }
}
