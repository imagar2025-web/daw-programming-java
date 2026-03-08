
package ejerciciosarraysbidimensionales;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class EjerciciosArraysBidimensionales {
    public Scanner datos=new Scanner(System.in);
    
    //EJERCICIOS PREVIOS
    
     public static void ejercicio1() {
        int sumador = 0;
        int[][] matriz = new int[5][3];  // Crear una matriz 5x5

        // Rellenar la matriz automáticamente con números incrementales
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sumador;  // Asignar el valor del sumador
                sumador++;  // Incrementar el sumador
            }
        }

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {  // Recorrer filas
            for (int j = 0; j < matriz[i].length; j++) {  // Recorrer columnas
                System.out.print(matriz[i][j] + " ");  // Imprimir valor
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }
     
     public static void ejercicio2(int filas,int columnas){
         int [][]matriz=new int [filas][columnas];
         int filador=0;
         for (int i = 0; i < matriz.length; i++) {
            matriz[i][0]=filador;
            int axu=5;
             for (int j = 1; j < matriz.length; j++) {
                 matriz[i][j]=filador+axu;
                 axu+=5;
             }
 
         }
     }
     
     public static void ejercicio3(){
         //la matriz identidad obligatoriamente ha de tener el mismo nuemro de columnas que de filas
         int [][] matriz=new int [3][3];
         int posi1=0;
         for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (j!=posi1) {
                    System.out.print("" + "0");
                }else{
                    System.out.print("" + "1");
                } 
            }
            posi1++;
            System.out.println("");
         }
     }
     public static void ejercicio4(int [][] matriz){
         
         int sumador=0;
         for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[j][i] = sumador;  // Asignar el valor del sumador
                sumador++;  // Incrementar el sumador
            }
        }
         
         
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[i].length; j++) {
                 System.out.print(" " + matriz[i][j]);
             }
             System.out.println();
             
         }
     }
     public static String  ejercicio5(char [][] matriz){
         String conversor="";
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[i].length; j++) {
                 conversor+=matriz[i][j];
             }
             conversor+=" ";
         }
         return conversor;
     }

    public static void main(String[] args) {
        // TODO code application logic here
        
        //ejercicio1();
        ejercicio4(new int [6][2]);
        
        //char [][] matrizFrase={{'h','o','l','a'},{'A','l','e','j','a','n','d','r','o'}};
        //System.out.println(ejercicio5(matrizFrase));
    }
    
}
