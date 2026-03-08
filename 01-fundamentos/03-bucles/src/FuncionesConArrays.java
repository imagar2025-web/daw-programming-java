
package simulacroexamen;

import java.util.Random;
import java.util.Scanner;


public class FuncionesExamene {
    public static Scanner datos=new Scanner(System.in);
    public static  Random numeroAleatorios=new Random();
    public static int[] crearArrayPar(int tam,int divisible){
        int [] chanchito;
        if (tam%divisible==0) {
            chanchito=new int [tam];
        }else{
            int divisibilidad=tam*divisible;
            chanchito=new int [divisibilidad];
        }   
        return chanchito;
    }
    public static int [] rellenarArrayPares(int [] elArray){
        
        for (int i = 0; i < elArray.length; i++) {
            boolean par=false;
            while(par==false){
                int numero=numeroAleatorios.nextInt(1, 10);
                if (numero%2==0) {
                    elArray[i]=numero;
                    par=true;
                }
            }
        }
          
        return elArray;
    }
    public static void mostrarPosición(int [] array,int posicion){
        if (posicion>array.length-1 || posicion<0) {
            System.out.println("Has pedido un valor que esta fuera de rango ");
        }else{
            System.out.println("En contenido de la posicion " + posicion + " es " + array[posicion]);
        }
        
    }
    public static int [] reposicionadorDeArrays(int [] arrayBase, int posionDeInicio){
        int [] reposicionadoArray=new int [arrayBase.length];
        int movimiento=0;
        for (int i = posionDeInicio; i < arrayBase.length; i++) {
            reposicionadoArray[movimiento]=arrayBase[i];
            movimiento++;
        }
        int posicionesFinales=0;
        for (int i = movimiento; i < reposicionadoArray.length; i++) {
            reposicionadoArray[i]=arrayBase[posicionesFinales];
            posicionesFinales++;
        }
        return reposicionadoArray;
        
    }
    public static char [] sustituyeCaracteres(char busqueda,char sustitucion,String miCadena){
        int numeroSustituciones=0;
         char [] cadenaBuscable=miCadena.toCharArray();
        for (int i = 0; i <cadenaBuscable.length ; i++) {
            if (cadenaBuscable[i]==busqueda) {
                cadenaBuscable[i]=sustitucion;
                numeroSustituciones++;
            }
        }
        char [] cambiosTotales=new char [numeroSustituciones*2];
        for (int i = 0; i < cambiosTotales.length; i++) {
            if (i%2==0) {
                cambiosTotales[i]=busqueda;
            }else{
                cambiosTotales[i]=sustitucion;
            }
        }
        return cambiosTotales;
    }
    public static void main(String[] args) {
       /* int tamaño,numeroDivisible;
        System.out.println("Introducca el tamaño");
        tamaño=datos.nextInt();
        System.out.println("Introducca el numero por el que se va a dividir");
        numeroDivisible=datos.nextInt();
        int [] array1=crearArrayPar(tamaño, numeroDivisible);
        System.out.println(array1.length);
        */
        System.out.println("----------------------------------");
        /*System.out.println("Introduce el tamaño del array de pares");
        int tamañoArrayPar=datos.nextInt();
        int [] arrayPar=new int [tamañoArrayPar];
        arrayPar=rellenarArrayPares(arrayPar);
        for (int i = 0; i < arrayPar.length; i++) {
            System.out.println(arrayPar[i]);
        }*/
        /*System.out.println("-----------------------------------");
        System.out.println("Introduce el tamaño de tu array");
        int tamañoC=datos.nextInt();
        int [] array3C=new int [tamañoC];
        int [] arraPosiciones=rellenarArrayPares(array3C);
        System.out.println("Introducca la posicion que quiere ver");
        int posi=datos.nextInt();
        mostrarPosición(array3C, posi);*/
        System.out.println("-----------------------------------");
        /*int [] arraPosicionador={1,2,3,4,5};
        System.out.println("Introduce la posicion por la que quieres hacer los cambios");
        int posicionDecambio=datos.nextInt();
        arraPosicionador=reposicionadorDeArrays(arraPosicionador, posicionDecambio);
        for (int i = 0; i < arraPosicionador.length; i++) {
            System.out.print(arraPosicionador[i] + " ");
            
        }*/
        System.out.println("-----------------------------------");
        System.out.println("Introduce en este orden: cadena,caracter de sustitucion y caracter para ser sustituido");
        String cadena=datos.next();
        char buscador=datos.next().charAt(0);
        char buscado=datos.next().charAt(0);
        char [] caracteresDevolucion=sustituyeCaracteres(buscado, buscador, cadena);
        for (int i = 0; i < caracteresDevolucion.length; i++) {
            System.out.print(caracteresDevolucion[i] + " ");
            
        }
        
    }
    
}
