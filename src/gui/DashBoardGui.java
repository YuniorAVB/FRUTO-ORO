package gui;

import config.Rutas;
import config.EstadosApp;
import controller.EmpresaConductorController;
import controller.EmpresaMovilidadController;
import controller.PesajeController;
import controller.PesajeTicketController;
import entities.EmpresaConductorEntiti;
import entities.EmpresaMovilidadEntiti;
import entities.PesajeTicketEntiti;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import state.StateApp;
import utils.LecturaSerial;
import utils.LecturaSerial.LeerSerial;

public class DashBoardGui extends javax.swing.JFrame {

    DefaultComboBoxModel<String> modelo_conductor;
    EmpresaMovilidadEntiti empresa_movilidad;
    DefaultTableModel modelo_tabla;
    boolean peso_ingreso = true;

    public static PesajeTicketEntiti pesajeTicket;

    public DashBoardGui() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.OcultarOpcionesSession();
        this.cargarImagenes();
        this.generateNewTicket();
        this.getTicketsPendientes();
        this.setDataLabelPortSerial();
        this.setNameUsuario();

    }

    public void setNameUsuario() {
        jlbl_nombre_usuario.setText(EstadosApp.SESSION_USUARIO.toUpperCase());
        jlbl_nombre_usuario_2.setText(EstadosApp.SESSION_USUARIO.toUpperCase());
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

        //PROCESO DE PEAJE
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_capturar, Rutas.DIR_ASSETS_IMAGES + "capturarkg.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_guardar, Rutas.DIR_ASSETS_IMAGES + "camionlleno.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_imprimir, Rutas.DIR_ASSETS_IMAGES + "printer-64x.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_nuevo, Rutas.DIR_ASSETS_IMAGES + "newpeso.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_copia, Rutas.DIR_ASSETS_IMAGES + "printer-64.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_peso_rapido, Rutas.DIR_ASSETS_IMAGES + "camionproducto.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_salir, Rutas.DIR_ASSETS_IMAGES + "closesoft.png");

        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_resetear_ingreso, Rutas.DIR_ASSETS_IMAGES + "WZUNDO.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_peaje_resetear_salida, Rutas.DIR_ASSETS_IMAGES + "WZUNDO.jpg");

        rsscalelabel.RSScaleLabel.setScaleLabel(jlbl_proceso_pesaje_actualizar_valanza, Rutas.DIR_ASSETS_IMAGES + "update.png");

    }

    public void generateNewTicket() {

        int newSerie = PesajeTicketController.getGenerateNewTicketSerie();

        jtxt_ticket_numero_serie.setText(String.valueOf(newSerie));

    }

    public void getEmpresaMovilidad(String placa) {

        empresa_movilidad = EmpresaMovilidadController.getEmpresaMovilidadByPlaca(placa);

        if (empresa_movilidad != null) {
            jtxt_empresa_nombre.setText(empresa_movilidad.getEprmovdet_epr_id().getEpr_nombre());
            jtxt_empresa_ruc.setText(empresa_movilidad.getEprmovdet_epr_id().getEpr_ruc());

            jtxt_movilidad_destino.setText(empresa_movilidad.getEprmovdet_mov_id().getMv_destino());
            jtxt_movilidad_procedencia.setText(empresa_movilidad.getEprmovdet_mov_id().getMov_procedencia());
            jtxt_placa_movilidad.setText(empresa_movilidad.getEprmovdet_mov_id().getMov_placa());

            getEmpresaConductor(empresa_movilidad.getEprmovdet_epr_id().getEpr_id());
            jtxt_placa_movilidad.setEditable(false);
        }

    }

    public void getEmpresaConductor(int empresa_id) {

        ArrayList<EmpresaConductorEntiti> lista_conductor = EmpresaConductorController.getListaEmpresaMovilidadByEmpresaId(empresa_id);

        if (false == lista_conductor.isEmpty()) {

            modelo_conductor = (DefaultComboBoxModel<String>) jcb_conductor.getModel();

            modelo_conductor.removeAllElements();

            lista_conductor.forEach((ele) -> {
                if (ele.getEprcondet_con_id() != null) {

                    modelo_conductor.addElement(ele.getEprcondet_con_id().getCon_id()
                            + " - " + ele.getEprcondet_con_id().getCon_dni()
                            + " - " + ele.getEprcondet_con_id().getCon_nombre().toUpperCase()
                            + " - " + ele.getEprcondet_con_id().getCon_apellido().toUpperCase());

                }
            });
        }

    }

    public void clearForm() {

        jtxt_fecha_ingreso.setText("");
        jtxt_peso_ingreso.setText("");
        jtxt_hora_ingreso.setText("");
        jtxt_placa_movilidad.setText("");
        jtxt_producto.setText("");
        jtxt_empresa_nombre.setText("");
        jtxt_empresa_ruc.setText("");
        jlbl_peso_balanza.setText("0KG");

        jtxt_movilidad_destino.setText("");
        jtxt_movilidad_procedencia.setText("");

        jtxt_tara_referencial.setText("");

        jtxt_peso_salida.setText("");
        jtxt_fecha_salida.setText("");
        jtxt_hora_salida.setText("");

        jtxt_peso_tara.setText("");
        jtxt_peso_bruto.setText("");
        jtxt_peso_neto.setText("");

        if (modelo_conductor != null) {

            modelo_conductor.removeAllElements();
        }
    }

    public void registrarPesajeIngreso() {
        if (jcb_conductor.getItemCount() > 0) {
            int pes_mov_id = empresa_movilidad.getEprmovdet_mov_id().getMov_id();
            int pes_emp_id = EstadosApp.SESSION_USUARIO_ID;
            String id_conductor = jcb_conductor.getSelectedItem().toString();

            int pes_con_id = Integer.parseInt(id_conductor.split(" - ")[0]);
            String pes_fecha_ingreso = jtxt_fecha_ingreso.getText();
            double pes_peso_ingreso = Double.parseDouble(jtxt_peso_ingreso.getText());
            String pes_hora_ingreso = jtxt_hora_ingreso.getText();
            int serie_numero = Integer.parseInt(jtxt_ticket_numero_serie.getText());
            double pes_tara = Double.parseDouble(jtxt_tara_referencial.getText());
            String pes_producto = jtxt_producto.getText();

            PesajeController.insertPesajeIngreso(pes_mov_id, pes_emp_id, pes_con_id, pes_fecha_ingreso, pes_peso_ingreso, pes_hora_ingreso, serie_numero, pes_tara, pes_producto);

            getLastPesajeIngreso();

            generateNewTicket();

            getTicketsPendientes();

        } else {
            JOptionPane.showMessageDialog(null, "ESTA EMPRESA NO TIENE CONDUCTORES");
        }

    }

    public void getLastPesajeIngreso() {
        pesajeTicket = PesajeTicketController.getLastPesajeTicketIngreso();

    }

    public void getLastPesajeSalida() {

        pesajeTicket = PesajeTicketController.getBuscarTicketByTicket(pesajeTicket.getTic_serie_numero());

    }

    public void getTicketsPendientes() {

        ArrayList<PesajeTicketEntiti> lista_pendientes = PesajeTicketController.getTodosTicketsPendientes();

        modelo_tabla = (DefaultTableModel) jtbl_proceso_pesaje_pendientes.getModel();

        modelo_tabla.setColumnCount(0);
        modelo_tabla.setRowCount(0);

        modelo_tabla.addColumn("TICKET");
        modelo_tabla.addColumn("PLACA");

        if (lista_pendientes.isEmpty() == false && lista_pendientes != null) {

            lista_pendientes.forEach(ele -> {

                if (ele.getTic_pes_id() != null) {

                    modelo_tabla.addRow(new String[]{String.valueOf(ele.getTic_id()), ele.getTic_pes_id().getPes_mov_id().getMov_placa()});
                }
            });

        }

    }

    public void registrarPesajeSalida() {

        if (jtxt_fecha_salida.getText().isEmpty() == false) {

            String pes_fecha_salida = jtxt_fecha_salida.getText();
            String pes_hora_salida = jtxt_hora_salida.getText();
            double pes_peso_salida = Double.parseDouble(jtxt_peso_salida.getText());
            double pes_neto = Double.parseDouble(jtxt_peso_neto.getText());
            double pes_bruto = Double.parseDouble(jtxt_peso_bruto.getText());

            PesajeController.updatePesajeSalida(pesajeTicket.getTic_pes_id().getPes_id(), pes_fecha_salida, pes_hora_salida, pes_peso_salida, pes_neto, pes_bruto);
            getTicketsPendientes();
            getLastPesajeSalida();
            peso_ingreso = true;
        } else {

            JOptionPane.showMessageDialog(null, "Capture el pesaje de Salida");

        }

    }

    LecturaSerial readPortSerial;

    public void setDataLabelPortSerial() {
        readPortSerial = new LecturaSerial();
        readPortSerial.leerPueto(jlbl_peso_balanza);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbl_logo = new javax.swing.JLabel();
        jlbl_nombre_usuario = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jlbl_nombre_usuario_2 = new javax.swing.JLabel();
        jtxt_ticket_numero_serie = new javax.swing.JTextField();
        jlbl_buscar_ticket = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_proceso_pesaje_pendientes = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jlbl_peso_balanza = new javax.swing.JLabel();
        jlbl_proceso_pesaje_actualizar_valanza = new javax.swing.JLabel();
        jlbl_refrescar_tabla = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtxt_placa_movilidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxt_tara_referencial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxt_producto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxt_empresa_nombre = new javax.swing.JTextField();
        jtxt_empresa_ruc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxt_movilidad_procedencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxt_movilidad_destino = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jcb_conductor = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlbl_proceso_peaje_capturar = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlbl_proceso_peaje_guardar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jlbl_proceso_peaje_imprimir = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jlbl_proceso_peaje_nuevo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jlbl_proceso_peaje_copia = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jlbl_proceso_peaje_peso_rapido = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jlbl_proceso_peaje_salir = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jlbl_proceso_peaje_resetear_ingreso = new javax.swing.JLabel();
        jtxt_fecha_ingreso = new javax.swing.JTextField();
        jtxt_hora_ingreso = new javax.swing.JTextField();
        jtxt_peso_ingreso = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jlbl_proceso_peaje_resetear_salida = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jtxt_fecha_salida = new javax.swing.JTextField();
        jtxt_hora_salida = new javax.swing.JTextField();
        jtxt_peso_salida = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jtxt_peso_bruto = new javax.swing.JTextField();
        jtxt_peso_tara = new javax.swing.JTextField();
        jtxt_peso_neto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(9, 113, 195));

        jPanel2.setBackground(new java.awt.Color(9, 113, 195));

        jlbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/login.png"))); // NOI18N

        jlbl_nombre_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbl_nombre_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_nombre_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_nombre_usuario.setText("OPERADOR");

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

        jbtn_proceso_pesaje.setBackground(new java.awt.Color(255, 51, 102));
        jbtn_proceso_pesaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_proceso_pesaje.setForeground(new java.awt.Color(255, 255, 255));
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
        jbtn_balanza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_balanzaMouseClicked(evt);
            }
        });

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
                    .addComponent(jlbl_nombre_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jlbl_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_cambiar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("EMPLEADO");

        jlbl_nombre_usuario_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_nombre_usuario_2.setText("PROGRAMADOR");

        jtxt_ticket_numero_serie.setEditable(false);
        jtxt_ticket_numero_serie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_ticket_numero_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_ticket_numero_serie.setText("000312");
        jtxt_ticket_numero_serie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_ticket_numero_serie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_ticket_numero_serie.setPreferredSize(new java.awt.Dimension(74, 35));

        jlbl_buscar_ticket.setBackground(new java.awt.Color(0, 102, 255));
        jlbl_buscar_ticket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbl_buscar_ticket.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_buscar_ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_buscar_ticket.setText("BUSCAR TICKETS");
        jlbl_buscar_ticket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_buscar_ticket.setOpaque(true);
        jlbl_buscar_ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_buscar_ticketMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jlbl_nombre_usuario_2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jlbl_buscar_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxt_ticket_numero_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbl_buscar_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jlbl_nombre_usuario_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_ticket_numero_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtbl_proceso_pesaje_pendientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbl_proceso_pesaje_pendientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_proceso_pesaje_pendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbl_proceso_pesaje_pendientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_proceso_pesaje_pendientes.setGridColor(new java.awt.Color(0, 0, 0));
        jtbl_proceso_pesaje_pendientes.setRowHeight(30);
        jtbl_proceso_pesaje_pendientes.setRowMargin(10);
        jtbl_proceso_pesaje_pendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_proceso_pesaje_pendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_proceso_pesaje_pendientes);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("XDK-9");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel33.setBackground(new java.awt.Color(9, 113, 195));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("VOLVER CERO");
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel33.setOpaque(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));

        jlbl_peso_balanza.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbl_peso_balanza.setForeground(new java.awt.Color(51, 204, 0));
        jlbl_peso_balanza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbl_peso_balanza.setText("0KG");

        jlbl_proceso_pesaje_actualizar_valanza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_pesaje_actualizar_valanza, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbl_peso_balanza, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbl_proceso_pesaje_actualizar_valanza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbl_peso_balanza, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlbl_refrescar_tabla.setBackground(new java.awt.Color(255, 51, 102));
        jlbl_refrescar_tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbl_refrescar_tabla.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_refrescar_tabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_refrescar_tabla.setText("REFRESCAR");
        jlbl_refrescar_tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_refrescar_tabla.setOpaque(true);
        jlbl_refrescar_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_refrescar_tablaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbl_refrescar_tabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_refrescar_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PLACA");

        jtxt_placa_movilidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_placa_movilidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_placa_movilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_placa_movilidad.setPreferredSize(new java.awt.Dimension(74, 30));
        jtxt_placa_movilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_placa_movilidadKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TARA REFERENCIAL");

        jtxt_tara_referencial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_tara_referencial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_tara_referencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_tara_referencial.setPreferredSize(new java.awt.Dimension(74, 30));
        jtxt_tara_referencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_tara_referencialActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PRODUCTO");

        jtxt_producto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_producto.setPreferredSize(new java.awt.Dimension(74, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("EMPRESA");

        jtxt_empresa_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_empresa_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_empresa_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_empresa_nombre.setPreferredSize(new java.awt.Dimension(74, 30));

        jtxt_empresa_ruc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_empresa_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_empresa_ruc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_empresa_ruc.setPreferredSize(new java.awt.Dimension(74, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("CONDUCTOR");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PROCEDENCIA");

        jtxt_movilidad_procedencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_movilidad_procedencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_movilidad_procedencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_movilidad_procedencia.setPreferredSize(new java.awt.Dimension(74, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("DESTINO");

        jtxt_movilidad_destino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_movilidad_destino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_movilidad_destino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_movilidad_destino.setPreferredSize(new java.awt.Dimension(74, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Doc. Refere.");

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField11.setPreferredSize(new java.awt.Dimension(74, 30));

        jcb_conductor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcb_conductor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jcb_conductor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_movilidad_procedencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxt_movilidad_destino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jtxt_placa_movilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxt_tara_referencial, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                            .addComponent(jtxt_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jtxt_empresa_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtxt_empresa_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcb_conductor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_placa_movilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(jtxt_tara_referencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxt_empresa_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_empresa_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcb_conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxt_movilidad_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxt_movilidad_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setBackground(new java.awt.Color(9, 113, 195));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CAPTURAR");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel13.setOpaque(true);

        jlbl_proceso_peaje_capturar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_capturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_capturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_capturarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlbl_proceso_peaje_capturar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_capturar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbl_proceso_peaje_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_guardarMouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(9, 113, 195));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("GUARDAR");
        jLabel15.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlbl_proceso_peaje_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setBackground(new java.awt.Color(9, 113, 195));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("IMPRIMIR");
        jLabel16.setOpaque(true);

        jlbl_proceso_peaje_imprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_imprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_imprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbl_proceso_peaje_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbl_proceso_peaje_nuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_nuevoMouseClicked(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(9, 113, 195));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("NUEVO");
        jLabel17.setOpaque(true);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlbl_proceso_peaje_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setBackground(new java.awt.Color(9, 113, 195));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("COPIA");
        jLabel18.setOpaque(true);

        jlbl_proceso_peaje_copia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_copia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_copia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_copiaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlbl_proceso_peaje_copia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_copia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbl_proceso_peaje_peso_rapido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_peso_rapido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setBackground(new java.awt.Color(9, 113, 195));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PESO RAPIDO");
        jLabel19.setOpaque(true);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbl_proceso_peaje_peso_rapido, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_peso_rapido, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbl_proceso_peaje_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_proceso_peaje_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_salirMouseClicked(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(9, 113, 195));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("SALIR");
        jLabel20.setOpaque(true);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlbl_proceso_peaje_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_proceso_peaje_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("INGRESO");

        jlbl_proceso_peaje_resetear_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_resetear_ingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_resetear_ingresoMouseClicked(evt);
            }
        });

        jtxt_fecha_ingreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_fecha_ingreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_fecha_ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_fecha_ingreso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_fecha_ingreso.setEnabled(false);

        jtxt_hora_ingreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_hora_ingreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_hora_ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_hora_ingreso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_hora_ingreso.setEnabled(false);

        jtxt_peso_ingreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_peso_ingreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_peso_ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_peso_ingreso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_peso_ingreso.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("FECHA");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("HORA");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("PESO");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_proceso_peaje_resetear_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxt_peso_ingreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jtxt_hora_ingreso, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxt_fecha_ingreso, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbl_proceso_peaje_resetear_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_peso_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("SALIDA");

        jlbl_proceso_peaje_resetear_salida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_proceso_peaje_resetear_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_proceso_peaje_resetear_salidaMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("PESO");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("HORA");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("FECHA");

        jtxt_fecha_salida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_fecha_salida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_fecha_salida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_fecha_salida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_fecha_salida.setEnabled(false);

        jtxt_hora_salida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_hora_salida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_hora_salida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_hora_salida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_hora_salida.setEnabled(false);

        jtxt_peso_salida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_peso_salida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_peso_salida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_peso_salida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_peso_salida.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_proceso_peaje_resetear_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxt_peso_salida, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxt_hora_salida, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxt_fecha_salida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbl_proceso_peaje_resetear_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_peso_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("TOTAL DE PESAJE");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("NETO");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("TARA");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("BRUTO");

        jtxt_peso_bruto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_peso_bruto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_peso_bruto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_peso_bruto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_peso_bruto.setEnabled(false);

        jtxt_peso_tara.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_peso_tara.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_peso_tara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_peso_tara.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_peso_tara.setEnabled(false);

        jtxt_peso_neto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_peso_neto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_peso_neto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxt_peso_neto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxt_peso_neto.setEnabled(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_peso_neto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxt_peso_tara, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxt_peso_bruto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_peso_bruto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_peso_tara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_peso_neto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        readPortSerial.closePort();
        BackupGui v = new BackupGui();
        v.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jbtn_respaldoMouseClicked

    private void jbtn_cambiar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_cambiar_usuarioMouseClicked
        readPortSerial.closePort();
        LoginGui v = new LoginGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_cambiar_usuarioMouseClicked

    private void jtbl_proceso_pesaje_pendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_proceso_pesaje_pendientesMouseClicked
        clearForm();

        int row = jtbl_proceso_pesaje_pendientes.getSelectedRow();

        int idTicketPesaje = Integer.valueOf(jtbl_proceso_pesaje_pendientes.getValueAt(row, 0).toString());

        pesajeTicket = PesajeTicketController.getPesajeIngresoById(idTicketPesaje);

        if (pesajeTicket != null) {

            peso_ingreso = false;

            getEmpresaMovilidad(pesajeTicket.getTic_pes_id().getPes_mov_id().getMov_placa());

            jtxt_fecha_ingreso.setText(pesajeTicket.getTic_pes_id().getPes_fecha_ingreso());
            jtxt_hora_ingreso.setText(pesajeTicket.getTic_pes_id().getPes_hora_ingreso());
            jtxt_peso_ingreso.setText(String.valueOf(pesajeTicket.getTic_pes_id().getPes_peso_ingreso()));
            jtxt_peso_tara.setText(String.valueOf(pesajeTicket.getTic_pes_id().getPes_tara()));
            jtxt_tara_referencial.setText(String.valueOf(pesajeTicket.getTic_pes_id().getPes_tara()));
            jtxt_producto.setText(pesajeTicket.getTic_pes_id().getPes_producto());

        }


    }//GEN-LAST:event_jtbl_proceso_pesaje_pendientesMouseClicked

    private void jbtn_ticketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ticketsMouseClicked

        readPortSerial.closePort();

        TicketGui v = new TicketGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_ticketsMouseClicked

    private void jbtn_proceso_pesajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_proceso_pesajeMouseClicked
        readPortSerial.closePort();
        DashBoardGui v = new DashBoardGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_proceso_pesajeMouseClicked

    private void jbtn_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_reportesMouseClicked
        readPortSerial.closePort();
        ReporteGui v = new ReporteGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_reportesMouseClicked

    private void jlbl_proceso_peaje_imprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_imprimirMouseClicked

        if (pesajeTicket != null) {

            if (pesajeTicket.getTic_pes_id().getPes_peso_salida() > 0) {

                TicketSalidaGui salida_v = new TicketSalidaGui();
                salida_v.setVisible(true);

            } else {
                TicketIngresoGui ingreso_v = new TicketIngresoGui();
                ingreso_v.setVisible(true);
            }

        }

    }//GEN-LAST:event_jlbl_proceso_peaje_imprimirMouseClicked

    private void jbtn_mantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_mantenimientoMouseClicked
        readPortSerial.closePort();
        MantenimientoGui v = new MantenimientoGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_mantenimientoMouseClicked

    private void jlbl_proceso_peaje_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_nuevoMouseClicked
        jtxt_placa_movilidad.setEditable(true);
        peso_ingreso = true;
        clearForm();
        generateNewTicket();
    }//GEN-LAST:event_jlbl_proceso_peaje_nuevoMouseClicked

    private void jtxt_tara_referencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_tara_referencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_tara_referencialActionPerformed

    private void jtxt_placa_movilidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_placa_movilidadKeyReleased

        String placa = jtxt_placa_movilidad.getText();

        if (placa.length() > 3) {
            getEmpresaMovilidad(placa);
        }
    }//GEN-LAST:event_jtxt_placa_movilidadKeyReleased

    private void jlbl_proceso_peaje_capturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_capturarMouseClicked

        if (peso_ingreso) {
            jtxt_fecha_ingreso.setText(LocalDate.now().toString());
            jtxt_hora_ingreso.setText(LocalTime.now().toString());
            jtxt_peso_ingreso.setText(jlbl_peso_balanza.getText().split("KG")[0]);
            jtxt_tara_referencial.setText(jlbl_peso_balanza.getText().split("KG")[0]);
        } else {
            jtxt_fecha_salida.setText(LocalDate.now().toString());
            jtxt_hora_salida.setText(LocalTime.now().toString());
            jtxt_peso_salida.setText(jlbl_peso_balanza.getText().split("KG")[0]);

            double peso_tara = pesajeTicket.getTic_pes_id().getPes_tara();
            double peso_bruto = Double.parseDouble(jlbl_peso_balanza.getText().split("KG")[0]);

            jtxt_peso_bruto.setText(String.valueOf(peso_bruto));

            double peso_neto = Math.abs(peso_bruto - peso_tara);

            jtxt_peso_neto.setText(String.valueOf(peso_neto));

        }


    }//GEN-LAST:event_jlbl_proceso_peaje_capturarMouseClicked

    private void jlbl_proceso_peaje_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_guardarMouseClicked

        if (peso_ingreso) {
            registrarPesajeIngreso();
        } else {
            registrarPesajeSalida();
        }

    }//GEN-LAST:event_jlbl_proceso_peaje_guardarMouseClicked

    private void jlbl_refrescar_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_refrescar_tablaMouseClicked
        getTicketsPendientes();
    }//GEN-LAST:event_jlbl_refrescar_tablaMouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        jlbl_peso_balanza.setText("0KG");
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jlbl_proceso_peaje_copiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_copiaMouseClicked
        if (pesajeTicket != null) {

            if (pesajeTicket.getTic_pes_id().getPes_peso_salida() > 0) {

                TicketSalidaGui salida_v = new TicketSalidaGui();
                salida_v.setVisible(true);

            } else {
                TicketIngresoGui ingreso_v = new TicketIngresoGui();
                ingreso_v.setVisible(true);
            }

        }
    }//GEN-LAST:event_jlbl_proceso_peaje_copiaMouseClicked

    private void jlbl_proceso_peaje_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_salirMouseClicked
        readPortSerial.closePort();
        this.dispose();
    }//GEN-LAST:event_jlbl_proceso_peaje_salirMouseClicked

    private void jlbl_proceso_peaje_resetear_ingresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_resetear_ingresoMouseClicked
        jtxt_fecha_ingreso.setText(LocalDate.now().toString());
        jtxt_hora_ingreso.setText(LocalTime.now().toString());
        jtxt_peso_ingreso.setText(jlbl_peso_balanza.getText().split("KG")[0]);
    }//GEN-LAST:event_jlbl_proceso_peaje_resetear_ingresoMouseClicked

    private void jlbl_proceso_peaje_resetear_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_proceso_peaje_resetear_salidaMouseClicked
        jtxt_fecha_salida.setText(LocalDate.now().toString());
        jtxt_hora_salida.setText(LocalTime.now().toString());
        jtxt_peso_salida.setText(jlbl_peso_balanza.getText().split("KG")[0]);
    }//GEN-LAST:event_jlbl_proceso_peaje_resetear_salidaMouseClicked

    private void jbtn_balanzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_balanzaMouseClicked

    }//GEN-LAST:event_jbtn_balanzaMouseClicked

    private void jlbl_buscar_ticketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_buscar_ticketMouseClicked

        BuscarTicketGui v = new BuscarTicketGui();
        v.setVisible(true);
    }//GEN-LAST:event_jlbl_buscar_ticketMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoardGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DashBoardGui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JLabel jbtn_balanza;
    private javax.swing.JLabel jbtn_cambiar_usuario;
    private javax.swing.JLabel jbtn_mantenimiento;
    private javax.swing.JLabel jbtn_proceso_pesaje;
    private javax.swing.JLabel jbtn_reportes;
    private javax.swing.JLabel jbtn_respaldo;
    private javax.swing.JLabel jbtn_tickets;
    private javax.swing.JComboBox<String> jcb_conductor;
    private javax.swing.JLabel jlbl_buscar_ticket;
    private javax.swing.JLabel jlbl_logo;
    private javax.swing.JLabel jlbl_nombre_usuario;
    private javax.swing.JLabel jlbl_nombre_usuario_2;
    private javax.swing.JLabel jlbl_peso_balanza;
    private javax.swing.JLabel jlbl_proceso_peaje_capturar;
    private javax.swing.JLabel jlbl_proceso_peaje_copia;
    private javax.swing.JLabel jlbl_proceso_peaje_guardar;
    private javax.swing.JLabel jlbl_proceso_peaje_imprimir;
    private javax.swing.JLabel jlbl_proceso_peaje_nuevo;
    private javax.swing.JLabel jlbl_proceso_peaje_peso_rapido;
    private javax.swing.JLabel jlbl_proceso_peaje_resetear_ingreso;
    private javax.swing.JLabel jlbl_proceso_peaje_resetear_salida;
    private javax.swing.JLabel jlbl_proceso_peaje_salir;
    private javax.swing.JLabel jlbl_proceso_pesaje_actualizar_valanza;
    private javax.swing.JLabel jlbl_refrescar_tabla;
    private javax.swing.JTable jtbl_proceso_pesaje_pendientes;
    private javax.swing.JTextField jtxt_empresa_nombre;
    private javax.swing.JTextField jtxt_empresa_ruc;
    private javax.swing.JTextField jtxt_fecha_ingreso;
    private javax.swing.JTextField jtxt_fecha_salida;
    private javax.swing.JTextField jtxt_hora_ingreso;
    private javax.swing.JTextField jtxt_hora_salida;
    private javax.swing.JTextField jtxt_movilidad_destino;
    private javax.swing.JTextField jtxt_movilidad_procedencia;
    private javax.swing.JTextField jtxt_peso_bruto;
    private javax.swing.JTextField jtxt_peso_ingreso;
    private javax.swing.JTextField jtxt_peso_neto;
    private javax.swing.JTextField jtxt_peso_salida;
    private javax.swing.JTextField jtxt_peso_tara;
    private javax.swing.JTextField jtxt_placa_movilidad;
    private javax.swing.JTextField jtxt_producto;
    private javax.swing.JTextField jtxt_tara_referencial;
    private javax.swing.JTextField jtxt_ticket_numero_serie;
    // End of variables declaration//GEN-END:variables
}
