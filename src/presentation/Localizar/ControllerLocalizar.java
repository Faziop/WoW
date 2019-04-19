package presentation.Localizar;

import presentation.Teletransportar.*;

public class ControllerLocalizar {
    
    private ModelLocalizar model;
    private ViewJugadores view;
    public ViewLocalizar viewLocalizar;

    public ControllerLocalizar(ModelLocalizar model, ViewJugadores view) {
        this.model = model;
        this.view = view;
        this.viewLocalizar = new ViewLocalizar();
        this.viewLocalizar.setController(this);
        this.viewLocalizar.setModel(this.model);
        this.model.addObserver(view);
        this.model.addObserver(viewLocalizar);
        view.setModel(model);
        view.setController(this);
    }

    public ModelLocalizar getModel() {
        return model;
    }

    public void setModel(ModelLocalizar model) {
        this.model = model;
    }
    
    public void llenarTabla() throws Exception {
        this.listaJugadores();
        this.model.llenarTabla();
    }
    
    public void listaJugadores() throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadoresTele());
    }

    public ViewJugadores getView() {
        return view;
    }

    public void updateUbicacion(String nombre, Integer ubicacion) throws Exception {
        logic.Model.instance().getDb().updateUbicacion(nombre, ubicacion);
    }

    public void getJugador(String nombre) throws Exception {
        this.model.setJugador(logic.Model.instance().getDb().getJugador(nombre));
    }
}
