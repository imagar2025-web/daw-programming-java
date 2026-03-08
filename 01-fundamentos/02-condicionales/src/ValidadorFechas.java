
package calendarioconvariables;

import java.util.Scanner;


public class CalendarioConVariables {

    public static void main(String[] args) {
          Scanner datosScanner=new Scanner(System.in);
        System.out.println("Introduce un dia del mes");
        int dia=datosScanner.nextInt();
        System.out.println("Introduce un numero de mes");
        int mes=datosScanner.nextInt();
        System.out.println("Introduce un a?o");
        int año=datosScanner.nextInt();
        if(año==2024){
            if(mes<=10 && mes>=1){
                if((mes==1) || (mes==3) || (mes==5) || (mes==7) ||(mes==8) || (mes==10) ){
                    if(mes==10){
                        if(dia>=1 && dia<=8){
                        System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + año);
                        }else{
                            System.out.println("Has introducido un dia no valido");}
                    }else
                        if(dia>=1 && dia<=31){
                        System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + año);
                        }else{
                            System.out.println("Has introducido un dia no valido");}
                }else{
                    if(mes==2){
                        if(año==0){
                             if(dia<=28 && dia>=1){
                             System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + año);
                            }else{
                            System.out.println("Has introducido un valor invalido para febrero");}
                        }else{
                            if(dia<=29 && dia>=1){
                             System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + año);
                            }else{
                            System.out.println("Has introducido un valor invalido para febrero");}
                        }
                    }else if(dia<=30 && dia>=1){
                         System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + año);
                    }else{
                        System.out.println("Has introducido un valor que no es valido");}
                }
            
            }else{
                System.out.println("Has introducido un mes fuera de rango");}
            
        }else if (aÃ±o<=2024 && aÃ±o>=0){
            if(mes<=12 && mes>=1){
                if((mes==1) || (mes==3) || (mes==5) || (mes==7) ||(mes==8) || (mes==10) ||(mes==12)){
                    if(dia>=1 && dia<=31){
                        System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + aÃ±o);
                    }else{
                        System.out.println("Has introducido un dia no valido");}
                }else{
                     if(mes==2){
                        if(aÃ±o%4==0){
                             if(dia<=28 && dia>=1){
                             System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + aÃ±o);
                            }else{
                            System.out.println("Has introducido un valor invalido para febrero");}
                        }else{
                            if(dia<=29 && dia>=1){
                             System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + aÃ±o);
                            }else{
                            System.out.println("Has introducido un valor invalido para febrero");}
                        }
                    }else if(dia<=30 && dia>=1){
                         System.out.println("La fecha indicada es " + dia + "/" + mes + "/" + aÃ±o);
                    }else{
                        System.out.println("Has introducido un valor que no es valido");}
                }
            
            }else{System.out.println("Has introducido un mes fuera de rango");}
            
        }
    }
    
}
