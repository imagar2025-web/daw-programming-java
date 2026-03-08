
package EjerciciosHerencia;


public class App {
    
    public static void main(String[] args) {
        Multimedia verdadero= new Multimedia("asas", "sdf", 3434, "dvd");
        Multimedia m1=new Disco("rock", "la casa de pael", "mago de oz", 23.23, "mp3");
        
        Multimedia [] arrayMulti={verdadero,m1};
        //Para evitar este problema podemos usar la palbra reservada de instanceof
        for (Multimedia multimedia : arrayMulti) {
            if (multimedia instanceof Disco) {
                System.out.println(((Disco)multimedia));
            }
            
        }
    }
    
}
