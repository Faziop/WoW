package presentation.menu;

import wow.Application;

/*
 * @author alefa
 */
public class ControllerMenu {

    private ModelMenu model;
    private ViewMenu view;

    public ControllerMenu(ModelMenu model, ViewMenu view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
    }

    public ModelMenu getModel() {
        return model;
    }

    public void setModel(ModelMenu model) {
        this.model = model;
    }

    public ViewMenu getView() {
        return view;
    }

    public void setView(ViewMenu view) {
        this.view = view;
    }

    public void menu(String opcion) {
        if (opcion.equals("Agregar")) {
            Application.CONTROLLER_AGREGAR.getView().setVisible(true);
        } else if (opcion.equals("Borrar")) {
            Application.CONTROLLER_BORRAR.getView().setVisible(true);
        }
    }
}
