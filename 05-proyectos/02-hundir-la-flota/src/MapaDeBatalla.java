package destruirlaflota_ivan_martin_garcia;

import java.util.Random;
import java.util.Scanner;

public class MapaDeBatalla extends Mapa {
    private boolean[][] disparos;
    private Random rand;
    private Scanner scanner;

    public MapaDeBatalla() {
        super();
        disparos = new boolean[10][10];
        rand = new Random();
        scanner = new Scanner(System.in);
    }

    public int [] disparoJugador(String[][] mapaObjetivo) {
        while (true) {
            try {
                scanner=new Scanner(System.in);
                System.out.println("Introduce coordenada de disparo (ej: a1):");
                int[] coord = validarYConvertirCoordenada(scanner.next());
                if (disparos[coord[0]][coord[1]]) {
                    throw new MiExcepcion("No puedes volver a disparar en la misma casilla");
                }
                disparos[coord[0]][coord[1]] = true;
                String impacto = mapaObjetivo[coord[0]][coord[1]];
                if (!impacto.equals("-")) {
                    setMiMapa(coord[0], coord[1], "X");
                    return coord;
                }
                return null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    

    public String disparoIA(String[][] mapaObjetivo, int[] lastImpacto) {
        int[] disparo;
        if (lastImpacto != null) {
            disparo = disparoInteligente(lastImpacto[0], lastImpacto[1]);
            if (disparo == null) disparo = disparoAleatorio();
        } else {
            disparo = disparoAleatorio();
        }
        disparos[disparo[0]][disparo[1]] = true;
        String impacto = mapaObjetivo[disparo[0]][disparo[1]];
        if (impacto.equals("-")) {
            setMiMapa(disparo[0], disparo[1], "X");
            return impacto;
        }
        return null;
    }

    protected int[] disparoInteligente(int x, int y) {
        if (x > 0 && !disparos[x - 1][y]) return new int[]{x - 1, y};
        if (x < 9 && !disparos[x + 1][y]) return new int[]{x + 1, y};
        if (y > 0 && !disparos[x][y - 1]) return new int[]{x, y - 1};
        if (y < 9 && !disparos[x][y + 1]) return new int[]{x, y + 1};
        return null;
    }

    protected int[] disparoAleatorio() {
        int x, y;
        do {
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        } while (disparos[x][y]);
        return new int[]{x, y};
    }
}
