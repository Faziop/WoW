package presentation.Teletransportar;


public class ControllerTeletransportar {
    
    private ModelTeletransportar model;
    private ViewTeletransportar view;

    public ControllerTeletransportar(ModelTeletransportar model, ViewTeletransportar view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(view);
        view.setModel(model);
        view.setController(this);
    }

    public ModelTeletransportar getModel() {
        return model;
    }

    public void setModel(ModelTeletransportar model) {
        this.model = model;
    }

    public ViewTeletransportar getView() {
        return view;
    }
}
