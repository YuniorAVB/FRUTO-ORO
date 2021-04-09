package controller;

import entities.EmpleadoEntiti;
import entities.SessionEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.EmpleadoModel;
import model.SessionModel;

/**
 *
 * @author YAVB
 */
public class EmpleadoController {

    public static ArrayList<EmpleadoEntiti> getListaEmpleados() {

        return EmpleadoModel.getTodosEmpleados();

    }

    public static EmpleadoEntiti getEmpleadoById(int emp_id) {

        return EmpleadoModel.getEmpleadoById(new EmpleadoEntiti(emp_id));

    }

    public static void updateEmpleado(String emp_nombre, String emp_apellido, String emp_dni, char emp_sexo, int emp_edad, int emp_id) {

        EmpleadoEntiti empleado = new EmpleadoEntiti(emp_apellido, emp_dni, emp_nombre, emp_edad, emp_sexo, emp_id);

        boolean resultado = EmpleadoModel.updateEmpleado(empleado);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empleado Actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualziar");
        }

    }

    public static void insertEmpleado(String emp_nombre, String emp_apellido, String emp_dni, char emp_sexo, int emp_edad) {

        EmpleadoEntiti empleado = new EmpleadoEntiti(emp_apellido, emp_dni, emp_nombre, emp_edad, emp_sexo, emp_edad);

        boolean resultado = EmpleadoModel.insertEmpleado(empleado);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empleado Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void deleteEmpleado(int emp_id) {

        EmpleadoEntiti empleado = new EmpleadoEntiti(emp_id);

        boolean resultado = EmpleadoModel.deleteEmpleado(empleado);

        SessionEntiti session = SessionModel.getSessionByIdEmpleado(new SessionEntiti(empleado));

        if (session != null) {

            SessionModel.deleteSessionByIdEmpleado(new SessionEntiti(empleado));
        }

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empleado Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void deleteEmpleadoAllTables(int emp_id) {

        EmpleadoEntiti empleado = new EmpleadoEntiti(emp_id);

        boolean resultado = EmpleadoModel.deleteEmpleadoAllTables(empleado);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Empleado Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Eliminar");
        }

    }

}
