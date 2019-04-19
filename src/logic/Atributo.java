package logic;

public class Atributo {
    String nombre;
    int valor;

    public Atributo(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
