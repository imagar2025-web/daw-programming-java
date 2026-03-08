/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawcicle;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public abstract class ProductosBici {
    private Scanner datos=new Scanner(System.in);
    private int numSerie;
    private double precio;
    private double precioDesc;
    private String nombre;
    private int unidades;

    public ProductosBici(){
        boolean creado=false;
        do {
            try {
                datos=new Scanner(System.in);
                System.out.println("Indique el nombre de su producto");
                this.nombre=datos.nextLine();
                if (this.nombre.length()==0) {
                    throw new MiExcepcion("Has introducido una cadena sin caracteres");
                }
                //Controla las excepciones de los numeros pidiendo hasta que sea un numero permitido
                boolean numero=false;
                do {
                    try {
                        datos=new Scanner(System.in);
                        System.out.println("Introduzca el precio de su nuevo producto");
                        this.precio=datos.nextDouble();
                        if (this.precio<=0) {
                            throw new MiExcepcionDe0("Has introducido un precio igual o menor a cero");
                        }
                        System.out.println("Introduzca la cantidad de ese producto");
                        this.unidades=datos.nextInt();
                        if (this.unidades<=0) {
                            throw new MiExcepcionDe0("Has introducido una cantidad igual o menor a cero");
                        }
                        precioDesc=precio*0.9;
                        numero=true;
                    } catch (MiExcepcionDe0 e) {
                        System.out.println(e.getMessage()+", vuelva a introducit el numero");
                    }
                } while (!numero);
                System.out.println("Para finalizar Introduzca el numero de serie:");   
                this.numSerie=datos.nextInt();
                creado=true;
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage()+", vuelva a introducir el nombre");
            }catch(Exception e){
                System.out.println("Erro: " +e.getMessage()+" ,vuelva a introducir el articulo");
            }
        } while (!creado);
    }
    
    public String infoProducto(){
        String info="Nombre del articulo: "+this.nombre+"\nID: " +this.numSerie+"\nUnidades: "+this.unidades+"\nPrecio: "+this.precio;
        return info;
    }
    public boolean comprarProducto(int cantidad){
        boolean compra=false;
        if (this.unidades==0) {
            System.out.println("No queda mas stock de este producto");
        }else if((this.unidades-cantidad)<0){
            System.out.println("No puedes comprar mas producto del que hay");
        }else{
            this.unidades-=cantidad;
            compra=true;
        }
        return compra;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPrecioDesc() {
        return precioDesc;
    }
    
    public int getUnidades() {
        return unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    }
    
    
    

