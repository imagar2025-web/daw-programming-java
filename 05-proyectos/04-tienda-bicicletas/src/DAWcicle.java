/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dawcicle;

/**
 *
 * @author daw1
 */
import java.util.Scanner;
public class DAWcicle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner datos=new Scanner(System.in);
        System.out.println("Bienvenido a la aplicacion de DAWcicle");
        boolean menu=false;
        SitemaDAWcicleta s1= new SitemaDAWcicleta();
        do {
            datos=new Scanner(System.in);
            System.out.println("Elija que quiere hacer:\nInsertar producto(1)\nComprar producto(2)\nVer productos(3)\nSalir(4)");
            try {
                int opcion=datos.nextInt();
                switch (opcion) {
                    case 1 -> {
                        s1.insertarProducto();
                    }
                    case 2 -> {
                        if(s1.comprar()){
                            System.out.println("Se ha vendido el producto");
                        }
                    }
                    case 3 -> {
                        s1.verProductos();
                    }
                    case 4 -> {
                        menu=true;
                        System.out.println("Gracias por usar el programa");
                    }
                    default -> throw new MiExcepcion("Has introducido una opcion no valida");
                }
            } catch (MiExcepcion e) {
                System.out.println("Vuelva a introducir la opcion, " + e.getMessage());
            }catch(Exception e){
                System.out.println("Ocurrio algo inesperado vuelva a seleccionar una opccion");
            }   
        } while (!menu);
    }
    
}
