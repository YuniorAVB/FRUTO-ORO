package db;

import com.mysql.jdbc.Connection;
import config.DataBase;
import config.MensajeError;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author YAVB
 */
public class Conexion {

    private static Connection conexion;

    public static Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion.conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + DataBase.DB_HOST + ":" + DataBase.DB_PORT + "/" + DataBase.DB_NAME, DataBase.DB_USER, DataBase.DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_CONEXION_DB);
        }
        return conexion;
    }

}
