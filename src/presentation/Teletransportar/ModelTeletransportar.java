/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Teletransportar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import logic.Jugador;

/**
 *
 * @author LoLER
 */
public class ModelTeletransportar extends Observable {
 
    private ArrayList<Jugador> jugadores;
    
        public ModelTeletransportar() {
    }
        
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
