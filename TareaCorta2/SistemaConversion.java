import java.util.Scanner;

public class SistemaConversion {

    public static void mostrarOpciones(){
        System.out.println("Opción 1. Metros a kilómetros");
        System.out.println("Opción 2. Kilómetros a millas");
        System.out.println("Opción 3. Millas a kilómetros");
        System.out.println("Opción 4. Metros a yardas");
        System.out.println("Opción 5. Salir");
    }

    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            //Mostramos opciones y guardamos la opcion escogida
            mostrarOpciones();
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            
            if (opcion == 5){
                System.out.println("Programa terminado");
                break;
            }

            System.out.print("Ingrese el valor a convertir: ");
            double valor = input.nextDouble();
            
            double resultado;

            switch(opcion){
                case 1:
                    resultado = Conversor.metrosAKilometros(valor);
                    System.out.println(valor + " metros son: " + resultado + " kilómetros\n");
                    break;

                case 2:
                    resultado = Conversor.kilometrosAMillas(valor);
                    System.out.println(valor + " kilómetros son: " + resultado + " millas\n");
                    break;

                case 3:
                    resultado = Conversor.millasAKilometros(valor);
                    System.out.println(valor + " millas son: " + resultado + " kilómetros\n");
                    break;

                case 4:
                    resultado = Conversor.metrosAYardas(valor);
                    System.out.println(valor + " metros son: " + resultado + " yardas\n");
                    break;

                default:
                    System.out.println("Opción inválida.\n");
            }

        } while (true);
        

    }
}
