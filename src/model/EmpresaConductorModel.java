package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.ConductorEntiti;
import entities.EmpresaConductorEntiti;
import entities.EmpresaEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaConductorModel {

    public static ArrayList<EmpresaConductorEntiti> getTodosEmpresaConductor() {

        ArrayList<EmpresaConductorEntiti> empresa_conductor_lista = new ArrayList<>();
        EmpresaEntiti empresa;
        ConductorEntiti conductor;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_EMPRESA_CONDUCTOR_DETALLE);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int eprcondet_id = rs.getInt("eprcondet_id");
                int eprcondet_con_id = rs.getInt("eprcondet_con_id");
                int eprcondet_epr_id = rs.getInt("eprcondet_epr_id");

                empresa = EmpresaModel.getEmpresaById(new EmpresaEntiti(eprcondet_epr_id));
                conductor = ConductorModel.getConductorById(new ConductorEntiti(eprcondet_con_id));

                empresa_conductor_lista.add(new EmpresaConductorEntiti(eprcondet_id, conductor, empresa));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_conductor_lista;
    }
    
    
 

    public static ArrayList<EmpresaConductorEntiti> getTodosEmpresaConductorByEmpresaId(EmpresaEntiti empresa_buscar) {

        ArrayList<EmpresaConductorEntiti> empresa_conductor_lista = new ArrayList<>();
        EmpresaEntiti empresa;
        ConductorEntiti conductor;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_EMPRESA_CONDUCTOR_DETALLE
                    + " WHERE eprcondet_epr_id = ?;");

            stm.setInt(1, empresa_buscar.getEpr_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int eprcondet_id = rs.getInt("eprcondet_id");
                int eprcondet_con_id = rs.getInt("eprcondet_con_id");
                int eprcondet_epr_id = rs.getInt("eprcondet_epr_id");

                empresa = EmpresaModel.getEmpresaById(new EmpresaEntiti(eprcondet_epr_id));
                conductor = ConductorModel.getConductorById(new ConductorEntiti(eprcondet_con_id));

                empresa_conductor_lista.add(new EmpresaConductorEntiti(eprcondet_id, conductor, empresa));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_conductor_lista;
    }

    public static boolean insertEmpresaConductor(EmpresaConductorEntiti empresaConductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_EMPRESA_CONDUCTOR_DETALLE
                    + " (eprcondet_con_id,eprcondet_epr_id) VALUES (?,?)");

            stm.setInt(1, empresaConductor.getEprcondet_epr_id().getEpr_id());
            stm.setInt(2, empresaConductor.getEprcondet_con_id().getCon_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteEmpresaConductor(EmpresaConductorEntiti empresaConductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  "
                    + DataBase.TBL_EMPRESA_CONDUCTOR_DETALLE
                    + " WHERE eprcondet_id = ?");

            stm.setInt(1, empresaConductor.getEprcondet_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
