package controller;

import entities.ConductorEntiti;
import entities.EmpleadoEntiti;
import entities.MovilidadEntiti;
import entities.PesajeEntiti;
import entities.SessionEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EmpleadoModel;
import model.PesajeModel;
import model.SessionModel;

/**
 *
 * @author YAVB
 */
public class PesajeController {

    public static void insertPesajeIngreso(int pes_mov_id, int pes_emp_id, int pes_con_id, String pes_fecha_ingreso, double pes_peso_ingreso, String pes_hora_ingreso, int tic_serie_numero, double pes_tara, String pes_producto) {

        PesajeEntiti pesaje = new PesajeEntiti(new MovilidadEntiti(pes_mov_id), new EmpleadoEntiti(pes_emp_id), new ConductorEntiti(pes_con_id), pes_fecha_ingreso, pes_peso_ingreso, pes_hora_ingreso, pes_tara, pes_producto);

        boolean resultado = PesajeModel.insertPesajeIngreso(pesaje);

        if (resultado) {
            pesaje = PesajeModel.getPesajeIngresoLast();

            if (pesaje != null) {
                PesajeTicketController.insertTicket(pesaje.getPes_id(), tic_serie_numero);
            }

            JOptionPane.showMessageDialog(null, "Pesaje Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void updatePesajeSalida(int pes_id, String pes_fecha_salida, String pes_hora_salida, double pes_peso_salida, double pes_neto, double pes_bruto) {

        PesajeEntiti pesaje = new PesajeEntiti(pes_id, pes_fecha_salida, pes_peso_salida, pes_hora_salida, pes_neto, pes_bruto);

        boolean resultado = PesajeModel.updatePesajeSalida(pesaje);

        if (resultado) {

            JOptionPane.showMessageDialog(null, "Pesaje actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualizar");
        }

    }

}
