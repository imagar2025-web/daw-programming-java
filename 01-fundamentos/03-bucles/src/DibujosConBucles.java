
package dibujosconbucles;

public class DibujosConBucles {

    public static void dibujoCuadrado(){
        int alto=5;
        int ancho=5;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho-1 ; j++) {
                System.out.print("* ");
            }System.out.println("*");
        }
    }
    public static void DibujoRectangulo(){
        int alto=4;
        int ancho=2;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho-1 ; j++) {
                System.out.print("* ");
            }System.out.println("*");
        }
    }
    public static void trianguloInvertido(){
        int alto=7;
        
        for (int i = 0; i < alto; i++) {
            for (int j = alto; j > i; j--) {
                System.out.print("*");
            }System.out.println("");
        }
    }
    public static void TrianguloHaciaUnLado(){
        int alto=7;
        for (int i = 0; i < alto; i++) {
            for (int j = i; j < alto-1; j++) {
                System.out.print(" ");
            }
            for (int j = alto; j <=i+alto; j++) {
                System.out.print("*");
            }System.out.println("");
        }
    }
    public static void piramide(){
        int alto=7;
        for (int i = 1; i < alto; i++) {
            for (int j = i; j < alto; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2*i-1); j++) {
                System.out.print("*");
            }System.out.println();
        }
    }
    public static void piramideInvertida(){
        int n=5;
        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
                
            }
            for (int j = 1; j <= (2*i-1); j++) {
                System.out.print("*");
                
            }System.out.println();
        }
        
    }
    public static void corazon(){
        int n=6;
        for (int i = n/2; i <= n; i+=2) {
            for (int j = 1; j < n-i; j+=2) {
                System.out.print(" ");  
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
                
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
                
            }
            for (int j = 1; j <= (2*i-1); j++) {
                System.out.print("*");
                
            }System.out.println();
        }
    }
    public static void marco(){
        int n=5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i==1||i==n||j==1||j==n) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }
    public static void cruz(){
        int n=5;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                if (j==i || j==n-i+1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }System.out.println();
            
        }
    }
    public static void trianguloVacio(){
        int n=5;
        for (int i = 1; i <=n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
                
            }
            for (int j = 1; j <= 2*i-1; j++) {
                if (j==1||j==2*i-1||i==n) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
        dibujoCuadrado();
        System.out.println("----------------");
        DibujoRectangulo();
        System.out.println("----------------");
        trianguloInvertido();
        System.out.println("----------------");
        TrianguloHaciaUnLado();
        System.out.println("----------------");
        piramide();
        System.out.println("----------------");
        piramideInvertida();
        System.out.println("----------------");
        marco();
        System.out.println("----------------");
        corazon();
        System.out.println("----------------");
        cruz();
        System.out.println("----------------");
        trianguloVacio();
        
    }
    
}
