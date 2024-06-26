package Controlador;

import static Controlador.ControladorVerMascotas.listaMascota;
import static Controlador.ControladorVerMascotas.vistaMascota;
import Modelo.Componentes.FechaIsNull;
import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.metal.MetalIconFactory;

public class ControladorAgendarCita {

    static VistaAgendarCita vistaAgendar = new VistaAgendarCita();
    static daoVeterinarios daoVet = new daoVeterinarios();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    private static ArrayList<LocalDateTime> fechas = new ArrayList<>();
    static Cliente cliente;
    static ArrayList<Mascota> listaMascota;

    public static daoVeterinarios getDaoVet() {
        return daoVet;
    }

    public static void popularCombo() {
        for (Mascota mascota : listaMascota) {
            String nombre = mascota.getNombre();
            vistaAgendar.getCombo_mascotas().addItem(nombre);
        }
    }

    public static void setDaoVet(daoVeterinarios daoVet) {
        ControladorAgendarCita.daoVet = daoVet;
    }

    public static daoVeterinarios getDaoVets() {
        return daoVet;
    }

    public static void mostrarVentanda() {
        cliente = ControladorMenuInicio.getClienteActual();
        listaMascota = cliente.getMascotas();
        vistaAgendar.setVisible(true);
        evento();
        popularCombo();

    }

    public static void modificarVentana(Cita cita) {
        vistaAgendar.setVisible(true);
        String tipo = cita.getTipo();
        String mascota = cita.getNomMascota();
        String fecha = cita.getFecha().toString();
        vistaAgendar.getComb_tipo().setSelectedItem(tipo);
        popularCombo();
        vistaAgendar.getCombo_mascotas().setSelectedItem(mascota);
        evento();
        //vistaAgendar.getCombo_fechas().setSelectedItem(fecha);
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
        //LocalDateTime hora = LocalDateTime.parse((String) vistaAgendar.getCombo_fechas().getSelectedItem());
        String hora = (String) vistaAgendar.getSelecFecha().getCombo_fecha().getSelectedItem();

        for (Veterinario vetAux : daoVet.getListaVet()) {

            boolean fechaDisponible = vetAux.getHorasDisponibles().contains(hora);
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

    public static Cita crearCita() throws FechaIsNull {
        Cita cita;
        String id = ""; //Para actualizar
        Veterinario vet = getVeterinario();
        Cliente cliente = ControladorMenuInicio.getClienteActual();
        String nomMascota = (String) vistaAgendar.getCombo_mascotas().getSelectedItem();
        LocalDateTime fecha = vistaAgendar.getSelecFecha().getFecha().fechaHora;
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();
        cita = new Cita(id, vet, cliente, nomMascota, fecha, tipo);
        daoVet.quitarHoras(fecha, vet);
        logicaVeterinario.setDaoVet(daoVet);
        return cita;

    }

    public static void quitarHoras(Cita cita) {

    }

    public static void revisionSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("General");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgendar.getSelecFecha().popularCombo(horas);

    }

    public static void esterilSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Cirujana");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgendar.getSelecFecha().popularCombo(horas);

    }

    public static void esteticoSelec() {
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Estetica");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgendar.getSelecFecha().popularCombo(horas);
    }

    public static ArrayList<String> getHorasDisp(ArrayList<Veterinario> listVetsAptos) {
        ArrayList<String> horas = new ArrayList<>();
        for (Veterinario vet : listVetsAptos) {
            for (String hora : vet.getHorasDisponibles()) {
                if (!horas.contains(hora)) {
                    horas.add(hora);
                }
            }
        }
        return horas;
    }

    public static void limpiarCombo() {
        int total = vistaAgendar.getSelecFecha().getCombo_fecha().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgendar.getSelecFecha().getCombo_fecha().removeItemAt(0);
        }
    }

}
