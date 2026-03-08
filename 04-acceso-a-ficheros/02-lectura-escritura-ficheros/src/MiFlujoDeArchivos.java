/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionexamen3t;

/**
 *
 * @author daw1
 */
import java.util.ArrayList;
import java.io.*;
public class MiFlujoDeArchivos {
    
    public static boolean transportarArchivos(InfoEmpresa laEmpresa){
        try {
            File miFichero=new File("path.txt");
            BufferedReader miLector=new BufferedReader(new FileReader(miFichero));
            ArrayList<String> misArchivos=new ArrayList<>();
            String rutasLeidas=miLector.readLine();
            while(rutasLeidas !=null){
                //System.out.println(rutasLeidas);
                misArchivos.add(rutasLeidas);
                rutasLeidas=miLector.readLine();
            }
            miLector.close();
            BufferedReader lasAcciones=new BufferedReader(new FileReader(misArchivos.get(0)));
            ArrayList<String> datosAcciones=new ArrayList<>();
            String lineasAcciones=lasAcciones.readLine();
            while(lineasAcciones!=null){
                //System.out.println(lineasAcciones);
                datosAcciones.add(lineasAcciones);
                lineasAcciones=lasAcciones.readLine();
            }
            for (String fila : datosAcciones) {
                String  []miFila=fila.split(":");
                laEmpresa.addActions(miFila[1], Double.parseDouble(miFila[3]), Integer.parseInt(miFila[2]), Integer.parseInt(miFila[0]));
            }
            //System.out.println(laEmpresa.getMisAcciones().size());
            System.out.println(laEmpresa.verMisAcciones());
            lasAcciones.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    
}
