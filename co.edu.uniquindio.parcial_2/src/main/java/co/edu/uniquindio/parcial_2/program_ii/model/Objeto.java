package co.edu.uniquindio.parcial_2.program_ii.model;

public class Objeto {
    private String nombre;
    private String idObjeto;
    private boolean disponible = true;
    private int vecesPrestado = 0;
    PrestamoObjeto ownedByPrestamoUq;

    public Objeto() {
    }

    public Objeto(String nombre, String idObjeto) {
        this.nombre = nombre;
        this.idObjeto = idObjeto;
    }

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                ", disponible=" + disponible +
                ", vecesPrestado=" + vecesPrestado +
                '}';
    }

    public boolean prestar(){
        if (!disponible) {
            return false;
        }
        vecesPrestado ++;
        disponible = false;
        return true;
    }

    public void incrementarPrestamos(){
        this.vecesPrestado ++;
    }
}
