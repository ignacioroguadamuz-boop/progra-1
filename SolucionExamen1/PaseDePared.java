import java.util.Scanner;

public class PaseDePared {

    // Dimensiones de la cancha (accesibles desde el metodo)
    static int N;
    static int M;
    static int[][] cancha;

    /**
     * Analiza si se puede realizar un pase seguro desde la posicion del balon.
     * 
     * @param fila     fila actual del balon
     * @param columna  columna actual del balon
     */
    public static void analizarPase(int fila, int columna) {

        // Direcciones: arriba, abajo, izquierda, derecha
        int[] deltaFila    = {-1,  1,  0,  0};
        int[] deltaColumna = { 0,  0, -1,  1};
        String[] nombres   = {"Arriba", "Abajo", "Izquierda", "Derecha"};

        int zonasLibres   = 0;  // vecinos con 0 rivales
        int totalRivales  = 0;  // suma de rivales en vecinos validos

        System.out.println("\nVecinos analizados:");

        for (int i = 0; i < 4; i++) {

            int nuevaFila    = fila    + deltaFila[i];
            int nuevaColumna = columna + deltaColumna[i];

            // Verificar si el vecino esta dentro de la cancha
            if (nuevaFila >= 0 && nuevaFila < N &&
                nuevaColumna >= 0 && nuevaColumna < M) {

                int rivales = cancha[nuevaFila][nuevaColumna];

                System.out.println("  " + nombres[i] +
                    " (" + nuevaFila + "," + nuevaColumna + ")" +
                    " = " + rivales + " rivales" +
                    (rivales == 0 ? " <- zona libre" : ""));

                totalRivales += rivales;

                if (rivales == 0) {
                    zonasLibres++;
                }

            } else {
                System.out.println("  " + nombres[i] + " = fuera de la cancha");
            }
        }

        System.out.println("\nZonas libres encontradas: " + zonasLibres);
        System.out.println("Total de rivales en vecinos: " + totalRivales);

        // Condiciones para pase seguro:
        // 1. Al menos una celda valida tiene 0 rivales
        // 2. La suma total de rivales no supera 3
        if (zonasLibres >= 1 && totalRivales <= 3) {
            System.out.println("\nResultado: PASE SEGURO");
        } else {
            System.out.println("\nResultado: PASE BLOQUEADO" +
                (totalRivales > 3 ? " (el total de rivales en vecinos supera 3)" : ""));
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ingresar dimensiones
        System.out.print("Ingrese N (filas): ");
        N = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Ingrese M (columnas): ");
        M = Integer.parseInt(sc.nextLine().trim());

        // Llenar la cancha
        cancha = new int[N][M];

        System.out.println("Ingrese los valores de la cancha (entre 0 y 3):");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print("  cancha[" + i + "][" + j + "]: ");
                cancha[i][j] = Integer.parseInt(sc.nextLine().trim());
            }
        }

        // Posicion inicial del balon
        System.out.print("Fila del balon: ");
        int fila = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Columna del balon: ");
        int columna = Integer.parseInt(sc.nextLine().trim());

        // Juego: se repite mientras el pase sea seguro
        while (true) {

            System.out.println("\nBalon en posicion (" + fila + ", " + columna + ")");

            analizarPase(fila, columna);

            // Verificar resultado para decidir si continua
            // Recalcular para saber si fue seguro o bloqueado
            int zonasLibres  = 0;
            int totalRivales = 0;

            int[] deltaFila    = {-1,  1,  0,  0};
            int[] deltaColumna = { 0,  0, -1,  1};

            for (int i = 0; i < 4; i++) {
                int nf = fila    + deltaFila[i];
                int nc = columna + deltaColumna[i];
                if (nf >= 0 && nf < N && nc >= 0 && nc < M) {
                    totalRivales += cancha[nf][nc];
                    if (cancha[nf][nc] == 0) zonasLibres++;
                }
            }

            // Si es bloqueado, termina el juego
            if (!(zonasLibres >= 1 && totalRivales <= 3)) {
                System.out.println("El juego termina.");
                break;
            }

            // Si es seguro, preguntar a cual zona libre mover el balon
            System.out.print("¿A cual zona libre desea mover el balon? (fila columna): ");
            String[] input = sc.nextLine().trim().split(" ");
            int nuevaFila    = Integer.parseInt(input[0]);
            int nuevaColumna = Integer.parseInt(input[1]);

            // Validar que la celda elegida es una zona libre valida
            boolean esValida = false;

            int[] dFila = {-1, 1, 0, 0};
            int[] dCol  = { 0, 0,-1, 1};

            for (int i = 0; i < 4; i++) {
                int nf = fila + dFila[i];
                int nc = columna + dCol[i];
                if (nf == nuevaFila && nc == nuevaColumna &&
                    nf >= 0 && nf < N && nc >= 0 && nc < M &&
                    cancha[nf][nc] == 0) {
                    esValida = true;
                    break;
                }
            }

            if (!esValida) {
                System.out.println("Posicion invalida. Debe elegir una zona libre vecina.");
                continue;
            }

            fila    = nuevaFila;
            columna = nuevaColumna;
        }
    }
}
