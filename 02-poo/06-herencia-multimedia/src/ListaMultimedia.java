/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosHerencia;

/**
 *
 * @author zeus0
 */
public class ListaMultimedia {
    private int cantidadObjetos;
    private Multimedia [] m;

    public ListaMultimedia(int capacidadLista) {
        m=new Multimedia[capacidadLista];
        cantidadObjetos=0;
    }
    
    public int size(){
        return cantidadObjetos;
    }
    
    public boolean add(Multimedia m){
        for (int i = 0; i < this.m.length; i++) {
            if (this.m[i]==null) {
                this.m[i]=m;
                return true;
            }   
        }
        return false;
    }
    
    public Multimedia getPosition(int posicion){
        return m[posicion];
    }

    @Override
    public String toString() {
        String info="Lista del contenido almacenado\n";
        for (Multimedia multimedia : m) {
            info+=m.toString();
        }
        return info;
    }
    
    
    
    
}
