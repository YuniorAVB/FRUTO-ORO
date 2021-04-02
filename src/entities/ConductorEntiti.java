package entities;

/**
 *
 * @author YAVB
 */
public class ConductorEntiti {

    private int con_id;
    private String con_nombre;
    private String con_dni;
    private String con_apellido;

    public int getCon_id() {
        return con_id;
    }

    public String getCon_nombre() {
        return con_nombre;
    }

    public String getCon_dni() {
        return con_dni;
    }

    public String getCon_apellido() {
        return con_apellido;
    }

    public ConductorEntiti(int con_id) {
        this.con_id = con_id;
    }

    public ConductorEntiti(String con_nombre, String con_dni, String con_apellido) {
        this.con_nombre = con_nombre;
        this.con_dni = con_dni;
        this.con_apellido = con_apellido;
    }

    
    

    public ConductorEntiti(int con_id, String con_nombre, String con_dni, String con_apellido) {
        this.con_id = con_id;
        this.con_nombre = con_nombre;
        this.con_dni = con_dni;
        this.con_apellido = con_apellido;
    }

}
