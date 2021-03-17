package gui;

import controller.PesajeTicketController;
import entities.PesajeTicketEntiti;
import javax.swing.JOptionPane;

public class BuscarTicketGui extends javax.swing.JFrame {
    
    public static PesajeTicketEntiti pesaje;
    
    public BuscarTicketGui() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void buscarTicket(String tipo) {
        
        String ticket = jtxt_buscar_ticket.getText();
        if (ticket.trim().isEmpty() == false) {
            
            pesaje = PesajeTicketController.getBuscarTicketByTicket(Integer.parseInt(ticket));
            if (pesaje != null) {
                switch (tipo) {
                    
                    case "ingreso":
                        TicketIngresoCopiaGui v_ingreso = new TicketIngresoCopiaGui();
                        v_ingreso.setVisible(true);
                        break;
                    case "salida":
                        TicketCopiaSalidaGui v_salida = new TicketCopiaSalidaGui();
                        v_salida.setVisible(true);
                        break;
                    case "copia":
                        TicketCopiaFullGui v_copia = new TicketCopiaFullGui();
                        v_copia.setVisible(true);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Ticket no Existe o falta Pesar la Salida");
            }
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Ingrese el numero de Serie de ticket");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxt_buscar_ticket = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlbl_ingreso = new javax.swing.JLabel();
        jlbl_salida = new javax.swing.JLabel();
        jlbl_copia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtxt_buscar_ticket.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxt_buscar_ticket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_buscar_ticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_buscar_ticketKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_buscar_ticketKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("N. TICKET");

        jlbl_ingreso.setBackground(new java.awt.Color(0, 153, 255));
        jlbl_ingreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbl_ingreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_ingreso.setText("INGRESO");
        jlbl_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_ingreso.setOpaque(true);
        jlbl_ingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_ingresoMouseClicked(evt);
            }
        });

        jlbl_salida.setBackground(new java.awt.Color(0, 153, 255));
        jlbl_salida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbl_salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_salida.setText("SALIDA");
        jlbl_salida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_salida.setOpaque(true);
        jlbl_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_salidaMouseClicked(evt);
            }
        });

        jlbl_copia.setBackground(new java.awt.Color(0, 153, 255));
        jlbl_copia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbl_copia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_copia.setText("COPIA");
        jlbl_copia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_copia.setOpaque(true);
        jlbl_copia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_copiaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbl_ingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_copia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_buscar_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxt_buscar_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_copia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_buscar_ticketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_buscar_ticketKeyTyped

    }//GEN-LAST:event_jtxt_buscar_ticketKeyTyped

    private void jtxt_buscar_ticketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_buscar_ticketKeyReleased
        

    }//GEN-LAST:event_jtxt_buscar_ticketKeyReleased

    private void jlbl_ingresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_ingresoMouseClicked
        buscarTicket("ingreso");
    }//GEN-LAST:event_jlbl_ingresoMouseClicked

    private void jlbl_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_salidaMouseClicked
        buscarTicket("salida");
    }//GEN-LAST:event_jlbl_salidaMouseClicked

    private void jlbl_copiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_copiaMouseClicked
        buscarTicket("copia");
    }//GEN-LAST:event_jlbl_copiaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarTicketGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarTicketGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarTicketGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarTicketGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarTicketGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbl_copia;
    private javax.swing.JLabel jlbl_ingreso;
    private javax.swing.JLabel jlbl_salida;
    private javax.swing.JTextField jtxt_buscar_ticket;
    // End of variables declaration//GEN-END:variables
}
