
package array;

import java.util.Scanner;

public class PizarraClase {

    public static void main(String[] args) {
        Scanner datosScanner=new Scanner(System.in);
        System.out.println("Seleccione el tamaño del array");
        int tamaño=datosScanner.nextInt();
        int [] miArray= new int [tamaño];
        for(int x=0;x<miArray.length;x++){
            System.out.println("Introducca el " + (x+1) + "º del array");
            miArray[x]=datosScanner.nextInt();
        }
        int sumador=0;
        int pares=0;
        int impares=0;
        for(int x=0;x<miArray.length;x++){
            sumador=sumador + miArray[x];
            if(miArray[x]%2==0){
                pares++;
            }else{
                impares++;
            }
        }
        //Puedo generar dos array's con los tamaños
        int[] losPares = new int [pares];
        int[] losImPares = new int [impares];
        pares=0;
        impares=0;
        //Ahora rellenaremos los array's con un bucle
        //Reutilizacion la variables paras e impares para controlar la posicion del numero 
          for(int x=0;x<miArray.length;x++){
            if(miArray[x]%2==0){
                losPares[pares]=miArray[x];
                pares++;
            }else{
                losImPares[impares]=miArray[x];
                impares++;
            }
        }
        //Ya esta obtenida la información solo quedaría mostrar
        System.out.println(sumador + " " + (sumador/tamaño) + " ");
        System.out.print("Los numeros pares son: ");
        for(int x =0;x<losPares.length;x++){
            System.out.print((x+1) + "º " + losPares[x]);
        }
        System.out.println("");
          System.out.print("Los numeros pares son: ");
        for(int x =0;x<losImPares.length;x++){
            System.out.print((x+1) + "º " + losImPares[x]);
        }
        
    }
    
}
