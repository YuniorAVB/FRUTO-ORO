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
public class PesajeEntiti {

    private int pes_id;
    private MovilidadEntiti pes_mov_id;
    private EmpleadoEntiti pes_emp_id;
    private ConductorEntiti pes_con_id;
    private String pes_fecha_ingreso;
    private String pes_fecha_salida;
    private double pes_peso_ingreso;
    private double pes_peso_salida;
    private String pes_hora_ingreso;
    private String pes_hora_salida;
    private double pes_tara;
    private double pes_neto;
    private double pes_bruto;
    private String pes_producto;

    public String getPes_producto() {
        return pes_producto;
    }

    public PesajeEntiti(int pes_id) {
        this.pes_id = pes_id;
    }

    public PesajeEntiti(int pes_id, MovilidadEntiti pes_mov_id, EmpleadoEntiti pes_emp_id, ConductorEntiti pes_con_id, String pes_fecha_ingreso, String pes_fecha_salida, double pes_peso_ingreso, double pes_peso_salida, String pes_hora_ingreso, String pes_hora_salida, double pes_tara) {
        this.pes_id = pes_id;
        this.pes_mov_id = pes_mov_id;
        this.pes_emp_id = pes_emp_id;
        this.pes_con_id = pes_con_id;
        this.pes_fecha_ingreso = pes_fecha_ingreso;
        this.pes_fecha_salida = pes_fecha_salida;
        this.pes_peso_ingreso = pes_peso_ingreso;
        this.pes_peso_salida = pes_peso_salida;
        this.pes_hora_ingreso = pes_hora_ingreso;
        this.pes_hora_salida = pes_hora_salida;
        this.pes_tara = pes_tara;
    }

    public PesajeEntiti(MovilidadEntiti pes_mov_id, EmpleadoEntiti pes_emp_id, ConductorEntiti pes_con_id, String pes_fecha_ingreso, String pes_fecha_salida, double pes_peso_ingreso, double pes_peso_salida, String pes_hora_ingreso, String pes_hora_salida, double pes_tara) {
        this.pes_mov_id = pes_mov_id;
        this.pes_emp_id = pes_emp_id;
        this.pes_con_id = pes_con_id;
        this.pes_fecha_ingreso = pes_fecha_ingreso;
        this.pes_fecha_salida = pes_fecha_salida;
        this.pes_peso_ingreso = pes_peso_ingreso;
        this.pes_peso_salida = pes_peso_salida;
        this.pes_hora_ingreso = pes_hora_ingreso;
        this.pes_hora_salida = pes_hora_salida;
        this.pes_tara = pes_tara;
    }

    public PesajeEntiti(MovilidadEntiti pes_mov_id, EmpleadoEntiti pes_emp_id, ConductorEntiti pes_con_id, String pes_fecha_ingreso, double pes_peso_ingreso, String pes_hora_ingreso, double pes_tara,String pes_producto) {
        this.pes_mov_id = pes_mov_id;
        this.pes_emp_id = pes_emp_id;
        this.pes_con_id = pes_con_id;
        this.pes_fecha_ingreso = pes_fecha_ingreso;
        this.pes_peso_ingreso = pes_peso_ingreso;
        this.pes_hora_ingreso = pes_hora_ingreso;
        this.pes_tara = pes_tara;
        this.pes_producto = pes_producto;

    }

    public PesajeEntiti(int pes_id, MovilidadEntiti pes_mov_id, EmpleadoEntiti pes_emp_id, ConductorEntiti pes_con_id, String pes_fecha_ingreso, double pes_peso_ingreso, String pes_hora_ingreso, double pes_tara, String pes_producto) {
        this.pes_id = pes_id;
        this.pes_mov_id = pes_mov_id;
        this.pes_emp_id = pes_emp_id;
        this.pes_con_id = pes_con_id;
        this.pes_fecha_ingreso = pes_fecha_ingreso;
        this.pes_peso_ingreso = pes_peso_ingreso;
        this.pes_hora_ingreso = pes_hora_ingreso;
        this.pes_tara = pes_tara;
        this.pes_producto = pes_producto;
    }

    public PesajeEntiti(int pes_id, String pes_fecha_salida, double pes_peso_salida, String pes_hora_salida, double pes_neto, double pes_bruto) {
        this.pes_id = pes_id;
        this.pes_fecha_salida = pes_fecha_salida;
        this.pes_peso_salida = pes_peso_salida;
        this.pes_hora_salida = pes_hora_salida;
        this.pes_neto = pes_neto;
        this.pes_bruto = pes_bruto;
    }

    public PesajeEntiti(int pes_id, MovilidadEntiti pes_mov_id, EmpleadoEntiti pes_emp_id, ConductorEntiti pes_con_id, String pes_fecha_ingreso, String pes_fecha_salida, double pes_peso_ingreso, double pes_peso_salida, String pes_hora_ingreso, String pes_hora_salida, double pes_tara, double pes_neto, double pes_bruto, String pes_producto) {
        this.pes_id = pes_id;
        this.pes_mov_id = pes_mov_id;
        this.pes_emp_id = pes_emp_id;
        this.pes_con_id = pes_con_id;
        this.pes_fecha_ingreso = pes_fecha_ingreso;
        this.pes_fecha_salida = pes_fecha_salida;
        this.pes_peso_ingreso = pes_peso_ingreso;
        this.pes_peso_salida = pes_peso_salida;
        this.pes_hora_ingreso = pes_hora_ingreso;
        this.pes_hora_salida = pes_hora_salida;
        this.pes_tara = pes_tara;
        this.pes_neto = pes_neto;
        this.pes_bruto = pes_bruto;
        this.pes_producto = pes_producto;
    }

    
    public double getPes_neto() {
        return pes_neto;
    }

    public double getPes_bruto() {
        return pes_bruto;
    }

    public int getPes_id() {
        return pes_id;
    }

    public MovilidadEntiti getPes_mov_id() {
        return pes_mov_id;
    }

    public EmpleadoEntiti getPes_emp_id() {
        return pes_emp_id;
    }

    public ConductorEntiti getPes_con_id() {
        return pes_con_id;
    }

    public String getPes_fecha_ingreso() {
        return pes_fecha_ingreso;
    }

    public String getPes_fecha_salida() {
        return pes_fecha_salida;
    }

    public double getPes_peso_ingreso() {
        return pes_peso_ingreso;
    }

    public double getPes_peso_salida() {
        return pes_peso_salida;
    }

    public String getPes_hora_ingreso() {
        return pes_hora_ingreso;
    }

    public String getPes_hora_salida() {
        return pes_hora_salida;
    }

    public double getPes_tara() {
        return pes_tara;
    }

}
