
package ejemplosherencia;

public class Perro extends Animal{
    private boolean ladrador;
    private boolean mordedor;
    private String raza;

    public Perro(boolean ladrador, boolean mordedor, String raza, boolean pelaje) {
        super(pelaje);
        this.ladrador = ladrador;
        this.mordedor = mordedor;
        this.raza = raza;
    }

    public Perro(boolean ladrador, boolean mordedor, String raza, double altura, double peso, String nombreCientifico, String color, boolean pelaje, String tipoAlimentacion) {
        super(altura, peso, nombreCientifico, color, pelaje, tipoAlimentacion);
        this.ladrador = ladrador;
        this.mordedor = mordedor;
        this.raza = raza;
    }
    
    
    public void ladrar(){
        if (ladrador) {
            System.out.println("Ladrar");
        }
    }
    
    public void jugar(){
        System.out.println("Estoy jugando");
    }
}
