package presentation.Teletransportar;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ViewTeletransportar extends javax.swing.JFrame implements Observer {

    private ModelTeletransportar model;
    private ControllerTeletransportar controller;

    public ViewTeletransportar() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        try{
        int w = 3482;
        int h = 995;
        File file = new File("C:\\Users\\LoLER\\OneDrive - Universidad Nacional de Costa Rica\\Documentos\\Bases de datos\\WoW\\src\\images\\Mapa.jpg");
        Image img = ImageIO.read(file);
        ImageIcon icon = new ImageIcon(ZoomImage(w, h, img));
        jLabel1.setIcon(icon);
        } catch(Exception e){}
    }
    
    public void setModel(ModelTeletransportar model) {
        this.model = model;
    }

    public void setController(ControllerTeletransportar controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jLabel1);

        jButton1.setText("Zoom -");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zoom +");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 957, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           
           int w = jLabel1.getWidth();
           int h = jLabel1.getHeight();
           File file = new File("C:\\Users\\LoLER\\OneDrive - Universidad Nacional de Costa Rica\\Documentos\\Bases de datos\\WoW\\src\\images\\Mapa.jpg");
           Image img = ImageIO.read(file);
           ImageIcon icon = new ImageIcon(ZoomImage(w-1000, h-1000, img));
           jLabel1.setIcon(icon);
       }
       catch(Exception e){
           
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
           
           int w = jLabel1.getWidth();
           int h = jLabel1.getHeight();
           File file = new File("C:\\Users\\LoLER\\OneDrive - Universidad Nacional de Costa Rica\\Documentos\\Bases de datos\\WoW\\src\\images\\Mapa.jpg");
           Image img = ImageIO.read(file);
           ImageIcon icon = new ImageIcon(ZoomImage(w+1000, h+1000, img));
           jLabel1.setIcon(icon);
       }
       catch(Exception e){
           
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
        int w = 3482;
        int h = 995;
        File file = new File("C:\\Users\\LoLER\\OneDrive - Universidad Nacional de Costa Rica\\Documentos\\Bases de datos\\WoW\\src\\images\\Mapa.jpg");
        Image img = ImageIO.read(file);
        ImageIcon icon = new ImageIcon(ZoomImage(w, h, img));
        jLabel1.setIcon(icon);
        } catch(Exception e){}
    }//GEN-LAST:event_jButton3ActionPerformed


    @Override
    public void update(Observable o, Object arg) {

    }
    
    private Image ZoomImage(int w, int h, Image img){
        BufferedImage buf = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        Graphics2D grf =  buf.createGraphics();
        grf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        grf.drawImage(img, 0, 0, w, h, null);
        grf.dispose();
        return buf;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
