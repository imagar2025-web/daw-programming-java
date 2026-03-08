/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesabstractas;

/**
 *
 * @author zeus0
 */
public abstract class ProductoElectronico extends Producto{
    private String madeIn;

    public ProductoElectronico(String madeIn, double precioNormal, String calidad) {
        super(precioNormal, calidad);
        this.madeIn = madeIn;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public abstract int tiempoGarantia();
}
