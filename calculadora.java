import java.util.Scanner;
//creo la clase
public class calculadora {
    public static void calcular(double a, double b, char operacion) {
        switch (operacion){
            case '+':
                System.out.println("El resultado es: " + (a+b));
                return;
            case '-':
                System.out.println("El resultado es: " + (a-b));
                return;
            case '/':
                System.out.println("El resultado es: " + (a/b));
                return;
            case '*':
                System.out.println("El resultado es: " + (a*b));
                return;
            default: System.out.println("No válido");
                
        }
    }
    public static void main(String argv[]){
        calcular (4,3,'+');
        calcular(199,54, '-');
        calcular (86,4, '/');
        calcular (4, 5, '*');
        
    }
    
}