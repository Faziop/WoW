package presentation.Agregar;

public class ControllerAgregar {

    private ModelAgregar model;
    private ViewAgregar view;

    public ControllerAgregar(ModelAgregar model, ViewAgregar view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
    }

    public ModelAgregar getModel() {
        return model;
    }

    public void setModel(ModelAgregar model) {
        this.model = model;
    }

    public ViewAgregar getView() {
        return view;
    }

    public void setView(ViewAgregar view) {
        this.view = view;
    }

    public void agregar() throws Exception {
        this.model.agregar();
        logic.Model.instance().getDb().agregarJugador(this.model.getJugador());
    }
}
