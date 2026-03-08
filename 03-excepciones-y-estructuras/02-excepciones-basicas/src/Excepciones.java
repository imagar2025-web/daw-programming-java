
package excepciones;

public class Excepciones {
    public static void Hola(int a, int b) throws Exception{
        try {
            if(b==0){
                throw new MiExcepcion("Peto");
            }
        } catch (MiExcepcion e) {
        }
    }
    
    public static void main(String[] args) {
        try {
            int resuktado= 10/0;
        } catch (Exception e) {
            System.out.println("No se puede dividir");
            
        }finally{
            System.out.println("Aprende a dividir bien");
        }
    }
    
}
