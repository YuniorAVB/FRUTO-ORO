package controller;

import entities.EmpresaEntiti;
import entities.EmpresaMovilidadDetalleEntiti;
import entities.MovilidadEntiti;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.EmpresaMovilidadDetalleModel;
import model.MovilidadModel;

/**
 *
 * @author YAVB
 */
public class EmpresaMovilidadDetalleController {

    public static ArrayList<MovilidadEntiti> getListaEmpresaMovilidadDisponible() {

        ArrayList<MovilidadEntiti> lista_movilidad_disponible = MovilidadModel.getTodosMovilidad();
        ArrayList<EmpresaMovilidadDetalleEntiti> lista_movilidad_empresa = EmpresaMovilidadDetalleModel.getTodosEmpresaMovilidad();

        Iterator<MovilidadEntiti> iterador = lista_movilidad_disponible.iterator();

        while (iterador.hasNext()) {

            MovilidadEntiti movilidad = iterador.next();

            for (int j = 0; j < lista_movilidad_empresa.size(); j++) {

                if (movilidad.getMov_id() == lista_movilidad_empresa.get(j).getEprmovdet_mov_id().getMov_id()) {
                    iterador.remove();
                }

            }
        }

        return lista_movilidad_disponible;

    }

    public static ArrayList<EmpresaMovilidadDetalleEntiti> getListaEmpresaMovilidadByEmpresaId(int epr_id) {

        return EmpresaMovilidadDetalleModel.getTodosEmpresaMovilidadByEmpresaId(new EmpresaEntiti(epr_id));

    }

    public static void insertEmpresaMovilidad(int eprmovdet_epr_id, int eprmovdet_mov_id) {

        EmpresaMovilidadDetalleEntiti empresa_movilidad = new EmpresaMovilidadDetalleEntiti(new EmpresaEntiti(eprmovdet_epr_id), new MovilidadEntiti(eprmovdet_mov_id));

        boolean resultado = EmpresaMovilidadDetalleModel.insertEmpresaMovilidad(empresa_movilidad);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad agregado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al agregar");
        }

    }

    public static void deleteEmpresaMovilidad(int eprmovdet_id) {

        EmpresaMovilidadDetalleEntiti movilidad_empresa = new EmpresaMovilidadDetalleEntiti(eprmovdet_id);

        boolean resultado = EmpresaMovilidadDetalleModel.deleteEmpresaMovilidad(movilidad_empresa);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al eliminar");
        }

    }

}
