package gui;

import config.Rutas;
import config.EstadosApp;
import controller.ModeloTicketController;
import entities.ModeloTicketEntiti;
import java.awt.event.MouseListener;

import state.StateApp;

public class ReporteGui extends javax.swing.JFrame {
    
    ModeloTicketEntiti ticket;
    
    public ReporteGui() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.OcultarOpcionesSession();
        this.cargarImagenes();
        
    }
    
    public void OcultarOpcionesSession() {
        
        switch (StateApp.ses_tipo) {
            
            case EstadosApp.SESSION_ADMIN:
                break;
            
            case EstadosApp.SESSION_EMPLEADO:
                this.quitarEventosAdmin();
                break;
            
            default:
                this.quitarEventosTodos();
                break;
            
        }
        
    }
    
    public void quitarEventosAdmin() {
        
        jbtn_balanza.setEnabled(false);
        jbtn_respaldo.setEnabled(false);
        
        MouseListener[] mListener = jbtn_balanza.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_balanza.removeMouseListener(ml);
        }
        
        mListener = jbtn_respaldo.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_respaldo.removeMouseListener(ml);
        }
        
    }
    
    public void quitarEventosTodos() {
        
        jbtn_balanza.setEnabled(false);
        jbtn_tickets.setEnabled(false);
        jbtn_balanza.setEnabled(false);
        jbtn_mantenimiento.setEnabled(false);
        jbtn_reportes.setEnabled(false);
        jbtn_proceso_pesaje.setEnabled(false);
        jbtn_respaldo.setEnabled(false);
        jbtn_cambiar_usuario.setEnabled(false);
        
        MouseListener[] mListener = jbtn_balanza.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_respaldo.removeMouseListener(ml);
        }
        
        mListener = jbtn_tickets.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_tickets.removeMouseListener(ml);
        }
        
        mListener = jbtn_mantenimiento.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_mantenimiento.removeMouseListener(ml);
        }
        
        mListener = jbtn_reportes.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_reportes.removeMouseListener(ml);
        }
        
        mListener = jbtn_proceso_pesaje.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_proceso_pesaje.removeMouseListener(ml);
        }
        
        mListener = jbtn_respaldo.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_respaldo.removeMouseListener(ml);
        }
        
        mListener = jbtn_cambiar_usuario.getMouseListeners();
        for (MouseListener ml : mListener) {
            jbtn_cambiar_usuario.removeMouseListener(ml);
        }
        
    }
    
    public void cargarImagenes() {
        
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_logo, Rutas.DIR_ASSETS_IMAGES + "login.png");

        //PROCESO DE TICKET
        //rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_capturar, Rutas.DIR_ASSETS_IMAGES + "capturarkg.png");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbl_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jbtn_tickets = new javax.swing.JLabel();
        jbtn_proceso_pesaje = new javax.swing.JLabel();
        jbtn_mantenimiento = new javax.swing.JLabel();
        jbtn_reportes = new javax.swing.JLabel();
        jbtn_balanza = new javax.swing.JLabel();
        jbtn_respaldo = new javax.swing.JLabel();
        jbtn_cambiar_usuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxt_fecha_desde = new javax.swing.JTextField();
        jtxt_fecha_hasta = new javax.swing.JTextField();
        jcb_tipo_reporte = new javax.swing.JComboBox<>();
        jlbl_generar_reporte = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jlbl_tipo_reporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 113, 195));

        jPanel2.setBackground(new java.awt.Color(9, 113, 195));

        jlbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPERADOR");

        jPanel4.setBackground(new java.awt.Color(9, 113, 195));

        jbtn_tickets.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_tickets.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_tickets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_tickets.setText("TICKETS");
        jbtn_tickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_tickets.setOpaque(true);
        jbtn_tickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_ticketsMouseClicked(evt);
            }
        });

        jbtn_proceso_pesaje.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_proceso_pesaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_proceso_pesaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_proceso_pesaje.setText("PROCESO DE PESAJE");
        jbtn_proceso_pesaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_proceso_pesaje.setOpaque(true);
        jbtn_proceso_pesaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_proceso_pesajeMouseClicked(evt);
            }
        });

        jbtn_mantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_mantenimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_mantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_mantenimiento.setText("MANTENIMIENTO");
        jbtn_mantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_mantenimiento.setOpaque(true);
        jbtn_mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_mantenimientoMouseClicked(evt);
            }
        });

        jbtn_reportes.setBackground(new java.awt.Color(255, 51, 102));
        jbtn_reportes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_reportes.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_reportes.setText("REPORTES");
        jbtn_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_reportes.setOpaque(true);

        jbtn_balanza.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_balanza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_balanza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_balanza.setText("BALANZA");
        jbtn_balanza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_balanza.setOpaque(true);

        jbtn_respaldo.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_respaldo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_respaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_respaldo.setText("RESPALDO (BACKUP)");
        jbtn_respaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_respaldo.setOpaque(true);
        jbtn_respaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_respaldoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_tickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_mantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_balanza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_respaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jbtn_proceso_pesaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jbtn_tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_balanza, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_respaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jbtn_proceso_pesaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(310, Short.MAX_VALUE)))
        );

        jbtn_cambiar_usuario.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_cambiar_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_cambiar_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_cambiar_usuario.setText("CAMBIAR USUARIO");
        jbtn_cambiar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_cambiar_usuario.setOpaque(true);
        jbtn_cambiar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_cambiar_usuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtn_cambiar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_cambiar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("DESDE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HASTA");

        jtxt_fecha_desde.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_fecha_desde.setText("2021-01-21");

        jtxt_fecha_hasta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_fecha_hasta.setText("2021-01-21");

        jcb_tipo_reporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcb_tipo_reporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FECHA", "RUC", "DNI", "PRODUCTO" }));
        jcb_tipo_reporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_tipo_reporteItemStateChanged(evt);
            }
        });

        jlbl_generar_reporte.setBackground(new java.awt.Color(255, 0, 102));
        jlbl_generar_reporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_generar_reporte.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_generar_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_generar_reporte.setText("GENERAR REPORTE");
        jlbl_generar_reporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_generar_reporte.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("TIPO");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setText("123456789");

        jlbl_tipo_reporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_tipo_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_tipo_reporte.setText("FECHA");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbl_generar_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcb_tipo_reporte, 0, 324, Short.MAX_VALUE)
                            .addComponent(jtxt_fecha_desde))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbl_tipo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_fecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb_tipo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbl_tipo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jlbl_generar_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_respaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_respaldoMouseClicked
        

    }//GEN-LAST:event_jbtn_respaldoMouseClicked

    private void jbtn_cambiar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_cambiar_usuarioMouseClicked
        LoginGui v = new LoginGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_cambiar_usuarioMouseClicked

    private void jbtn_proceso_pesajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_proceso_pesajeMouseClicked
        DashBoardGui v = new DashBoardGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_proceso_pesajeMouseClicked

    private void jcb_tipo_reporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_tipo_reporteItemStateChanged

        String tipo_reporte = (String) jcb_tipo_reporte.getSelectedItem();
        
        jlbl_tipo_reporte.setText(tipo_reporte);
    }//GEN-LAST:event_jcb_tipo_reporteItemStateChanged

    private void jbtn_ticketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ticketsMouseClicked
         TicketGui v = new TicketGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_ticketsMouseClicked

    private void jbtn_mantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_mantenimientoMouseClicked
        MantenimientoGui v = new MantenimientoGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_mantenimientoMouseClicked
    
    public static void main(String args[]) {
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReporteGui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel jbtn_balanza;
    private javax.swing.JLabel jbtn_cambiar_usuario;
    private javax.swing.JLabel jbtn_mantenimiento;
    private javax.swing.JLabel jbtn_proceso_pesaje;
    private javax.swing.JLabel jbtn_reportes;
    private javax.swing.JLabel jbtn_respaldo;
    private javax.swing.JLabel jbtn_tickets;
    private javax.swing.JComboBox<String> jcb_tipo_reporte;
    private javax.swing.JLabel jlbl_generar_reporte;
    private javax.swing.JLabel jlbl_logo;
    private javax.swing.JLabel jlbl_tipo_reporte;
    private javax.swing.JTextField jtxt_fecha_desde;
    private javax.swing.JTextField jtxt_fecha_hasta;
    // End of variables declaration//GEN-END:variables
}
