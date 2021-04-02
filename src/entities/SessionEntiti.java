package entities;

/**
 *
 * @author YAVB
 */
public class SessionEntiti {

    private String ses_usuario;
    private String ses_contrasenia;
    private int ses_tipo;
    private EmpleadoEntiti ses_emp_id;
    private int ses_id;

    public int getSes_id() {
        return ses_id;
    }

    public SessionEntiti(int ses_id) {
        this.ses_id = ses_id;
    }

    public SessionEntiti(int ses_id, String ses_usuario, String ses_contrasenia, int ses_tipo, EmpleadoEntiti ses_emp_id) {
        this.ses_id = ses_id;
        this.ses_usuario = ses_usuario;
        this.ses_contrasenia = ses_contrasenia;
        this.ses_tipo = ses_tipo;
        this.ses_emp_id = ses_emp_id;
    }

    public SessionEntiti(String ses_usuario, String ses_contrasenia, int ses_tipo, EmpleadoEntiti ses_emp_id) {
        this.ses_usuario = ses_usuario;
        this.ses_contrasenia = ses_contrasenia;
        this.ses_tipo = ses_tipo;
        this.ses_emp_id = ses_emp_id;
    }

    public SessionEntiti(EmpleadoEntiti ses_emp_id) {
        this.ses_emp_id = ses_emp_id;
    }
    
    



    public String getSes_usuario() {
        return ses_usuario;
    }

    public String getSes_contrasenia() {
        return ses_contrasenia;
    }

    public int getSes_tipo() {
        return ses_tipo;
    }

    public EmpleadoEntiti getSes_emp_id() {
        return ses_emp_id;
    }

}
