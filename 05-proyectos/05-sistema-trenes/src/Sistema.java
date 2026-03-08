/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaexamen;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static Scanner datos=new Scanner(System.in);
    private double ganancia=0;
    private ArrayList <Destinos> misDestinos=new ArrayList<>();
    private ArrayList<Usuarios1> misUsuarios=new ArrayList<>();
    private boolean usuarioRegistrado=false;

    public Sistema() {
        System.out.println("Introduce todos los destinos que tiene la empresa");
        boolean salida=false;
        do {   
            try {
                int destinos=0;
                    destinos=datos.nextInt();
                    if (asignarTrenes(destinos)) {
                        System.out.println("Todos los trenes han sido asignados con exito");
                        menuUser();
                    }
                    
            }catch(Exception e){
                System.out.println("Error, vuelva a introducir el dato: " + e.getMessage());
            }
        } while (!salida);
    }
    
    private boolean asignarTrenes(int tam){
        for (int i = 0; i < tam; i++) {
            boolean salida=false;
            do {
                try {
                    System.out.println("Que tipo de tren es: Cercanias o Larga");
                    String tipoTren=datos.next();
                    if (tipoTren.equalsIgnoreCase("Cercanias") || tipoTren.equalsIgnoreCase("Larga")) {
                        datos=new Scanner(System.in);
                        System.out.println("Indique el nombre del destino");
                        String destino=datos.nextLine();
                        System.out.println("Indique el nuemero de asientos disponibles");
                        int nAsientos=datos.nextInt();
                        System.out.println("Asigne el precio del billete");
                        double precio=datos.nextDouble();
                        String tipoSpecial;
                        if (tipoTren.equalsIgnoreCase("Cercanias")) {
                            System.out.println("A que comunidad va");
                            tipoSpecial=datos.next();
                            System.out.println("El tren a sido asignado gratamente");
                            this.misDestinos.add(new DestinoCercanias(tipoSpecial, destino, nAsientos, precio));
                        }else {
                            System.out.println("A que pais va");
                            tipoSpecial=datos.next();
                            System.out.println("El tren a sido asignado gratamente");
                            this.misDestinos.add(new DestinosLargasDistancias(tipoSpecial, destino, nAsientos, precio));  
                        }
                    }else   throw new MiExcepcion("No has introducido un tipo de tren valido");
                    salida=true;
                } catch (MiExcepcion e) {
                    System.out.println("Vuelva a introducir el tren debido a que " + e.getMessage() );
                }catch (Exception e){
                    System.out.println("Error inesperado, vuelva a introducir el tren: " + e.getMessage());
                }
            } while (!salida);
        }
        return true;
    }

    public void menuUser() {
        System.out.println("-------------Trains telecom-------------"
                            +"\nBuscar Destino(1)\nReservar Destino(2)\nVer trenes(3)");
        if (usuarioRegistrado) {
            System.out.println("Logout(4)");
        }else{
            System.out.println("Login(4)");
        }
        System.out.println("Registrar Usuario(5)");
        System.out.println("Exit(6)");
        System.out.println("Que quieres hacer(Introduce el numero)");
        boolean fin=false;
       
        do {
            try {
                int opcion=datos.nextInt();
                 switch (opcion) {
                    case 1 -> {
                        buscarTren();
                    }
                    case 2 -> {
                        reservarTren();
                        desaparecerTren();
                    }
                    case 3 -> {
                        consultarMisTrenecitos();
                    }
                    case 4 -> {
                        System.out.println("Introduzca su nombre");
                        String logueo=datos.next();
                        System.out.println("Ahora introduzca su contraseña de 8 caracteres");
                        String contraseña=datos.next();
                        for (int i = 0; i < misUsuarios.size(); i++) {
                            if (misUsuarios.get(i).getNombre().equalsIgnoreCase(logueo)&&misUsuarios.get(i).getPassword().equalsIgnoreCase(contraseña)) {
                                usuarioRegistrado=true;
                            }
                            
                        }
                    }
                    case 5 -> {
                        misUsuarios.add(new Usuarios1());
                        
                    }
                    case 6 -> {
                        System.out.println("Gracias por usar nuestra aplicacion");
                        fin=true;
                    }
                    default -> throw new MiExcepcion("No has elegido una opcion valida");
                }
            } catch (MiExcepcion e) {
                System.out.println("Error opcion no valida, vuelva a introducirla: " + e.getMessage());
            }catch(Exception e){
                System.out.println("Erro, vuelva a introducir la opcion:" + e.getMessage());
            }
               
        } while (!fin);
    
            
    }
    private boolean buscarTren(){
        System.out.println("Introducca el distino que desea buscar");
                            String destino=datos.nextLine();
                            for (int i = 0; i < misDestinos.size(); i++) {
                                if (misDestinos.get(i).getNombreDestino().equalsIgnoreCase(destino)) {
                                    System.out.println("Aquie esta la informacion del tren que desea\n"+misDestinos.get(i).toString());
                                    return true;
                                }
                            }
                            System.out.println("El tren no existe");
                            return false;
    }
    private Destinos buscarTren(String tren){
        System.out.println("Introducca el distino que desea buscar");
                            String destino=datos.nextLine();
                            for (int i = 0; i < misDestinos.size(); i++) {
                                if (misDestinos.get(i).getNombreDestino().equalsIgnoreCase(destino)) {
                                    System.out.println("Aquie esta la informacion del tren que desea\n"+misDestinos.get(i).toString());
                                    return misDestinos.get(i);
                                }
                            }
                            System.out.println("El tren no existe");
                            return null;
                            
    }

    private void reservarTren() {
        boolean salida=false;
        do {
            System.out.println("Seleccione destino");
            Destinos target=buscarTren(datos.nextLine());
            
            if (target!=null) {
                do {
                    try {
                        System.out.println("Cuantas plazas quiere reservar");
                        int numBilletes=datos.nextInt();
                        if (target.getNumeroBilletes()>numBilletes) {
                            double precio=((double)numBilletes) * target.getPrecioDelBillete();
                            System.out.println("Sus billetes han sido reservados por la cuantia de " + precio);
                            ganancia=ganancia+precio;
                            for (int i = 0; i < misDestinos.size(); i++) {
                                if (misDestinos.contains(target)) {
                                   misDestinos.get(i).setNumeroBilletes(target.getNumeroBilletes()-numBilletes); 
                                }
                            }
                            salida=true;
                        }else   throw new MiExcepcion("Estas comprando un numero de billetes invalido");
                    } catch (MiExcepcion e) {
                        System.out.println(e.getMessage());
                    }catch(Exception e){
                        System.out.println("Ocurrio algo inesperado, vuelve a introducir los billetes");
                    }   
                } while (!salida);        
            }
        } while (!salida);
        
    }

    public double getGanancia() {
        return ganancia;
    }

    private void desaparecerTren() {
        for (int i = 0; i < misDestinos.size(); i++) {
            if (misDestinos.get(i).getNumeroBilletes()==0) {
                misDestinos.remove(i);
            }
            
        }
    }

    private void consultarMisTrenecitos() {
        System.out.println("-------------TRENES-------------\nLARGAS DISTANCIA");
        
        for (int i = 0; i < misDestinos.size(); i++) {
            if (misDestinos.get(i) instanceof DestinosLargasDistancias) {
                System.out.println(misDestinos.get(i).toString());
            }System.out.println();
    
        }
        System.out.println("CORSTAS DISTANCIAS");
        for (int i = 0; i < misDestinos.size(); i++) {
            if (misDestinos.get(i) instanceof DestinoCercanias) {
                System.out.println(misDestinos.get(i).toString());
            }System.out.println();
    
        }
    }
    
    

    
    

}
