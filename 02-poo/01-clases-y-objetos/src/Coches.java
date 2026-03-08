
package ejerciciosdeclase1;

public class Coches {
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private int CV;
    
    public Coches(String marca, String modelo, int año, String color, int CV){
        this.marca=marca;
        this.modelo=modelo;
        this.año=año;
        this.color=color;
        this.CV=CV;
    }
    
    public void setColor(String otroColor){
        this.color=otroColor;
    }
    
    public int getAño(){
        return this.año;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCV() {
        return CV;
    }
    
    
    public void compararCoches(Coches otroCoche){
        if (this.CV>otroCoche.CV) {
            System.out.println("El " + this.getModelo() + " es más rapido que " + otroCoche.modelo);
        }else if(this.CV<otroCoche.CV){
            System.out.println("El " + otroCoche + " es más rapido que " + this);
        }else{
            System.out.println("Ambos coches tiene la misma velocidad");
        }
    }
    
}
