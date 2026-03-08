package destruirlaflota_ivan_martin_garcia;

import java.util.Scanner;

public abstract class Mapa {
    protected Scanner datos = new Scanner(System.in);
    private String[][] miMapa;
    private int barcosColocados;
    protected Barco[] inventario = {
        new Barco(1, "v"),
        new Barco(2, "f"),
        new Barco(3, "b"),
        new Barco(4, "p")
    };

    public Mapa() {
        this.miMapa = new String[10][10];
        this.barcosColocados = 0;
        for (int i = 0; i < miMapa.length; i++) {
            for (int j = 0; j < miMapa[i].length; j++) {
                setMiMapa(i, j, "-"); 
            }
        }
    }
    public void pintarse() {
        String[] primerColum = {"X", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < getMiMapa().length + 1; i++) {
            for (int j = 0; j < getMiMapa()[0].length + 1; j++) {
                if (j == 0) {
                    System.out.print("| " + primerColum[i]);
                } else if (i == 0 && j != 0) {
                    System.out.print(" " + j + " ");
                } else {
                    if (getMiMapa()[i - 1][j - 1].equals("-")) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(" " + getMiMapa()[i - 1][j - 1] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void informacionJuegoMapeo() {
        System.out.println("A continuación deberás colocar los barcos de tu inventario: "
                + "\n 4 Veleros de tamaño 1"
                + "\n 3 Fragatas de tamaño 2"
                + "\n 2 Buques de tamaño 3"
                + "\n 1 Portaviones de tamaño 4"
                + "\n\nLas reglas de colocación son las siguientes:\n"
                + "Elegirás la coordenada dentro de las posibles del mapa\n"
                + "A continuación elegirás el tipo de colocación "
                + "\nV: vertical (desde el punto de partida hacia abajo)"
                + "\nH: horizontal (desde el punto de partida hacia la derecha)"
                + "\nEn el caso de que sea posible y no choque con ninguna,"
                + "\ndebe de tener una posición de diferencia por todos los lados,"
                + "\na excepción de las posiciones diagonales");
    }

    
    protected int[] validarYConvertirCoordenada(String coord) throws MiExcepcion {
        if (coord == null || (coord.length() != 2 && coord.length() != 3)) {
            throw new MiExcepcion("La coordenada debe tener 2 o 3 caracteres.");
        }
        // El primer carácter debe ser la fila (letra) y el resto la columna
        char filaChar = coord.toLowerCase().charAt(0);
        String colStr = coord.substring(1);
        if (colStr.length() == 0) {
            throw new MiExcepcion("No se especificó la columna.");
        }
        // Validamos que la columna sea numérica
        if (!colStr.matches("[0-9]+")) {
            throw new MiExcepcion("La columna debe ser un número.");
        }
        char colChar = colStr.charAt(0);
        // Si se ingresa "10" se considera que el dígito es '0' (ya que en nuestro arreglo 10 se representa con 0)
        if (colStr.equals("10")) {
            colChar = '0';
        }
        return coordenadas(filaChar, colChar);
    }
    
    protected int[] coordenadas(char fila, char columna) throws MiExcepcion {
        int filaInt, colInt;
        switch (fila) {
            case 'a': filaInt = 0; break;
            case 'b': filaInt = 1; break;
            case 'c': filaInt = 2; break;
            case 'd': filaInt = 3; break;
            case 'e': filaInt = 4; break;
            case 'f': filaInt = 5; break;
            case 'g': filaInt = 6; break;
            case 'h': filaInt = 7; break;
            case 'i': filaInt = 8; break;
            case 'j': filaInt = 9; break;
            default: throw new MiExcepcion("Has introducido una fila inexistente.");
        }
        switch (columna) {
            case '1': colInt = 0; break;
            case '2': colInt = 1; break;
            case '3': colInt = 2; break;
            case '4': colInt = 3; break;
            case '5': colInt = 4; break;
            case '6': colInt = 5; break;
            case '7': colInt = 6; break;
            case '8': colInt = 7; break;
            case '9': colInt = 8; break;
            case '0': colInt = 9; break;
            default: throw new MiExcepcion("Estás fuera de los límites del mapa por la derecha.");
        }
        return new int[]{filaInt, colInt};
    }
    
    public String[][] getMiMapa() {
        return miMapa;
    }

    public Barco[] getInventario() {
        return inventario;
    }
    
    public int getBarcosColocados() {
        return barcosColocados;
    }

    public void setMiMapa(int x, int y, String identificador) {
        this.miMapa[x][y] = identificador;
    }
    
    public void setMiMapa(int x,int y,int tamaño,String identi,char direc){
        if (direc == 'v') {
            for (int i = 0; i < tamaño; i++) {
                setMiMapa(x + i, y, identi);
            }
        } else if (direc== 'h') {
            for (int i = 0; i < tamaño; i++) {
                setMiMapa(x, y + i, identi);
            }
        }
    }
    
    

    public void setBarcosColocados(int barcosColocados) {
        this.barcosColocados = barcosColocados;
    }
}
