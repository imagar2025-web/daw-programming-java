

package EjerciciosExcepciones;

import java.util.InputMismatchException;


import java.util.Scanner;


class NotaMal extends Exception {
    public NotaMal(String mensaje) {
        super(mensaje);
    }
}


class SoloAceptoS extends Exception {
    public SoloAceptoS(String mensaje) {
        super(mensaje);
    }
}

class MediaNotas {
    public static void mediaNotas() {
        Scanner scanner = new Scanner(System.in);
        double sumaNotas = 0;
        int contadorNotas = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Introduce una nota (0-10): ");
                double nota = Double.parseDouble(scanner.nextLine());

                if (nota < 0 || nota > 10) {
                    throw new NotaMal("La nota debe estar entre 0 y 10.");
                }

                sumaNotas += nota;
                contadorNotas++;

                System.out.print("¿Quieres continuar? (s/n): ");
                String respuesta = scanner.nextLine().toLowerCase();

                if (respuesta.equals("n")) {
                    continuar = false;
                } else if (!respuesta.equals("s")) {
                    throw new SoloAceptoS("Solo acepto 's' o 'n' como respuesta.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido.");
            } catch (NotaMal e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SoloAceptoS e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (contadorNotas > 0) {
            double media = sumaNotas / contadorNotas;
            System.out.println("La media de las notas es: " + media);
        } else {
            System.out.println("No se introdujeron notas.");
        }
    }
}


public class Ejercicios1 {

    /**
     * @param args the command line arguments
     */
    static Scanner datos=new Scanner(System.in);
    
    static void ejerc1(){
        System.out.println("Introduce la cadena:");
        String laCadena=datos.nextLine();
        try{
            System.out.println("Elija el indice donde quiera que aparezca");

            System.out.println("El caracter en la posicion elegida es " + laCadena.charAt((datos.nextInt()-1)));
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Exploto por: " + e.getMessage());
        }
    }
    static void ejerc2(){
        System.out.println("Introduce la cadena:");
        String laCadena=datos.nextLine();
        boolean posiCorrect=false;
        do {
            try{
                System.out.println("Elija el indice donde quiera que aparezca");
                System.out.println("El caracter en la posicion elegida es " + laCadena.charAt((datos.nextInt()-1)));
                posiCorrect=true;
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Exploto por: " + e.getMessage());
            } 
        } while (!posiCorrect);
    
           
    }
    
    static void ejer3Y4(){
        int a,b;
        boolean salida=false;
        do {
            try {
            System.out.println("Introduca un numero a");
            a=datos.nextInt();
            System.out.println("Introduca un numero b");
            b=datos.nextInt();
            System.out.println("La division de " + a + " y " + b +" es: " + a/b);   
            salida=true;
            } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
            }catch(ArithmeticException e){
                e.printStackTrace(); 
            }catch(Exception e){
                System.out.println("Ocurrio algo inesperado " + e.getMessage());
            }
        } while (!salida);
    }
    
    static void ejer5(String cadena){
        boolean salida=false;
        do{
            try {
                System.out.println(cadena);
                System.out.println(ejer5Otro(new int [] {2,3,4,6,7}, 1) );
                salida=true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No puede salir por esa posicion del array");
            }catch(RuntimeException e){
                System.out.println("Surgio un erros durante la ejecucion: " + e.getMessage());
                System.out.println("Debes inicializar su cadena");
                cadena=datos.next();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(!salida);
        
    }
        
    static void ejer6(){
        int edad=0;
        String nombre="";
        boolean salida=false;
        do{    
            try {
                System.out.println("Introduce tu nombre");
                nombre=datos.next();
                validarNombre(nombre);
                edad=datos.nextInt();
                validarEdad(edad);

            } catch (InvalidNameException e) {
                System.out.println("No es valido ya que has usado un caracter illegal"
                        + "\n " + e.getMessage());

            }catch(InvalidAgeException e){
                System.out.println(e.getMessage());
            }     
        }while(!salida);
        
        if (edad<18) {
            System.out.println("Eres menor de edad y te llamas " + nombre);
        }else if((edad>=18) || (edad<=65)){
            System.out.println("Eres mayor de edad");
        }else if(edad>65){
            System.out.println("Estas en la tercera edad");
        }
                
    }
    static void ejer7(){
        int edad=0;
        String nombre="";
        boolean salida=false;
        do {
            try {
                System.out.println("Introduce tu nombre");
                nombre=datos.next();
                validarNombre(nombre);
                edad=datos.nextInt();
                validarEdad(edad);

            } catch (InvalidNameException e) {
                System.out.println("No es valido ya que has usado un caracter illegal"
                        + "\n " + e.getMessage());

            }catch(InvalidAgeException e){
                System.out.println(e.getMessage());

            }
        } while (!salida);
    
            
        if (edad<18) {
            System.out.println("Eres menor de edad y te llamas " + nombre);
        }
        
    }
    static void validarNombre(String nombre) throws InvalidNameException{
        for (int i = 0; i < nombre.length(); i++) {
            if (((int) nombre.charAt(i)>=65 && (int) nombre.charAt(i)<=90) || ((int) nombre.charAt(i)>=97 && (int) nombre.charAt(i)<=122)) {
                
            }else{
                throw new InvalidNameException("El caracter " + nombre.charAt(i) + " es ilegal");
            }
            
        }
    }
    
    static void validarEdad(int edad) throws InvalidAgeException{
        if (edad<0 || edad>120) {
            throw new InvalidAgeException("Esa edad es imposible.... " + edad + "????" );
        }
    }
    
    
    static int ejer5Otro(int[] cadena, int posicion) throws ArrayIndexOutOfBoundsException{
        return cadena[posicion];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //ejerc1();
        //ejerc2();
        //ejer3Y4();
        //ejer3Y4();
        //String cadena;
        //ejer5(cadena);
        MediaNotas.mediaNotas();
        
        //MiArrayCopiador prueba=new MiArrayCopiador(5);
        
        //prueba.coiparArray(new int []{3,4,5,6,7,8,9,7,6,5,3});
    }
    
}
