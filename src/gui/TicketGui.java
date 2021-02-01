package gui;

import config.Rutas;
import config.EstadosApp;
import controller.ModeloTicketController;
import entities.ModeloTicketEntiti;
import java.awt.event.MouseListener;

import state.StateApp;

public class TicketGui extends javax.swing.JFrame {
    
    ModeloTicketEntiti ticket;
    
    public TicketGui() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.OcultarOpcionesSession();
        this.cargarImagenes();
        this.cargarModeloTicket();
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
    
    public void cargarModeloTicket() {
        
        ticket = ModeloTicketController.getModeloTicket();
        
        jlbl_pie_pagina_ticket.setText(ticket.getModtic_pie_pagina());
        jlbl_subtitulo_ticket.setText(ticket.getMod_sub_titulo());
        jlbl_titulo_ticket.setText(ticket.getModtic_titulo());
        
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
        jPanel6 = new javax.swing.JPanel();
        jtxt_proceso_ticket_titulo = new javax.swing.JTextField();
        jtxt_proceso_ticket_sub_titulo = new javax.swing.JTextField();
        jtxt_proceso_ticket_pie_pagina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl_proceso_ticket_guardar = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlbl_titulo_ticket = new javax.swing.JLabel();
        jlbl_subtitulo_ticket = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jlbl_pie_pagina_ticket = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 113, 195));

        jPanel2.setBackground(new java.awt.Color(9, 113, 195));

        jlbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPERADOR");

        jPanel4.setBackground(new java.awt.Color(9, 113, 195));

        jbtn_tickets.setBackground(new java.awt.Color(255, 51, 102));
        jbtn_tickets.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_tickets.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_tickets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_tickets.setText("TICKETS");
        jbtn_tickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_tickets.setOpaque(true);

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

        jbtn_reportes.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_reportes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtn_reportes.setText("REPORTES");
        jbtn_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_reportes.setOpaque(true);
        jbtn_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_reportesMouseClicked(evt);
            }
        });

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

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtxt_proceso_ticket_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_proceso_ticket_titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_proceso_ticket_titulo.setText("FRUTO DE ORO");
        jtxt_proceso_ticket_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtxt_proceso_ticket_sub_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_proceso_ticket_sub_titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_proceso_ticket_sub_titulo.setText("Sistema de pesaje automatico");
        jtxt_proceso_ticket_sub_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtxt_proceso_ticket_pie_pagina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_proceso_ticket_pie_pagina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_proceso_ticket_pie_pagina.setText("GRACIAS POR SU VISITA");
        jtxt_proceso_ticket_pie_pagina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TITULO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SUB-TITULO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PIE-PAGINA");

        jlbl_proceso_ticket_guardar.setBackground(new java.awt.Color(255, 51, 102));
        jlbl_proceso_ticket_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_proceso_ticket_guardar.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_proceso_ticket_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_ticket_guardar.setText("GUARDAR");
        jlbl_proceso_ticket_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_ticket_guardar.setOpaque(true);
        jlbl_proceso_ticket_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_ticket_guardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtxt_proceso_ticket_sub_titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addComponent(jtxt_proceso_ticket_pie_pagina, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxt_proceso_ticket_titulo))
                .addGap(18, 18, 18)
                .addComponent(jlbl_proceso_ticket_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jtxt_proceso_ticket_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_proceso_ticket_sub_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_proceso_ticket_pie_pagina, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jlbl_proceso_ticket_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbl_titulo_ticket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_titulo_ticket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbl_titulo_ticket.setText("FRUTO DE ORO");

        jlbl_subtitulo_ticket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbl_subtitulo_ticket.setText("Sistema de pesaje automatico");

        jLabel8.setText("TICKET");

        jLabel9.setText("00000251");

        jLabel10.setText("RUC");

        jLabel11.setText("00000251");

        jLabel12.setText("DNI");

        jLabel13.setText("12345678");

        jLabel14.setText("PROCEDENCIA");

        jLabel15.setText("PISCO");

        jLabel16.setText("DESTINO");

        jLabel17.setText("GLORIA");

        jLabel18.setText("REFERENCIA");

        jLabel19.setText("............");

        jLabel20.setText("PRODUCTO");

        jLabel21.setText("LECHE FRESCA");

        jLabel22.setText("PLACA");

        jLabel23.setText("C9CKE");

        jLabel24.setText("EMPRESA");

        jLabel25.setText("GLORIA");

        jLabel26.setText("CHOFER");

        jLabel27.setText("HERACIO FERNANDEZ");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("P. PESADA");

        jLabel31.setText("FECHA");

        jLabel32.setText("HORA");

        jLabel33.setText("PESO");

        jLabel35.setText("2021/01/16");

        jLabel36.setText("11:05:22");

        jLabel37.setText("14760KG");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("P. PESADA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("P. PESADA");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlbl_pie_pagina_ticket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_pie_pagina_ticket.setText("GRACIAS POR SU VISITA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbl_titulo_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jlbl_pie_pagina_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbl_subtitulo_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_titulo_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_subtitulo_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbl_pie_pagina_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jlbl_proceso_ticket_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_ticket_guardarMouseClicked
        
        String ticket_titulo = jtxt_proceso_ticket_titulo.getText();
        String ticket_sub_titulo = jtxt_proceso_ticket_sub_titulo.getText();
        String ticket_pie_pagina = jtxt_proceso_ticket_pie_pagina.getText();
        
        ModeloTicketController.updateModeloTicket(ticket_titulo, ticket_sub_titulo, ticket_pie_pagina, ticket.getModtic_id());
        
        this.cargarModeloTicket();
        
    }//GEN-LAST:event_jlbl_proceso_ticket_guardarMouseClicked

    private void jbtn_proceso_pesajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_proceso_pesajeMouseClicked
        DashBoardGui v = new DashBoardGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_proceso_pesajeMouseClicked

    private void jbtn_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_reportesMouseClicked
         ReporteGui v = new ReporteGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_reportesMouseClicked
    
    public static void main(String args[]) {
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TicketGui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jbtn_balanza;
    private javax.swing.JLabel jbtn_cambiar_usuario;
    private javax.swing.JLabel jbtn_mantenimiento;
    private javax.swing.JLabel jbtn_proceso_pesaje;
    private javax.swing.JLabel jbtn_reportes;
    private javax.swing.JLabel jbtn_respaldo;
    private javax.swing.JLabel jbtn_tickets;
    private javax.swing.JLabel jlbl_logo;
    private javax.swing.JLabel jlbl_pie_pagina_ticket;
    private javax.swing.JLabel jlbl_proceso_ticket_guardar;
    private javax.swing.JLabel jlbl_subtitulo_ticket;
    private javax.swing.JLabel jlbl_titulo_ticket;
    private javax.swing.JTextField jtxt_proceso_ticket_pie_pagina;
    private javax.swing.JTextField jtxt_proceso_ticket_sub_titulo;
    private javax.swing.JTextField jtxt_proceso_ticket_titulo;
    // End of variables declaration//GEN-END:variables
}
