package clasesabstractas;

public class Libro extends Producto{
    private int fechaPublicacion;
    private String titulo;

    public Libro(int fechaPublicacion, String titulo, double precioNormal, String calidad) {
        super(precioNormal, calidad);
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
    }

    

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public double precioConDescuento(int descuento) {
        return this.getPrecioNormal()*((((double)descuento)/100)-100);
    }
    
}
