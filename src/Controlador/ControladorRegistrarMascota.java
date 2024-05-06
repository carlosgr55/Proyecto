package Controlador;

import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaRegistrarMascota;
import java.awt.Menu;

public class ControladorRegistrarMascota {

    static VistaRegistrarMascota vistaRegistro;
    static Cliente cliente;
    static boolean esRecepcion = ControladorCrearCuenta.esRecepcion;

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
        if (!esRecepcion) {
            cliente.addMascota(crearMascota());
            vistaRegistro.setVisible(false);
            vistaRegistro.dispose();
            ControladorInicioSesion.mostrarVentana();

        } else {
            cliente.addMascota(crearMascota());
            vistaRegistro.setVisible(false);
            ControladorMenuRecepcion.mostrarVentana();
            vistaRegistro.dispose();
        }

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
