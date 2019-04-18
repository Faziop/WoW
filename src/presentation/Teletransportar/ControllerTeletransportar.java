package presentation.Teletransportar;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerTeletransportar {
    
    private ModelTeletransportar model;
    private ViewTeletransportar view;

    public ControllerTeletransportar(ModelTeletransportar model, ViewTeletransportar view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
        try {
            this.listaJugadores();
        } catch (Exception ex) {
            
        }
    }

    public ModelTeletransportar getModel() {
        return model;
    }

    public void setModel(ModelTeletransportar model) {
        this.model = model;
    }
    
    public void listaJugadores() throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadoresTele());
    }

    public ViewTeletransportar getView() {
        return view;
    }
}
