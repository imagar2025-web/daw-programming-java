package ejemplodecomposicion;

public class EjemploDeComposicion {

    
    public static void main(String[] args) {
        Ciudadano c1 = new Ciudadano("13245", "Pepito Grillo", 150, "Fantasia");
        Ciudadano c2 = new Ciudadano("34567", "Peter Pan", 120, "Fantasia");
        Ciudadano c3 = new Ciudadano("46780", "Son goku", 38, "fantasia");
        Poblacion fantasia = new Poblacion("Fantasía", "*****", "Nunca Jamás");
        fantasia.añadirCiudadano(c1);
        fantasia.añadirCiudadano(c2);
        fantasia.añadirCiudadano(c3);
        //fantasia.mostrarCiudadanos();
        //Desde fantasia llamo al get que me devuelve el array de Ciudadanos
        //una vez lo tengo, accedo a su posicion 0 y una vez la tengo
        //(el primer ciudadano), llamo al método de Ciudadanos que me 
        //devuelve el nombre
        System.out.println(fantasia.getLosCiudadanos()[0].getNombreApellidos());
        
        
        Poblacion [] misPoblaciones={fantasia};
        System.out.println(misPoblaciones[0].getLosCiudadanos()[0].getDni());
    
}   
    
    
}
