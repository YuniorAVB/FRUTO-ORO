/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.EmpresaConductorController;
import entities.ConductorEntiti;
import entities.EmpresaConductorEntiti;
import entities.EmpresaEntiti;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ConductorModel;
import utils.ButtonTableCell;
import utils.RenderButton;

public class EmpresaConductor extends javax.swing.JFrame {

    int id_empresa = -1;
    DefaultTableModel modelo_tabla_conductor_disponible;
    DefaultTableModel modelo_tabla_conductor_empresa;
    TableRowSorter<DefaultTableModel> buscar_disponible;
    TableRowSorter<DefaultTableModel> buscar_empresa;

    EmpresaEntiti empresa;

    public EmpresaConductor() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.checkUpdateOrCreate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_conductor_empresa = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_conductor_disponible = new javax.swing.JTable();
        jtxt_conductor_disponible = new javax.swing.JTextField();
        jtxt_conductor_empresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jtbl_conductor_empresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_conductor_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbl_conductor_empresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_conductor_empresa.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jtbl_conductor_empresa.setRowHeight(30);
        jtbl_conductor_empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_conductor_empresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_conductor_empresa);

        jLabel6.setBackground(new java.awt.Color(253, 140, 43));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONDUCTOR DISPONIBLE");
        jLabel6.setOpaque(true);

        jtbl_conductor_disponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_conductor_disponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbl_conductor_disponible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_conductor_disponible.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jtbl_conductor_disponible.setRowHeight(30);
        jtbl_conductor_disponible.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbl_conductor_disponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_conductor_disponibleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_conductor_disponible);

        jtxt_conductor_disponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_conductor_disponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_conductor_disponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_conductor_disponibleKeyReleased(evt);
            }
        });

        jtxt_conductor_empresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_conductor_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_conductor_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_conductor_empresaKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 72, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CONDUCTOR EMPRESA");
        jLabel7.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BUSCAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_conductor_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_conductor_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(573, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jtxt_conductor_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_conductor_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jtxt_conductor_disponibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_conductor_disponibleKeyReleased
        String buscar_objeto = jtxt_conductor_disponible.getText();

        if (buscar_objeto.length() == 0) {
            buscar_disponible.setRowFilter(null);
        } else {
            buscar_disponible.setRowFilter(RowFilter.regexFilter("(?i)" + buscar_objeto));
        }
    }//GEN-LAST:event_jtxt_conductor_disponibleKeyReleased

    private void jtbl_conductor_disponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_conductor_disponibleMouseClicked

        int column = jtbl_conductor_disponible.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtbl_conductor_disponible.getRowHeight();

        if (row < jtbl_conductor_disponible.getRowCount() && row >= 0 && column < jtbl_conductor_disponible.getColumnCount() && column > 0) {

            Object value = jtbl_conductor_disponible.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();

                JButton btn = (JButton) value;

                if (btn.getName().equals("AGREGAR")) {

                    int index_row = jtbl_conductor_disponible.getSelectedRow();
                    int mov_id = (int) jtbl_conductor_disponible.getValueAt(index_row, 0);

                    agregarMovilidadEmpresa(mov_id);

                }
            }

        }

    }//GEN-LAST:event_jtbl_conductor_disponibleMouseClicked

    private void jtbl_conductor_empresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_conductor_empresaMouseClicked
        int column = jtbl_conductor_empresa.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtbl_conductor_empresa.getRowHeight();

        if (row < jtbl_conductor_empresa.getRowCount() && row >= 0 && column < jtbl_conductor_empresa.getColumnCount() && column > 0) {

            Object value = jtbl_conductor_empresa.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();

                JButton btn = (JButton) value;

                if (btn.getName().equals("ELIMINAR")) {

                    int index_row = jtbl_conductor_empresa.getSelectedRow();
                    int eprmovdet_id = (int) jtbl_conductor_empresa.getValueAt(index_row, 0);
                    
                    eliminarConductorEmpresa(eprmovdet_id);

                }
            }

        }
    }//GEN-LAST:event_jtbl_conductor_empresaMouseClicked

    private void jtxt_conductor_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_conductor_empresaKeyReleased
        String buscar_objeto = jtxt_conductor_empresa.getText();

        if (buscar_objeto.length() == 0) {
            buscar_empresa.setRowFilter(null);
        } else {
            buscar_empresa.setRowFilter(RowFilter.regexFilter("(?i)" + buscar_objeto));
        }
    }//GEN-LAST:event_jtxt_conductor_empresaKeyReleased

    public void eliminarConductorEmpresa(int eprcondet_epr_id) {

        EmpresaConductorController.deleteEmpresaConductor(eprcondet_epr_id);

        cargarConductorDisponible();
        cargarConductorEmpresa();

    }

    public void agregarMovilidadEmpresa(int eprcondet_con_id) {

        EmpresaConductorController.insertEmpresaConductor(id_empresa, eprcondet_con_id);

        cargarConductorDisponible();
        cargarConductorEmpresa();

    }

    public void cargarConductorDisponible() {

        ArrayList<ConductorEntiti> lista_conductor = EmpresaConductorController.getListaEmpresaConductorDisponible();

        modelo_tabla_conductor_disponible = (DefaultTableModel) jtbl_conductor_disponible.getModel();

        modelo_tabla_conductor_disponible.setColumnCount(0);
        modelo_tabla_conductor_disponible.setRowCount(0);

        modelo_tabla_conductor_disponible.addColumn("ID");
        modelo_tabla_conductor_disponible.addColumn("NOMBRE");
        modelo_tabla_conductor_disponible.addColumn("DNI");
        modelo_tabla_conductor_disponible.addColumn("OPCIONES");

        lista_conductor.forEach(eprmov -> {

            modelo_tabla_conductor_disponible.addRow(new Object[]{eprmov.getCon_id(),
                eprmov.getCon_nombre(),eprmov.getCon_dni(), ButtonTableCell.crearButton("AGREGAR", "AGREGAR")});
        });

        jtbl_conductor_disponible.setDefaultRenderer(Object.class, new RenderButton());

        buscar_disponible = new TableRowSorter<>(modelo_tabla_conductor_disponible);
        jtbl_conductor_disponible.setRowSorter(buscar_disponible);

    }

    public void cargarConductorEmpresa() {

        ArrayList<EmpresaConductorEntiti> lista_conductor = EmpresaConductorController.getListaEmpresaMovilidadByEmpresaId(id_empresa);

        modelo_tabla_conductor_empresa = (DefaultTableModel) jtbl_conductor_empresa.getModel();

        modelo_tabla_conductor_empresa.setColumnCount(0);
        modelo_tabla_conductor_empresa.setRowCount(0);

        modelo_tabla_conductor_empresa.addColumn("ID");
        modelo_tabla_conductor_empresa.addColumn("NOMBRE");
        modelo_tabla_conductor_empresa.addColumn("DNI");
        modelo_tabla_conductor_empresa.addColumn("OPCIONES");

        lista_conductor.forEach(eprmov -> {

            modelo_tabla_conductor_empresa.addRow(new Object[]{eprmov.getEprcondet_id(),
                eprmov.getEprcondet_con_id().getCon_nombre(),eprmov.getEprcondet_con_id().getCon_dni(), ButtonTableCell.crearButton("ELIMINAR", "ELIMINAR")});
        });

        jtbl_conductor_empresa.setDefaultRenderer(Object.class, new RenderButton());

        buscar_empresa = new TableRowSorter<>(modelo_tabla_conductor_empresa);
        jtbl_conductor_empresa.setRowSorter(buscar_empresa);

    }

    public void checkUpdateOrCreate() {
        id_empresa = MantenimientoGui.id_objeto;

        if (id_empresa > 0) {

            cargarConductorDisponible();
            cargarConductorEmpresa();
        }

    }

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
        java.awt.EventQueue.invokeLater(() -> {
            new EmpresaConductor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbl_conductor_disponible;
    private javax.swing.JTable jtbl_conductor_empresa;
    private javax.swing.JTextField jtxt_conductor_disponible;
    private javax.swing.JTextField jtxt_conductor_empresa;
    // End of variables declaration//GEN-END:variables
}
