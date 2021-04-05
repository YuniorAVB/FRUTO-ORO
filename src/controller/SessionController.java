package controller;

import config.EstadosApp;
import entities.EmpleadoEntiti;
import entities.SessionEntiti;
import javax.swing.JOptionPane;
import model.SessionModel;

/**
 *
 * @author YAVB
 */
public class SessionController {

    public static int validarSession(String usuario, String contrasenia) {

        SessionEntiti login = SessionModel.getSessionByUsuarioAndPassword(usuario, contrasenia);

        if (login != null) {
            EstadosApp.SESSION_USUARIO_ID = login.getSes_emp_id().getEmp_id();
            EstadosApp.SESSION_USUARIO = login.getSes_usuario();
            return login.getSes_tipo();
        }

        JOptionPane.showMessageDialog(null, "Usuario o contraseña Incorrecta");

        return EstadosApp.ESTADO_INT_ERROR;
    }

    public static void insertSession(String ses_usuario, String ses_contrasenia, int ses_tipo, int ses_emp_id) {

        boolean estado = SessionModel.insertSession(new SessionEntiti(ses_usuario, ses_contrasenia, ses_tipo, new EmpleadoEntiti(ses_emp_id)));

        if (estado == true) {

            JOptionPane.showMessageDialog(null, "Session Creado");
        } else {

            JOptionPane.showMessageDialog(null, "Ocurrio un Error");

        }

    }


    public static SessionEntiti getSessionByIdEmpleado(int ses_emp_id) {

        return SessionModel.getSessionByIdEmpleado(new SessionEntiti(new EmpleadoEntiti(ses_emp_id)));
    }

}
