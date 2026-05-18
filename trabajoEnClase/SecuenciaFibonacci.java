public class SecuenciaFibonacci {
    public static int factorialIterativo(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++){
            resultado *= i;
        }
        return resultado;
    }
    
    public static int factorialRecursivo(int n) {
        int resultado = 0;
        if (n == 1) return 1; //condicion para cerrar el metodo
        resultado = (n * factorialRecursivo(n-1));
        return resultado;
    }
    
    public static int factorialRecursivoTerminal(int n, int acumulador) {
        if (n == 1) return acumulador;
        return factorialRecursivoTerminal(n -1, n* acumulador);
    }
    
    public static void main (String[]args){
        System.out.println(factorialIterativo(5));
        System.out.println(factorialRecursivo(5));
        System.out.println(factorialRecursivoTerminal(5, 1));
    }
    
}
