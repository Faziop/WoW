package presentation.Localizar;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewJugadores extends javax.swing.JFrame implements Observer {

    private ModelLocalizar model;
    private ControllerLocalizar controller;

    public ViewJugadores() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableCellRenderer alinear = (DefaultTableCellRenderer) jt_jugadores.getCellRenderer(0, 0);
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setModel(ModelLocalizar model) {
        this.model = model;
    }

    public void setController(ControllerLocalizar controller) {
        this.controller = controller;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jt_jugadores = new javax.swing.JTable();
        jb_localizar = new javax.swing.JButton();

        setTitle("Jugadores online");
        setResizable(false);

        jt_jugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Jugador", "Clase", "Raza", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jt_jugadores);

        jb_localizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jb_localizar.setText("Localizar");
        jb_localizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_localizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jb_localizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_localizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_localizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_localizarActionPerformed
        try {
            if (jt_jugadores.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (jt_jugadores.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Más de una fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                controller.getJugador(jt_jugadores.getValueAt(jt_jugadores.getSelectedRow(), 0).toString());
            }

            this.controller.viewLocalizar.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El jugador no existe, o no está conectado actualmente.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.cargarDatos();
        
    }//GEN-LAST:event_jb_localizarActionPerformed

    public void cargarDatos() {
        DefaultTableModel d = (DefaultTableModel) jt_jugadores.getModel();
        this.model.setTableModel(d);
        this.model.getTableModel().setRowCount(0);

        try {
            this.controller.llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_localizar;
    private javax.swing.JTable jt_jugadores;
    // End of variables declaration//GEN-END:variables
}
