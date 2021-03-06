package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpresaEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaModel {

    public static ArrayList<EmpresaEntiti> getTodosEmpresas() {

        ArrayList<EmpresaEntiti> empresa_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_EMPRESA);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String epr_ruc = rs.getString("epr_ruc");
                String epr_nombre = rs.getString("epr_nombre");
                int epr_id = rs.getInt("epr_id");

                empresa_lista.add(new EmpresaEntiti(epr_id, epr_ruc, epr_nombre));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empresa_lista;
    }

    public static EmpresaEntiti getEmpresaById(EmpresaEntiti empresa) {

        EmpresaEntiti empresa_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_EMPRESA + " WHERE epr_id = ?;");

            stm.setInt(1, empresa.getEpr_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String epr_ruc = rs.getString("epr_ruc");
                String epr_nombre = rs.getString("epr_nombre");
                int epr_id = rs.getInt("epr_id");

                empresa_buscado = new EmpresaEntiti(epr_id, epr_ruc, epr_nombre);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return empresa_buscado;
    }

    public static boolean insertEmpresa(EmpresaEntiti empresa) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_EMPRESA + " (epr_nombre,epr_ruc) VALUES (?,?)");
            stm.setString(1, empresa.getEpr_nombre());
            stm.setString(2, empresa.getEpr_ruc());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updateEmpresa(EmpresaEntiti empresa) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_EMPRESA + " SET  epr_nombre = ?,epr_ruc= ? WHERE epr_id = ?");
            stm.setString(1, empresa.getEpr_nombre());
            stm.setString(2, empresa.getEpr_ruc());

            stm.setInt(3, empresa.getEpr_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteEmpresa(EmpresaEntiti empresa) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_EMPRESA + " WHERE epr_id = ?");
            stm.setInt(1, empresa.getEpr_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
