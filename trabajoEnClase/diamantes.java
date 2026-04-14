public class diamantes {

    public static void main (String args[]){
        int altura = 5;
        diamante(altura);
    }
    
    public static void diamante(int n) {

        //triangulo normal, recordar n=5
       // este for inicia con 4 espacios
        for (int i = 1; i <= n; i++) {

            // Espacios  
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // Asteriscos
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // triangulo invertido
        
        for (int i = n - 1; i >= 1; i--) {

            // Espacios
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // Asteriscos
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}