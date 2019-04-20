package presentation.Listar;

public class ControllerListar {
    
    private ModelListar model;
    private ViewJugadores view;

    public ControllerListar(ModelListar model, ViewJugadores view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
    }

    public ModelListar getModel() {
        return model;
    }

    public void setModel(ModelListar model) {
        this.model = model;
    }
    
    public void llenarTabla() throws Exception {
        this.listaJugadores();
        this.model.llenarTabla();
    }
    
    public void listaJugadores() throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadoresFiltro(""));
    }

    public ViewJugadores getView() {
        return view;
    }

    public void actualizarTabla() throws Exception {
        this.model.llenarTabla();
    }
    
    public void actualizarDatos(String nombre) throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadoresFiltro(nombre));
    }

}
