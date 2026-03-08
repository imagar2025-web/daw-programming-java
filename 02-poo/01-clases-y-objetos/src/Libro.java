
package ejerciciosdeclase1;

import java.util.Scanner;

public class Libro {
    public Scanner datos=new Scanner(System.in);
    private String titulo,autor,genero;
    private int añoPublicado;
    private boolean prestado;
    private String [] generosPosibles={"aventuras", "ciencia", "romance", 
        "etica","religion", "historia", "programacion"};
    public Libro(){
        System.out.println("Introducca los datos de su nuevo libro \n Titutlo:");
        this.titulo=datos.nextLine();
        System.out.println("Autor");
        this.autor=datos.nextLine();
        System.out.print("Ahora seleccione uno de estos generos: ");
        for (int i = 0; i < generosPosibles.length; i++) {
            System.out.print(generosPosibles[i]+", ");
        }
        System.out.println("");
        boolean salidaGeneros=false;
        do {    
            this.genero=datos.next();
            for (int i = 0; i < generosPosibles.length; i++) {
                if (this.genero.equals(generosPosibles[i])) {
                    salidaGeneros=true;
                }
            }
            if(!salidaGeneros){
                System.out.println("No has introducido ningun genero válido, "
                        + "vuelvalo a intentar con uno de los generos posibles");
            }
        } while (!salidaGeneros);
        System.out.println("Año de publicacion");
        boolean salidaAñoPublicado=false;
        do {            
            añoPublicado=datos.nextInt();
            if (añoPublicado<1450 || añoPublicado>2024) {
                System.out.println("Has una fecha imaginaria");
            }else salidaAñoPublicado=true;
        } while (!salidaAñoPublicado);
        prestado=false;
    }
    public void prestarLibro(){
        if (!prestado) {
            System.out.println("Aquí tienes tu libro");
            prestado=true;
        }else {
            System.out.println("lo siento mucho este libro ya a sido prestado;");
        }
    }
    
    public void devovelerLibro(){
        if (prestado) {
            System.out.println("Gracias por devolver el libro");
            prestado=false;
        }else{
            System.out.println("Ese libro no ha sido prestado");
        }
    }
    
    public boolean compararAutores(Libro otroAutor){
        return this.autor.equalsIgnoreCase(otroAutor.autor);
    }
}
