
package ejemplosherencia;

//Para indicar que un Gato es hijo de una animal usamos la palabra EXTENDS
public class Gato extends Animal{
    //Vamos a definir los atributos propios de los Gatos, teniendo en cuenta
    //que han heredado todos los atributos de Animal
    private String razaGatuna;
    private String tipoMaullido;
    private boolean soyAdorable;
    private boolean soyTravieso;
    
    
    //Necesitamos como siempre un método constructor que debe llamar SIEMPRE
    //como primera línea al constructor de la clase madre, se hace usando el método
    //super()
    public Gato(String razaGatuna, String tipoMaullido, boolean soyAdorable, boolean soyTravieso, double altura, double peso, String nombreCientifico, String color, boolean pelaje, String tipoAlimentacion) {
        super(altura, peso, nombreCientifico, color, pelaje, tipoAlimentacion);
        this.razaGatuna = razaGatuna;
        this.tipoMaullido = tipoMaullido;
        this.soyAdorable = soyAdorable;
        this.soyTravieso = soyTravieso;
    }

    public Gato(String razaGatuna, String tipoMaullido, boolean soyAdorable, boolean soyTravieso, boolean pelaje) {
        super(pelaje);
        this.razaGatuna = razaGatuna;
        this.tipoMaullido = tipoMaullido;
        this.soyAdorable = soyAdorable;
        this.soyTravieso = soyTravieso;
    }
    
    //Ahora hacemos los métodos típico de la clase Gato
    public void maullar(){
        System.out.println("MIAUUuuuUUUuuUUU");
    }
    
    public void cazarInsectos(){
        System.out.println("Mira que cucarachita, se la llevaré a la cama a mi amo");
    }
    
    public void ronronear(){
        System.out.println("grgrgrgrgrrrggrrr");
    }
    
   
}
