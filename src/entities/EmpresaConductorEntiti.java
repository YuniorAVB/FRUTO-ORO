package entities;

public class EmpresaConductorEntiti {

    private int eprcondet_id;
    private ConductorEntiti eprcondet_con_id;
    private EmpresaEntiti eprcondet_epr_id;

    public EmpresaConductorEntiti(int movcondet_id, ConductorEntiti movcondet_con_id, EmpresaEntiti eprcondet_epr_id) {
        this.eprcondet_id = movcondet_id;
        this.eprcondet_con_id = movcondet_con_id;
        this.eprcondet_epr_id = eprcondet_epr_id;
    }

    public EmpresaConductorEntiti(ConductorEntiti movcondet_con_id, EmpresaEntiti eprcondet_epr_id) {
        this.eprcondet_con_id = movcondet_con_id;
        this.eprcondet_epr_id = eprcondet_epr_id;
    }

    public EmpresaConductorEntiti(int movcondet_id) {
        this.eprcondet_id = movcondet_id;
    }

    public EmpresaEntiti getEprcondet_epr_id() {
        return eprcondet_epr_id;
    }

    public int getEprcondet_id() {
        return eprcondet_id;
    }

    public ConductorEntiti getEprcondet_con_id() {
        return eprcondet_con_id;
    }

}
