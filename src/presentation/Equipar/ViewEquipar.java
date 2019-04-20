package presentation.Equipar;

import javax.swing.DefaultComboBoxModel;

public class ViewEquipar extends javax.swing.JFrame {

    ControllerEquipar controller;
    ModelEquipar model;

    public ViewEquipar() {
        initComponents();
    }

    public ModelEquipar getModel() {
        return model;
    }

    public void setModel(ModelEquipar model) {
        this.model = model;
    }

    public ControllerEquipar getController() {
        return controller;
    }

    public void setController(ControllerEquipar controller) {
        this.controller = controller;
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
        labelIntelecto = new javax.swing.JLabel();
        valorIntelecto = new javax.swing.JLabel();
        labelEstamina = new javax.swing.JLabel();
        valorEstamina = new javax.swing.JLabel();
        labelMana = new javax.swing.JLabel();
        valorMana = new javax.swing.JLabel();
        labelAgilidad = new javax.swing.JLabel();
        valorAgilidad = new javax.swing.JLabel();
        labelGolpeCritico = new javax.swing.JLabel();
        valorGolpeCritico = new javax.swing.JLabel();
        labelHipnosis = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        valorHipnosis = new javax.swing.JLabel();
        labelSuerte = new javax.swing.JLabel();
        valorSuerte = new javax.swing.JLabel();
        labelVeneno = new javax.swing.JLabel();
        valorVeneno = new javax.swing.JLabel();
        botonDesequipar = new javax.swing.JButton();
        botonEquipar = new javax.swing.JButton();
        labelArmamento = new javax.swing.JLabel();
        valorArmamento = new javax.swing.JLabel();
        nombreDeRazaYClase = new javax.swing.JLabel();
        jugadoresAEquipar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        nombreDeJugador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreDeJugador.setText("-");

        jScrollPane1.setViewportView(listaEquipamiento);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Atributos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Equipamiento");

        jScrollPane2.setViewportView(listaInventario);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Inventario");

        labelIntelecto.setText("Intelecto");

        valorIntelecto.setText("-");

        labelEstamina.setText("Estamina");

        valorEstamina.setText("-");

        labelMana.setText("Mana");

        valorMana.setText("-");

        labelAgilidad.setText("Agilidad");

        valorAgilidad.setText("-");

        labelGolpeCritico.setText("Golpe critico");

        valorGolpeCritico.setText("-");

        labelHipnosis.setText("Hipnosis");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Encantamientos");

        valorHipnosis.setText("-");

        labelSuerte.setText("Suerte");

        valorSuerte.setText("-");

        labelVeneno.setText("Veneno");

        valorVeneno.setText("-");

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

        labelArmamento.setText("Armamento");

        valorArmamento.setText("-");

        nombreDeRazaYClase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreDeRazaYClase.setText("-");

        jugadoresAEquipar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadoresAEquiparActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione al jugador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(botonEquipar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDeJugador)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonDesequipar)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDeRazaYClase)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelGolpeCritico)
                                            .addComponent(labelHipnosis)
                                            .addComponent(labelVeneno)
                                            .addComponent(labelSuerte))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valorGolpeCritico)
                                            .addComponent(valorHipnosis)
                                            .addComponent(valorVeneno)
                                            .addComponent(valorSuerte)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelAgilidad)
                                            .addComponent(labelMana)
                                            .addComponent(labelIntelecto)
                                            .addComponent(labelEstamina))
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valorIntelecto)
                                            .addComponent(valorEstamina)
                                            .addComponent(valorAgilidad)
                                            .addComponent(valorMana)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(labelArmamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(valorArmamento)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(39, 39, 39))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(64, 64, 64))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jugadoresAEquipar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreDeJugador)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonDesequipar)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreDeRazaYClase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelIntelecto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelEstamina)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelMana)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelAgilidad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valorIntelecto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valorEstamina)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valorMana)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valorAgilidad)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelArmamento)
                                    .addComponent(valorArmamento, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelGolpeCritico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelHipnosis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelSuerte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelVeneno))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(valorGolpeCritico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorHipnosis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorSuerte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorVeneno)))))
                .addGap(17, 17, 17)
                .addComponent(botonEquipar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadoresAEquipar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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

    private void jugadoresAEquiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadoresAEquiparActionPerformed
        this.controller.actualizarModel();
        this.actualizar();
        this.jugadoresAEquipar.setFocusable(false);
    }//GEN-LAST:event_jugadoresAEquiparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDesequipar;
    private javax.swing.JButton botonEquipar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jugadoresAEquipar;
    private javax.swing.JLabel labelAgilidad;
    private javax.swing.JLabel labelArmamento;
    private javax.swing.JLabel labelEstamina;
    private javax.swing.JLabel labelGolpeCritico;
    private javax.swing.JLabel labelHipnosis;
    private javax.swing.JLabel labelIntelecto;
    private javax.swing.JLabel labelMana;
    private javax.swing.JLabel labelSuerte;
    private javax.swing.JLabel labelVeneno;
    private javax.swing.JList<String> listaEquipamiento;
    private javax.swing.JList<String> listaInventario;
    private javax.swing.JLabel nombreDeJugador;
    private javax.swing.JLabel nombreDeRazaYClase;
    private javax.swing.JLabel valorAgilidad;
    private javax.swing.JLabel valorArmamento;
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

        String nombreDeJugador = this.model.getJugador().getNombre();

        this.nombreDeJugador.setText(nombreDeJugador);
        this.nombreDeRazaYClase.setText(this.model.getJugador().getRaza().getNombre() + " " + this.model.getJugador().getClase().getNombre());
        this.listaInventario.setModel(this.model.getInventario());
        this.listaEquipamiento.setModel(this.model.getEquipamiento());

        if (this.model.getAtributos().get("Intelecto") == null) {
            this.labelIntelecto.setEnabled(false);
            this.valorIntelecto.setEnabled(false);
            this.valorIntelecto.setText("-");
        } else {
            this.valorIntelecto.setText(String.valueOf(this.model.getAtributos().get("Intelecto").getValor()));
        }

        if (this.model.getAtributos().get("Estamina") == null) {
            this.labelEstamina.setEnabled(false);
            this.valorEstamina.setEnabled(false);
            this.valorEstamina.setText("-");
        } else {
            this.valorEstamina.setText(String.valueOf(this.model.getAtributos().get("Estamina").getValor()));
        }

        if (this.model.getAtributos().get("Mana") == null) {
            this.labelMana.setEnabled(false);
            this.valorMana.setEnabled(false);
            this.valorMana.setText("-");
        } else {
            this.valorMana.setText(String.valueOf(this.model.getAtributos().get("Mana").getValor()));
        }

        if (this.model.getAtributos().get("Agilidad") == null) {
            this.labelAgilidad.setEnabled(false);
            this.valorAgilidad.setEnabled(false);
            this.valorAgilidad.setText("-");
        } else {
            this.valorAgilidad.setText(String.valueOf(this.model.getAtributos().get("Agilidad").getValor()));
        }

        if (this.model.getAtributos().get("Armamento") == null) {
            this.labelArmamento.setEnabled(false);
            this.valorArmamento.setEnabled(false);
            this.valorArmamento.setText("-");
        } else {
            this.valorArmamento.setText(String.valueOf(this.model.getAtributos().get("Armamento").getValor()));
        }

        if (this.model.getEncantamientos().get("Golpe critico") == null) {
            this.valorGolpeCritico.setText("0");
        } else {
            this.valorGolpeCritico.setText(String.valueOf(this.model.getEncantamientos().get("Golpe critico").getValor()));
        }

        if (this.model.getEncantamientos().get("Hipnosis") == null) {
            this.valorHipnosis.setText("0");
        } else {
            this.valorHipnosis.setText(String.valueOf(this.model.getEncantamientos().get("Hipnosis").getValor()));
        }

        if (this.model.getEncantamientos().get("Suerte") == null) {
            this.valorSuerte.setText("0");
        } else {
            this.valorSuerte.setText(String.valueOf(this.model.getEncantamientos().get("Suerte").getValor()));
        }

        if (this.model.getEncantamientos().get("Veneno") == null) {
            this.valorVeneno.setText("0");
        } else {
            this.valorVeneno.setText(String.valueOf(this.model.getEncantamientos().get("Veneno").getValor()));
        }
    }

    public String getJugadorAEquipar() {
        return (String) this.jugadoresAEquipar.getSelectedItem();
    }

    public void setJugadoresAEquipar(DefaultComboBoxModel jugadores) {
        this.jugadoresAEquipar.setModel(jugadores);
    }
}
