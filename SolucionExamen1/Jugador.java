public class Jugador {
    public String nombre;
    public int goles;
    
    public Jugador (String nombre){
        this.nombre = nombre;
        this.goles = 0;
    }
    
    public int agregarGol(){  
        goles++;
        return goles;
    
    }
    
}