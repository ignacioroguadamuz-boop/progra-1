import java.util.Scanner;
public class Mundial{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int cantidadEquipos;
        
        //menú
        
        do {
            System.out.print("Cantidad de equipos, el mínimo es de 3: ");
            cantidadEquipos = sc.nextInt();
            sc.nextLine();
        } while (cantidadEquipos < 3);
        
        Equipo[] equipos = new Equipo[cantidadEquipos];
        
        for (int i = 0; i < equipos.length; i++){
            System.out.println("Pais de equipo: ");
            String pais = sc.nextLine();
        
        
            Jugador [] jugadores = new Jugador[25];
        
            for (int j = 0; j < jugadores.length; j++){
                System.out.println("Escriba el nombre del jugador " + (j+1) + ":");
                String nombre = sc.nextLine();
                jugadores[j] = new Jugador(nombre);
            }
        
            equipos[i] = new Equipo(pais, jugadores);
        }
        
        int cantidadPartidos = cantidadEquipos * (cantidadEquipos - 1) /2;
        Partido[] partidos = new Partido[cantidadPartidos];

        int indicePartido = 0;

        for (int i = 0; i < equipos.length; i++) {

            for (int j = i + 1; j < equipos.length; j++) {

                Equipo e1 = equipos[i];
                Equipo e2 = equipos[j];

                Partido partido = new Partido(e1, e2);

                System.out.println();
                System.out.println(
                    "Partido: " + e1.pais + " vs " + e2.pais
                );

                // goles equipo1

                while (true) {

                    System.out.print(
                        "Jugador que anoto para " + e1.pais +
                        " (fin para terminar): "
                    );

                    String nombre = sc.nextLine();

                    if (nombre.equalsIgnoreCase("fin")) {
                        break;
                    }

                    Jugador jugador = e1.buscarJugador(nombre);

                    if (jugador != null) {

                        jugador.agregarGol();

                        partido.goles1++;
                        e1.gf++;
                        e2.gc++;
                    }
                }

                // goles equipo2

                while (true) {

                    System.out.print(
                        "Jugador que anoto para " + e2.pais +
                        " (fin para terminar): "
                    );

                    String nombre = sc.nextLine();

                    if (nombre.equalsIgnoreCase("fin")) {
                        break;
                    }

                    Jugador jugador = e2.buscarJugador(nombre);

                    if (jugador != null) {

                        jugador.agregarGol();

                        partido.goles2++;
                        e2.gf++;
                        e1.gc++;
                    }
                }

                // actualiza tabla

                e1.pj++;
                e2.pj++;

                if (partido.goles1 > partido.goles2) {

                    e1.pg++;
                    e2.pp++;

                } else if (partido.goles2 > partido.goles1) {

                    e2.pg++;
                    e1.pp++;

                } else {

                    e1.pe++;
                    e2.pe++;
                }

                partidos[indicePartido] = partido;
                indicePartido++;
            }
        }

        // mostrar jugadores

        System.out.println();
        System.out.println("=== JUGADORES POR EQUIPO ===");

        for (int i = 0; i < equipos.length; i++) {

            equipos[i].mostrarJugadores();
        }

        // tabla de posiciones

        System.out.println("=== TABLA DE POSICIONES ===");

        System.out.println(
            "Equipo\tPJ\tPG\tPE\tPP\tGF\tGC"
        );

        for (int i = 0; i < equipos.length; i++) {

            Equipo e = equipos[i];

            System.out.println(
                e.pais + "\t" +
                e.pj + "\t" +
                e.pg + "\t" +
                e.pe + "\t" +
                e.pp + "\t" +
                e.gf + "\t" +
                e.gc
            );
        }

        // estadisticas

        int totalGoles = 0;

        Equipo mejorEquipo = equipos[0];

        Jugador maximoGoleador = equipos[0].jugadores[0];

        Partido partidoMasGoles = partidos[0];

        for (int i = 0; i < equipos.length; i++) {

            totalGoles += equipos[i].gf;

            if (equipos[i].gf > mejorEquipo.gf) {
                mejorEquipo = equipos[i];
            }

            for (int j = 0; j < equipos[i].jugadores.length; j++) {

                if (
                    equipos[i].jugadores[j].goles >
                    maximoGoleador.goles
                ) {

                    maximoGoleador = equipos[i].jugadores[j];
                }
            }
        }

        for (int i = 0; i < partidos.length; i++) {

            int golesPartido =
                partidos[i].goles1 + partidos[i].goles2;

            int golesMaximos =
                partidoMasGoles.goles1 + partidoMasGoles.goles2;

            if (golesPartido > golesMaximos) {

                partidoMasGoles = partidos[i];
            }
        }

        double promedio =
            (double) totalGoles / cantidadPartidos;

        // mostrar estadisticas

        System.out.println();
        System.out.println("=== ESTADISTICAS ===");

        System.out.println("Total goles: " + totalGoles);

        System.out.println(
            "Promedio goles por partido: " + promedio
        );

        System.out.println(
            "Equipo con mas goles: " +
            mejorEquipo.pais +
            " (" + mejorEquipo.gf + ")"
        );

        System.out.println(
            "Maximo goleador: " +
            maximoGoleador.nombre +
            " (" + maximoGoleador.goles + " goles)"
        );

        System.out.println(
            "Partido con mas goles: " +
            partidoMasGoles.equipo1.pais +
            " " + partidoMasGoles.goles1 +
            " - " +
            partidoMasGoles.goles2 +
            " " +
            partidoMasGoles.equipo2.pais
        );

        sc.close();
    }
}  