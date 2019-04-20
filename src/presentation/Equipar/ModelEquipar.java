package presentation.Equipar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import logic.Atributo;
import logic.Encantamiento;
import logic.Jugador;
import logic.Objeto;

public class ModelEquipar {

    private Vector<String> jugadores;
    private Jugador jugador;
    private HashMap<String, Atributo> atributos;
    private HashMap<String, Encantamiento> encantamientos;
    private ObjetoListModel equipamiento;
    private ObjetoListModel inventario;

    public ModelEquipar() {
        this.jugadores = new Vector<>();
        this.jugador = new Jugador();
        this.atributos = new HashMap();
        this.encantamientos = new HashMap();
        this.equipamiento = new ObjetoListModel();
        this.inventario = new ObjetoListModel();
    }

    public Vector<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Vector<String> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public HashMap<String, Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(HashMap<String, Atributo> atributos) {
        this.atributos = atributos;
    }

    public HashMap<String, Encantamiento> getEncantamientos() {
        return encantamientos;
    }

    public void setEncantamientos(HashMap<String, Encantamiento> encantamientos) {
        this.encantamientos = encantamientos;
    }

    public ObjetoListModel getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(ObjetoListModel equipamiento) {
        this.equipamiento = equipamiento;
    }

    public ObjetoListModel getInventario() {
        return inventario;
    }

    public void setInventario(ObjetoListModel inventario) {
        this.inventario = inventario;
    }

    public void obtenerJugador(String nombre) throws Exception {
        this.jugador = logic.Model.instance().getDb().getJugador1(nombre);
    }

    public void obtenerAtributosDeJugador(String nombre) {
        this.setAtributos(logic.Model.instance().getDb().getAtributosDeJugador(nombre));
    }

    public void obtenerEncantamientosDeJugador(String nombre) {
        this.setEncantamientos(logic.Model.instance().getDb().getEncantamientosDeJugador(nombre));
    }

    public void obtenerObjetosDeJugador(String nombre) {
        String nombreDeJugador = jugador.getNombre();
        
        ObjetoListModel nuevoEquipamiento = new ObjetoListModel();

        for (Objeto obj : logic.Model.instance().getDb().getObjetosDeJugador(nombreDeJugador, 1)) {
            nuevoEquipamiento.addObjeto(new ContendedorDeObjeto(obj, logic.Model.instance().getDb().getAtributosDeJugadorModificadosPorObjeto(obj.getId(), nombreDeJugador), logic.Model.instance().getDb().getEncantamientosDeJugadorModificadosPorObjeto(obj.getId(), nombreDeJugador)));
        }
        
        ObjetoListModel nuevoInventario = new ObjetoListModel();

        for (Objeto obj : logic.Model.instance().getDb().getObjetosDeJugador(nombreDeJugador, 0)) {
            nuevoInventario.addObjeto(new ContendedorDeObjeto(obj, logic.Model.instance().getDb().getAtributosDeJugadorModificadosPorObjeto(obj.getId(), nombreDeJugador), logic.Model.instance().getDb().getEncantamientosDeJugadorModificadosPorObjeto(obj.getId(), nombreDeJugador)));
        }
        
        this.setEquipamiento(nuevoEquipamiento);
        this.setInventario(nuevoInventario);
    }

    public void obtenerJugadoresAEquipar() {
        this.setJugadores(logic.Model.instance().getDb().getJugadoresAEquipar());
    }

    public void actualizarEstadoDeObjeto(int id, ArrayList<Atributo> atributos) {
        logic.Model.instance().getDb().actualizarEstadoDeObjeto(id, this.getJugador().getClase().getId(), this.getJugador().getNombre(), atributos);
    }
}
