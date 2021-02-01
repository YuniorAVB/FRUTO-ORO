/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.ModeloTicketEntiti;
import javax.swing.JOptionPane;
import model.ModeloTicketModel;

/**
 *
 * @author YAVB
 */
public class ModeloTicketController {

    public static ModeloTicketEntiti getModeloTicket() {

        ModeloTicketEntiti modeloTicket = ModeloTicketModel.getTicket();

        return modeloTicket;

    }

    public static void updateModeloTicket(String modtic_titulo, String modtic_sub_titulo, String modtic_pie_pagina, int modtic_id) {

        ModeloTicketEntiti modeloTicket = new ModeloTicketEntiti(modtic_id, modtic_titulo, modtic_pie_pagina, modtic_sub_titulo);

        boolean resultado = ModeloTicketModel.updateTicket(modeloTicket);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Ticket Actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualziar");
        }

    }
}
