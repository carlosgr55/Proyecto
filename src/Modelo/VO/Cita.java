package Modelo.VO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {

    private String id;
    private Veterinario vet;
    private Cliente cliente;
    private String nomMascota;
    private LocalDateTime fecha;
    private String tipo;
    private char estatus; //A de Atendida, P de pendiente, C de cancelada
    
    
    public Cita(String id, Veterinario vet, Cliente cliente, String nomMascota, LocalDateTime fecha, String tipo) {
        this.id = id;
        this.vet = vet;
        this.cliente = cliente;
        this.nomMascota = nomMascota;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estatus = 'P';
    }

    public Cita() {
        this.id = "";
        this.vet = null;
        this.cliente = null;
        this.nomMascota = "";
        this.fecha = null;
        this.tipo = "";
        this.estatus = 'P';
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    
    
    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getNomMascota() {
        return nomMascota;
    }

    public void setNomMascota(String nomMascota) {
        this.nomMascota = nomMascota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void crearId(int idAnterior) {
        int mes = this.fecha.getMonthValue() * 1000000;
        int ano = (this.fecha.getYear() - 2000) * 10000;
        idAnterior++;
        int res = mes + ano + idAnterior;
        String idCreado = res + "";
        if(idCreado.charAt(0) != '1'){
          idCreado = "0" + idCreado;               
        }
        this.id = idCreado;
    }

    public Veterinario getVet() {
        return vet;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", vet=" + vet + ", cliente=" + cliente + ", nomMascota=" + nomMascota + ", fecha=" + fecha + ", tipo=" + tipo + '}';
    }

}
