/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Teletransportar;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author LoLER
 */
public class ModelTeletransportar extends Observable {
 
        public ModelTeletransportar() {
    }
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
