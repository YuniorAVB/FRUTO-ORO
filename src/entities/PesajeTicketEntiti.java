/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author yavb
 */
public class PesajeTicketEntiti {

    int tic_id;
    PesajeEntiti tic_pes_id;
    int tic_serie_numero;

    public PesajeTicketEntiti(int tic_id) {
        this.tic_id = tic_id;
    }

    public PesajeTicketEntiti(int tic_id, int tic_serie_numero) {
        this.tic_id = tic_id;
        this.tic_serie_numero = tic_serie_numero;
    }

    public PesajeTicketEntiti(PesajeEntiti tic_pes_id, int tic_serie_numero) {
        this.tic_pes_id = tic_pes_id;
        this.tic_serie_numero = tic_serie_numero;
    }

    public PesajeTicketEntiti(int tic_id, PesajeEntiti tic_pes_id, int tic_serie_numero) {
        this.tic_id = tic_id;
        this.tic_pes_id = tic_pes_id;
        this.tic_serie_numero = tic_serie_numero;
    }

    public int getTic_id() {
        return tic_id;
    }

    public PesajeEntiti getTic_pes_id() {
        return tic_pes_id;
    }

    public int getTic_serie_numero() {
        return tic_serie_numero;
    }

}
