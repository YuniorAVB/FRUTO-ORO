/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.ConductorEntiti;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ConductorModel;

/**
 *
 * @author YAVB
 */
public class ConductorController {

    public static ArrayList<ConductorEntiti> getListaEmpleados() {

        return ConductorModel.getTodosConductor();

    }

    public static ConductorEntiti getConductorById(int con_id) {

        return ConductorModel.getConductorById(new ConductorEntiti(con_id));

    }

    public static void insertConductor(String con_nombre, String con_apellido, String con_dni) {

        ConductorEntiti conductor = new ConductorEntiti(con_nombre, con_dni, con_apellido);

        boolean resultado = ConductorModel.insertConductor(conductor);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Conductor Creado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }

    public static void updateConductor(int con_id, String con_nombre, String con_apellido, String con_dni) {

        ConductorEntiti conductor = new ConductorEntiti(con_id, con_nombre, con_dni, con_apellido);

        boolean resultado = ConductorModel.updateConductor(conductor);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Cunductor Actualizado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Actualziar");
        }

    }

    public static void deleteConductor(int con_id) {

        ConductorEntiti conductor = new ConductorEntiti(con_id);

        boolean resultado = ConductorModel.deleteConductor(conductor);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Conductor Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error al Crear");
        }

    }
}
