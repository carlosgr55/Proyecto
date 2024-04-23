package Controlador;

import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControladorAgendarCita {

    static VistaAgendarCita vistaAgendar = new VistaAgendarCita();
    static daoVeterinarios daoVet = new daoVeterinarios();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    private static ArrayList<LocalDateTime> fechas = new ArrayList<>();

    public static daoVeterinarios getDaoVet() {
        return daoVet;
    }

    public static void setDaoVet(daoVeterinarios daoVet) {
        ControladorAgendarCita.daoVet = daoVet;
    }

    
    
    public static daoVeterinarios getDaoVets(){
        return daoVet;
    }
    
    public static void mostrarVentanda() {
        vistaAgendar.setVisible(true);
        evento();
    }
    
    public static void modificarVentana(Cita cita){
        vistaAgendar.setVisible(true);
        String tipo = cita.getTipo();
        String mascota = cita.getNomMascota();
        String fecha = cita.getFecha().toString();
        vistaAgendar.getComb_tipo().setSelectedItem(tipo);
        vistaAgendar.getTxt_nomMascota().setText(mascota);
        evento();
        vistaAgendar.getCombo_fechas().setSelectedItem(fecha);
    }

    public static void evento() {
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaAgendar.getComb_estetico().setVisible(true);
                vistaAgendar.getLb_estetico().setVisible(true);
                esteticoSelec();
                break;
            case "Revision":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Vacunacion":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Esterelizacion":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                esterilSelec();
                break;
        }

    }

    public static Veterinario getVeterinario() {
        Veterinario vet = null;
        String especialidad = getEspecialidad();
        LocalDateTime hora = LocalDateTime.parse((String) vistaAgendar.getCombo_fechas().getSelectedItem());

        for (Veterinario vetAux : daoVet.getListaVet()) {

            boolean fechaDisponible = vetAux.getDisponibilidad().contains(hora);
            boolean especialidadCorrecta = vetAux.getEspecialidad().contains(especialidad);

            if (fechaDisponible && especialidadCorrecta) {
                vet = vetAux;
            }
        }
        return vet;
    }

    private static String getEspecialidad() {
        String especialidad = "";
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();
        switch (tipo) {
            case "Estetico":
                especialidad = "Estetica";
                break;
            case "Revision":
                especialidad = "General";
                break;
            case "Vacunacion":
                especialidad = "General";
                break;
            case "Esterelizacion":
                especialidad = "Cirujana";
                break;
        }

        return especialidad;
    }

    public static Cita crearCita(){
        Cita cita;
        String id = ""; //Para actualizar
        Veterinario vet = getVeterinario();
        Cliente cliente = ControladorMenuInicio.getClienteActual();
        String nomMascota = vistaAgendar.getTxt_nomMascota().getText();
        LocalDateTime fecha = LocalDateTime.parse((String) vistaAgendar.getCombo_fechas().getSelectedItem());
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();
        cita = new Cita(id, vet, cliente, nomMascota, fecha, tipo);
        daoVet.quitarHoras(fecha, vet);
        logicaVeterinario.setDaoVet(daoVet);
        return cita;
    }

    public static void quitarHoras(Cita cita){
        
    }
    
    
    public static void revisionSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("General");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaAgendar.getCombo_fechas().addItem(hora);
        }
        vistaAgendar.getCombo_fechas().setEnabled(true);

    }

    public static void esterilSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Cirujana");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaAgendar.getCombo_fechas().addItem(hora);
        }
        vistaAgendar.getCombo_fechas().setEnabled(true);

    }

    public static void esteticoSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Estetica");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaAgendar.getCombo_fechas().addItem(hora);
        }
        vistaAgendar.getCombo_fechas().setEnabled(true);

    }

    public static void limpiarCombo() {
        int total = vistaAgendar.getCombo_fechas().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgendar.getCombo_fechas().removeItemAt(0);
        }
    }

}
