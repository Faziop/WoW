package presentation.Localizar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import logic.Jugador;

public class ModelLocalizar extends Observable {
 
    private ArrayList<Jugador> jugadores;
    private DefaultTableModel tableModel;
    private Jugador jugador;
    
    public ModelLocalizar() {}
        
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    public void llenarTabla() {
        for(Jugador j : this.jugadores){
            Object[] o = new Object[]{j.getNombre(), j.getRaza().getNombre(), j.getClase().getNombre(), j.getUbicacion().getNombre()};
            this.tableModel.addRow(o);
        }
    } 
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
