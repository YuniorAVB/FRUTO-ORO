package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpresaEntiti;
import entities.EmpresaMovilidadDetalleEntiti;
import entities.MovilidadEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaMovilidadDetalleModel {

    public static ArrayList<EmpresaMovilidadDetalleEntiti> getTodosEmpresaMovilidad() {
        ArrayList<EmpresaMovilidadDetalleEntiti> empresa_movilidad_lista = new ArrayList<>();
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

                empresa_movilidad_lista.add(new EmpresaMovilidadDetalleEntiti(eprmovdet_id, empresa, movilidad));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_movilidad_lista;
    }

    public static ArrayList<EmpresaMovilidadDetalleEntiti> getTodosEmpresaMovilidadByEmpresaId(EmpresaEntiti empresa_buscar) {

        ArrayList<EmpresaMovilidadDetalleEntiti> empresa_movilidad_lista = new ArrayList<>();
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

                empresa_movilidad_lista.add(new EmpresaMovilidadDetalleEntiti(eprmovdet_id, empresa, movilidad));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_movilidad_lista;
    }

    public static boolean insertEmpresaMovilidad(EmpresaMovilidadDetalleEntiti empresaMovilidad) {

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

    public static boolean deleteEmpresaMovilidad(EmpresaMovilidadDetalleEntiti empresaMovilidad) {

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
