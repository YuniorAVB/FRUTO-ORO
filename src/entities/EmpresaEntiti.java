/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author YAVB
 */
public class EmpresaEntiti {

    private int epr_id;
    private String epr_ruc;
    private String epr_nombre;

    public EmpresaEntiti(int epr_id, String epr_ruc, String epr_nombre) {
        this.epr_id = epr_id;
        this.epr_ruc = epr_ruc;
        this.epr_nombre = epr_nombre;
    }

    public EmpresaEntiti(String epr_ruc, String epr_nombre) {
        this.epr_ruc = epr_ruc;
        this.epr_nombre = epr_nombre;
    }
    

    public EmpresaEntiti(int epr_id) {
        this.epr_id = epr_id;
    }

    public int getEpr_id() {
        return epr_id;
    }

    public String getEpr_ruc() {
        return epr_ruc;
    }

    public String getEpr_nombre() {
        return epr_nombre;
    }

}
