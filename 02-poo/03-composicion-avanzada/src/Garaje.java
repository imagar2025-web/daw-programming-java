
package EjercicioGaraje;

public class Garaje {
    private Coche miCoche;
    private String averiaAsociada;
    private int nAtendidos;

    public Garaje() {
        this.miCoche = null;
        this.averiaAsociada = null;
        this.nAtendidos = 0;
    }

    public boolean cocheAtendible(){
        return miCoche==null;
    }
    
    public  void atenderCoche(String averia, Coche elcoche){
        if (cocheAtendible()) {
            setAveriaAsociada(averia);
            setMiCoche(elcoche);
        }else  {
            System.out.println("El garaje está lleno  su vehiculo no puede ser acptado en este momento");
        }
    }
    
    public void devolverCoche(){
        if (!cocheAtendible()) {
            System.out.println("Aqui tiene su vehiculo");
            setMiCoche(null);
            setAveriaAsociada(null);
        }else   System.out.println("No habia ninun coche en el  taller en estos momentos");
    }

    public Coche getMiCoche() {
        return miCoche;
    }

    public void setMiCoche(Coche miCoche) {
        this.miCoche = miCoche;
    }

    public String getAveriaAsociada() {
        return averiaAsociada;
    }

    public void setAveriaAsociada(String averiaAsociada) {
        this.averiaAsociada = averiaAsociada;
    }

    public int getnAtendidos() {
        return nAtendidos;
    }
    
    
    
    
    
    
}
