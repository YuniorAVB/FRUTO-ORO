/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JButton;

/**
 *
 * @author YAVB
 */
public class ButtonTableCell {

    public static JButton crearButton(String texto, String nombre) {
        JButton btn_add = new JButton(texto);
        btn_add.setName(nombre);
        return btn_add;
    }

}
