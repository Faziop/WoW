package presentation.Equipar;

public class ViewEquipar extends javax.swing.JFrame {

    ControllerEquipar controller;
    ModelEquipar model;

    public ViewEquipar(ControllerEquipar controller, ModelEquipar me, ObjetoListModel equipamiento, ObjetoListModel inventario) {
        initComponents();
        this.controller = controller;
        this.model = me;
        listaEquipamiento.setModel(equipamiento);
        listaInventario.setModel(inventario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreDeJugador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEquipamiento = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaInventario = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valorIntelecto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        valorEstamina = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        valorMana = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        valorAgilidad = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        valorGolpeCritico = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        valorHipnosis = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        valorSuerte = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        valorVeneno = new javax.swing.JLabel();
        botonDesequipar = new javax.swing.JButton();
        botonEquipar = new javax.swing.JButton();

        nombreDeJugador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreDeJugador.setText("Nombre de jugador");

        listaEquipamiento.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Objeto 1", "Objeto 2", "Objeto 3", "..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaEquipamiento);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Atributos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Equipamiento");

        listaInventario.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Objeto 1", "Objeto 2", "Objeto 3", "..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaInventario);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Inventario");

        jLabel5.setText("Intelecto");

        valorIntelecto.setText("val1");

        jLabel7.setText("Estamina");

        valorEstamina.setText("val2");

        jLabel9.setText("Mana");

        valorMana.setText("val3");

        jLabel11.setText("Agilidad");

        valorAgilidad.setText("val4");

        jLabel13.setText("Golpe critico");

        valorGolpeCritico.setText("val5");

        jLabel15.setText("Hipnosis");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Encantamientos");

        valorHipnosis.setText("val6");

        jLabel18.setText("Suerte");

        valorSuerte.setText("val7");

        jLabel20.setText("Veneno");

        valorVeneno.setText("val 8");

        botonDesequipar.setText("Des-equipar");
        botonDesequipar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesequiparActionPerformed(evt);
            }
        });

        botonEquipar.setText("Equipar");
        botonEquipar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEquiparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDeJugador)
                            .addComponent(botonEquipar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonDesequipar)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valorIntelecto)
                                    .addComponent(valorEstamina)
                                    .addComponent(valorAgilidad)
                                    .addComponent(valorMana)
                                    .addComponent(valorGolpeCritico)
                                    .addComponent(valorHipnosis)
                                    .addComponent(valorVeneno)
                                    .addComponent(valorSuerte))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreDeJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonDesequipar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valorIntelecto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorEstamina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorMana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorAgilidad)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(valorGolpeCritico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorHipnosis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorSuerte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorVeneno)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEquipar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonDesequiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesequiparActionPerformed
        int seleccion = this.listaEquipamiento.getSelectedIndex();
        if (seleccion != -1) {
            controller.eliminarObjeto(seleccion);
        }
    }//GEN-LAST:event_botonDesequiparActionPerformed

    private void botonEquiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEquiparActionPerformed
        int seleccion = this.listaInventario.getSelectedIndex();
        if (seleccion != -1) {
            controller.agregarObjeto(seleccion);
        }
    }//GEN-LAST:event_botonEquiparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDesequipar;
    private javax.swing.JButton botonEquipar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaEquipamiento;
    private javax.swing.JList<String> listaInventario;
    private javax.swing.JLabel nombreDeJugador;
    private javax.swing.JLabel valorAgilidad;
    private javax.swing.JLabel valorEstamina;
    private javax.swing.JLabel valorGolpeCritico;
    private javax.swing.JLabel valorHipnosis;
    private javax.swing.JLabel valorIntelecto;
    private javax.swing.JLabel valorMana;
    private javax.swing.JLabel valorSuerte;
    private javax.swing.JLabel valorVeneno;
    // End of variables declaration//GEN-END:variables

    void actualizar() {
        this.repaint();
        
        this.listaInventario.setModel(this.model.getInventario());
        this.listaEquipamiento.setModel(this.model.getEquipamiento());
        
        this.valorIntelecto.setText(String.valueOf(this.model.getAtributos().get("Intelecto").getValor()));
        this.valorEstamina.setText(String.valueOf(this.model.getAtributos().get("Estamina").getValor()));
        this.valorMana.setText(String.valueOf(this.model.getAtributos().get("Mana").getValor()));
        this.valorAgilidad.setText(String.valueOf(this.model.getAtributos().get("Agilidad").getValor()));
        
        this.valorGolpeCritico.setText(String.valueOf(this.model.getEncantamientos().get("Golpe critico").getValor()));
        this.valorHipnosis.setText(String.valueOf(this.model.getEncantamientos().get("Hipnosis").getValor()));
        this.valorSuerte.setText(String.valueOf(this.model.getEncantamientos().get("Suerte").getValor()));
        this.valorVeneno.setText(String.valueOf(this.model.getEncantamientos().get("Veneno").getValor()));
    }

    public javax.swing.JLabel getNombreUsuario() {
        return this.nombreDeJugador;
    }
}
