package gui;

import controller.EmpresaMovilidadController;
import controller.ModeloTicketController;
import controller.PesajeTicketController;
import entities.EmpresaMovilidadEntiti;
import entities.ModeloTicketEntiti;
import entities.PesajeTicketEntiti;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

public class TicketIngresoGui extends javax.swing.JFrame implements Printable {

    ModeloTicketEntiti ticket;

    public TicketIngresoGui() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.cargarModeloTicket();
        getDatosTicket();

    }

    public void getDatosTicket() {
        int ticketId = DashBoardGui.pesajeTicket.getTic_id();

        PesajeTicketEntiti ticket_pesaje = PesajeTicketController.getPesajeIngresoById(ticketId);

        EmpresaMovilidadEntiti empresa = EmpresaMovilidadController.getEmpresaMovilidadByPlaca(ticket_pesaje.getTic_pes_id().getPes_mov_id().getMov_placa());

        if (ticket_pesaje != null && empresa != null) {

            jlbl_numero_ticket.setText(String.valueOf(ticket_pesaje.getTic_serie_numero()));
            jlbl_nombre_chofer.setText(ticket_pesaje.getTic_pes_id().getPes_con_id().getCon_nombre());
            jlbl_procedencia.setText(ticket_pesaje.getTic_pes_id().getPes_mov_id().getMov_procedencia());
            jlbl_destino.setText(ticket_pesaje.getTic_pes_id().getPes_mov_id().getMv_destino());
            
            jlbl_empresa.setText(empresa.getEprmovdet_epr_id().getEpr_nombre());
            jlbl_ruc.setText(empresa.getEprmovdet_epr_id().getEpr_ruc());
            
            jlbl_producto.setText(ticket_pesaje.getTic_pes_id().getPes_producto());

            jlbl_placa.setText(ticket_pesaje.getTic_pes_id().getPes_mov_id().getMov_placa());
            jlbl_dni.setText(ticket_pesaje.getTic_pes_id().getPes_con_id().getCon_dni());
            jlbl_fecha_ingreso.setText(ticket_pesaje.getTic_pes_id().getPes_hora_ingreso());
            jlbl_hora_ingreso.setText(ticket_pesaje.getTic_pes_id().getPes_hora_ingreso());
            jlbl_peso_ingreso.setText(String.valueOf(ticket_pesaje.getTic_pes_id().getPes_peso_ingreso()));

        }

    }

    public void cargarModeloTicket() {

        ticket = ModeloTicketController.getModeloTicket();

        if (ticket != null) {

            jlbl_pie_pagina_ticket.setText(ticket.getModtic_pie_pagina());
            jlbl_subtitulo_ticket2.setText(ticket.getMod_sub_titulo());
            jlbl_titulo_ticket2.setText(ticket.getModtic_titulo());
        }

    }

    public void imprimirTicket() {
        try {

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);

            if (job.printDialog()) {
                job.print();
            }

        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            jpnl_imprimir.printAll(graphics);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnl_imprimir = new javax.swing.JPanel();
        jlbl_titulo_ticket2 = new javax.swing.JLabel();
        jlbl_subtitulo_ticket2 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jlbl_numero_ticket = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jlbl_ruc = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jlbl_dni = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jlbl_procedencia = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jlbl_destino = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jlbl_producto = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jlbl_placa = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jlbl_empresa = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jlbl_nombre_chofer = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jlbl_fecha_ingreso = new javax.swing.JLabel();
        jlbl_hora_ingreso = new javax.swing.JLabel();
        jlbl_peso_ingreso = new javax.swing.JLabel();
        jlbl_pie_pagina_ticket = new javax.swing.JLabel();
        jbtn_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpnl_imprimir.setBackground(new java.awt.Color(255, 255, 255));
        jpnl_imprimir.setBorder(null);

        jlbl_titulo_ticket2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_titulo_ticket2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbl_titulo_ticket2.setText("FRUTO DE ORO");

        jlbl_subtitulo_ticket2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbl_subtitulo_ticket2.setText("Sistema de pesaje automatico");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("TICKET");

        jlbl_numero_ticket.setText("00000251");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setText("RUC");

        jlbl_ruc.setText("00000251");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setText("DNI");

        jlbl_dni.setText("12345678");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("PROCEDENCIA");

        jlbl_procedencia.setText("PISCO");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setText("DESTINO");

        jlbl_destino.setText("SAN CLEMENTE");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel76.setText("PRODUCTO");

        jlbl_producto.setText("LECHE FRESCA");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel78.setText("PLACA");

        jlbl_placa.setText("C9CKE");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setText("EMPRESA");

        jlbl_empresa.setText("GLORIA");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel82.setText("CHOFER");

        jlbl_nombre_chofer.setText("HERACIO FERNANDEZ");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("P. PESADA");

        jLabel85.setText("FECHA");

        jLabel86.setText("HORA");

        jLabel87.setText("PESO");

        jlbl_fecha_ingreso.setText("2021/01/16");

        jlbl_hora_ingreso.setText("11:05:22");

        jlbl_peso_ingreso.setText("14760KG");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbl_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbl_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbl_peso_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_peso_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlbl_pie_pagina_ticket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_pie_pagina_ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_pie_pagina_ticket.setText("GRACIAS POR SU VISITA");

        javax.swing.GroupLayout jpnl_imprimirLayout = new javax.swing.GroupLayout(jpnl_imprimir);
        jpnl_imprimir.setLayout(jpnl_imprimirLayout);
        jpnl_imprimirLayout.setHorizontalGroup(
            jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(546, 546, 546))
                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                        .addComponent(jlbl_titulo_ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                        .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addGap(67, 67, 67)
                                .addComponent(jlbl_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel70))
                                .addGap(48, 48, 48)
                                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                        .addComponent(jlbl_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel80))
                                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                        .addComponent(jlbl_numero_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel78))
                                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                        .addComponent(jlbl_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel72)
                                            .addComponent(jLabel82)))
                                    .addComponent(jlbl_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlbl_empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbl_nombre_chofer, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(jlbl_destino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                                        .addComponent(jlbl_placa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6))))
                            .addComponent(jlbl_subtitulo_ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbl_pie_pagina_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpnl_imprimirLayout.setVerticalGroup(
            jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_imprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_titulo_ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_subtitulo_ticket2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jlbl_numero_ticket)
                    .addComponent(jLabel78)
                    .addComponent(jlbl_placa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jlbl_ruc)
                    .addComponent(jLabel80)
                    .addComponent(jlbl_empresa))
                .addGap(18, 18, 18)
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jlbl_dni)
                    .addComponent(jLabel82)
                    .addComponent(jlbl_nombre_chofer))
                .addGap(18, 18, 18)
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jlbl_procedencia)
                    .addComponent(jLabel72)
                    .addComponent(jlbl_destino))
                .addGap(18, 18, 18)
                .addGroup(jpnl_imprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76)
                    .addComponent(jlbl_producto))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_pie_pagina_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtn_imprimir.setBackground(new java.awt.Color(51, 102, 255));
        jbtn_imprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_imprimir.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_imprimir.setText("IMPRIMIR TICKET");
        jbtn_imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_imprimir.setOpaque(true);
        jbtn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnl_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtn_imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnl_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_imprimirActionPerformed
        imprimirTicket();
    }//GEN-LAST:event_jbtn_imprimirActionPerformed

    public static void main(String args[]) {
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketIngresoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TicketIngresoGui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JButton jbtn_imprimir;
    private javax.swing.JLabel jlbl_destino;
    private javax.swing.JLabel jlbl_dni;
    private javax.swing.JLabel jlbl_empresa;
    private javax.swing.JLabel jlbl_fecha_ingreso;
    private javax.swing.JLabel jlbl_hora_ingreso;
    private javax.swing.JLabel jlbl_nombre_chofer;
    private javax.swing.JLabel jlbl_numero_ticket;
    private javax.swing.JLabel jlbl_peso_ingreso;
    private javax.swing.JLabel jlbl_pie_pagina_ticket;
    private javax.swing.JLabel jlbl_placa;
    private javax.swing.JLabel jlbl_procedencia;
    private javax.swing.JLabel jlbl_producto;
    private javax.swing.JLabel jlbl_ruc;
    private javax.swing.JLabel jlbl_subtitulo_ticket2;
    private javax.swing.JLabel jlbl_titulo_ticket2;
    private javax.swing.JPanel jpnl_imprimir;
    // End of variables declaration//GEN-END:variables
}
