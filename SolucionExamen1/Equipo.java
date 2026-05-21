public class Equipo {
    String pais;
    Jugador[] jugadores;
    
    public int pj;
    public int pg;
    public int pe;
    public int pp;
    
    public int gf;
    public int gc;
    
    public Equipo(String pais, Jugador[] jugadores){
        this.pais = pais;
        this.jugadores = jugadores;
    }
    
    public void mostrarJugadores(){
        System.out.println("Equipo: " + pais);
        for (int i = 0; i < jugadores.length; i++){
            System.out.println(jugadores[i].nombre + " - Goles: " + jugadores[i].goles);
        }
        System.out.println("Total goles equipo: " + gf);
        System.out.println();
    }
    
    public Jugador buscarJugador(String nombre) {
        for (int i = 0; i < jugadores.length; i++){
            if (jugadores[i].nombre.equalsIgnoreCase(nombre)){
                return jugadores[i];
            }
        }
        return null;
    }
    
        
    
    
    
    
}