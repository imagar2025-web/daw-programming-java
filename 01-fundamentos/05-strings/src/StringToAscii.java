
package ejemplosstring.s;

public class Ejercicio10 {

    public static void main(String[] args) {
       String name="ABCD";
       StringBuilder asciiV= new StringBuilder();
       
      for(int x=0;x<name.length();x++){
          char caracter=name.charAt(x);
          int ascii = (int) caracter;
          asciiV.append(ascii).append(" ");
      }
        System.out.println(asciiV.toString().trim());
    }
    
}
