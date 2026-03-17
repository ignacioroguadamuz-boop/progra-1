public class Main{
    public static void main (String[] args){
        //Creo una instancia de deportista, usé a un jugador de futbol
        Deportista Pedri = new Deportista("Pedri", "González", 23, 68, "Futbol", "Masculino", true, 100); 
        //uso los getters
        System.out.println("Nombre: " + Pedri.getNombre());
        System.out.println("Apellido: " + Pedri.getApellido());
        System.out.println("Edad: " + Pedri.getEdad());
        System.out.println("Peso: " + Pedri.getPeso());
        System.out.println("Disciplina: " + Pedri.getDisciplina());
        System.out.println("Genero: " + Pedri.getGenero());
        System.out.println("Clasificado: " + Pedri.getClasificado());
        System.out.println("Puntuación: " + Pedri.getPuntuacion());
    }
}