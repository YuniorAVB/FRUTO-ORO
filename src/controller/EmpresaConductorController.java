package controller;

import entities.ConductorEntiti;
import entities.EmpresaConductorEntiti;
import entities.EmpresaEntiti;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.ConductorModel;
import model.EmpresaConductorModel;

public class EmpresaConductorController {

    public static ArrayList<ConductorEntiti> getListaEmpresaConductorDisponible() {

        ArrayList<ConductorEntiti> lista_conductor_disponible = ConductorModel.getTodosConductor();

        ArrayList<EmpresaConductorEntiti> lista_conductor_empresa = EmpresaConductorModel.getTodosEmpresaConductor();

        Iterator<ConductorEntiti> iterador = lista_conductor_disponible.iterator();

        while (iterador.hasNext()) {

            ConductorEntiti conductor = iterador.next();

            for (int j = 0; j < lista_conductor_empresa.size(); j++) {

                if (lista_conductor_empresa.get(j).getEprcondet_con_id() != null) {

                    if (conductor.getCon_id() == lista_conductor_empresa.get(j).getEprcondet_con_id().getCon_id()) {
                        iterador.remove();
                    }

                }

            }
        }

        return lista_conductor_disponible;

    }

    public static ArrayList<EmpresaConductorEntiti> getListaEmpresaMovilidadByEmpresaId(int epr_id) {

        return EmpresaConductorModel.getTodosEmpresaConductorByEmpresaId(new EmpresaEntiti(epr_id));

    }

    public static void insertEmpresaConductor(int movcondet_con_id, int eprcondet_epr_id) {

        EmpresaConductorEntiti empresa_conductor = new EmpresaConductorEntiti(new ConductorEntiti(movcondet_con_id), new EmpresaEntiti(eprcondet_epr_id));

        boolean resultado = EmpresaConductorModel.insertEmpresaConductor(empresa_conductor);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Conductor agregado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al agregar");
        }

    }

    public static void deleteEmpresaConductor(int movcondet_id) {

        EmpresaConductorEntiti copnductor_empresa = new EmpresaConductorEntiti(movcondet_id);

        boolean resultado = EmpresaConductorModel.deleteEmpresaConductor(copnductor_empresa);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Conductor Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al eliminar");
        }

    }

}
