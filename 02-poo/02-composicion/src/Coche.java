
package ejemplodecomposicionsencilla;

public class Coche {
    private String marca;
    private String modelo;
    private int numplazas;
    private String color;
    
    //Quiero tener datos referentes al tipo de motor de este coche 
    //Para eso vamos a crear un tipo de dato (Objeto) llamado Motor
    private Motor elMotorDelCoche;

    
    public Coche(String marca, String modelo, int numplazas, String color, Motor elMotorDelCoche) {
        this.marca = marca;
        this.modelo = modelo;
        this.numplazas = numplazas;
        this.color = color;
        this.elMotorDelCoche = elMotorDelCoche;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNumplazas() {
        return numplazas;
    }

    public String getColor() {
        return color;
    }

    public Motor getElMotorDelCoche() {
        return elMotorDelCoche;
    }
    
    public void conducirCoche(int cantidadKm){
        this.elMotorDelCoche.aumKM(cantidadKm);
    }
    
    
}
