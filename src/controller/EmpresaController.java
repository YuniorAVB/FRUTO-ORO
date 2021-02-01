package controller;


import entities.EmpresaEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EmpresaModel;


/**
 *
 * @author YAVB
 */
public class EmpresaController {

    public static ArrayList<EmpresaEntiti> getListaEmpresas() {

        return EmpresaModel.getTodosEmpresas();

    }

    public static EmpresaEntiti getEmpresaById(int epr_id) {

        return EmpresaModel.getEmpresaById(new EmpresaEntiti(epr_id));

    }

    public static void updateEmpresa(String epr_nombre,String epr_ruc, int epr_id) {

        EmpresaEntiti empresa = new EmpresaEntiti(epr_id, epr_ruc, epr_nombre);

        boolean resultado = EmpresaModel.updateEmpresa(empresa);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empresa Actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualziar");
        }

    }

    public static void insertEmpresa(String epr_nombre,String epr_ruc) {

        EmpresaEntiti empresa = new  EmpresaEntiti(epr_ruc, epr_nombre);

        boolean resultado = EmpresaModel.insertEmpresa(empresa);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empresa Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void deleteEmpresa(int epr_id) {

        EmpresaEntiti empresa = new  EmpresaEntiti(epr_id);

        boolean resultado = EmpresaModel.deleteEmpresa(empresa);


        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empresa Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

}
