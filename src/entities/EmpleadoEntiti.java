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
public class EmpleadoEntiti {

    private String emp_apellido;
    private String emp_dni;
    private String emp_nombre;
    private int emp_edad;
    private char emp_sexo;
    private int emp_id;

    public EmpleadoEntiti(String emp_apellido, String emp_dni, String emp_nombre, int emp_edad, char emp_sexo, int emp_id) {
        this.emp_apellido = emp_apellido;
        this.emp_dni = emp_dni;
        this.emp_nombre = emp_nombre;
        this.emp_edad = emp_edad;
        this.emp_sexo = emp_sexo;
        this.emp_id = emp_id;
    }

    public EmpleadoEntiti(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_apellido() {
        return emp_apellido;
    }

    public String getEmp_dni() {
        return emp_dni;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public int getEmp_edad() {
        return emp_edad;
    }

    public char getEmp_sexo() {
        return emp_sexo;
    }

    public int getEmp_id() {
        return emp_id;
    }

}
