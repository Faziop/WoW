package presentation.Teletransportar;

public class ControllerTeletransportar {
    
    private ModelTeletransportar model;
    private ViewTeletransportar view;
    public ViewJugadores viewJugadores;

    public ControllerTeletransportar(ModelTeletransportar model, ViewTeletransportar view) {
        this.model = model;
        this.view = view;
        this.viewJugadores = new ViewJugadores();
        this.viewJugadores.setController(this);
        this.viewJugadores.setModel(this.model);
        this.model.addObserver(view);
        this.model.addObserver(viewJugadores);
        view.setModel(model);
        view.setController(this);
    }

    public ModelTeletransportar getModel() {
        return model;
    }

    public void setModel(ModelTeletransportar model) {
        this.model = model;
    }
    
    public void llenarTabla() throws Exception {
        this.listaJugadores();
        this.model.llenarTabla();
    }
    
    public void listaJugadores() throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadoresTele());
    }

    public ViewTeletransportar getView() {
        return view;
    }

    public void updateUbicacion(String nombre, Integer ubicacion) throws Exception {
        logic.Model.instance().getDb().updateUbicacion(nombre, ubicacion);
    }
}
