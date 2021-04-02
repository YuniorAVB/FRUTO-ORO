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
public class ModeloTicketEntiti {

    private int modtic_id;
    private String modtic_titulo;
    private String modtic_pie_pagina;
    private String mod_sub_titulo;

    public ModeloTicketEntiti(int modtic_id, String modtic_titulo, String modtic_pie_pagina, String mod_sub_titulo) {
        this.modtic_id = modtic_id;
        this.modtic_titulo = modtic_titulo;
        this.modtic_pie_pagina = modtic_pie_pagina;
        this.mod_sub_titulo = mod_sub_titulo;
    }

    public ModeloTicketEntiti(int modtic_id) {
        this.modtic_id = modtic_id;
    }
    
    

    public int getModtic_id() {
        return modtic_id;
    }

    public String getModtic_titulo() {
        return modtic_titulo;
    }

    public String getModtic_pie_pagina() {
        return modtic_pie_pagina;
    }

    public String getMod_sub_titulo() {
        return mod_sub_titulo;
    }

}
