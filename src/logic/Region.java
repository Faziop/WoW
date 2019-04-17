package logic;

/*
 * @author alefa
 */
public class Region {

    private int id;
    private String nombre;
    private String capital;
    private Continente continente;

    public Region() {
    }

    public Region(int id, String nombre, String capital, Continente continente) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.continente = continente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }
}
