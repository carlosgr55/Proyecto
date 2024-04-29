package Controlador;

import Modelo.DAO.daoClientes;
import Modelo.VO.Cliente;
import Vista.VistaMenuInicio;
import javax.swing.JOptionPane;

public class ControladorMenuInicio {

    static VistaMenuInicio menu = new VistaMenuInicio();
    static int index;
    static daoClientes daoCliente = ControladorInicioSesion.getDao();
    private static Cliente clienteActual;

    public ControladorMenuInicio(String username) {
        index = daoCliente.indice(username);
    }

    public static void cerrar() {
        ControladorInicioSesion.mostrarVentana();
        menu.dispose();
        clienteActual = null;
    }

    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }

    public static void mostraVentana() {
        menu.setVisible(true);
        menu.getLbl_mensaje().setText("Hola, " + clienteActual.getNombre());
    }

    public static void salir() {
        System.exit(0);
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void agendarCita() {
        if (!clienteActual.getMascotas().isEmpty()) {
            ControladorAgendarCita.mostrarVentanda();
        } else {
            JOptionPane.showMessageDialog(menu, "No hay mascotas registradas");
        }
    }

    public static void setVisible(boolean estado) {
        menu.setVisible(estado);
    }

    public static void verCitas() {
        menu.setVisible(false);
        ControladorVerCitas.mostrarVentana(true);
    }

}
