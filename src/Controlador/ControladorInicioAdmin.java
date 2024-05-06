package Controlador;

import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaAdministrador;
import Modelo.VO.Admin;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaInicioAdministrador;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class ControladorInicioAdmin {

    //static VistaInicioAdministrador vInicioAdmin = new VistaInicioAdministrador();
    static VistaInicioAdministrador vInicioAdmin = new VistaInicioAdministrador();
    static daoVeterinarios daoVet = new daoVeterinarios();
    static LogicaAdministrador logicaAdmin = new LogicaAdministrador();
    static Admin admi = new Admin();

    public static void mostrarVentana() {
        vInicioAdmin.setVisible(true);
    }

    public static void accesar(String user, String password) {
        boolean acceso = logicaAdmin.accesoValido(user, password, admi);
        if (acceso) {
            mensaje("Acceso valido");
            //ControladorMenuAdmi.mostrarVentana();
            ControladorMenuAdmi.mostrarVentana();
            vInicioAdmin.dispose();
        } else {
            mensaje("Contraseña invalida intente de nuevo");

        }
    }

    private static void mensaje(String msg) {
        vInicioAdmin.getLbl_auxiliar().setText(msg);
        vInicioAdmin.getLbl_auxiliar().setVisible(true);
    }

    // Métodos para la gestión de veterinarios por parte del administrador
    public static void agregarVeterinario(Veterinario vet) {
        logicaAdmin.agregarVeterinario(vet);
    }

    public static void eliminarVeterinario(Veterinario vet) {
        logicaAdmin.eliminarVeterinario(vet);
    }

    /*public static void obtenerDisponibilidad(Veterinario vet) {
        ArrayList<LocalDateTime> disponibilidad = new ArrayList<>();
        // Obtener la lista de citas del veterinario
        ArrayList<Cita> citas = ControladorDetalleCita.getDaocitas().getCitasPorVeterinario(vet);
        // Iterar sobre cada cita para obtener las horas ocupadas
        for (Cita cita : citas) {
            disponibilidad.add(cita.getFecha());
        }
        // Obtener las horas disponibles del veterinario restando las horas ocupadas
        ArrayList<LocalDateTime> horasDisponibles = new ArrayList<>(vet.getDisponibilidad());
        horasDisponibles.removeAll(disponibilidad);

        // Actualizar el componente visual con las horas disponibles
        DefaultListModel<String> model = new DefaultListModel<>();
        for (LocalDateTime hora : horasDisponibles) {
            model.addElement(hora.toString());
        }
        // HorasDisponibles

    }*/

}
