public class Main{
    public static void main (String[] args){
        //Primera instancia del objeto deportista
        Deportista Pedri = new Deportista("Pedri", "González", 23, 68, "Futbol", "Masculino", true, 100);
        //Segunda instancia del objeto deportista
        Deportista Moregard = new Deportista("Truls", "Moregard", 24, 73, "Tennis de Mesa", "Masculino", true, 100);
        //imprimo los datos de pedri
        System.out.println("Nombre: " + Pedri.getNombre());
        System.out.println("Apellido: " + Pedri.getApellido());
        System.out.println("Edad: " + Pedri.getEdad());
        System.out.println("Peso: " + Pedri.getPeso());
        System.out.println("Disciplina: " + Pedri.getDisciplina());
        System.out.println("Genero: " + Pedri.getGenero());
        System.out.println("Clasificado: " + Pedri.getClasificado());
        System.out.println("Puntuación: " + Pedri.getPuntuacion() + "\n");
        //imprimo los datos de moregard, el backslash n es para separar a los deportistas
        System.out.println("Nombre: " + Moregard.getNombre());
        System.out.println("Apellido: " + Moregard.getApellido());
        System.out.println("Edad: " + Moregard.getEdad());
        System.out.println("Peso: " + Moregard.getPeso());
        System.out.println("Disciplina: " + Moregard.getDisciplina());
        System.out.println("Genero: " + Moregard.getGenero());
        System.out.println("Clasificado: " + Moregard.getClasificado());
        System.out.println("Puntuación: " + Moregard.getPuntuacion());
    }
}