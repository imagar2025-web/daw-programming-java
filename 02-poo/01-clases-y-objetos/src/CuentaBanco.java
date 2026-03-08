
package ejerciciosdeclase1;

public class CuentaBanco {
    private String nombre;
    private double saldoActual;
    
    public CuentaBanco(String nombre,double saldoActual){
        this.nombre=nombre;
        this.saldoActual=saldoActual;
    }
    
    public int sacarDinero(int dineroDeseado){
        if (saldoActual-(double) dineroDeseado>=0) {
            saldoActual=saldoActual-(double)dineroDeseado;
            return dineroDeseado;
        }else{
            System.out.println("No tienes dinero suficiente en la cuenta del banco");
            return 0;
        }
    }
    
    public void ingresarDinero(int dineroIngresado){
        if(dineroIngresado>0)
            saldoActual=saldoActual+dineroIngresado;
    }
    
    public double getSaldoActual(){
        return saldoActual;
    }
    
    public boolean pedirPrestamo(){
        return saldoActual>10000;
    }
}
