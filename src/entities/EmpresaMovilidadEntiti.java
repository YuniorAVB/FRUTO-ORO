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
public class EmpresaMovilidadEntiti {

    private int eprmovdet_id;
    private EmpresaEntiti eprmovdet_epr_id;
    private MovilidadEntiti eprmovdet_mov_id;

    public EmpresaMovilidadEntiti(int eprmovdet_id, EmpresaEntiti eprmovdet_epr_id, MovilidadEntiti eprmovdet_mov_id) {
        this.eprmovdet_id = eprmovdet_id;
        this.eprmovdet_epr_id = eprmovdet_epr_id;
        this.eprmovdet_mov_id = eprmovdet_mov_id;
    }

    public EmpresaMovilidadEntiti(EmpresaEntiti eprmovdet_epr_id, MovilidadEntiti eprmovdet_mov_id) {
        this.eprmovdet_epr_id = eprmovdet_epr_id;
        this.eprmovdet_mov_id = eprmovdet_mov_id;
    }

    public EmpresaMovilidadEntiti(int eprmovdet_id) {
        this.eprmovdet_id = eprmovdet_id;
    }

    public int getEprmovdet_id() {
        return eprmovdet_id;
    }

    public EmpresaEntiti getEprmovdet_epr_id() {
        return eprmovdet_epr_id;
    }

    public MovilidadEntiti getEprmovdet_mov_id() {
        return eprmovdet_mov_id;
    }

}
