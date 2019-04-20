package presentation.Equipar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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

        try {
            if (this.model.getJugador().getNivel() >= objetoEquipado.getNivel()) {

                this.model.actualizarEstadoDeObjeto(objetoEquipado.getId(), objeto.getAtributos(), objeto.getEncantamientos());
                this.model.getEquipamiento().addObjeto(objeto);

                this.model.getInventario().eliminarObjeto(seleccion);

                this.actualizarModel();
            } else {
                JOptionPane.showMessageDialog(null, "El nivel del personaje es menor al nivel requerido del objeto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }

            this.view.actualizar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    void eliminarObjeto(int seleccion) {
        ContendedorDeObjeto objeto = this.model.getEquipamiento().getObjeto(seleccion);
        Objeto objetoEquipado = objeto.getObjeto();

        try {
            if (this.model.getJugador().getNivel() >= objetoEquipado.getNivel()) {

                this.model.actualizarEstadoDeObjeto(objetoEquipado.getId(), objeto.getAtributos(), objeto.getEncantamientos());
                this.model.getInventario().addObjeto(objeto);

                this.model.getEquipamiento().eliminarObjeto(seleccion);

                this.actualizarModel();
            }

            this.view.actualizar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrar() {
        this.view.setVisible(true);

        this.actualizarModel();

        this.view.setJugadoresAEquipar(new DefaultComboBoxModel(this.model.getJugadores()));
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
