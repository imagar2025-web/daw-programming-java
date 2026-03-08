
package ejemplodecomposicionsencilla;

public class Motor {
    private int cilindrada;
    private String tipo;
    private int cv;
    private String tipoCombustible;
    private int maxSpeed;
    private boolean nivelAceiteCorrecto;
    private double cantKM;

    public Motor(int cilindrada, String tipo, int cv, String tipoCombustible, int maxSpeed) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
        this.cv = cv;
        this.tipoCombustible = tipoCombustible;
        this.maxSpeed = maxSpeed;
        this.nivelAceiteCorrecto=true;
        this.cantKM=0;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCv() {
        return cv;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public boolean getNivelAceiteCorrecto(){
        return this.nivelAceiteCorrecto;
    }

    public boolean isNivelAceiteCorrecto() {
        return nivelAceiteCorrecto;
    }

    public double getCantKM() {
        return cantKM;
    }
    
    public void revisarMotor(){
        System.out.println("Todo esta bien, haz revisiones periodicas");
    }
    
    public void aumKM(int cantidadKM){
        this.cantKM+= cantidadKM;
    }
}
