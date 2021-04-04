package controller;

import entities.EmpresaEntiti;
import entities.EmpresaMovilidadEntiti;
import entities.MovilidadEntiti;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.EmpresaMovilidadModel;
import model.MovilidadModel;

/**
 *
 * @author YAVB
 */
public class EmpresaMovilidadController {

    public static ArrayList<MovilidadEntiti> getListaEmpresaMovilidadDisponible() {

        ArrayList<MovilidadEntiti> lista_movilidad_disponible = MovilidadModel.getTodosMovilidad();
        ArrayList<EmpresaMovilidadEntiti> lista_movilidad_empresa = EmpresaMovilidadModel.getTodosEmpresaMovilidad();

        Iterator<MovilidadEntiti> iterador = lista_movilidad_disponible.iterator();

        while (iterador.hasNext()) {

            MovilidadEntiti movilidad = iterador.next();

            for (int j = 0; j < lista_movilidad_empresa.size(); j++) {

                if (movilidad != null && lista_movilidad_empresa.get(j).getEprmovdet_mov_id() != null) {
                    if (movilidad.getMov_id() == lista_movilidad_empresa.get(j).getEprmovdet_mov_id().getMov_id()) {
                        iterador.remove();
                    }
                }

            }
        }

        return lista_movilidad_disponible;

    }

    public static ArrayList<EmpresaMovilidadEntiti> getListaEmpresaMovilidadByEmpresaId(int epr_id) {

        return EmpresaMovilidadModel.getTodosEmpresaMovilidadByEmpresaId(new EmpresaEntiti(epr_id));

    }

    public static void insertEmpresaMovilidad(int eprmovdet_epr_id, int eprmovdet_mov_id) {

        EmpresaMovilidadEntiti empresa_movilidad = new EmpresaMovilidadEntiti(new EmpresaEntiti(eprmovdet_epr_id), new MovilidadEntiti(eprmovdet_mov_id));

        boolean resultado = EmpresaMovilidadModel.insertEmpresaMovilidad(empresa_movilidad);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad agregado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al agregar");
        }

    }

    public static void deleteEmpresaMovilidad(int eprmovdet_id) {

        EmpresaMovilidadEntiti movilidad_empresa = new EmpresaMovilidadEntiti(eprmovdet_id);

        boolean resultado = EmpresaMovilidadModel.deleteEmpresaMovilidad(movilidad_empresa);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Movilidad Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al eliminar");
        }

    }

    public static EmpresaMovilidadEntiti getEmpresaMovilidadByPlaca(String placa) {

        MovilidadEntiti movilidad = MovilidadModel.getMovilidadByPlaca(new MovilidadEntiti(placa));
        EmpresaMovilidadEntiti movilidad_empresa = null;

        if (movilidad != null) {
            movilidad_empresa = EmpresaMovilidadModel.getEmpresaMovilidadByPlaca(movilidad);

        }

        return movilidad_empresa;

    }

}
