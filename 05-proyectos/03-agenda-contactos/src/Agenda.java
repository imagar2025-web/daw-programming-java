
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Agenda implements Serializable {

    ArrayList<Contacto> contactos;
    String contactoBuscado, apellidosBuscado;

    //coontructor que se guardara automaticamente
    public Agenda(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void reistrarContacto() {
        System.out.println("Si el nombre apellidos coinciden con los de otro contacto, este no sera valido");
        if (encontrarUsuario()==null) {
            contactos.add(new Contacto(contactoBuscado, apellidosBuscado));
        }else{
            System.out.println("Contacto no valido");
        }

    }

    public Contacto encontrarUsuario() {
        String nombre, apellidos;
        boolean salida = false;
        do {
            try {
                Scanner datos = new Scanner(System.in);
                System.out.println("Escriba el nombre del contacto");
                nombre = datos.next();
                System.out.println("Introducca los apellidos que corresponden a ese contacto");
                datos=new Scanner(System.in);
                apellidos = datos.nextLine();
                for (int i = 0; i < contactos.size(); i++) {
                    if (contactos.get(i).getNombre().equals(nombre) && contactos.get(i).getApellidos().equals(apellidos)) {
                        return contactos.get(i);
                    }
                }
                contactoBuscado=nombre;
                apellidosBuscado=apellidos;
                salida=true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!salida);
        return null;
    }

    public void buscarContacto(Contacto c) {
        if (c != null) {
            System.out.println("Aqui esta su usuario buscado\n" + c);
        }
    }

    public void eliminarUsuario(Contacto c) {
        if (c != null) {
            contactos.remove(c);
        }
    }

    @Override
    public String toString() {
        String info="Contactos:";
        for (int i = 0; i < contactos.size(); i++) {
            info+="\n"+contactos.get(i).toString()+"\n------------------------------";
            
        }
        return info;
    }
    
    

}
