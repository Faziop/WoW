package presentation.Borrar;

/*
 * @author alefa
 */
public class ControllerBorrar {

    private ModelBorrar model;
    private ViewBorrar view;

    public ControllerBorrar(ModelBorrar model, ViewBorrar view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
    }

    public ModelBorrar getModel() {
        return model;
    }

    public void setModel(ModelBorrar model) {
        this.model = model;
    }

    public ViewBorrar getView() {
        return view;
    }

    public void setView(ViewBorrar view) {
        this.view = view;
    }

    public void llenarTabla() throws Exception {
        this.listaJugadores();
        this.model.llenarTabla();
    }

    public void listaJugadores() throws Exception {
        this.model.setJugadores(logic.Model.instance().getDb().listaJugadores());
    }

    public void borrar(String nombre) throws Exception {

    }
}
