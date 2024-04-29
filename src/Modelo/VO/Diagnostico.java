package Modelo.VO;

public class Diagnostico {

    private String diagnostico;
    private Cita cita;
    private double precio;

    public Diagnostico(String diagnostico, Cita cita, double precio) {
        this.diagnostico = diagnostico;
        this.cita = cita;
        this.precio = precio;
    }

    public Diagnostico(String diagnostico, Cita cita) {
        this.diagnostico = diagnostico;
        this.cita = cita;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
