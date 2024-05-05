/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.daoClientes;
import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import Vista.VistaAgendarRecepcion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gambo
 */
public class ControladorAgendarRecepcion {

    static VistaAgendarRecepcion vistaAgeRec = new VistaAgendarRecepcion();
    static boolean usuarioValido = false;
    static daoClientes clientesdao = ControladorInicioSesion.getDao();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    static daoVeterinarios daoVet = ControladorAgendarCita.getDaoVet();

    public static void mostrarVentana() {
        vistaAgeRec.getBtn_siguiente().setEnabled(false);
        vistaAgeRec.getLb_mensaje().setVisible(false);
        vistaAgeRec.setVisible(true);
    }

    public static void verificarUsuario(String txt) {
        vistaAgeRec.getLb_mensaje().setVisible(true);
        if (!clientesdao.consulta(txt)) {
            vistaAgeRec.getBtn_siguiente().setEnabled(false);
            vistaAgeRec.getLb_mensaje().setText("El cliente no existe");
            limpiarDatos();

        } else {
            Cliente cliente = clientesdao.returnCliente(txt);
            vistaAgeRec.getLb_mensaje().setText("ENCONTRADDE");
            llenarDatos(cliente);
            evento();
            habilitar(true, true, true);
            vistaAgeRec.getBtn_siguiente().setEnabled(true);
        }
    }

    public static void limpiarDatos() {
        try {
            vistaAgeRec.getTxt_nombre().setText("");
            limpiarCombo();
            limpiarMascotas();
            habilitar(false, false, false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("EXCEPCION INDEX OUT OF BOUND");
        }
    }

    public static void limpiarMascotas() throws ArrayIndexOutOfBoundsException {
        int total = vistaAgeRec.getComb_mascotas().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgeRec.getComb_mascotas().removeItemAt(i);
        }
    }

    public static void regresar() {
        ControladorMenuRecepcion.mostrarVentana();
        vistaAgeRec.setVisible(false);
        vistaAgeRec.dispose();
    }

    public static void llenarDatos(Cliente cliente) {
        vistaAgeRec.getTxt_nombre().setText(cliente.getNombre() + " " + cliente.getApellido());
        popularMascotas(cliente);
        habilitar(true, true, true);
    }

    public static void popularMascotas(Cliente cliente) {
        for (Mascota mascota : cliente.getMascotas()) {
            vistaAgeRec.getComb_mascotas().addItem(mascota.getNombre());
        }
    }

    public static void habilitar(boolean mascotas, boolean tipo, boolean fecha) {
        vistaAgeRec.getComb_mascotas().setEnabled(mascotas);
        vistaAgeRec.getComb_tipo().setEnabled(tipo);
        vistaAgeRec.getSelecFecha1().setEnabled(fecha);
    }

    public static void evento() {
        String tipo = (String) vistaAgeRec.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaAgeRec.getComb_estetico().setVisible(true);
                vistaAgeRec.getLb_estetico().setVisible(true);
                esteticoSelec();
                break;
            case "Revision":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Vacunacion":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                revisionSelec();
                break;
            case "Esterelizacion":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                esterilSelec();
                break;
        }

    }

    public static Cita crearCita() {
        Cita cita;
        String id = ""; //Para actualizar
        Veterinario vet = getVeterinario();
        Cliente cliente = clientesdao.returnCliente(vistaAgeRec.getTxt_usuario().getText());
        String nomMascota = (String) vistaAgeRec.getComb_mascotas().getSelectedItem();
        LocalDateTime fecha = vistaAgeRec.getSelecFecha1().getFechaHora();
        String tipo = (String) vistaAgeRec.getComb_tipo().getSelectedItem();
        cita = new Cita(id, vet, cliente, nomMascota, fecha, tipo);
        daoVet.quitarHoras(fecha, vet);
        logicaVeterinario.setDaoVet(daoVet);
        return cita;
    }

    public static Veterinario getVeterinario() {
        Veterinario vet = null;
        String especialidad = getEspecialidad();
        //LocalDateTime hora = LocalDateTime.parse((String) vistaAgendar.getCombo_fechas().getSelectedItem());
        String hora = (String) vistaAgeRec.getSelecFecha1().getCombo_fecha().getSelectedItem();

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
        String tipo = (String) vistaAgeRec.getComb_tipo().getSelectedItem();
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

    public static void revisionSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("General");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgeRec.getSelecFecha1().popularCombo(horas);

    }

    public static void esterilSelec() {
        limpiarCombo();
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Cirujana");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgeRec.getSelecFecha1().popularCombo(horas);

    }

    public static void esteticoSelec() {
        ArrayList<Veterinario> listaVetsAptos = logicaVeterinario.espValida("Estetica");
        ArrayList<String> horas = getHorasDisp(listaVetsAptos);
        vistaAgeRec.getSelecFecha1().popularCombo(horas);
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
        int total = vistaAgeRec.getSelecFecha1().getCombo_fecha().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgeRec.getSelecFecha1().getCombo_fecha().removeItemAt(0);
        }
    }

}
