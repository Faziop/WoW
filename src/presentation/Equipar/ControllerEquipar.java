package presentation.Equipar;

import javax.swing.DefaultComboBoxModel;
import logic.Objeto;

public class ControllerEquipar {

    ModelEquipar model;
    ViewEquipar view;

    public ControllerEquipar(ModelEquipar me, ViewEquipar ve) {
        this.model = me;
        this.view = ve;
        view.setModel(me);
        view.setController(this);
    }

    void agregarObjeto(int seleccion) {
        ContendedorDeObjeto objeto = this.model.getInventario().getObjeto(seleccion);
        Objeto objetoEquipado = objeto.getObjeto();

//        Verificar estado de objeto y SQL
        try {
            if (this.model.getJugador().getNivel() >= objetoEquipado.getNivel()) {
                this.model.getEquipamiento().addObjeto(objeto);

                this.model.actualizarEstadoDeObjeto(objetoEquipado.getId(), objeto.getAtributos());

                this.model.getInventario().eliminarObjeto(seleccion);

                this.actualizarModel();
            }

            this.view.actualizar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void eliminarObjeto(int seleccion) {
        ContendedorDeObjeto objeto = this.model.getEquipamiento().getObjeto(seleccion);

//        SQL        
        this.model.getInventario().addObjeto(objeto);

        this.model.getEquipamiento().eliminarObjeto(seleccion);

        this.view.actualizar();
    }

    public void mostrar() {
        this.view.setVisible(true);

        this.actualizarModel();
    }

    public void actualizarModel() {
        try {
            this.model.obtenerJugadoresAEquipar();

            if (this.view.getJugadorAEquipar() != null) {
                this.model.obtenerJugador(this.view.getJugadorAEquipar());
                String nombreDeJugador = this.model.getJugador().getNombre();
                this.model.obtenerAtributosDeJugador(nombreDeJugador);
                this.model.obtenerEncantamientosDeJugador(nombreDeJugador);
                this.model.obtenerObjetosDeJugador(nombreDeJugador);
            }

            this.view.setJugadoresAEquipar(new DefaultComboBoxModel(this.model.getJugadores()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
