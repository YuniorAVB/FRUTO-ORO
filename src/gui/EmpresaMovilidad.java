/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.EmpresaMovilidadController;
import entities.EmpresaEntiti;
import entities.EmpresaMovilidadEntiti;
import entities.MovilidadEntiti;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.ButtonTableCell;
import utils.RenderButton;

public class EmpresaMovilidad extends javax.swing.JFrame {

    int id_empresa = -1;
    DefaultTableModel modelo_tabla_movilidad_disponible;
    DefaultTableModel modelo_tabla_movilidad_empresa;
    TableRowSorter<DefaultTableModel> buscar_disponible;
    TableRowSorter<DefaultTableModel> buscar_empresa;

    EmpresaEntiti empresa;

    public EmpresaMovilidad() {
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
        jtbl_movilidad_empresa = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_movilidad_disponible = new javax.swing.JTable();
        jtxt_movilidad_disponible = new javax.swing.JTextField();
        jtxt_movilidad_empresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 102));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jtbl_movilidad_empresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_movilidad_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbl_movilidad_empresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_movilidad_empresa.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jtbl_movilidad_empresa.setRowHeight(30);
        jtbl_movilidad_empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_movilidad_empresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_movilidad_empresa);

        jLabel6.setBackground(new java.awt.Color(253, 140, 43));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MOVILIDAD DISPONIBLE");
        jLabel6.setOpaque(true);

        jtbl_movilidad_disponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_movilidad_disponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbl_movilidad_disponible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_movilidad_disponible.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jtbl_movilidad_disponible.setRowHeight(30);
        jtbl_movilidad_disponible.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbl_movilidad_disponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_movilidad_disponibleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_movilidad_disponible);

        jtxt_movilidad_disponible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_movilidad_disponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_movilidad_disponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_movilidad_disponibleKeyReleased(evt);
            }
        });

        jtxt_movilidad_empresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_movilidad_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_movilidad_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_movilidad_empresaKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 72, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MOVILIDAD EMPRESA");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_movilidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxt_movilidad_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(494, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_movilidad_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxt_movilidad_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(122, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jtxt_movilidad_disponibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_movilidad_disponibleKeyReleased
        String buscar_objeto = jtxt_movilidad_disponible.getText();

        if (buscar_objeto.length() == 0) {
            buscar_disponible.setRowFilter(null);
        } else {
            buscar_disponible.setRowFilter(RowFilter.regexFilter("(?i)" + buscar_objeto));
        }
    }//GEN-LAST:event_jtxt_movilidad_disponibleKeyReleased

    private void jtbl_movilidad_disponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_movilidad_disponibleMouseClicked

        int column = jtbl_movilidad_disponible.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtbl_movilidad_disponible.getRowHeight();

        if (row < jtbl_movilidad_disponible.getRowCount() && row >= 0 && column < jtbl_movilidad_disponible.getColumnCount() && column > 0) {

            Object value = jtbl_movilidad_disponible.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();

                JButton btn = (JButton) value;

                if (btn.getName().equals("AGREGAR")) {

                    int index_row = jtbl_movilidad_disponible.getSelectedRow();
                    int mov_id = (int) jtbl_movilidad_disponible.getValueAt(index_row, 0);

                    agregarMovilidadEmpresa(mov_id);

                }
            }

        }

    }//GEN-LAST:event_jtbl_movilidad_disponibleMouseClicked

    private void jtbl_movilidad_empresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_movilidad_empresaMouseClicked
        int column = jtbl_movilidad_empresa.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtbl_movilidad_empresa.getRowHeight();

        if (row < jtbl_movilidad_empresa.getRowCount() && row >= 0 && column < jtbl_movilidad_empresa.getColumnCount() && column > 0) {

            Object value = jtbl_movilidad_empresa.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();

                JButton btn = (JButton) value;

                if (btn.getName().equals("ELIMINAR")) {

                    int index_row = jtbl_movilidad_empresa.getSelectedRow();
                    int eprmovdet_id = (int) jtbl_movilidad_empresa.getValueAt(index_row, 0);
                    
                    eliminarMovilidadEmpresa(eprmovdet_id);

                }
            }

        }
    }//GEN-LAST:event_jtbl_movilidad_empresaMouseClicked

    private void jtxt_movilidad_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_movilidad_empresaKeyReleased
        String buscar_objeto = jtxt_movilidad_empresa.getText();

        if (buscar_objeto.length() == 0) {
            buscar_empresa.setRowFilter(null);
        } else {
            buscar_empresa.setRowFilter(RowFilter.regexFilter("(?i)" + buscar_objeto));
        }
    }//GEN-LAST:event_jtxt_movilidad_empresaKeyReleased

    public void eliminarMovilidadEmpresa(int eprmovdet_id) {

        EmpresaMovilidadController.deleteEmpresaMovilidad(eprmovdet_id);

        cargarMovilidadDisponible();
        cargarMovilidadEmpresa();

    }

    public void agregarMovilidadEmpresa(int mov_id) {

        EmpresaMovilidadController.insertEmpresaMovilidad(id_empresa, mov_id);

        cargarMovilidadDisponible();
        cargarMovilidadEmpresa();

    }

    public void cargarMovilidadDisponible() {

        ArrayList<MovilidadEntiti> lista_empresas = EmpresaMovilidadController.getListaEmpresaMovilidadDisponible();

        modelo_tabla_movilidad_disponible = (DefaultTableModel) jtbl_movilidad_disponible.getModel();

        modelo_tabla_movilidad_disponible.setColumnCount(0);
        modelo_tabla_movilidad_disponible.setRowCount(0);

        modelo_tabla_movilidad_disponible.addColumn("ID");
        modelo_tabla_movilidad_disponible.addColumn("PLACA");
        modelo_tabla_movilidad_disponible.addColumn("OPCIONES");

        lista_empresas.forEach(eprmov -> {

            modelo_tabla_movilidad_disponible.addRow(new Object[]{eprmov.getMov_id(),
                eprmov.getMov_placa(), ButtonTableCell.crearButton("AGREGAR", "AGREGAR")});
        });

        jtbl_movilidad_disponible.setDefaultRenderer(Object.class, new RenderButton());

        buscar_disponible = new TableRowSorter<>(modelo_tabla_movilidad_disponible);
        jtbl_movilidad_disponible.setRowSorter(buscar_disponible);

    }

    public void cargarMovilidadEmpresa() {

        ArrayList<EmpresaMovilidadEntiti> lista_empresas = EmpresaMovilidadController.getListaEmpresaMovilidadByEmpresaId(id_empresa);

        modelo_tabla_movilidad_empresa = (DefaultTableModel) jtbl_movilidad_empresa.getModel();

        modelo_tabla_movilidad_empresa.setColumnCount(0);
        modelo_tabla_movilidad_empresa.setRowCount(0);

        modelo_tabla_movilidad_empresa.addColumn("ID");
        modelo_tabla_movilidad_empresa.addColumn("PLACA");
        modelo_tabla_movilidad_empresa.addColumn("OPCIONES");

        lista_empresas.forEach(eprmov -> {

            modelo_tabla_movilidad_empresa.addRow(new Object[]{eprmov.getEprmovdet_id(),
                eprmov.getEprmovdet_mov_id().getMov_placa(), ButtonTableCell.crearButton("ELIMINAR", "ELIMINAR")});
        });

        jtbl_movilidad_empresa.setDefaultRenderer(Object.class, new RenderButton());

        buscar_empresa = new TableRowSorter<>(modelo_tabla_movilidad_empresa);
        jtbl_movilidad_empresa.setRowSorter(buscar_empresa);

    }

    public void checkUpdateOrCreate() {
        id_empresa = MantenimientoGui.id_objeto;

        if (id_empresa > 0) {

            cargarMovilidadDisponible();
            cargarMovilidadEmpresa();
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
            new EmpresaMovilidad().setVisible(true);
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
    private javax.swing.JTable jtbl_movilidad_disponible;
    private javax.swing.JTable jtbl_movilidad_empresa;
    private javax.swing.JTextField jtxt_movilidad_disponible;
    private javax.swing.JTextField jtxt_movilidad_empresa;
    // End of variables declaration//GEN-END:variables
}
