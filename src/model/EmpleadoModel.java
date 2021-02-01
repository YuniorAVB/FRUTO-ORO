package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpleadoEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoModel {

    public static ArrayList<EmpleadoEntiti> getTodosEmpleados() {

        ArrayList<EmpleadoEntiti> empleado_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_EMPLEADO);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String emp_apellido = rs.getString("emp_apellido");
                String emp_dni = rs.getString("emp_dni");
                String emp_nombre = rs.getString("emp_nombre");
                int emp_id = rs.getInt("emp_id");

                int emp_edad = rs.getInt("emp_edad");
                char emp_sexo = rs.getString("emp_sexo").charAt(0);

                empleado_lista.add(new EmpleadoEntiti(emp_apellido, emp_dni, emp_nombre, emp_edad, emp_sexo, emp_id));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return empleado_lista;
    }

    public static EmpleadoEntiti getEmpleadoById(EmpleadoEntiti empleado) {

        EmpleadoEntiti empleado_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_EMPLEADO + " WHERE emp_id = ?;");

            stm.setInt(1, empleado.getEmp_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String emp_apellido = rs.getString("emp_apellido");
                String emp_dni = rs.getString("emp_dni");
                String emp_nombre = rs.getString("emp_nombre");
                int emp_id = rs.getInt("emp_id");

                int emp_edad = rs.getInt("emp_edad");
                char emp_sexo = rs.getString("emp_sexo").charAt(0);

                empleado_buscado = new EmpleadoEntiti(emp_apellido, emp_dni, emp_nombre, emp_edad, emp_sexo, emp_id);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return empleado_buscado;
    }

    public static boolean insertEmpleado(EmpleadoEntiti empleado) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_EMPLEADO + " (emp_nombre,emp_apellido,emp_dni,emp_edad,emp_sexo) VALUES (?,?,?,?,?)");
            stm.setString(1, empleado.getEmp_nombre());
            stm.setString(2, empleado.getEmp_apellido());
            stm.setString(3, empleado.getEmp_dni());
            stm.setInt(4, empleado.getEmp_edad());
            stm.setString(5, String.valueOf(empleado.getEmp_sexo()));

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updateEmpleado(EmpleadoEntiti empleado) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_EMPLEADO + " SET  emp_nombre = ?,emp_apellido= ?,emp_dni=?,emp_edad=?,emp_sexo=? WHERE emp_id = ?");
            stm.setString(1, empleado.getEmp_nombre());
            stm.setString(2, empleado.getEmp_apellido());
            stm.setString(3, empleado.getEmp_dni());
            stm.setInt(4, empleado.getEmp_edad());
            stm.setString(5, String.valueOf(empleado.getEmp_sexo()));
            stm.setInt(6, empleado.getEmp_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteEmpleado(EmpleadoEntiti empleado) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_EMPLEADO + " WHERE emp_id = ?");
            stm.setInt(1, empleado.getEmp_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
