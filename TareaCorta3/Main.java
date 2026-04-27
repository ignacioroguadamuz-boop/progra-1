import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese cantidad de iteraciones: ");
        int n = sc.nextInt();

        AproximadorPi aproximador = new AproximadorPi(n);

        aproximador.calcularMonteCarlo();
        aproximador.calcularLeibniz();

        System.out.println("\n--- RESULTADOS ---");
        System.out.println(aproximador);

        sc.close();
    }
}
