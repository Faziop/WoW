package presentation.Equipar;

import logic.Objeto;

public class ControllerEquipar {

    ModelEquipar model;
    ViewEquipar view;

    public ControllerEquipar(ModelEquipar me) {
        this.model = me;
        view = new ViewEquipar(this, me, this.model.getEquipamiento(), this.model.getEquipamiento());
    }

    void agregarObjeto(int seleccion) {
        ContendedorDeObjeto objeto = this.model.getInventario().getObjeto(seleccion);

//        Verificar estado de objeto
        try {
        this.model.getEquipamiento().addObjeto(objeto);
        
        this.model.getInventario().eliminarObjeto(seleccion);
        
        this.actualizarView();
            
        } catch (Exception ex) { System.out.println(ex.getMessage());}
    }

    void eliminarObjeto(int seleccion) {
        ContendedorDeObjeto objeto = this.model.getEquipamiento().getObjeto(seleccion);
        
        this.model.getInventario().addObjeto(objeto);
        
        this.model.getEquipamiento().eliminarObjeto(seleccion);
        
        this.actualizarView();
    }
    
    void actualizarView() {
        this.view.actualizar();      
    }

    public void mostrar() {
        this.view.setVisible(true);
        this.view.getNombreUsuario().setText(this.model.getJugador().getNombre());
        
        this.actualizarView();    
    }
}
