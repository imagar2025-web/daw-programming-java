
import java.util.Scanner;


public class Ejercicios {

    public static int[] CrearArrys (){
        Scanner datosScanner=new Scanner(System.in);
        System.out.println("Introduce un tamaño");
        int tamaño=datosScanner.nextInt();
        int [] miArray = new int [tamaño];
        System.out.println("-----------");
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Introducca el " + (i+1) + "º ");
            miArray[i]=datosScanner.nextInt();
        }
        return miArray;
    }
    public static int ejercicio2(int[] array1,int[] array2){
        int suma1=0;
        int suma2=0;
        int sumaFinal;
        for (int i = 0; i < array1.length; i++) {
            suma1 = suma1 + array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            suma2 = suma2 + array2[i];
        }
        sumaFinal=suma1+suma2;
        return  sumaFinal;
    }
    public static int mayorEnArrya(){
        int[] array = CrearArrys();
        int numeroMayor=-1000000;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > numeroMayor) {
                numeroMayor=array[i];
            }
            
        }
        return  numeroMayor;
    }
    public static int sumadorDePares(){
        int [] lista=CrearArrys();
        int sumaPafres=0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i]%2==0) {
                sumaPafres=sumaPafres+lista[i];
            }
        }
        return  sumaPafres;
    }
    public static int numerosFactoriales(int numeroFac){
        int operandoFac=1;
        for (int i = numeroFac; i >0 ; i--) {
            operandoFac=operandoFac*i;
            
        }
        return operandoFac;
    }
    
    public static void main(String[] args) {
     
        
//Ejercicio2
        /* int [] array1 =CrearArrys();
        int [] array2 =CrearArrys();
        int resultado=ejercicio2(array1, array2);
        System.out.println("La suma de sus dos arrays's es  " + resultado);*/
       
        
//Ejercicio 3
        /*int maximo=mayorEnArrya();
        System.out.println("El numero mas grande en su array es : " + maximo);*/
        

//Ejercicio4
        /*int suma=sumadorDePares();
        System.out.println("La suma de los pares es igual a " + suma);*/
        

//Ejercicio5
        System.out.println("Introducca su numero para mostrar su resultado en factorial");
        Scanner datosScanner=new Scanner(System.in);
        int num=datosScanner.nextInt();
        int numeroFact=numerosFactoriales(num);
        System.out.println("El numero factoria de " + num + " es igual a " + numeroFact);
    }   
    
}
