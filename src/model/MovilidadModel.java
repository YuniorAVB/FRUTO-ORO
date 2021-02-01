package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.EmpresaEntiti;
import entities.MovilidadEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MovilidadModel {

    public static ArrayList<MovilidadEntiti> getTodosMovilidad() {

        ArrayList<MovilidadEntiti> movilidad_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_MOVILIDAD);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String mov_procedencia = rs.getString("mov_procedencia");
                String mov_destino = rs.getString("mov_destino");
                String mov_placa = rs.getString("mov_placa");
                int mov_id = rs.getInt("mov_id");
                
                movilidad_lista.add(new MovilidadEntiti(mov_id, mov_destino, mov_procedencia, mov_placa));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return movilidad_lista;
    }

    public static MovilidadEntiti getMovilidadById(MovilidadEntiti movilidad) {

        MovilidadEntiti movilidad_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_MOVILIDAD + " WHERE mov_id = ?;");

            stm.setInt(1, movilidad.getMov_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String mov_procedencia = rs.getString("mov_procedencia");
                String mov_destino = rs.getString("mov_destino");
                String mov_placa = rs.getString("mov_placa");
                int mov_id = rs.getInt("mov_id");

                movilidad_buscado = new MovilidadEntiti(mov_id, mov_destino, mov_procedencia, mov_placa);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return movilidad_buscado;
    }

    public static boolean insertMovilidad(MovilidadEntiti movilidad) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO " + DataBase.TBL_MOVILIDAD + " (mov_procedencia,mov_destino,mov_placa) VALUES (?,?,?)");
            stm.setString(1, movilidad.getMov_procedencia());
            stm.setString(2, movilidad.getMv_destino());
            stm.setString(3, movilidad.getMov_placa());
            
            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean updateMovilidad(MovilidadEntiti movilidad) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_MOVILIDAD + " SET  mov_procedencia = ?,mov_destino= ?, mov_placa = ? WHERE mov_id = ?");
            stm.setString(1, movilidad.getMov_procedencia());
            stm.setString(2, movilidad.getMv_destino());
            stm.setString(3, movilidad.getMov_placa());

            stm.setInt(4, movilidad.getMov_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

    public static boolean deleteMovilidad(MovilidadEntiti movilidad) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("DELETE FROM  " + DataBase.TBL_MOVILIDAD + " WHERE mov_id = ?");
            stm.setInt(1, movilidad.getMov_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
