package logic;

/*
 * @author alefa
 */
public class Jugador {

    private String nombre;
    private String genero;
    private String color;
    private int nivel;
    private Clase clase;
    private Raza raza;
    private Faccion faccion;
    private Sitio ubicacion;
    private boolean conectado;

    public Jugador() {
    }

    public Jugador(String nombre, String genero, String color, int nivel, Clase clase, Raza raza, Faccion faccion, Sitio ubicacion, boolean conectado) {
        this.nombre = nombre;
        this.genero = genero;
        this.color = color;
        this.nivel = nivel;
        this.clase = clase;
        this.raza = raza;
        this.faccion = faccion;
        this.ubicacion = ubicacion;
        this.conectado = conectado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

    public Sitio getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Sitio ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

}
