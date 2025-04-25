package co.edu.uniquindio.parcial_2.program_ii.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private int prestamosRealizados = 0;
    private int vecesPrestado = 0;


    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrestamosRealizados() {
        return prestamosRealizados;
    }

    public void setPrestamosRealizados(int prestamosRealizados) {
        this.prestamosRealizados = prestamosRealizados;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", prestamosRealizados=" + prestamosRealizados +
                ", vecesPrestado=" + vecesPrestado +
                '}';
    }

    public void indicarEdad(){
        System.out.println("Hola mi edad es: " + this.edad);
    }

    public void incrementarPrestamos(){
        this.prestamosRealizados ++;
    }


    public String nombre() {
        return nombre;
    }

    public int vecesPrestado() {
        return vecesPrestado;
    }
}
