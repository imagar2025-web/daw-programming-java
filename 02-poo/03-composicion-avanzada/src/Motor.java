
package EjercicioGaraje;

public class Motor {
    private int litrosAcite;
    private int CV;

    public Motor(int CV) {
        this.litrosAcite = 0;
        this.CV = CV;
    }

    public int getLitrosAcite() {
        return litrosAcite;
    }

    public void setLitrosAcite(int litrosAcite) {
        this.litrosAcite = litrosAcite;
    }

    public int getCV() {
        return CV;
    }

    public void setCV(int CV) {
        this.CV = CV;
    }
    
    
    
}

