/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawcicle;

/**
 *
 * @author daw1
 */
import java.util.Scanner;
public class Bicicleta extends ProductosBici{
    private Scanner entrada=new Scanner(System.in);
    private String marca,tipo;
    private String[] tiposBici;

    public Bicicleta() {
        super();
        tiposBici=new String[]{"mont","paseo","carretera"};
        boolean salida=false;
        do {
            try {
                entrada=new Scanner(System.in);
                System.out.println("Introduzca la marca de su bici");
                this.marca=entrada.nextLine();
                if (marca.length()==0) {
                    throw new MiExcepcion("Has introducido una cadena vacia");
                }
                System.out.println("Estos son los tipo de bici que existen en la tienda.");
                for (int i = 0; i < tiposBici.length; i++) {
                    System.out.println(tiposBici[i]);
                }
                System.out.println("Elija una para continuar");
                entrada=new Scanner(System.in);
                tipo=entrada.next();
                if (tipo.length()==0) {
                    throw new MiExcepcion("Has introducido una cadena vacia");
                }
                for (int i = 0; i < tiposBici.length; i++) {
                    if (tiposBici[i].equalsIgnoreCase(tipo)) {
                        salida=true;
                    }
                }
                if (!salida) {
                    throw new MiExcepcion("No has puesto ningun tipo de bici permitido");
                }
                
            } catch (MiExcepcion e) {
                System.out.println("Debe de volver a introducir los datos debido a " + e.getMessage());
            }catch(Exception e){
                System.out.println("Ocurrio un error inesperado, vuelva a introducir los datos");
            }
        } while (!salida);
    }
    @Override
    public String infoProducto(){
        return super.infoProducto()+"\nMarca "+this.marca+"\nTipo "+this.tipo;
    }
    
    public boolean comprarBici(){
        return comprarProducto(1);
    }
    
    
    
}
