package tallerserializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TallerSerializable {

    public static Scanner datos = new Scanner(System.in);

    public static void guardarTaller(Taller elTaller) {
        try {
            Scanner datos = new Scanner(System.in);
            //Como vamos desde dentro del programa hacia fuer el flujo es OUTPUT
            System.out.println("Introduce el nombre del fichero a guardar");
            String name = datos.next();
            FileOutputStream miFlujoSalida = new FileOutputStream(name);
            ObjectOutputStream miObjetoCopia = new ObjectOutputStream(miFlujoSalida);
            miObjetoCopia.writeObject(elTaller);
            miObjetoCopia.close();
            miFlujoSalida.close();
            System.out.println("Taller guardado correctamente");
        } catch (