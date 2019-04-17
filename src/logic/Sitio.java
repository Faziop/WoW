package logic;

/*
 * @author alefa
 */
public class Sitio {
    
    private int id;
    private String nombre;
    private String tipo;
    private Region region;

    public Sitio() {
    }

    public Sitio(int id, String nombre, String tipo, Region region) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    
}
