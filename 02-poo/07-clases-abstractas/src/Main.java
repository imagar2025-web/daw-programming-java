
package clasesabstractas;


        
public class ClasesAbstractas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto [] misProductos={new MP3("rojo", "china", 100.98, "Premiun"),new TV(27, "Francia", 500, "Baja"),new Libro(2018, "La china de la nive", 10, "Superior")};
        
        for (Producto actual : misProductos) {
            actual.getCalidad();
            actual.mostrarAtributos();
            actual.getPrecioNormal();
            actual.precioConDescuento(30);
            if(actual instanceof ProductoElectronico){
                ((ProductoElectronico) actual).getMadeIn();
                ((ProductoElectronico) actual).tiempoGarantia();
            }
            if(actual instanceof Libro){
                ((Libro)actual).getFechaPublicacion();
                ((Libro)actual).getTitulo();
            }
        }
    }
    
}
