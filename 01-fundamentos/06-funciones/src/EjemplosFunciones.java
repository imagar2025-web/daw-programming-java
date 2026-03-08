
package ejemplosfunciones;
import java.util.Scanner;

public class EjemplosFunciones {

    public static void cuentaNum(){
        System.out.println("Vamos a contar del 1 al 10");
        for(int x=1;x<11;x++){
            System.out.println(x);
        }
    }
    //FUncion con valor de retorno
    public static int hacerSuma(){
        Scanner datos=new Scanner(System.in);
        int n1=datos.nextInt();
        int n2=datos.nextInt();
        int suma=n1+n2;
        return suma;
    }
    public static void main(String[] args) {
        //Para hacer una funcion o metodo, hay que declararlo primero
        /*SINTAXIS-> public static tipoDeRetorno nombreFuncion(parametro1,parame2,....)
        las funciones podrias no tener parametros
        {Codigo a ejecutar},no podemos declarar funciones dentro del main pero dentr de la calse
        
        */
        /*
        para mostrara de pone y se añade los parametros necesarios y si hay un retorno
        deberiamos guardarlo o mostrarlo por pantalla
        */
        System.out.println("Ahora vamos a invocar una funcion que cuente "
                + "del uno al 10");
        cuentaNum();
        // para ejecuutar la suma debo llamarla,si la quiero llamar la cosa es guardarla en una variable
        //Pilla el retun
        hacerSuma();
        int valor=hacerSuma();

        
    }
    
}
