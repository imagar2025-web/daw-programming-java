
package ejercicioscondicionales;

import java.util.Scanner;


public class EjercicioCondicionales_5 {


    public static void main(String[] args) {
        Scanner datos=new Scanner(System.in);
        double coutabase=800.d;
        System.out.println("Para inscribirte al club antes que nada debes decirme tu edad");
        double edad=datos.nextInt();
        if (edad<21){
            System.out.println("Ahora, dime si tus padres son socios(True/False)");
            boolean padreSocios=datos.nextBoolean();
            //Si no le digo nada al if compara directamente con el true
            if(padreSocios==true){
                System.out.println("Al ser menor de 21 y tus padres socios la cuota tendr?a "
                        + "un 45% de desceunto siendo " + (coutabase*0.55));
            }else if (padreSocios==false){
                System.out.println("Al no ser tus padres socios pero si menor "
                        + "de 21 tienes un 25% que se quedar?a en " + (coutabase*0.75));
            }
        }else if(edad>=65){
            System.out.println("Al ser mayor de 65 tiene usted un 40%"
                    + " de descuento siendo la cuota a pagar " + (coutabase*0.60));
        }else{
            System.out.println("Al no ser ni menor de 21 ni mayor de 65 "
                    + "la cuota base a pagar ser?a de " + coutabase);
        }
    }
    
}
