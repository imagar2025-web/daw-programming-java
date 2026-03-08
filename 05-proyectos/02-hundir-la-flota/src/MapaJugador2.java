package destruirlaflota_ivan_martin_garcia;

import java.util.Random;
import java.util.Scanner;

public class MapaJugador2 extends Mapa {
    private Scanner datos = new Scanner(System.in);
    private Random rand= new Random();
    private int[] restantes = {4, 3, 2, 1};

    public MapaJugador2() {
        super();
    }
    
    public void colocarBarcos() {
        
        while (this.getBarcosColocados() != 10) {
            System.out.println("Quedan:" +
                    "\n (v)Veleros: " + restantes[0] +
                    "\n (f)Fragatas: " + restantes[1] +
                    "\n (b)Buques: " + restantes[2] +
                    "\n (p)Portaviones: " + restantes[3]);
            pintarse();
            String eleccion = "";
            boolean salida = false;
            do {
                try {
                    System.out.println("Seleccione su barco:");
                    eleccion = datos.next().trim();
                    if (eleccion.length() == 1) {
                        if (eleccionDeBarco(eleccion.charAt(0), restantes)) {
                            if (colocarPieza(eleccion.charAt(0))) {
                                this.setBarcosColocados(this.getBarcosColocados() + 1);
                            }
                        }
                    } else {
                        throw new MiExcepcion("Has seleccionado un barco ilegítimo");
                    }
                    salida = true;
                } catch (Exception e) {
                    if (e instanceof ShipNotFound) {
                        System.out.println(e.getMessage() + ", por favor vuelve a introducir el tipo de barco");
                    } else if (e instanceof MiExcepcion) {
                        System.out.println(e.getMessage());
                    } else if (e instanceof MiExcepcionEspecial) {
                        System.out.println("Vuelva a introducir su barco debido a que " + e.getMessage());
                    } else {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            } while (!salida);
            System.out.println("Acabó la colocación, ahora empieza el juego");
        }
    }
    private boolean eleccionDeBarco(char tipoBarco, int[] cantidadBarcos) throws ShipNotFound, MiExcepcionEspecial {
        char[] barcos = {'v', 'f', 'b', 'p'};
        boolean legit = false;
        for (int i = 0; i < barcos.length; i++) {
            if (tipoBarco == barcos[i]) {
                if (cantidadBarcos[i] > 0) {
                    legit = true;
                    cantidadBarcos[i]--;
                } else {
                    throw new MiExcepcionEspecial("no quedan más barcos de este tipo");
                }
            }
        }
        if (!legit) {
            throw new ShipNotFound("No se ha encontrado el tipo de barco que has indicado");
        }
        return legit;
    }
    // Sobrescribimos los métodos de colisiones para incluir las restricciones de MapaJugador2

    
    protected boolean colisiones(int x, int y) throws MiExcepcionEspecial{
        tieneBarcoCerca(x, y);
        return (super.getMiMapa()[x][y].equals("-"));
    }

    
    protected boolean colisiones(int x, int y, int tam, char direccion) throws MiExcepcionEspecial {
        if (direccion == 'v') {
            if (x + tam > 10) {  // Se sale por abajo
                throw new MiExcepcionEspecial("El barco se está saliendo de los límites por abajo");
            }
            for (int i = 0; i < tam; i++) {
                if (!super.getMiMapa()[x + i][y].equals("-") ) {
                    throw new MiExcepcionEspecial("Estamos chocando con un barco por abajo");
                }
                tieneBarcoCerca(x+i, y);
            }
        } else if (direccion == 'h') {
            if (y + tam > 10) {  // Se sale por la derecha
                throw new MiExcepcionEspecial("El barco se está saliendo de los límites por la derecha");
            }
            for (int i = 0; i < tam; i++) {
                if (!super.getMiMapa()[x][y + i].equals("-")) {
                    throw new MiExcepcionEspecial("Estamos chocando con uno de nuestros barcos por la derecha");
                }
                tieneBarcoCerca(x, y+i);
            }
        }
        return true;
    }
    
    private boolean colocarPieza(char pieza) {
        int tamaño = 0;
        String barcoActual = "";
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].getRepresentación().charAt(0) == pieza) {
                tamaño = inventario[i].getTamaño();
                barcoActual = inventario[i].getRepresentación();
            }
        }
        boolean salida = false;
        int[] copiaCords;
        String cordenada = "";
        do {
            try {
                System.out.println("Elija dónde quiere colocar su pieza (ejemplo: a1 o a10):");
                cordenada = datos.next().toLowerCase();
                copiaCords = validarYConvertirCoordenada(cordenada);
                if (tamaño == 1) {
                    if (colisiones(copiaCords[0], copiaCords[1])) {
                        super.setMiMapa(copiaCords[0], copiaCords[1], barcoActual);
                        System.out.println("El velero ha sido colocado");
                    } else {
                        throw new MiExcepcion("Estamos chocando con un barco aliado, elija otra ubicación");
                    }
                } else {
                    boolean salidaDireccion = false;
                    do {
                        try {
                            System.out.println("Introduce en qué dirección quieres colocar el barco"
                                    + "\n(v) Vertical"
                                    + "\n(h) Horizontal:");
                            String posicion = datos.next().toLowerCase();
                            if (posicion.length() != 1 || (posicion.charAt(0) != 'v' && posicion.charAt(0) != 'h')) {
                                throw new MiExcepcion("No has introducido una opción válida, vuelve a introducirla");
                            }
                            if (colisiones(copiaCords[0], copiaCords[1], tamaño, posicion.charAt(0))) {
                                
                                setMiMapa(copiaCords[0], copiaCords[1], tamaño, barcoActual, posicion.charAt(0));
                                System.out.println("El barco ha sido colocado satisfactoriamente");
                            }
                            salidaDireccion = true;
                        } catch (MiExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!salidaDireccion);
                }
                salida = true;
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            } catch (MiExcepcionEspecial e) {
                System.out.println("Elija otra ubicación, " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió algo inesperado: " + e.getMessage());
            }
        } while (!salida);
        return salida;
    }
    
    protected boolean tieneBarcoCerca(int x, int y) throws MiExcepcionEspecial{
    // Direcciones: arriba, abajo, izquierda, derecha.
    int[][] direcciones = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    for (int[] dir : direcciones) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        // Verifica que la posición esté dentro de los límites del mapa.
        if (nx >= 0 && nx < getMiMapa().length && ny >= 0 && ny < getMiMapa()[0].length) {
            if (!getMiMapa()[nx][ny].equals("-")) {
                throw new MiExcepcionEspecial("Estamos muy cerca de otro de nuestros barcos");
            }
        }
    }
    return true;
}

    // Los métodos internos para elegir y colocar piezas usan la validación de coordenadas heredada.
    
        public void mapeoIA(){
        String[] barcos = {"v", "f", "b", "p"};
            for (int i = 0; i < barcos.length; i++) {
                for (int j = 0; j < restantes[i]; j++) {
                    boolean colocado=false;
                    do {
                        char direcFinal='c';
                        
                        try {
                            int x = rand.nextInt(10);
                        int y = rand.nextInt(10);
                        if (i==0 && colisiones(x, y)) {
                            setMiMapa(x, y, inventario[i].getRepresentación());
                            colocado=true;
                        }else{
                            int direccion= rand.nextInt(2);
                            switch (direccion) {
                                case 0 -> {
                                    direcFinal='h';
                                }
                                case 1 -> {
                                    direcFinal='v';
                                }
                            }
                            try {
                                datos=new Scanner(System.in);
                                if (colisiones(x, y, inventario[i].getTamaño(),direcFinal)) {
                                    setMiMapa(x, y, inventario[i].getTamaño(), inventario[i].getRepresentación(), direcFinal);
                                    colocado=true;
                                }
                            } catch (MiExcepcionEspecial e) {
                            }catch (Exception e) {
                            }
                        }
                        } catch (Exception e) {
                        }
                    } while (!colocado);
                }
                
            }
        }
    
}
