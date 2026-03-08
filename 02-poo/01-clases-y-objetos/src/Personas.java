
package ejerciciosdeclase1;
public class Personas {
    private String nombre;
    private int edad;
    private double altura;
    private double peso;
    
    public Personas(String nombre, int edad, double altura, double peso){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
        this.peso=peso;
    }
    
    public void comer(String comida){
        System.out.println("Que rica esta la comida");
    }
    
    public void respirar(int nRespiraciones){
        for (int i = 0; i < nRespiraciones; i++) {
            if (nRespiraciones%2==0) {
                System.out.println("Inhalar");
            }else System.out.println("Exhalar");
        }
    }
    
    public String rangoEdad(){
        if (this.edad>=0 && this.edad<=17) {
            return "Niño";
        }else if(this.edad>=18 && this.edad<=69){
            return "Adulto";
        }else if(this.edad>=70 && this.edad<=110){
            return "Anciano";
        }
        return null;
    }
    
    public int getEdad(){
        return this.edad;
    }
}
