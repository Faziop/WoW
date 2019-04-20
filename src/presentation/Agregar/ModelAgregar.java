package presentation.Agregar;

import java.util.Observable;
import java.util.Observer;
import logic.Clase;
import logic.Faccion;
import logic.Jugador;
import logic.Raza;
import logic.Sitio;

/*
 * @author alefa
 */
public class ModelAgregar extends Observable {

    private Jugador jugador;
    private Raza raza;
    private Clase clase;
    private Faccion faccion;
    private Sitio sitio;

    public ModelAgregar() {
        this.jugador = new Jugador();
        this.raza = new Raza();
        this.clase = new Clase();
        this.faccion = new Faccion();
        this.sitio = new Sitio();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public void agregar() {
        this.jugador.setClase(clase);
        this.jugador.setFaccion(faccion);
        this.jugador.setRaza(raza);
        this.jugador.setUbicacion(sitio);
    }
}
