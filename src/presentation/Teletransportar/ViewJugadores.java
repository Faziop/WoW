package presentation.Teletransportar;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewJugadores extends javax.swing.JFrame implements Observer {

    private ModelTeletransportar model;
    private ControllerTeletransportar controller;

    public ViewJugadores() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableCellRenderer alinear = (DefaultTableCellRenderer) jt_jugadores.getCellRenderer(0, 0);
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setModel(ModelTeletransportar model) {
        this.model = model;
    }

    public void setController(ControllerTeletransportar controller) {
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
        jcb_region = new javax.swing.JComboBox<>();
        jl_region = new javax.swing.JLabel();
        jb_teletransportar = new javax.swing.JButton();

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

        jcb_region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azerot", "Kalindor", "Pandarian" }));

        jl_region.setText("Región:");

        jb_teletransportar.setText("Teletransportar");
        jb_teletransportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_teletransportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_teletransportar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_region)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_region)
                            .addComponent(jcb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jb_teletransportar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_teletransportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_teletransportarActionPerformed

        try {
            if (jt_jugadores.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < jt_jugadores.getSelectedRowCount(); i++){
                    controller.updateUbicacion(jt_jugadores.getValueAt(jt_jugadores.getSelectedRows()[i], 0).toString(), jcb_region.getSelectedIndex() + 1);    
                }
                
                this.cargarDatos();
                this.controller.getView().repaint();
                JOptionPane.showMessageDialog(null, "Teletransportado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El jugador no existe, o no está conectado actualmente.");
        }

    }//GEN-LAST:event_jb_teletransportarActionPerformed

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
    public void update(Observable o, Object arg) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_teletransportar;
    private javax.swing.JComboBox<String> jcb_region;
    private javax.swing.JLabel jl_region;
    private javax.swing.JTable jt_jugadores;
    // End of variables declaration//GEN-END:variables
}
