
package pruebaexamen;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class Usuarios1 {
    private String nombre;
    private String apellido;
    private String DNI;
    private String password;

    public Usuarios1() {
        boolean salida=false;
        do {
            try {
                Sistema.datos=new Scanner(System.in);
                System.out.println("Introduzca su nombre");
                this.nombre=Sistema.datos.next();
                System.out.println("Introduzca su apellido");
                this.apellido=Sistema.datos.next();
                System.out.println("Introduzca su DNI");
                this.DNI=Sistema.datos.next();
                for (int i = 0; i < 8; i++) {
                    int numeroRamdon=((int)Math.random()*10);
                    this.password=this.password+numeroRamdon;
                    
                }
                System.out.println("Esta es su contraseña " + password);
            } catch (Exception e) {
                System.out.println("Error: vuelva a introducir sus datos"+e.getMessage());
            }
        } while (!salida);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    
}
    


