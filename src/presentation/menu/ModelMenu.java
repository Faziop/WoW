package presentation.menu;

import java.util.Observable;
import java.util.Observer;

/*
 * @author alefa
 */
public class ModelMenu extends Observable {
    
    public ModelMenu(){
        
    }
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
