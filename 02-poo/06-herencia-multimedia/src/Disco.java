/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosHerencia;

/**
 *
 * @author zeus0
 */
public class Disco extends Multimedia{
    private String genero;

    public Disco(String genero, String autor, String titulo, double duracion, String formato) {
        super(autor, titulo, duracion, formato);
        this.genero = genero;
    }

    @Override
    public String toString() {
        String info= super.toString() + "\n Genero: " + genero;
        return info;
    }
    
    
}
