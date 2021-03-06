package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.PesajeEntiti;
import entities.PesajeTicketEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PesajeTicketModel {

    public static ArrayList<PesajeTicketEntiti> getTodosTickets() {

        ArrayList<PesajeTicketEntiti> ticket_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE_TICKET);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int tic_id = rs.getInt("tic_id");
                int tic_pes_id = rs.getInt("tic_pes_id");
                int tic_serie_numero = rs.getInt("tic_serie_numero");

                PesajeEntiti pesaje = PesajeModel.getPesajeById(new PesajeEntiti(tic_pes_id));

                PesajeTicketEntiti ticket_buscado = new PesajeTicketEntiti(tic_id, pesaje, tic_serie_numero);

                ticket_lista.add(ticket_buscado);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return ticket_lista;
    }

    public static ArrayList<PesajeTicketEntiti> getTodosTicketsPendientes() {

        ArrayList<PesajeTicketEntiti> ticket_lista = new ArrayList<>();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_PESAJE_TICKET + " as pe_tic INNER JOIN "
                    + DataBase.TBL_PESAJE + " as pe ON pe_tic.tic_pes_id =  pe.pes_id "
                    + "WHERE pe.pes_fecha_salida IS NULL"
            );

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int tic_id = rs.getInt("tic_id");
                int tic_pes_id = rs.getInt("tic_pes_id");
                int tic_serie_numero = rs.getInt("tic_serie_numero");

                PesajeEntiti pesaje = PesajeModel.getPesajeIngresoById(new PesajeEntiti(tic_pes_id));

                PesajeTicketEntiti ticket_buscado = new PesajeTicketEntiti(tic_id, pesaje, tic_serie_numero);

                ticket_lista.add(ticket_buscado);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return ticket_lista;
    }

    public static PesajeTicketEntiti getPesajeTicketLastSerie() {

        PesajeTicketEntiti ticket_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM "
                    + DataBase.TBL_PESAJE_TICKET
                    + " ORDER BY tic_serie_numero DESC LIMIT 1;");

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int tic_id = rs.getInt("tic_id");
                int tic_pes_id = rs.getInt("tic_pes_id");
                int tic_serie_numero = rs.getInt("tic_serie_numero");

                ticket_buscado = new PesajeTicketEntiti(tic_id, new PesajeEntiti(tic_pes_id), tic_serie_numero);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return ticket_buscado;
    }

    public static PesajeTicketEntiti getPesajeTicketIngresoById(PesajeTicketEntiti ticket) {

        PesajeTicketEntiti ticket_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE_TICKET + " WHERE tic_id = ?;");

            stm.setInt(1, ticket.getTic_id());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int tic_id = rs.getInt("tic_id");
                int tic_pes_id = rs.getInt("tic_pes_id");
                int tic_serie_numero = rs.getInt("tic_serie_numero");

                PesajeEntiti pesaje = PesajeModel.getPesajeIngresoById(new PesajeEntiti(tic_pes_id));

                ticket_buscado = new PesajeTicketEntiti(tic_id, pesaje, tic_serie_numero);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return ticket_buscado;
    }
    
     public static PesajeTicketEntiti getPesajeTicketIngresoByTicket(PesajeTicketEntiti ticket) {

        PesajeTicketEntiti ticket_buscado = null;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_PESAJE_TICKET + " WHERE tic_serie_numero = ?;");

            stm.setInt(1, ticket.getTic_serie_numero());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int tic_id = rs.getInt("tic_id");
                int tic_pes_id = rs.getInt("tic_pes_id");
                int tic_serie_numero = rs.getInt("tic_serie_numero");

                PesajeEntiti pesaje = PesajeModel.getPesajeIngresoById(new PesajeEntiti(tic_pes_id));

                ticket_buscado = new PesajeTicketEntiti(tic_id, pesaje, tic_serie_numero);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

        return ticket_buscado;
    }
    
    
    

    public static boolean insertTicketPesaje(PesajeTicketEntiti ticket) {

        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("INSERT INTO "
                    + DataBase.TBL_PESAJE_TICKET
                    + " (tic_pes_id,tic_serie_numero) VALUES (?,?)");

            stm.setInt(1, ticket.getTic_pes_id().getPes_id());
            stm.setInt(2, ticket.getTic_serie_numero());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;

    }

}
