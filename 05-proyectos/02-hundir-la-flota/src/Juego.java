package destruirlaflota_ivan_martin_garcia;

public class Juego {
    private MapaJugador2 mapaJugador;
    private MapaJugador2 mapaMaquina;
    private MapaDeBatalla batallaJugador;
    private MapaDeBatalla batallaMaquina;

    public Juego() {
        mapaJugador = new MapaJugador2();
        mapaMaquina = new MapaJugador2();
        batallaJugador = new MapaDeBatalla();
        batallaMaquina = new MapaDeBatalla();
    }
    
    public boolean iniciarPartida() {
        System.out.println("Coloca tus barcos:");
        mapaJugador.mapeoIA();
        System.out.println("La IA coloca sus barcos...");
        mapaMaquina.mapeoIA();

        boolean turnoJugador = true;
        int[] ultimoImpactoIA = null;

        while (true) {
            if (contarBarcos(mapaJugador) == 0) {
                System.out.println("¡La máquina gana!");
                return true;
            }
            if (contarBarcos(mapaMaquina) == 0) {
                System.out.println("¡El jugador gana!");
                return false;
            }

            if(turnoJugador) {
                System.out.println("Mapa de ataque:\n ");
                batallaJugador.pintarse();
                System.out.println("\n Mapa jugador:\n");
                mapaJugador.pintarse();
                System.out.println("Mapa de ataque IA:\n ");
                batallaMaquina.pintarse();
                System.out.println("\n Mapa IA:\n");
                mapaMaquina.pintarse();
                boolean sigueDisparando = true;
                while (sigueDisparando) {
                    
                    int [] impacto = batallaJugador.disparoJugador(mapaMaquina.getMiMapa());
                    if (impacto != null) {
                        if (!hundido(impacto,mapaMaquina,batallaJugador)) {
                            System.out.println("Has impactado un barco rival"); 
                        }else System.out.println("Has hundido un barco rival");
                        batallaMaquina.setMiMapa(impacto[0], impacto[1], "A");
                    }else sigueDisparando = false;
                }
                turnoJugador = false;
            }else {
                boolean sigueDisparando = true;
                while (sigueDisparando) {
                    String impacto = batallaMaquina.disparoIA(mapaJugador.getMiMapa(), ultimoImpactoIA);
                    if (impacto != null &&!hundido(ultimoImpactoIA, mapaJugador, batallaMaquina)) {
                        if(!hundido(ultimoImpactoIA, mapaJugador, batallaMaquina)){
                            System.out.println("La maquina a impactado un barco");
                        }else System.out.println("La maquina a hundido uno de tus barcos");
                        batallaMaquina.setMiMapa(ultimoImpactoIA[0], ultimoImpactoIA[1], "A");
                    }else sigueDisparando = false;
                }
                turnoJugador = true;
            }
        }
    }

    private int contarBarcos(Mapa mapa) {
        int count = 0;
        for (String[] fila : mapa.getMiMapa()) {
            for (String celda : fila) {
                if (!celda.equals("A")) count++;
            }
        }
        return count;
    }
    
    //Con este metodo sacamos los datos que precisamos para la busqueda de coincidencias
    public boolean hundido(int [] coord,MapaJugador2 mapaObjetivo,MapaDeBatalla MapaDisparos){
        if (coord==null) {
            
            return false;
        }
        String representacion=mapaObjetivo.getMiMapa()[coord[0]][coord[1]];
        int tam=0;
        for (int i = 0; i <mapaObjetivo.getInventario().length ; i++) {
            if (mapaObjetivo.inventario[i].getRepresentación().equalsIgnoreCase(representacion)) {
                tam=mapaObjetivo.inventario[i].getTamaño();
            }  
        }
        return buscarCoincidencias(mapaObjetivo.getMiMapa(), MapaDisparos.getMiMapa(), coord[0], coord[1], representacion, tam);
        
    }

    public boolean buscarCoincidencias(String[][] mapaObjetivo,String[][] mapaDisparo, int filaInicial, int columnaInicial, String valorObjetivo, int minimoCoincidencias) {
        // Desplazamientos para las 4 direcciones:
        // Norte: (-1, 0), Sur: (1, 0), Este: (0, 1), Oeste: (0, -1)
        int[][] desplazamientos = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        int contadorCoincidencias = 0;
        // Recorremos cada dirección
        for (int[] desplazamiento : desplazamientos) {
            int filaActual = filaInicial;
            int columnaActual = columnaInicial;

            // Mientras estemos dentro de los límites y la celda contenga el valor objetivo...
            while (filaActual >= 0 && filaActual < mapaObjetivo.length && 
                   columnaActual >= 0 && columnaActual < mapaObjetivo[0].length && 
                   mapaObjetivo[filaActual][columnaActual].equals(valorObjetivo) &&
                    mapaDisparo[filaActual][columnaActual].equals("X")) {
                contadorCoincidencias++;
                // Si se ha alcanzado el mínimo requerido, se retorna true
                if (contadorCoincidencias == minimoCoincidencias) {
                    return false;
                }
                // Avanzamos en la dirección actual
                filaActual += desplazamiento[0];
                columnaActual += desplazamiento[1];
            }
        }
        return true;
    }

    
}
