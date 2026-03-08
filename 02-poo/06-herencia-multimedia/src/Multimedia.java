
package EjerciciosHerencia;

import java.util.Objects;
import java.util.Scanner;

public class Multimedia {
    private Scanner datos=new Scanner(System.in);
    private String autor;
    protected String titulo;
    private double duracion;
    private String formato;

    public Multimedia(String autor, String titulo, double duracion,String formato) {
        this.autor = autor;
        this.titulo = titulo;
        this.duracion = duracion;
        boolean salid=false;
        String [] formatos={"wav","mp3","midi","avi","mov","mpg","cdAudi","dvd"};
        for (String formato1 : formatos) {
                if (formato.equalsIgnoreCase(formato1)) {
                    this.formato=formato;
                    salid=true;
                }
        }
        while (!salid){
            System.out.print("Indique que formato contiene el archivo: ");
            for (int i = 0; i < formatos.length; i++) {
                if (i!=formatos.length) {
                    System.out.print(formatos[i] + ", ");
                }else System.out.println(formatos[i]);
            }
            this.formato=datos.next();
            for (String formato1 : formatos) {
                if (formato.equalsIgnoreCase(formato1)) {
                    salid=true;
                }
            }
            if (!salid) {
                System.out.println("Has introducido un formato no valido vuelva a introducirlo");
            }
        }
    }

    public Scanner getDatos() {
        return datos;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return "Autor: " + getAutor() + "\n Titulo: " + getTitulo() + 
                "\nDuración: " + getDuracion() +
                "\nFormato: " + getFormato();
    }

    
    public boolean equals(Multimedia m) {
        if (this.formato.equals(m.formato)) {
            return true;
        }else if (this.autor.equals(m.autor))
            return true;
        else
            return false;
    }
    
    
    
    
    
    
    
    
    
}
