
package ejerciciosdeclase1;

public class EjerciciosDeClase1 {

    public static void main(String[] args) {
        System.out.println("------- COCHES -------");
        Coches coche1=new Coches("Seat", "Leon", 2000, "Rojo", 90);
        Coches coche2=new Coches("BMV", "Q3", 2015, "Blanco", 120);
        
        coche2.compararCoches(coche1);
        System.out.println("El año del coche es " + coche2.getAño());
        
        System.out.println("------- CUENTA DE BANCO -------");
        CuentaBanco cuenta1=new CuentaBanco("Paco", 100000);
        cuenta1.pedirPrestamo();
        cuenta1.getSaldoActual();
        cuenta1.ingresarDinero(1000);
        
        System.out.println("------- LIBROS -------");
        Libro libro1=new Libro();
        Libro libro2=new Libro();
        
        libro1.compararAutores(libro2);
        libro2.prestarLibro();
        libro2.prestarLibro();
        libro2.devovelerLibro();
        
        
        
    }
    
    
    
}
