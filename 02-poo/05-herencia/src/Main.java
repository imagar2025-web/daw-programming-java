package ejemplosherencia;


public class EjemplosHerencia {

   
    public static void main(String[] args) {
        //Vamos a crear un animal, Sólo puede acceder a los métodos de ANIMAL, no a los del GATO
        Animal miAnimal=new Animal(1, 25, "Canne", "Marrón", true, "Carnivoro");
        miAnimal.comer();
        miAnimal.dormir();
        miAnimal.necesidades();
        System.out.println("Creamos un Gato");
        //Vamos a crear un Gato, lo debo hacer como si Gato fuera una clase normal, lo especial
        //lo hemos hecho dentro de su clase, en el main no hago nada especial
        Gato miGato=new Gato("Siames", "normal", true, true, 0.40, 8, "Gatunus comnunis", "Gris", true, "omnivoro");
        //El Gato puede usar todos los métodos de la clase Animal y además puede usar los métodos
        //específicos de la clase Gato
        miGato.comer();
        miGato.dormir();
        miGato.necesidades();
        miGato.cazarInsectos();
        miGato.maullar();
        miGato.ronronear();
    }

}
