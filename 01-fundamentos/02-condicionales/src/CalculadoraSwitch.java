
package calendarioconvariables;

import java.util.Scanner;

public class EjemploDeSwicht {

    public static void main(String[] args) {
        //La sentencia Swithc sirve para evaluar una condicion 
        //Y tomar el cmaino que corresponde dependiendo de la respuesta
        /* Sintxsis-> switch(condicion){
                       case "opcion":
                            lo que quiero que haga 
                            break;
                        case"opcion2":
                            lo que qioero que haga 
                            break;
                        default:
                            cualquier opcion no contemplada
                        }

                       */
        
        double n1,n2;
        Scanner datos=new Scanner(System.in);
        System.out.println("Introduce un primer numero para operar");
        n1=datos.nextDouble();
        System.out.println("Introduce un segundo numero con el que operar");
        n2=datos.nextDouble();
        System.out.println("Seleciona una operacion: +,-,*,/");
        String opcion=datos.next();
        switch(opcion){
            case "+":
                System.out.println("La suma de los numeros " + n1 + " y " + n2 + 
                        " es " + (n1+n2));
                break;
            case "-":
                System.out.println("La suma de los numeros " + n1 + " y " + n2 + 
                        " es " + (n1-n2));
                break;
            case "*":
                System.out.println("La suma de los numeros " + n1 + " y " + n2 + 
                        " es " + (n1*n2));
                break;
            case "/":
                System.out.println("La suma de los numeros " + n1 + " y " + n2 + 
                        " es " + (n1/n2));
                break;
            default:
                System.out.println("Has introducido un valor que no es valido");
        }
        
    }
    
}
