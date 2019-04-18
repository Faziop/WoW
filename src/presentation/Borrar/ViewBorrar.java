package presentation.Borrar;

import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;

/*
 * @author alefa
 */
public class ViewBorrar extends javax.swing.JFrame implements Observer{

    private ModelBorrar model;
    private ControllerBorrar controller;
    
    public ViewBorrar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setModel(ModelBorrar model) {
        this.model = model;
    }

    public void setController(ControllerBorrar controller) {
        this.controller = controller;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.model.setTableModel((DefaultTableModel) jt_jugadores.getModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_jugadores = new javax.swing.JTable();
        jb_borrar = new javax.swing.JButton();

        setTitle("Listado");
        setResizable(false);

        jt_jugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nivel", "Género", "Raza", "Clase", "Facción", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_jugadores);

        jb_borrar.setText("Borrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_borrar)
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_borrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JTable jt_jugadores;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void update(Observable o, Object arg) {
    }
}
