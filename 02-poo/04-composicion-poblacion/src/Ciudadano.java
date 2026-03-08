package ejemplodecomposicion;

public class Ciudadano {

    
    
    //Declarar los atributos de Ciudadano
    private final String dni;
    private String nombreApellidos;
    private int edad;
    private String localidad;
    
    public Ciudadano(String dni, String nombreApellidos, int edad, String localidad){
        this.dni=dni;
        this.nombreApellidos=nombreApellidos;
        this.edad=edad;
        this.localidad=localidad;
    }
    
    public void cumplirAños(){
        this.edad++;
    }
    
    @Override
    public String toString(){
        return "El Ciudadano se llama "+ this.nombreApellidos +
                "\nSu DNI es: " + this.dni + "\nVive en la localidad de " +
                this.localidad + "\nY tiene " + this.edad +" años";
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return the nombreApellidos
     */
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }
   
    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
    
}
