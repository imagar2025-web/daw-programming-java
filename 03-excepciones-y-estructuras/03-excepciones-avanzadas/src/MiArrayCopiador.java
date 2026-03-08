/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosExcepciones;

/**
 *
 * @author zeus0
 */
public class MiArrayCopiador {
    int [] cadena;

    public MiArrayCopiador(int tam) {
        while (tam<=0) {
            System.out.println("Has puesto un tamaño invalido");
            tam=Ejercicios1.datos.nextInt();
        }
        this.cadena=new int [tam];
    }
    
    public void coiparArray(int [] array){
        try {
            copia(array);
            
        } catch (DifferentSizeOfArray e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void copia(int [] array) throws DifferentSizeOfArray{
        if (cadena.length!=array.length) {
            throw new DifferentSizeOfArray("Los arrays tienen tamaños incompatibles");
        }
        for (int i = 0; i < array.length; i++) {
            cadena[i]=array[i];
            
        }
    }
    
}
