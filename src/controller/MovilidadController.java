package controller;

import entities.MovilidadEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.MovilidadModel;


/**
 *
 * @author YAVB
 */
public class MovilidadController {

    public static ArrayList<MovilidadEntiti> getListaMovilidad() {

        return MovilidadModel.getTodosMovilidad();

    }

    public static MovilidadEntiti getMovilidadById(int mov_id) {

        return MovilidadModel.getMovilidadById(new MovilidadEntiti(mov_id));

    }

    public static void updateMovilidad(String mov_procedencia,String mov_destino, String mov_placa,int mov_id) {

        MovilidadEntiti movilidad = new MovilidadEntiti(mov_id, mov_destino, mov_procedencia, mov_placa);

        boolean resultado = MovilidadModel.updateMovilidad(movilidad);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad Actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualziar");
        }

    }

    public static void insertMovilidad(String mov_procedencia,String mov_destino, String mov_placa) {

        MovilidadEntiti movilidad = new  MovilidadEntiti(mov_destino, mov_procedencia, mov_placa);

        boolean resultado = MovilidadModel.insertMovilidad(movilidad);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void deleteMovilidad(int mov_id) {

        MovilidadEntiti movilidad = new MovilidadEntiti(mov_id);

        boolean resultado = MovilidadModel.deleteMovilidad(movilidad);


        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

}
