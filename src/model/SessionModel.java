package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpleadoEntiti;
import entities.SessionEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author YAVB
 */
public class SessionModel {

    public static SessionEntiti getSessionByUsuarioAndPassword(String usuario, String contrasenia) {
        SessionEntiti loginEntiti = null;
        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_SESSION + " WHERE ses_usuario = ? AND ses_contrasenia  = ?");
            stm.setString(1, usuario);
            stm.setString(2, contrasenia);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String ses_usuario = rs.getString("ses_usuario");
                String ses_contrasenia = rs.getString("ses_contrasenia");
                int ses_tipo = rs.getInt("ses_tipo");
                int ses_emp_id = rs.getInt("ses_emp_id");
                int ses_id = rs.getInt("ses_id");
                loginEntiti = new SessionEntiti(ses_id, ses_usuario, ses_contrasenia, ses_tipo, new EmpleadoEntiti(ses_emp_id));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return loginEntiti;
    }

    public static SessionEntiti getSessionByIdEmpleado(SessionEntiti session) {

        SessionEntiti sessionEntiti = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_SESSION + " WHERE  ses_emp_id = ?");
            stm.setInt(1, session.getSes_emp_id().getEmp_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String ses_usuario = rs.getString("ses_usuario");
                String ses_contrasenia = rs.getString("ses_contrasenia");
                int ses_tipo = rs.getInt("ses_tipo");
                int ses_emp_id = rs.getInt("ses_emp_id");
                int ses_id = rs.getInt("ses_id");
                sessionEntiti = new SessionEntiti(ses_id, ses_usuario, ses_contrasenia, ses_tipo, new EmpleadoEntiti(ses_emp_id));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return sessionEntiti;
    }

    public static boolean insertSession(SessionEntiti session) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_SESSION + " (ses_usuario,ses_contrasenia,ses_emp_id,ses_tipo) VALUES (?,?,?,?);");
            stm.setString(1, session.getSes_usuario());
            stm.setString(2, session.getSes_contrasenia());
            stm.setInt(3, session.getSes_emp_id().getEmp_id());
            stm.setInt(4, session.getSes_tipo());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteSessionByIdEmpleado(SessionEntiti session) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM " + DataBase.TBL_SESSION + " WHERE ses_emp_id = ?;");
            stm.setInt(1, session.getSes_emp_id().getEmp_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
