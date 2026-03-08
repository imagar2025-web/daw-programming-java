/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExplicacionClase;

/**
 *
 * @author daw1
 */

//Se emplea la pañabra publica interface
public interface Vehiculo {
    //Las constantes se declaran todos sus atributos son FINAL y Static, es decir constantes aun que no lo especifíquemos explicitamnete
    //En las interfaces no puedes tener nada privados ni protegidos, solo publicos(Como las ayudas de Sanchez)
    //Por reglas de estilo las constantes se declaran en mayusculas
    public int VELMAXSPAIN=120;
    public final boolean PERMISODECIRCULACION=true;
    
    //Los métodos que tiene el interfaz son promesas de métodos que implementara posteriormente la clase que haga implements de esta interfaz
    
    //¿Qué métodos debe tener siempre un vehículo?
    public void arrancar();
    public void acelerar();
    public void frenar();
    //Los interfaces no me permiten implementar los métodos dentro de ellos, deben ser abstractos 
    
    public default boolean comparaConMax(int vel){
        return vel>VELMAXSPAIN;
    }
}
