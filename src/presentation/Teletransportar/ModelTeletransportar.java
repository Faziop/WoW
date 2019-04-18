/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Teletransportar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import logic.Jugador;

/**
 *
 * @author LoLER
 */
public class ModelTeletransportar extends Observable {
 
    private ArrayList<Jugador> jugadores;
    private DefaultTableModel tableModel;
    
        public ModelTeletransportar() {
    }
        
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
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
