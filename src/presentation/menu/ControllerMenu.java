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
        switch (opcion) {
            case "Agregar":
                Application.CONTROLLER_AGREGAR.getView().setVisible(true);
                break;
            case "Borrar":
                Application.CONTROLLER_BORRAR.getView().setVisible(true);
                break;
            case "Equipar":
                Application.CONTROLLER_EQUIPAR.mostrar();
                break;
            case "Teletransportar":
                Application.CONTROLLER_TELETRANSPORTAR.getView().setVisible(true);
                break;
            case "Localizar":
                Application.CONTROLLER_LOCALIZAR.getView().setVisible(true);
                break; 
            case "Listar":
                Application.CONTROLLER_LISTAR.getView().setVisible(true);
                break; 
            default:
                break;
        }
    }
}
