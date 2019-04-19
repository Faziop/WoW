package presentation.Agregar;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * @author alefa
 */
public class ViewAgregar extends javax.swing.JFrame implements Observer {

    private ModelAgregar model;
    private ControllerAgregar controller;

    public ViewAgregar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setModel(ModelAgregar model) {
        this.model = model;
    }

    public void setController(ControllerAgregar controller) {
        this.controller = controller;
    }

    public void isValido() throws Exception {
        boolean valido = true;
        this.jl_nombre.setForeground(Color.getColor("[0, 0, 0]"));
        this.jl_genero.setForeground(Color.getColor("[0, 0, 0]"));

        if (this.jtf_nombre.getText().equals("")) {
            this.jl_nombre.setForeground(Color.red);
            valido = false;
        }

        if (!this.jrb_femenino.isSelected() && !this.jrb_masculino.isSelected()) {
            this.jl_genero.setForeground(Color.red);
            valido = false;
        }

        if (!valido) {
            throw new Exception("Campos requeridos sin llenar");
        }
    }

    public void validarRaza() throws Exception {
        this.jl_raza.setForeground(Color.getColor("[0, 0, 0]"));
        this.jl_faccion.setForeground(Color.getColor("[0, 0, 0]"));

        if (this.jcb_raza.getSelectedIndex() >= 0 && this.jcb_raza.getSelectedIndex() <= 5 && this.jcb_faccion.getSelectedIndex() != 0) {
            this.jl_raza.setForeground(Color.red);
            this.jl_faccion.setForeground(Color.red);
            throw new Exception("Raza no pertenece a la facción");
        }

        if (this.jcb_raza.getSelectedIndex() >= 6 && this.jcb_raza.getSelectedIndex() <= 11 && this.jcb_faccion.getSelectedIndex() != 1) {
            this.jl_raza.setForeground(Color.red);
            this.jl_faccion.setForeground(Color.red);
            throw new Exception("Raza no pertenece a la facción");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_genero = new javax.swing.ButtonGroup();
        jl_nombre = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jl_genero = new javax.swing.JLabel();
        jrb_masculino = new javax.swing.JRadioButton();
        jrb_femenino = new javax.swing.JRadioButton();
        jl_color = new javax.swing.JLabel();
        jl_raza = new javax.swing.JLabel();
        jcb_raza = new javax.swing.JComboBox<>();
        jcb_color = new javax.swing.JComboBox<>();
        jb_raza = new javax.swing.JButton();
        jl_clase = new javax.swing.JLabel();
        jcb_clase = new javax.swing.JComboBox<>();
        jb_aceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jl_faccion = new javax.swing.JLabel();
        jcb_faccion = new javax.swing.JComboBox<>();

        setTitle("Agregar");
        setResizable(false);

        jl_nombre.setText("Nombre:");

        jl_genero.setText("Género:");

        jbg_genero.add(jrb_masculino);
        jrb_masculino.setText("Masculino");

        jbg_genero.add(jrb_femenino);
        jrb_femenino.setText("Femenino");

        jl_color.setText("Color:");

        jl_raza.setText("Raza:");

        jcb_raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Enano", "Elfo de la noche", "Gnomo", "Draenei", "Hombre Lobo", "Orco", "No muerto", "Tauren", "Trol", "Elfo de sangre", "Goblin", "Panda" }));
        jcb_raza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_razaActionPerformed(evt);
            }
        });

        jcb_color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blanco", "Moreno", "Negro" }));

        jb_raza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Humano.jpg"))); // NOI18N
        jb_raza.setBorderPainted(false);

        jl_clase.setText("Clase:");

        jcb_clase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Paladin", "Cazador", "Ladron", "Sacerdote", "Chaman", "Mago", "Brujo", "Monge", "Druida" }));

        jb_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aceptar.png"))); // NOI18N
        jb_aceptar.setText("Aceptar");
        jb_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_aceptarActionPerformed(evt);
            }
        });

        jl_faccion.setText("Facción:");

        jcb_faccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alianza", "Horda" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_genero)
                                    .addComponent(jl_clase))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcb_clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrb_masculino)
                                    .addComponent(jrb_femenino))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_color)
                                    .addComponent(jl_raza))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcb_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_faccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcb_faccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jb_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_raza, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nombre)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_raza)
                            .addComponent(jcb_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jl_genero))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jl_color)
                                            .addComponent(jcb_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jrb_masculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrb_femenino)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_clase)
                            .addComponent(jcb_clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_faccion)
                            .addComponent(jcb_faccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jb_raza)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_razaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_razaActionPerformed
        this.jb_raza.setIcon(new ImageIcon(getClass().getResource("/images/" + this.jcb_raza.getSelectedItem() + ".jpg")));
    }//GEN-LAST:event_jcb_razaActionPerformed

    public void limpiar() {
        this.jtf_nombre.setText("");
        this.jbg_genero.clearSelection();
    }

    private void jb_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_aceptarActionPerformed
        try {
            this.isValido();
            this.validarRaza();
            this.model.getJugador().setNombre(this.jtf_nombre.getText());
            this.model.getJugador().setColor(this.jcb_color.getSelectedItem() + "");
            this.model.getJugador().setConectado(true);
            this.model.getJugador().setNivel(0);
            if (this.jrb_femenino.isSelected()) {
                this.model.getJugador().setGenero("Femenino");
            } else {
                this.model.getJugador().setGenero("Masculino");
            }

            this.model.getClase().setId(jcb_clase.getSelectedIndex() + 1);
            this.model.getClase().setNombre(jcb_clase.getSelectedItem() + "");

            this.model.getFaccion().setId(jcb_faccion.getSelectedIndex() + 1);
            this.model.getFaccion().setNombre(jcb_faccion.getSelectedItem() + "");

            this.model.getRaza().setId(jcb_raza.getSelectedIndex() + 1);
            this.model.getRaza().setNombre(jcb_raza.getSelectedItem() + "");

            this.controller.agregar();
            this.limpiar();
            JOptionPane.showMessageDialog(null, "Se agregó correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_aceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jb_aceptar;
    private javax.swing.JButton jb_raza;
    private javax.swing.ButtonGroup jbg_genero;
    private javax.swing.JComboBox<String> jcb_clase;
    private javax.swing.JComboBox<String> jcb_color;
    private javax.swing.JComboBox<String> jcb_faccion;
    private javax.swing.JComboBox<String> jcb_raza;
    private javax.swing.JLabel jl_clase;
    private javax.swing.JLabel jl_color;
    private javax.swing.JLabel jl_faccion;
    private javax.swing.JLabel jl_genero;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_raza;
    private javax.swing.JRadioButton jrb_femenino;
    private javax.swing.JRadioButton jrb_masculino;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {

    }
}
