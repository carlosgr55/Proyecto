package Controlador;

import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaRegistrarMascota;

public class ControladorRegistrarMascota {

    static VistaRegistrarMascota vistaRegistro;
    static Cliente cliente;

    public static void mostrarVentana() {
        vistaRegistro = new VistaRegistrarMascota();
        vistaRegistro.setVisible(true);
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        ControladorRegistrarMascota.cliente = cliente;
    }

    public static void registrar() {
        cliente.addMascota(crearMascota());
        vistaRegistro.setVisible(false);
        ControladorInicioSesion.mostrarVentana();
        vistaRegistro.dispose();
    }

    public static Mascota crearMascota() {
        String nombre = vistaRegistro.getTxt_nombre().getText();
        char sexo = getSexo();
        String especie = getEspecie();
        Mascota mascota = new Mascota(nombre, especie, sexo);
        return mascota;

    }

    public static String getEspecie() {
        return (String) vistaRegistro.getCombo_especie().getSelectedItem();
    }

    private static char getSexo() {
        if (vistaRegistro.getRb_macho().isSelected()) {
            return 'M';
        } else {
            return 'H';
        }
    }

}
