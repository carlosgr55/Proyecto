package Controlador;

import Modelo.DAO.daoCitas;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaModificarCita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JTable;

public class ControladorModificarCita {

    static VistaModificarCita vistaMod = new VistaModificarCita();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    static JTable tabla = ControladorVerCitas.getTabla();
    static int fila = tabla.getSelectedRow();
    static String id = (String) tabla.getValueAt(fila, 0);
    static daoCitas Citasdao = ControladorDetalleCita.getDaocitas();
    static Cita cita = Citasdao.getCita(id);
    static int index = Citasdao.getLista().indexOf(cita);

    public static void mostrarVentana() {
        vistaMod.setVisible(true);
        mostrarDatos();
    }

    public static void mostrarDatos() {
        evento();
        vistaMod.getTxt_nomMascota().setText(cita.getNomMascota());
        vistaMod.getComb_tipo().setSelectedItem(cita.getTipo());
        vistaMod.getCombo_fechas().setSelectedItem(cita.getFecha());

    }

    public static void modificar() {
        cita.setNomMascota(vistaMod.getTxt_nomMascota().getText());
        cita.setFecha(LocalDateTime.parse((String) vistaMod.getCombo_fechas().getSelectedItem()));
        cita.setTipo((String) vistaMod.getComb_tipo().getSelectedItem());
        Citasdao.getLista().set(index, cita);
        vistaMod.setVisible(false);
        vistaMod.dispose();
        ControladorVerCitas.mostrarVentana(true);

    }

    public static void evento() {
        String tipo = (String) vistaMod.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaMod.getComb_estetico().setVisible(true);
                vistaMod.getLb_estetico().setVisible(true);
                esteticoSelec();
                break;
            case "Revision":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Vacunacion":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Esterelizacion":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                esterilSelec();
                break;
        }

    }

    public static void revisionSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("General");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaMod.getCombo_fechas().addItem(hora);
        }
        vistaMod.getCombo_fechas().setEnabled(true);

    }

    public static void esterilSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Cirujana");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaMod.getCombo_fechas().addItem(hora);
        }
        vistaMod.getCombo_fechas().setEnabled(true);

    }

    public static void esteticoSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Estetica");
        ArrayList<String> horasDisponibles = logicaVeterinario.getDisponibilidad(listaVetsAptos);
        for (String hora : horasDisponibles) {
            vistaMod.getCombo_fechas().addItem(hora);
        }
        vistaMod.getCombo_fechas().setEnabled(true);

    }

    public static void limpiarCombo() {
        int total = vistaMod.getCombo_fechas().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaMod.getCombo_fechas().removeItemAt(0);
        }
    }
}
