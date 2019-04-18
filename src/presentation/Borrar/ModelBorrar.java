package presentation.Borrar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import logic.Jugador;

/*
 * @author alefa
 */
public class ModelBorrar extends Observable {

    private DefaultTableModel tableModel;
    private ArrayList<Jugador> jugadores;

    public ModelBorrar() {
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void llenarTabla() {
        
    }

}
