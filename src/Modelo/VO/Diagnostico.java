
package Modelo.VO;


public class Diagnostico {
    private String diagnostico;
    private Cita cita;

    public Diagnostico(String diagnostico, Cita cita) {
        this.diagnostico = diagnostico;
        this.cita = cita;
    }

    
    
    
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    
    
}
