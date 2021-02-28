package gui;

import config.Rutas;
import config.EstadosApp;
import controller.ConductorController;
import controller.EmpleadoController;
import controller.EmpresaController;
import controller.MovilidadController;
import entities.ConductorEntiti;
import entities.EmpleadoEntiti;
import entities.EmpresaEntiti;
import entities.MovilidadEntiti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import state.StateApp;
import utils.ButtonTableCell;
import utils.RenderButton;

public class MantenimientoGui extends javax.swing.JFrame {

    DefaultTableModel tabla_lista = null;
    TableRowSorter<DefaultTableModel> buscar;
    static String tipo_mantenimiento = "EMPLEADOS";
    static int id_objeto = -1;

    public MantenimientoGui() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.OcultarOpcionesSession();
        this.cargarImagenes();
        this.cargarListaTabla();

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

    public void centrarTabla() {

    }

    public void cargarEmpleados() {

        ArrayList<EmpleadoEntiti> lista_empleados = EmpleadoController.getListaEmpleados();

        tabla_lista = (DefaultTableModel) jtbl_lista.getModel();

        tabla_lista.setColumnCount(0);
        tabla_lista.setRowCount(0);

        tabla_lista.addColumn("DNI");
        tabla_lista.addColumn("NOMBRE");
        tabla_lista.addColumn("APELLIDO");
        tabla_lista.addColumn("EDAD");
        tabla_lista.addColumn("SEXO");
        tabla_lista.addColumn("ID");

        lista_empleados.forEach(emp -> {
            tabla_lista.addRow(new String[]{emp.getEmp_dni(), emp.getEmp_nombre(), emp.getEmp_apellido(), String.valueOf(emp.getEmp_edad()), String.valueOf(emp.getEmp_sexo()), String.valueOf(emp.getEmp_id())});
        });

    }

    public void cargarConductores() {

        ArrayList<ConductorEntiti> lista_empleados = ConductorController.getListaEmpleados();

        tabla_lista = (DefaultTableModel) jtbl_lista.getModel();

        tabla_lista.setColumnCount(0);
        tabla_lista.setRowCount(0);

        tabla_lista.addColumn("DNI");
        tabla_lista.addColumn("NOMBRE");
        tabla_lista.addColumn("APELLIDO");
        tabla_lista.addColumn("ID");

        lista_empleados.forEach(con -> {
            tabla_lista.addRow(new String[]{con.getCon_dni(), con.getCon_nombre(), con.getCon_apellido(), String.valueOf(con.getCon_id())});
        });

    }

    public void cargarEmpresas() {

        ArrayList<EmpresaEntiti> lista_empresas = EmpresaController.getListaEmpresas();

        tabla_lista = (DefaultTableModel) jtbl_lista.getModel();

        tabla_lista.setColumnCount(0);
        tabla_lista.setRowCount(0);

        tabla_lista.addColumn("RUC");
        tabla_lista.addColumn("NOMBRE");
        tabla_lista.addColumn("ID");
        tabla_lista.addColumn("MOVILIDAD");
        tabla_lista.addColumn("CONDUCTOR");

        lista_empresas.forEach(epr -> {
            tabla_lista.addRow(new Object[]{epr.getEpr_ruc(), epr.getEpr_nombre(), String.valueOf(epr.getEpr_id()), ButtonTableCell.crearButton("MOVILIDAD", "MOVILIDAD"), ButtonTableCell.crearButton("CONDUCTOR", "CONDUCTOR")});
        });

    }

    public void cargarMovilidades() {

        ArrayList<MovilidadEntiti> lista_movilidad = MovilidadController.getListaMovilidad();

        tabla_lista = (DefaultTableModel) jtbl_lista.getModel();

        tabla_lista.setColumnCount(0);
        tabla_lista.setRowCount(0);

        tabla_lista.addColumn("PLACA");
        tabla_lista.addColumn("DESTINO");
        tabla_lista.addColumn("PROCEDENCIA");
        tabla_lista.addColumn("ID");

        lista_movilidad.forEach(mov -> {
            tabla_lista.addRow(new String[]{mov.getMov_placa(), mov.getMv_destino(), mov.getMov_procedencia(), String.valueOf(mov.getMov_id())});
        });

    }

    public void cargarListaTabla() {

        tipo_mantenimiento = (String) jcb_tipo_mantenimiento.getSelectedItem();

        jtbl_lista.setDefaultRenderer(Object.class, new RenderButton());

        switch (tipo_mantenimiento) {

            case "EMPLEADOS":
                jlbl_crear_session.setVisible(true);
                this.cargarEmpleados();

                break;

            case "EMPRESAS":
                jlbl_crear_session.setVisible(false);
                this.cargarEmpresas();
                break;

            case "CONDUCTOR":
                jlbl_crear_session.setVisible(false);
                this.cargarConductores();
                break;

            case "MOVILIDAD":
                jlbl_crear_session.setVisible(false);
                this.cargarMovilidades();
                break;

        }

        buscar = new TableRowSorter<>(tabla_lista);
        jtbl_lista.setRowSorter(buscar);

    }

    public void eliminarObjetoSeleccionado() {

        switch (tipo_mantenimiento) {

            case "EMPLEADOS":

                EmpleadoController.deleteEmpleado(id_objeto);

                break;
            case "CONDUCTOR":
                ConductorController.deleteConductor(id_objeto);
                break;

            case "EMPRESAS":
                EmpresaController.deleteEmpresa(id_objeto);
                break;

            case "MOVILIDAD":
                MovilidadController.deleteMovilidad(id_objeto);
                break;

        }

        this.cargarListaTabla();

    }

    public void cargarVentanasMantenimiento() {

        switch (tipo_mantenimiento) {
            case "EMPLEADOS":
                EmpleadoGui v_emp = new EmpleadoGui();
                v_emp.setVisible(true);
                break;

            case "CONDUCTOR":
                ConductorGui v_con = new ConductorGui();
                v_con.setVisible(true);
                break;

            case "EMPRESAS":
                EmpresaGui v_epr = new EmpresaGui();
                v_epr.setVisible(true);
                break;

            case "MOVILIDAD":
                MovilidadGui v_mov = new MovilidadGui();
                v_mov.setVisible(true);
                break;

        }
    }

    public void empresaMovilidadConductor(int row, int column) {
        if (row < jtbl_lista.getRowCount() && row >= 0 && column < jtbl_lista.getColumnCount() && column > 0) {

            Object value = jtbl_lista.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();

                JButton btn = (JButton) value;

                if (btn.getName().equals("MOVILIDAD")) {

                    EmpresaMovilidad em_mov = new EmpresaMovilidad();

                    em_mov.setVisible(true);

                } else if (btn.getName().equals("CONDUCTOR")) {

                    EmpresaConductor em_con = new EmpresaConductor();

                    em_con.setVisible(true);

                }

            }

        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_lista = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcb_tipo_mantenimiento = new javax.swing.JComboBox<>();
        jlbl_agregar = new javax.swing.JLabel();
        jlbl_eliminar = new javax.swing.JLabel();
        jlbl_actualizar = new javax.swing.JLabel();
        jlbl_refrescar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbl_crear_session = new javax.swing.JLabel();
        jtxt_buscar = new javax.swing.JTextField();

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

        jbtn_mantenimiento.setBackground(new java.awt.Color(255, 51, 102));
        jbtn_mantenimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtn_mantenimiento.setForeground(new java.awt.Color(255, 255, 255));
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

        jtbl_lista.setAutoCreateRowSorter(true);
        jtbl_lista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbl_lista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbl_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ){public boolean isCellEditable(int row,int column){return false;}}

    );
    jtbl_lista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jtbl_lista.setGridColor(new java.awt.Color(0, 0, 0));
    jtbl_lista.setIntercellSpacing(new java.awt.Dimension(5, 5));
    jtbl_lista.setRowHeight(25);
    jtbl_lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jtbl_lista.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jtbl_listaMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jtbl_lista);

    jLabel2.setBackground(new java.awt.Color(255, 255, 255));
    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel2.setText("OPCIONES");

    jcb_tipo_mantenimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jcb_tipo_mantenimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLEADOS", "EMPRESAS", "MOVILIDAD", "CONDUCTOR" }));
    jcb_tipo_mantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jcb_tipo_mantenimiento.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jcb_tipo_mantenimientoItemStateChanged(evt);
        }
    });

    jlbl_agregar.setBackground(new java.awt.Color(0, 153, 51));
    jlbl_agregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlbl_agregar.setForeground(new java.awt.Color(255, 255, 255));
    jlbl_agregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbl_agregar.setText("AGREGAR");
    jlbl_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlbl_agregar.setOpaque(true);
    jlbl_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlbl_agregarMouseClicked(evt);
        }
    });

    jlbl_eliminar.setBackground(new java.awt.Color(255, 0, 51));
    jlbl_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlbl_eliminar.setForeground(new java.awt.Color(255, 255, 255));
    jlbl_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbl_eliminar.setText("ELIMINAR");
    jlbl_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlbl_eliminar.setOpaque(true);
    jlbl_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlbl_eliminarMouseClicked(evt);
        }
    });

    jlbl_actualizar.setBackground(new java.awt.Color(51, 102, 255));
    jlbl_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlbl_actualizar.setForeground(new java.awt.Color(255, 255, 255));
    jlbl_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbl_actualizar.setText("ACTUALIZAR");
    jlbl_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlbl_actualizar.setOpaque(true);
    jlbl_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlbl_actualizarMouseClicked(evt);
        }
    });

    jlbl_refrescar.setBackground(new java.awt.Color(255, 102, 0));
    jlbl_refrescar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlbl_refrescar.setForeground(new java.awt.Color(255, 255, 255));
    jlbl_refrescar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbl_refrescar.setText("REFRESCAR");
    jlbl_refrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlbl_refrescar.setOpaque(true);
    jlbl_refrescar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlbl_refrescarMouseClicked(evt);
        }
    });

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel3.setText("BUSCAR");

    jlbl_crear_session.setBackground(new java.awt.Color(255, 51, 51));
    jlbl_crear_session.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlbl_crear_session.setForeground(new java.awt.Color(255, 255, 255));
    jlbl_crear_session.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbl_crear_session.setText("CREAR SESSION");
    jlbl_crear_session.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlbl_crear_session.setOpaque(true);
    jlbl_crear_session.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlbl_crear_sessionMouseClicked(evt);
        }
    });

    jtxt_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jtxt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jtxt_buscarKeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGap(30, 30, 30)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jcb_tipo_mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_crear_session, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                            .addComponent(jlbl_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtxt_buscar))))
            .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcb_tipo_mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlbl_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlbl_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlbl_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlbl_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlbl_crear_session, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addComponent(jtxt_buscar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
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

    private void jbtn_proceso_pesajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_proceso_pesajeMouseClicked
        DashBoardGui v = new DashBoardGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_proceso_pesajeMouseClicked

    private void jbtn_ticketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ticketsMouseClicked
        TicketGui v = new TicketGui();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_ticketsMouseClicked

    private void jcb_tipo_mantenimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_tipo_mantenimientoItemStateChanged
        this.cargarListaTabla();
    }//GEN-LAST:event_jcb_tipo_mantenimientoItemStateChanged

    private void jtbl_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_listaMouseClicked
        int index_row = 0;

        int column = jtbl_lista.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtbl_lista.getRowHeight();

        switch (tipo_mantenimiento) {

            case "EMPLEADOS":
                index_row = jtbl_lista.getSelectedRow();
                id_objeto = Integer.parseInt((String) tabla_lista.getValueAt(index_row, 5));
                break;

            case "CONDUCTOR":
                index_row = jtbl_lista.getSelectedRow();
                id_objeto = Integer.parseInt((String) tabla_lista.getValueAt(index_row, 3));
                break;

            case "EMPRESAS":
                index_row = jtbl_lista.getSelectedRow();
                id_objeto = Integer.parseInt((String) tabla_lista.getValueAt(index_row, 2));

                empresaMovilidadConductor(row, column);

                break;

            case "MOVILIDAD":
                index_row = jtbl_lista.getSelectedRow();
                id_objeto = Integer.parseInt((String) tabla_lista.getValueAt(index_row, 3));
                break;

        }
    }//GEN-LAST:event_jtbl_listaMouseClicked

    private void jlbl_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_actualizarMouseClicked

        if (id_objeto > 0) {

            this.cargarVentanasMantenimiento();
            jtbl_lista.clearSelection();

        } else {

            JOptionPane.showMessageDialog(null, "SELECIONE PRIMERO");
        }
    }//GEN-LAST:event_jlbl_actualizarMouseClicked

    private void jlbl_refrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_refrescarMouseClicked
        this.cargarListaTabla();
    }//GEN-LAST:event_jlbl_refrescarMouseClicked

    private void jlbl_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_agregarMouseClicked
        id_objeto = -1;
        this.cargarVentanasMantenimiento();
        jtbl_lista.clearSelection();
    }//GEN-LAST:event_jlbl_agregarMouseClicked

    private void jlbl_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_eliminarMouseClicked
        if (id_objeto > 0) {

            jtbl_lista.clearSelection();
            this.eliminarObjetoSeleccionado();
            id_objeto = -1;

        } else {

            JOptionPane.showMessageDialog(null, "SELECIONE PRIMERO");
        }

    }//GEN-LAST:event_jlbl_eliminarMouseClicked

    private void jlbl_crear_sessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_crear_sessionMouseClicked

        if (id_objeto > 0) {

            SessionGui v = new SessionGui();
            jtbl_lista.clearSelection();
            v.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "SELECIONE PRIMERO");
        }


    }//GEN-LAST:event_jlbl_crear_sessionMouseClicked

    private void jtxt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_buscarKeyReleased

        String buscar_objeto = jtxt_buscar.getText();

        if (buscar_objeto.length() == 0) {
            buscar.setRowFilter(null);
        } else {
            buscar.setRowFilter(RowFilter.regexFilter("(?i)" + buscar_objeto));
        }
    }//GEN-LAST:event_jtxt_buscarKeyReleased

    public static void main(String args[]) {
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MantenimientoGui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbtn_balanza;
    private javax.swing.JLabel jbtn_cambiar_usuario;
    private javax.swing.JLabel jbtn_mantenimiento;
    private javax.swing.JLabel jbtn_proceso_pesaje;
    private javax.swing.JLabel jbtn_reportes;
    private javax.swing.JLabel jbtn_respaldo;
    private javax.swing.JLabel jbtn_tickets;
    private javax.swing.JComboBox<String> jcb_tipo_mantenimiento;
    private javax.swing.JLabel jlbl_actualizar;
    private javax.swing.JLabel jlbl_agregar;
    private javax.swing.JLabel jlbl_crear_session;
    private javax.swing.JLabel jlbl_eliminar;
    private javax.swing.JLabel jlbl_logo;
    private javax.swing.JLabel jlbl_refrescar;
    private javax.swing.JTable jtbl_lista;
    private javax.swing.JTextField jtxt_buscar;
    // End of variables declaration//GEN-END:variables
}
