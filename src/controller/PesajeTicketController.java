/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.MensajeError;
import entities.ModeloTicketEntiti;
import entities.PesajeEntiti;
import entities.PesajeTicketEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModeloTicketModel;
import model.PesajeTicketModel;

/**
 *
 * @author YAVB
 */
public class PesajeTicketController {
    
    public static int getGenerateNewTicketSerie() {
        int newSerie = 0;
        
        try {
            PesajeTicketEntiti ticket = PesajeTicketModel.getPesajeTicketLastSerie();
            
            if (ticket != null) {
                newSerie = ticket.getTic_serie_numero() + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
        
        return newSerie;
        
    }
    
    public static void insertTicket(int tic_pes_id, int tic_pes_serie) {
        
        PesajeTicketEntiti ticket = new PesajeTicketEntiti(new PesajeEntiti(tic_pes_id), tic_pes_serie);
        
        boolean resultado = PesajeTicketModel.insertTicketPesaje(ticket);
        
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Ticket Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }
        
    }
    
    public static ArrayList<PesajeTicketEntiti> getTodosTicketsPendientes() {
        
        return PesajeTicketModel.getTodosTicketsPendientes();
    }
    
    public static PesajeTicketEntiti getPesajeIngresoById(int pesaje_ticket_id) {
        return PesajeTicketModel.getPesajeTicketIngresoById(new PesajeTicketEntiti(pesaje_ticket_id));
    }
    
    public static PesajeTicketEntiti getPesajeIngresoByTicket(int ticket_serie) {
        return PesajeTicketModel.getPesajeTicketIngresoByTicket(new PesajeTicketEntiti(0, ticket_serie));
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
