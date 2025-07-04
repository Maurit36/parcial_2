package co.edu.uniquindio.parcial_2.program_ii.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;


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


    public void indicarEdad(){
        System.out.println("Hola mi edad es: " + this.edad);
    }



}
