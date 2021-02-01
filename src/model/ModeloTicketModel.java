/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.DataBase;
import config.MensajeError;
import db.Conexion;
import entities.ModeloTicketEntiti;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModeloTicketModel {

    public static ModeloTicketEntiti getTicket() {

        ModeloTicketEntiti modeloTicketEntiti = null;
        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("SELECT * FROM " + DataBase.TBL_MODELO_TICKET);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String modtic_titulo = rs.getString("modtic_titulo");
                String modtic_sub_titulo = rs.getString("modtic_sub_titulo");
                String modtic_piepagina = rs.getString("modtic_pie_pagina");
                int modtic_id = rs.getInt("modtic_id");

                modeloTicketEntiti = new ModeloTicketEntiti(modtic_id, modtic_titulo, modtic_piepagina, modtic_sub_titulo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR+" ERROR :"+ex.getMessage());
        }
        return modeloTicketEntiti;
    }

    public static boolean updateTicket(ModeloTicketEntiti modeloTicketEntiti) {
        int result = 0;

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement("UPDATE " + DataBase.TBL_MODELO_TICKET + " SET modtic_titulo = ?,modtic_sub_titulo = ?, modtic_pie_pagina = ? WHERE modtic_id = ? ");
            stm.setString(1, modeloTicketEntiti.getModtic_titulo());
            stm.setString(2, modeloTicketEntiti.getMod_sub_titulo());
            stm.setString(3, modeloTicketEntiti.getModtic_pie_pagina());
            stm.setInt(4, modeloTicketEntiti.getModtic_id());

            result = stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        return result > 0;
    }

}
