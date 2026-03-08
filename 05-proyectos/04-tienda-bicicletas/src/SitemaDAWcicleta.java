/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawcicle;

/**
 *
 * @author daw1
 */
import java.util.ArrayList;
import java.util.Scanner;
public class SitemaDAWcicleta {
    Scanner entrada=new Scanner(System.in);
    private int [] descuentoPosible;
    private String [] tiposCompradosDescuen;
    private ArrayList<ProductosBici> productos;
    private ArrayList<ProductosBici> comprados;

    public SitemaDAWcicleta() {
        productos=new ArrayList<>();
        comprados=new ArrayList<>();
        tiposCompradosDescuen=new String[] {"Bici","Mejora","Reparacion","Entrenamiento"};
        descuentoPosible=new int[] {0,0,0,0};
    }
    
    public void insertarProducto(){
        boolean salida=false;
        ProductosBici axu;
        do {
            try {
                entrada=new Scanner(System.in);
                System.out.println("Que tipo de producto quiere insertar\nBici(1):\nArticulo(2)");
                int opcion=entrada.nextInt();
                switch (opcion) {
                    case 1 -> axu=new Bicicleta();
                    case 2 -> axu=new ArticuloVendible();
                    default -> throw new MiExcepcion("No has elegido una opcion valida");
                }
                if (!productos.isEmpty()) {
                    for (int i = 0; i < productos.size(); i++) {
                        if (productos.get(i).getNumSerie()==axu.getNumSerie()) {
                            throw new MiExcepcion("Has introducido un numero de serie duplicado");
                        }
                    }
                } 
                salida=insertarProducto(axu);
            } catch (MiExcepcion e) {
                System.out.println("Vuelva a introducir el tipo de producto: " + e.getMessage());
            }catch(Exception e){
                System.out.println("Ocurrio algo inesperado");
            }
        } while (!salida);
    }
    
    private boolean insertarProducto(ProductosBici axu){
        if (productos.isEmpty()) {
            productos.add(axu);
                    return true;
        }else{
            for (int i = 0; i < productos.size(); i++) {
                if (axu.getPrecio()<productos.get(i).getPrecio()) {
                    productos.add(i, axu);
                    return true;
                }
            }
            productos.add(axu);
            return true;
        }       
    }
    
    public void verProductos(){
        System.out.println("Productos:\n");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).infoProducto());
            
        }System.out.println("-------------------------");
    
    }
    
    public boolean comprar(){
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).setPrecio(productos.get(i).getPrecio());
            
        }
        int indiceProducto=0;
        boolean compra=false;
        try {
            
            boolean encontrado=false;
            System.out.println("Introduzca el nombre del articulo");
            String buscar=entrada.next();
            for (int i = 0; i < productos.size(); i++) {
                if (buscar.equalsIgnoreCase(productos.get(i).getNombre())) {
                    encontrado=true;
                    indiceProducto=i;
                }
            }
            if (encontrado) {
                System.out.println("Selecciones la cantidad del producto que quie, si es una bicicleta solo podra comprar una si es posible");
                int cant=entrada.nextInt();
                if (productos.get(indiceProducto) instanceof Bicicleta) {
                    if (cant>1) {
                        throw new MiExcepcion("No puedes comprar mas de una bicleta");
                    }else if(cant==1 && productos.get(indiceProducto).comprarProducto(cant)){
                        compra=true;
                        comprados.add(productos.get(indiceProducto));
                    }else throw  new MiExcepcion("No puedes comprar "+cant+" bicis");
                }else{
                    if (productos.get(indiceProducto).comprarProducto(cant)) {
                        compra=true;
                    }
                }
            }
        } catch (MiExcepcion e) {
            System.out.println("Error a la hora de la compra " +e.getMessage());
        }catch (Exception e){
            System.out.println("Ocurrio algo inesperado");
        }
        bajadaPrecios();
        return compra;
        
    }
    
    public void bajadaPrecios(){
        
        for (int i = 0; i < descuentoPosible.length; i++) {
            for (int j = 0; j < comprados.size(); j++) {
            if (comprados.get(j) instanceof Bicicleta && i==0) {
                descuentoPosible[i]++;
            }else if(tiposCompradosDescuen[i].equalsIgnoreCase(((ArticuloVendible)comprados.get(i)).getCategory()) && (comprados.get(i) instanceof ArticuloVendible)){
                descuentoPosible[i]++;
            }
        }
        }
        for (int i = 0; i < descuentoPosible.length; i++) {
            int j = descuentoPosible[i];
            
        }
        if (aplicarDescuento()>0) {
            System.out.println("Se han aplicado descuentos a las categoria/s categorias:\n");
            for (int i = 0; i < descuentoPosible.length; i++) {
                if (descuentoPosible[i]>=3) {
                    System.out.println(tiposCompradosDescuen[i]+"\n");
                }
                 
            }
        }
        
    }
    
    private int aplicarDescuento(){
        int descuentosAplicados=0;
        for (int i = 0; i < descuentoPosible.length; i++) {
            if (descuentoPosible[i]==3) {
                for (int j = 0; j < productos.size(); j++) {
                    if (productos.get(j) instanceof Bicicleta && i ==0) {
                        productos.get(j).setPrecio(productos.get(j).getPrecioDesc());
                        descuentosAplicados++;
                    }else if (tiposCompradosDescuen[i].equalsIgnoreCase(((ArticuloVendible)productos.get(j)).getCategory()) && productos.get(j) instanceof ArticuloVendible) {
                        productos.get(j).setPrecio(productos.get(j).getPrecioDesc());
                        descuentosAplicados++;
                    }    
                }
                
            }
            
        }
        return descuentosAplicados;
    }
}
    



