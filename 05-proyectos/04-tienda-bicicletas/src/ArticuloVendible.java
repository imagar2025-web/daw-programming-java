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
public class ArticuloVendible extends ProductosBici{
    private Scanner entrada=new Scanner(System.in);
    private String category;
    private boolean pedirProducto;
    private String[] miscateg;

    public ArticuloVendible() {
        super();
        this.pedirProducto=false;
        this.miscateg=new String[]{"Reparacion","Mejora","Entrenamiento"};
        boolean salida=false;
        
        do {
            entrada=new Scanner(System.in);
            try {
                System.out.println("Estas son las categorias disponibles:");
                for (int i = 0; i < miscateg.length; i++) {
                    System.out.println(miscateg[i]);
                    
                }
                System.out.println("Introduce la categoria de tu producto");
                this.category=entrada.next();
                for (int i = 0; i < miscateg.length; i++) {
                    if (this.category.equalsIgnoreCase(this.miscateg[i])) {
                        salida=true;
                    }
                }
                if (!salida) {
                    throw new MiExcepcion(this.category+" No es una categoria valida, vuelva a introducirla");
                }
                salida=true;
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Ocurrio algo inesperado, vuelva a introducirlo");
            }
        } while (!salida);
    
    }
    
    public void pedirProducto(){
        if (super.getUnidades()==0) {
            this.pedirProducto=true;
        }
    }
    
    @Override
    public String infoProducto(){
        String info=super.infoProducto()+"\nCategoria "+this.category+"\nPedir: ";
        if (pedirProducto) {
            info+="No se puede pedir";
        }else{
            info+="Si se puede pedir";
        }
        return info;
    }

    public String getCategory() {
        return category;
    }
    
    
    
}
