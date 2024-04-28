package Controlador;

import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaDetalleCita;
import java.time.LocalDateTime;

public class ControladorDetalleCita {

    static VistaDetalleCita vistaDetalle = new VistaDetalleCita();
    static Cita citaActual;
    static daoCitas daocitas = new daoCitas();

    public static daoCitas getDaocitas() {
        return daocitas;
    }
    
    public static void quitarHora(LocalDateTime hora, Cita cita){
        cita.getVet().quitarHora(hora);
    }
    
    
    
    public ControladorDetalleCita(Cita cita){
        citaActual = cita;
    }
    public static void mostrarVentana(){
        vistaDetalle.setVisible(true);
        
    }
    public static Cita getCitaActual(){
        return citaActual;
    }
    
    public static Cita regresarCita(){
        return citaActual;
    }
    
    public static void cancelar(){
        vistaDetalle.setVisible(false);
        vistaDetalle.dispose();
    }
    
    public static void aceptar(){
        daocitas.addCita(citaActual);
        daocitas.addId(citaActual);
        vistaDetalle.setVisible(false);
        vistaDetalle.dispose();
    }
    
    public static void quitarHorasVet(Cita cita){
        Veterinario vet = cita.getVet();
        LocalDateTime hora = cita.getFecha();
        int index = ControladorAgendarCita.getDaoVet().getListaVet().indexOf(vet);
        ControladorAgendarCita.daoVet.getListaVet().get(index).quitarHora(hora);
    }
    
    public static void mostrarDatos(Cita cita){
        vistaDetalle.getTxt_cliente().setText(cita.getCliente().getNombre());
        vistaDetalle.getTxt_mascota().setText(cita.getNomMascota());
        String fecha = cita.getFecha().getDayOfMonth()+"-"+ cita.getFecha().getMonthValue()+cita.getFecha().getYear();
        vistaDetalle.getTxt_fecha().setText(fecha);
        vistaDetalle.getTxt_hora().setText(cita.getFecha().getHour()+":"+cita.getFecha().getMinute());
        vistaDetalle.getTxt_vet().setText(cita.getVet().getNombre() +" "+ cita.getVet().getApellido());
        vistaDetalle.getTxt_motivo().setText(cita.getTipo());
    }
    
    public static void modificar(Cita cita){
        ControladorAgendarCita.modificarVentana(cita);
        vistaDetalle.setVisible(false);
        vistaDetalle.dispose();
    }
}
    