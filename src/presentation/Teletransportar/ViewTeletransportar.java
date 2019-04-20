package presentation.Teletransportar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import logic.Jugador;

public class ViewTeletransportar extends javax.swing.JFrame implements Observer {

    private ModelTeletransportar model;
    private ControllerTeletransportar controller;
    private BufferedImage image;
    
    public ViewTeletransportar() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.setLocationRelativeTo(null);
        this.repaint();
    }

    @Override
    public void setVisible(boolean b) {
        try {
            super.setVisible(b);
            this.controller.listaJugadores();
        } catch (Exception ex) {
            
        }
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
        jButton4 = new javax.swing.JButton();

        setTitle("Mapa");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

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

        jButton4.setText("Teleport");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(3, 3, 3)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(3, 3, 3)
                        .addComponent(jButton3)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           
           int w = jLabel1.getWidth();
           int h = jLabel1.getHeight();
           File file = new File("src\\images\\output.jpg");
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
           File file = new File("src\\images\\output.jpg");
           Image img = ImageIO.read(file);
           ImageIcon icon = new ImageIcon(ZoomImage(w+1000, h+1000, img));
           jLabel1.setIcon(icon);
       }
       catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            int w = 3482;
            int h = 995;
            File file = new File("src\\images\\output.jpg");
            Image img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(ZoomImage(w, h, img));
            jLabel1.setIcon(icon);
        } catch(Exception e){}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(model.getJugadores() != null)
            controller.viewJugadores.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private Image ZoomImage(int w, int h, Image img){
        BufferedImage buf = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        Graphics2D grf =  buf.createGraphics();
        grf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        grf.drawImage(img, 0, 0, w, h, null);
        grf.dispose();
        return buf;
    }
    
    public void paint(Graphics g){

        if(model.getJugadores() != null){
        
            int contVertor = 100;
            int contVerde = 100;
            int contRut = 100;
            int contMuro = 100;
            int contMando = 100;
            int contGally = 100;
            
            boolean flag = true;

            for(Jugador jugador : model.getJugadores()){

                if(jugador.isConectado()){

                    try{
                        File file = new File("src\\images\\"+ String.valueOf(flag == true ? "Mapa" : "output")+".jpg");
                        BufferedImage im = ImageIO.read(file);
                        File file2 = new File("src\\images\\" + jugador.getRaza().getNombre() + ".jpg");
                        BufferedImage im2 = ImageIO.read(file2);
                        Graphics2D g2 = im.createGraphics();

                        switch (jugador.getUbicacion().getId()) {
                            case 1:
                                g2.drawImage(im2, (im.getWidth() - im.getWidth() / 6), (im.getHeight() + contVertor) / 4, 100, 100, null);
                                contVertor += 200;
                                break;
                            case 2:
                                g2.drawImage(im2, (im.getWidth()) / 8, (im.getHeight() + contVerde) / 2, 100, 100, null);
                                contVerde += 200;
                                break;
                            case 3:
                                g2.drawImage(im2, (im.getWidth() - 400) / 2, (im.getHeight() - (im.getHeight() - contRut) / 4), 100, 100, null);
                                contRut += 200;
                                break;
                            case 4:
                                g2.drawImage(im2, (im.getWidth() - im.getWidth() / 6), (im.getHeight() - im.getHeight() + contMuro) / 4, 100, 100, null);
                                contMuro += 200;
                                break;
                            case 5:
                                g2.drawImage(im2, (im.getWidth()) / 8, (im.getHeight() - im.getHeight() + contMando) / 2, 100, 100, null);
                                contMando += 200;
                                break;
                            case 6:
                                g2.drawImage(im2, (im.getWidth() + 500) / 2, (im.getHeight() - (im.getHeight() - contGally) / 4), 100, 100, null);
                                contGally -= 200;
                                break;
                        }


                        ImageIO.write(im, "jpg", new File("src\\images\\output.jpg"));
                        
                    }catch(Exception e) {}
                    
                    flag = false;
                    
                }
            }
        }
        else {
            try {
                File file = new File("src\\images\\Mapa.jpg");
                BufferedImage im = ImageIO.read(file);
                ImageIO.write(im, "jpg", new File("src\\images\\output.jpg"));
            } catch (IOException ex) {}
            
        }
        
        try {
            
            int w = 3482;
            int h = 995;
            File file = new File("src\\images\\output.jpg");
            Image img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(ZoomImage(w, h, img));
            jLabel1.setIcon(icon);
            
        } catch(Exception e){}
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {}
}
