package logic;

public class Atributo {
    int identificador;
    String nombre;
    int valor;

    public Atributo() {
    }

    public Atributo(int identificador, String nombre, int valor) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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
