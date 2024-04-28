package Controlador;

import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaAgendarCita;
import Vista.VistaMascotas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorVerMascotas {

    static VistaMascotas vistaMascota;
    static Cliente clienteActual;
    static ArrayList<Mascota> listaMascota;

    public static void mostrarVentana() {
        vistaMascota = new VistaMascotas();
        vistaMascota.setVisible(true);
        clienteActual = ControladorMenuInicio.getClienteActual();
        listaMascota = clienteActual.getMascotas();
        if (!listaVacia(listaMascota)) {
            popularCombo();
            evento();
        } else {
            ControladorMenuInicio.mostraVentana();
            JOptionPane.showMessageDialog(null, "No hay mascotas que mostrar");
            vistaMascota.setVisible(false);
            vistaMascota.dispose();
        }
    }

    public static void eliminar() {
        Mascota mascota = getMascota((String) vistaMascota.getCombo_mascotas().getSelectedItem());
        ControladorConfimarEliminar.mostrarVentana(vistaMascota, true, mascota);
        boolean confirmo = ControladorConfimarEliminar.confirmacion;
        if (confirmo) {
            borrarMascota(mascota);
            vistaMascota.setVisible(false);
            vistaMascota.dispose();
            mostrarVentana();
        } else {

        }
    }

    public static boolean listaVacia(ArrayList<Mascota> mascota) {
        return mascota.isEmpty();
    }

    private static void borrarMascota(Mascota mascota) {
        clienteActual.getMascotas().remove(mascota);
        listaMascota.remove(mascota);
    }

    public static void popularCombo() {
        int i = 0;
        for (Mascota mascota : listaMascota) {
            String nombre = mascota.getNombre();
            vistaMascota.getCombo_mascotas().addItem(nombre);
        }
    }

    public static void evento() {
        String nombre = (String) vistaMascota.getCombo_mascotas().getSelectedItem();
        Mascota mascota = getMascota(nombre);
        llenarCampos(mascota);
    }

    public static void modificar() {
        habilitarBotones(false, false, true, false);
        habilitarCampos(true);
    }

    public static void guardar() {
        String nombre = (String) vistaMascota.getCombo_mascotas().getSelectedItem();
        int index = listaMascota.indexOf(getMascota(nombre));

        String nuevoNombre = vistaMascota.getTxt_nombre().getText();
        String nuevaEspecie = (String) vistaMascota.getCombo_especie().getSelectedItem();
        char sexo;
        if (vistaMascota.getRb_macho().isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'H';
        }
        Mascota nuevaMascota = new Mascota(nuevoNombre, nuevaEspecie, sexo);
        listaMascota.set(index, nuevaMascota);
        clienteActual.setMascotas(listaMascota);

        vistaMascota.dispose();
        mostrarVentana();
        habilitarBotones(true, true, false, true);
        habilitarCampos(false);
    }

    private static void limpiarCombo() {
        int total = vistaMascota.getComponentCount();
        for (int i = 0; i < total; i++) {
            vistaMascota.getCombo_mascotas().remove(i);
        }
    }

    private static void habilitarCampos(boolean campos) {
        vistaMascota.getTxt_nombre().setEnabled(campos);
        vistaMascota.getCombo_especie().setEnabled(campos);
        vistaMascota.getRb_hembra().setEnabled(true);
        vistaMascota.getRb_macho().setEnabled(true);

    }

    private static void habilitarBotones(boolean eliminar, boolean modificar, boolean guardar, boolean selector) {
        vistaMascota.getBtn_eliminar().setEnabled(eliminar);
        vistaMascota.getBtn_modificar().setEnabled(modificar);
        vistaMascota.getBtn_guardar().setEnabled(guardar);
        vistaMascota.getCombo_mascotas().setEnabled(selector);
    }

    public static void llenarCampos(Mascota mascota) {
        String nombre = mascota.getNombre();
        String especie = mascota.getEspecie();
        char sexo = mascota.getSexo();

        vistaMascota.getTxt_nombre().setText(nombre);
        vistaMascota.getCombo_especie().setSelectedItem(especie);
        if (sexo == 'M') {
            vistaMascota.getRb_macho().setSelected(true);
        } else {
            vistaMascota.getRb_hembra().setSelected(true);
        }

    }

    public static Mascota getMascota(String nombre) {
        Mascota pet = null;
        for (Mascota mascota : listaMascota) {
            if (mascota.getNombre().equals(nombre)) {
                pet = mascota;
            }
        }
        return pet;
    }

}
