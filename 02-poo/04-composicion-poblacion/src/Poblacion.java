package ejemplodecomposicion;

import java.util.Scanner;

public class Poblacion {
    private Scanner datos=new Scanner(System.in);
    private String nombrePoblacion;
    private String codigoPostal;
    private String pais;
    //Uso un array de Ciudadanos como atributo sin problemas
    private Ciudadano [] losCiudadanos;
    
    public Poblacion(String nombrePoblacion, String codigoPostal, String pais){
        this.nombrePoblacion=nombrePoblacion;
        this.codigoPostal=codigoPostal;
        this.pais=pais;
        //En este momento en cada casilla del array null
        this.losCiudadanos = new Ciudadano[15];
    }
    
    //Sobrecarga del constructor
    public Poblacion(String nombrePoblacion, String codigoPostal, String pais, Ciudadano[] losCiudadanos){
        //Llama al otro constructor sobrecargado
        this(nombrePoblacion, codigoPostal, pais);
        this.losCiudadanos=losCiudadanos;
    }
    
    public void añadirCiudadano(Ciudadano elCiudadano){
        boolean añadido=false;
        for(int x=0; x<this.losCiudadanos.length;x++){
            if (this.losCiudadanos[x]==null){
               //Encuentro un ciudadano "vacio" y añado el pasado por parametro
               this.losCiudadanos[x]=elCiudadano;
               añadido=true;
               break;
            }
        }
        if (añadido==true){
            System.out.println("Se ha censado un nuevo ciudadano");
            System.out.println("Sus datos son:");
            System.out.println(elCiudadano.toString());
        }
        else
            System.out.println("No cabe nadie en la ciudad");
    }
    
    public void añadirCiudadano(){
        boolean añadible=false;
        int posicionCensable=0;
        for(int x=0; x<this.losCiudadanos.length;x++){
            if (this.losCiudadanos[x]==null){
               //Encuentro un ciudadano "vacio" y añado el pasado por parametro
               añadible=true;
               break;
            }else posicionCensable++;
        }
        if (añadible) {
            System.out.println("Introduzzca los valores para instanciar a su nuevo ciudadano en su población");
            System.out.println("DNI: ");
            String dni=datos.next();
            System.out.println("Nombre y apellidos:");
            String nombreCompleto=datos.nextLine();
            System.out.println("La edad de su ciudadano");
            int edad=datos.nextInt();
            System.out.println("Localidad:");
            String localidad=datos.next();
            this.losCiudadanos[posicionCensable]=new Ciudadano(dni, nombreCompleto, edad, localidad);
            System.out.println("Sus datos son:");
            System.out.println(this.losCiudadanos[posicionCensable].toString());
        }else   System.out.println("no cabe nadie más en la población");
    }
    
   /* public void mostrarCiudadanos(){
        System.out.println("Los ciudadanos de esta poblacion son:");
        for(Ciudadano ciudadanoActual : this.losCiudadanos){
            if(ciudadanoActual!=null){
                System.out.println("Ciudadano:");
                System.out.println("---------");
                System.out.println(ciudadanoActual.toString());
            }
        }
    }*/
    
    public void mostrarCiudadanos(){
        for (int i = 0; i < losCiudadanos.length; i++) {
            if (losCiudadanos[i]!=null) {
               System.out.println("Ciudadano:");
               System.out.println("---------");
               System.out.println(losCiudadanos[i].toString()); 
            }else{
                break;
            }
        }
    }
    
    //Sobrecargar el metodo añadir ciudadano para que funcione sin paramentros
    

    /**
     * @return the nombrePoblacion
     */
    public String getNombrePoblacion() {
        return nombrePoblacion;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @return the losCiudadanos
     */
    public Ciudadano[] getLosCiudadanos() {
        return losCiudadanos;
    }
    
        
    
}
