public class Deportista{
    //Caracteristicas de los deportistas
    private String nombre;
    private String apellido;
    private int edad;
    private double peso;
    private String disciplina;
    private String genero;
    private boolean clasificado;
    private double puntuacion;
    //Constructor
    public Deportista (String nombre, String apellido, int edad, double peso, String disciplina, String genero, boolean clasificado, double puntuacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.disciplina = disciplina;
        this.genero = genero;
        this.clasificado = clasificado;
        this.puntuacion = puntuacion;
    }
    //getters
    public String getNombre(){
        return nombre;  
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public double getPeso(){
        return peso;
    }
    public String getDisciplina(){
        return disciplina;
    }
    public String getGenero(){
        return genero;
    }
    public boolean getClasificado(){
        return clasificado;
    }
    public double getPuntuacion(){
        return puntuacion;
    }
    
}