package Controlador;

import Modelo.DAO.daoClientes;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Vista.VistaCrearCuenta;
import javax.swing.JOptionPane;

public class ControladorCrearCuenta {

    static VistaCrearCuenta vistaCrear = new VistaCrearCuenta();
    static daoClientes dao = new daoClientes();
    static LogicaClientes logica = new LogicaClientes();

    public static void mostrarVentana() {
        vistaCrear.setVisible(true);
    }

    public static void regresar() {
        vistaCrear.setVisible(false);
        ControladorInicioSesion.mostrarVentana();
    }

    public static Cliente crearCliente() {
        String nombre = vistaCrear.getTxt_nombre().getText();
        String apellido = vistaCrear.getTxt_apellido().getText();
        String correo = vistaCrear.getTxt_correo().getText();
        String celular = vistaCrear.getTxt_celular().getText();
        String usuario = vistaCrear.getTxt_usuario().getText();
        String password = vistaCrear.getTxt_password().getText();

        Cliente cliente = new Cliente(usuario, password, nombre, apellido, celular, correo);
        return cliente;
    }

    public static boolean validarNumero(){
        boolean valido = false;
        String numero = vistaCrear.getTxt_celular().getText();
        if(logica.numeroValido(numero))
            valido = true;
        return valido;
    }

    public static boolean addCliente(Cliente cliente) {
        boolean creado = false;
        boolean existe = logica.clienteExiste(cliente);
        if (!existe) {
            creado = true;
            dao.addCliente(cliente);
            ControladorInicioSesion.getDao().addCliente(cliente);
        }
        return creado;
    }

    public static void mostrarClientes() {
        dao.mostrarClientes();
    }
}
