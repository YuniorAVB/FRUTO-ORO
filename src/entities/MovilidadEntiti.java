
package entities;

/**
 *
 * @author YAVB
 */
public class MovilidadEntiti {
    
    private int mov_id;
    private String mv_destino;
    private String mov_procedencia;
    private String mov_placa;

    public MovilidadEntiti(int mov_id) {
        this.mov_id = mov_id;
    }

    public MovilidadEntiti(int mov_id, String mv_destino, String mov_procedencia, String mov_placa) {
        this.mov_id = mov_id;
        this.mv_destino = mv_destino;
        this.mov_procedencia = mov_procedencia;
        this.mov_placa = mov_placa;
    }

    public MovilidadEntiti(String mv_destino, String mov_procedencia, String mov_placa) {
        this.mv_destino = mv_destino;
        this.mov_procedencia = mov_procedencia;
        this.mov_placa = mov_placa;
    }

    public int getMov_id() {
        return mov_id;
    }

    public String getMv_destino() {
        return mv_destino;
    }

    public String getMov_procedencia() {
        return mov_procedencia;
    }

    public String getMov_placa() {
        return mov_placa;
    }
    
    
    
    
}
