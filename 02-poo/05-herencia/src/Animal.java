package ejemplosherencia;

//La clase que usaremos como madre, no necesita tener nada especial

import java.util.Scanner;

//se define como cualquier otra clase que hayamos usado hasta ahora
//ESO SI-> Debemos pensar que todos los hijos que tenga deben heredar sus 
//atributos y mñetodos. Aquí ponemos generalidadeds a todos los animales.
public class Animal {
    //Este Scanner estará disponible en todas las clases hijas.
    private Scanner datos=new Scanner (System.in);
    //Estos atributos son comunes a TODOS los animales.
    private double altura;
    private double peso;
    private String nombreCientifico;
    private String color;
    private boolean pelaje;
    private String tipoAlimentacion;
    
    //Como siempre nuestra clase madre necesita de un método constructor
    public Animal(double altura, double peso, String nombreCientifico, String color, boolean pelaje, String tipoAlimentacion) {
        this.altura = altura;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
        this.color = color;
        this.pelaje = pelaje;
        this.tipoAlimentacion = tipoAlimentacion;
    }
    //Podemos sobrecargar el constructor y los dos constructores estarán 
    //disponibles en la clase hija
    public Animal(boolean pelaje){
        System.out.println("Introduce la altura del animal");
        this.altura=this.datos.nextDouble();
        System.out.println("Introduce el peso del animal");
        this.peso=datos.nextDouble();
        System.out.println("Introduce el color del animal");
        this.color=datos.nextLine();
        System.out.println("Introduce el nombre científico del animal");
        this.nombreCientifico=datos.nextLine();
        System.out.println("Introduce la almentación");
        this.tipoAlimentacion=datos.nextLine();
        this.pelaje=pelaje;
    }
    
    //Vamos a hacer los métodos que tiene el animal
    public void comer(){
        if(this.tipoAlimentacion.equalsIgnoreCase("Hervivoro"))
            System.out.println("Mmmm que rica la hierva");
        else if (this.tipoAlimentacion.equalsIgnoreCase("Omnivoro"))
            System.out.println("Como carne, verduras y pescado!!!");
        else if(this.tipoAlimentacion.equalsIgnoreCase("Carnivoro"))
            System.out.println("A mi dame vaca!");
        else
            System.out.println("Me alimento de cosas que no te gustarían");
    }
    
    public void dormir(){
        System.out.println("ZzzzZzzzzZZZzzz");
    }
    
    public void necesidades(){
        System.out.println("Uuffff, que alivio...");
    }
    
}
