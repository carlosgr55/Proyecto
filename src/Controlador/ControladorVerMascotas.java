package Controlador;

import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaMascotas;
import java.util.ArrayList;

public class ControladorVerMascotas {

    static VistaMascotas vistaMascota = new VistaMascotas();
    static Cliente clienteActual = ControladorMenuInicio.getClienteActual();
    static ArrayList<Mascota> listaMascota = clienteActual.getMascotas();

    public static void mostrarVentana() {
        vistaMascota.setVisible(true);
        popularCombo();
        evento();
    }

    public static void popularCombo() {
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
