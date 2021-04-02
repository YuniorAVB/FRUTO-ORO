package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpresaEntiti;
import entities.EmpresaMovilidadEntiti;
import entities.MovilidadEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaMovilidadModel {

    public static ArrayList<EmpresaMovilidadEntiti> getTodosEmpresaMovilidad() {
        ArrayList<EmpresaMovilidadEntiti> empresa_movilidad_lista = new ArrayList<>();
        EmpresaEntiti empresa;
        MovilidadEntiti movilidad;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int eprmovdet_id = rs.getInt("eprmovdet_id");
                int eprmovdet_epr_id = rs.getInt("eprmovdet_epr_id");
                int eprmovdet_mov_id = rs.getInt("eprmovdet_mov_id");

                empresa = EmpresaModel.getEmpresaById(new EmpresaEntiti(eprmovdet_epr_id));
                movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(eprmovdet_mov_id));

                empresa_movilidad_lista.add(new EmpresaMovilidadEntiti(eprmovdet_id, empresa, movilidad));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_movilidad_lista;
    }

    public static ArrayList<EmpresaMovilidadEntiti> getTodosEmpresaMovilidadByEmpresaId(EmpresaEntiti empresa_buscar) {

        ArrayList<EmpresaMovilidadEntiti> empresa_movilidad_lista = new ArrayList<>();
        EmpresaEntiti empresa;
        MovilidadEntiti movilidad;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE
                    + " WHERE eprmovdet_epr_id = ?;");

            stm.setInt(1, empresa_buscar.getEpr_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int eprmovdet_id = rs.getInt("eprmovdet_id");
                int eprmovdet_epr_id = rs.getInt("eprmovdet_epr_id");
                int eprmovdet_mov_id = rs.getInt("eprmovdet_mov_id");

                empresa = EmpresaModel.getEmpresaById(new EmpresaEntiti(eprmovdet_epr_id));
                movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(eprmovdet_mov_id));

                empresa_movilidad_lista.add(new EmpresaMovilidadEntiti(eprmovdet_id, empresa, movilidad));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_movilidad_lista;
    }

    public static EmpresaMovilidadEntiti getEmpresaMovilidadByPlaca(MovilidadEntiti movilidad_buscar) {

        EmpresaEntiti empresa;
        MovilidadEntiti movilidad;

        EmpresaMovilidadEntiti empresa_movilidad = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE
                    + " WHERE eprmovdet_mov_id =  ? ;");

            stm.setInt(1, movilidad_buscar.getMov_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int eprmovdet_id = rs.getInt("eprmovdet_id");
                int eprmovdet_epr_id = rs.getInt("eprmovdet_epr_id");
                int eprmovdet_mov_id = rs.getInt("eprmovdet_mov_id");

                empresa = EmpresaModel.getEmpresaById(new EmpresaEntiti(eprmovdet_epr_id));
                movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(eprmovdet_mov_id));

                empresa_movilidad = new EmpresaMovilidadEntiti(eprmovdet_id, empresa, movilidad);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_movilidad;
    }

    public static boolean insertEmpresaMovilidad(EmpresaMovilidadEntiti empresaMovilidad) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE
                    + " (eprmovdet_epr_id,eprmovdet_mov_id) VALUES (?,?)");

            stm.setInt(1, empresaMovilidad.getEprmovdet_epr_id().getEpr_id());
            stm.setInt(2, empresaMovilidad.getEprmovdet_mov_id().getMov_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteEmpresaMovilidad(EmpresaMovilidadEntiti empresaMovilidad) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE + " WHERE eprmovdet_id = ?");
            stm.setInt(1, empresaMovilidad.getEprmovdet_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
