
import java.io.Serializable;
import java.util.Scanner;

public class Contacto implements Serializable {

    private String nombre, apellidos, correo;
    private int edad, teléfono;

    public Contacto(String nombre, String apellidos) {
        Scanner datos = new Scanner(System.in);
        this.nombre = nombre;
        this.apellidos = apellidos;
        String nombreCompleto = nombre + " " + apellidos;
        boolean salida=false;
        do {
            try {
                datos = new Scanner(System.in);
                System.out.println("Introducca el numero de telefono del contacto de " + nombreCompleto);
                this.teléfono = datos.nextInt();
                System.out.println("Introducca el correo de contacto");
                this.correo=datos.next();
                while (!correo.contains("@")) {
                    System.out.println("no se identifica como un correo  electronico,vuelva a introducirlo");
                    this.correo=datos.next();
                }
                System.out.println("Introducca la edad del contacto");
                this.edad=datos.nextInt();
                System.out.println("El contacto se ha creado correctamente");
                salida=true;
            } catch (Exception e) {
                System.out.println("Hubo un error al introducir el contacto, vuelva a ingresar los siguientes campos (telefono,correo y edad)");
            }
        } while (!salida);

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    @Override
    public String toString() {
        return "Nombre=" + nombre + "\nApellidos=" + apellidos + "\nCorreo=" + correo + "\nEdad=" + edad + "\nTelefono=" + teléfono;
    }
    
    

}
