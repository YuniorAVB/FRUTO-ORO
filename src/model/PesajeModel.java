package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.ConductorEntiti;
import entities.EmpleadoEntiti;
import entities.MovilidadEntiti;
import entities.PesajeEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PesajeModel {

    public static ArrayList<PesajeEntiti> getTodosPesajes() {

        ArrayList<PesajeEntiti> pesaje_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int pes_id = rs.getInt("pes_id");
                int pes_mov_id = rs.getInt("pes_mov_id");
                int pes_emp_id = rs.getInt("pes_emp_id");
                int pes_con_id = rs.getInt("pes_con_id");
                String pes_fecha_ingreso = rs.getDate("pes_fecha_ingreso").toString();
                String pes_fecha_salida = rs.getDate("pes_fecha_salida").toString();
                double pes_peso_ingreso = rs.getDouble("pes_peso_ingreso");
                double pes_peso_salida = rs.getDouble("pes_peso_salida");
                String pes_hora_ingreso = rs.getString("pes_hora_ingreso");
                String pes_hora_salida = rs.getString("pes_hora_salida");
                double pes_tara = rs.getDouble("pes_tara");

                MovilidadEntiti movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(pes_mov_id));
                EmpleadoEntiti empleado = EmpleadoModel.getEmpleadoById(new EmpleadoEntiti(pes_emp_id));
                ConductorEntiti conductor = ConductorModel.getConductorById(new ConductorEntiti(pes_con_id));

                PesajeEntiti pesaje = new PesajeEntiti(movilidad, empleado, conductor, pes_fecha_ingreso, pes_fecha_salida, pes_peso_ingreso, pes_peso_salida, pes_hora_ingreso, pes_hora_salida, pes_tara);

                pesaje_lista.add(pesaje);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return pesaje_lista;
    }

    public static PesajeEntiti getPesajeById(PesajeEntiti pesaje) {

        PesajeEntiti pesaje_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE + " WHERE pes_id = ?;");

            stm.setInt(1, pesaje.getPes_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int pes_id = rs.getInt("pes_id");
                int pes_mov_id = rs.getInt("pes_mov_id");
                int pes_emp_id = rs.getInt("pes_emp_id");
                int pes_con_id = rs.getInt("pes_con_id");
                String pes_fecha_ingreso = rs.getDate("pes_fecha_ingreso").toString();
                String pes_fecha_salida = rs.getDate("pes_fecha_salida").toString();
                double pes_peso_ingreso = rs.getDouble("pes_peso_ingreso");
                double pes_peso_salida = rs.getDouble("pes_peso_salida");
                String pes_hora_ingreso = rs.getString("pes_hora_ingreso");
                String pes_hora_salida = rs.getString("pes_hora_salida");
                double pes_tara = rs.getDouble("pes_tara");

                MovilidadEntiti movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(pes_mov_id));
                EmpleadoEntiti empleado = EmpleadoModel.getEmpleadoById(new EmpleadoEntiti(pes_emp_id));
                ConductorEntiti conductor = ConductorModel.getConductorById(new ConductorEntiti(pes_con_id));

                pesaje_buscado = new PesajeEntiti(movilidad, empleado, conductor, pes_fecha_ingreso, pes_fecha_salida, pes_peso_ingreso, pes_peso_salida, pes_hora_ingreso, pes_hora_salida, pes_tara);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return pesaje_buscado;
    }

    public static PesajeEntiti getPesajeIngresoById(PesajeEntiti pesaje) {

        PesajeEntiti pesaje_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE + " WHERE pes_id = ?;");

            stm.setInt(1, pesaje.getPes_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int pes_id = rs.getInt("pes_id");
                int pes_mov_id = rs.getInt("pes_mov_id");
                int pes_emp_id = rs.getInt("pes_emp_id");
                int pes_con_id = rs.getInt("pes_con_id");
                String pes_fecha_ingreso = rs.getDate("pes_fecha_ingreso").toString();
                double pes_peso_ingreso = rs.getDouble("pes_peso_ingreso");
                String pes_hora_ingreso = rs.getString("pes_hora_ingreso");
                double pes_tara = rs.getDouble("pes_tara");
                String pes_producto = rs.getString("pes_producto");

                MovilidadEntiti movilidad = MovilidadModel.getMovilidadById(new MovilidadEntiti(pes_mov_id));
                EmpleadoEntiti empleado = EmpleadoModel.getEmpleadoById(new EmpleadoEntiti(pes_emp_id));
                ConductorEntiti conductor = ConductorModel.getConductorById(new ConductorEntiti(pes_con_id));

                pesaje_buscado = new PesajeEntiti(pes_id, movilidad, empleado, conductor, pes_fecha_ingreso, pes_peso_ingreso, pes_hora_ingreso, pes_tara, pes_producto);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return pesaje_buscado;
    }

    public static PesajeEntiti getPesajeIngresoLast() {

        PesajeEntiti pesaje_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE + "  ORDER BY pes_id DESC LIMIT 1;");

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int pes_id = rs.getInt("pes_id");

                pesaje_buscado = new PesajeEntiti(pes_id);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return pesaje_buscado;
    }

    public static boolean insertPesaje(PesajeEntiti pesaje) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO "
                    + DataBase.TBL_PESAJE
                    + " (pes_mov_id,pes_emp_id,pes_con_id,pes_fecha_ingreso,"
                    + "pes_fecha_salida,pes_peso_ingreso,pes_peso_salida,pes_hora_ingreso"
                    + ",pes_hora_salida,pes_tara) VALUES (?,?,?,?,?,?,?,?,?,?)");

            stm.setInt(1, pesaje.getPes_mov_id().getMov_id());
            stm.setInt(2, pesaje.getPes_emp_id().getEmp_id());
            stm.setInt(3, pesaje.getPes_con_id().getCon_id());
            stm.setDate(4, java.sql.Date.valueOf(pesaje.getPes_fecha_ingreso()));
            stm.setDate(5, java.sql.Date.valueOf(pesaje.getPes_fecha_salida()));
            stm.setDouble(6, pesaje.getPes_peso_ingreso());
            stm.setDouble(7, pesaje.getPes_peso_salida());
            stm.setString(8, pesaje.getPes_hora_ingreso());
            stm.setString(9, pesaje.getPes_hora_salida());
            stm.setDouble(10, pesaje.getPes_tara());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean insertPesajeIngreso(PesajeEntiti pesaje) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO "
                    + DataBase.TBL_PESAJE
                    + " (pes_mov_id,pes_emp_id,pes_con_id,pes_fecha_ingreso,"
                    + "pes_peso_ingreso,pes_hora_ingreso,pes_tara,pes_producto"
                    + ") VALUES (?,?,?,?,?,?,?,?)");

            stm.setInt(1, pesaje.getPes_mov_id().getMov_id());
            stm.setInt(2, pesaje.getPes_emp_id().getEmp_id());
            stm.setInt(3, pesaje.getPes_con_id().getCon_id());
            stm.setDate(4, java.sql.Date.valueOf(pesaje.getPes_fecha_ingreso()));
            stm.setDouble(5, pesaje.getPes_peso_ingreso());
            stm.setString(6, pesaje.getPes_hora_ingreso());
            stm.setDouble(7, pesaje.getPes_tara());
            stm.setString(8, pesaje.getPes_producto());

            result = stm.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updatePesaje(PesajeEntiti pesaje) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_PESAJE
                    + " SET  pes_mov_id = ?,pes_emp_id = ?,pes_con_id = ?,pes_fecha_ingreso = ?,"
                    + "pes_fecha_salida = ?,pes_peso_ingreso = ?,pes_peso_salida = ?,pes_hora_ingreso = ?,"
                    + "pes_hora_salida = ?,pes_tara = ? WHERE pes_id = ?");

            stm.setInt(1, pesaje.getPes_mov_id().getMov_id());
            stm.setInt(2, pesaje.getPes_emp_id().getEmp_id());
            stm.setInt(3, pesaje.getPes_con_id().getCon_id());
            stm.setDate(4, java.sql.Date.valueOf(pesaje.getPes_fecha_ingreso()));
            stm.setDate(5, java.sql.Date.valueOf(pesaje.getPes_fecha_salida()));
            stm.setDouble(6, pesaje.getPes_peso_ingreso());
            stm.setDouble(7, pesaje.getPes_peso_salida());
            stm.setString(8, pesaje.getPes_hora_ingreso());
            stm.setString(9, pesaje.getPes_hora_salida());

            stm.setDouble(10, pesaje.getPes_tara());

            stm.setDouble(11, pesaje.getPes_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updatePesajeSalida(PesajeEntiti pesaje) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_PESAJE
                    + " SET pes_fecha_salida = ?,pes_peso_salida = ?,"
                    + "pes_hora_salida = ?, pes_neto = ?,pes_bruto = ? WHERE pes_id = ?");

            stm.setDate(1, java.sql.Date.valueOf(pesaje.getPes_fecha_salida()));
            stm.setDouble(2, pesaje.getPes_peso_salida());
            stm.setString(3, pesaje.getPes_hora_salida());
            stm.setDouble(4, pesaje.getPes_neto());
            stm.setDouble(5, pesaje.getPes_bruto());

            stm.setDouble(6, pesaje.getPes_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean checkTicketSalidaById(PesajeEntiti pesaje) {

        boolean result = false;

        if (pesaje != null) {
            try {
                PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE
                        + " WHERE pes_id LIKE ? AND pes_peso_salida IS NOT NULL ");

                stm.setInt(1, pesaje.getPes_id());

                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    result = true;
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
            }
        }
        return result;

    }

    public static boolean deletePesaje(PesajeEntiti pesaje) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  "
                    + DataBase.TBL_PESAJE + " WHERE pes_id = ?");

            stm.setInt(1, pesaje.getPes_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
