package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.ConductorEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author YAVB
 */
public class ConductorModel {

    public static ArrayList<ConductorEntiti> getTodosConductor() {

        ArrayList<ConductorEntiti> conductor_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_CONDUCTOR);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String con_nombre = rs.getString("con_nombre");
                String con_dni = rs.getString("con_dni");
                String con_apellido = rs.getString("con_apellido");
                int con_id = rs.getInt("con_id");

                conductor_lista.add(new ConductorEntiti(con_id, con_nombre, con_dni, con_apellido));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return conductor_lista;
    }

    public static ConductorEntiti getConductorById(ConductorEntiti conductor) {

        ConductorEntiti conductor_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_CONDUCTOR + " WHERE con_id = ?;");

            stm.setInt(1, conductor.getCon_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String con_apellido = rs.getString("con_apellido");
                String con_dni = rs.getString("con_dni");
                String con_nombre = rs.getString("con_nombre");
                int con_id = rs.getInt("con_id");

                conductor_buscado = new ConductorEntiti(con_id, con_nombre, con_dni, con_apellido);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return conductor_buscado;
    }

    public static boolean insertConductor(ConductorEntiti conductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_CONDUCTOR + " (con_nombre,con_apellido,con_dni) VALUES (?,?,?)");
            stm.setString(1, conductor.getCon_nombre());
            stm.setString(2, conductor.getCon_apellido());
            stm.setString(3, conductor.getCon_dni());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updateConductor(ConductorEntiti conductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_CONDUCTOR + " SET  con_nombre = ?,con_apellido= ?,con_dni=? WHERE con_id = ?");
            stm.setString(1, conductor.getCon_nombre());
            stm.setString(2, conductor.getCon_apellido());
            stm.setString(3, conductor.getCon_dni());
            stm.setInt(4, conductor.getCon_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteConductor(ConductorEntiti conductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_CONDUCTOR + " WHERE con_id = ?");
            stm.setInt(1, conductor.getCon_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteConductorAlltables(ConductorEntiti conductor) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_CONDUCTOR + " WHERE con_id = ?");
            stm.setInt(1, conductor.getCon_id());

            PreparedStatement stm1 = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_PESAJE + " WHERE pes_con_id = ?");
            stm1.setInt(1, conductor.getCon_id());

            PreparedStatement stm2 = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_EMPRESA_CONDUCTOR_DETALLE + " WHERE eprcondet_con_id = ?");
            stm2.setInt(1, conductor.getCon_id());

            result = stm.executeUpdate();
            result = stm1.executeUpdate();
            result = stm2.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }
}
