package Controlador;

import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Veterinario;
import Repositorio.RepositorioVeterinarios;
import Vista.VistaMenuAdmi;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ControladorMenuAdmi {

    private static RepositorioVeterinarios repoVeterinarios = new RepositorioVeterinarios();
    private static VistaMenuAdmi vistaMenuAdmi = new VistaMenuAdmi();
    private static daoVeterinarios daoVet = new daoVeterinarios();

    static void mostrarVentana() {
        vistaMenuAdmi.setVisible(true);
        cargarDatosVeterinarios();
    }

    public static void eliminarVeterinario(String nom) {
        daoVet.eliminarVet(nom);
        cargarDatosVeterinarios();
    }

    public static void agregarVeterinario(Veterinario nuevoVet) {
        daoVet.addVet(nuevoVet);
        cargarDatosVeterinarios();
    }

    public static void modificarDatos() {

    }

    public static Veterinario evento() {
        String nombre = (String) vistaMenuAdmi.getComboBoxVeterinarios().getSelectedItem();
        return daoVet.getVeterinario(nombre);
    }

    public static void mostraDatos() {
        Veterinario vet = evento();

        vistaMenuAdmi.getTxt_Nombre().setText(vet.getNombre());
        vistaMenuAdmi.getTxt_Apellido().setText(vet.getApellido());
        vistaMenuAdmi.getTxt_Cedula().setText(vet.getCedula());
        vistaMenuAdmi.getTxt_Sueldo().setText(vet.getSueldo() + " ");
        vistaMenuAdmi.getTxt_Telefono().setText(vet.getTelefono());
    }

    public static void cargarDatosVeterinarios() {
        ArrayList<Veterinario> listaVeterinarios = repoVeterinarios.getLista();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Agregar solo los nombres de los veterinarios al combo box
        for (Veterinario veterinario : listaVeterinarios) {
            comboBoxModel.addElement(veterinario.getNombre());
        }

        JComboBox<String> cbxVeterinarios = vistaMenuAdmi.getComboBoxVeterinarios();
        cbxVeterinarios.setModel(comboBoxModel);
    }

    public static void mostrarDatosVeterinarioSeleccionado() {
        JComboBox<String> comboBoxVeterinarios = vistaMenuAdmi.getComboBoxVeterinarios();
        String nombreVeterinarioSeleccionado = (String) comboBoxVeterinarios.getSelectedItem();

        ArrayList<Veterinario> listaVeterinarios = repoVeterinarios.getLista();

    }
}
