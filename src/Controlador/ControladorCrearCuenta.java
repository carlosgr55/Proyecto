package Controlador;

import Excepciones.ClienteNoExistente;
import Excepciones.DatosIncompletosException;
import Modelo.DAO.daoClientes;
import Modelo.Logica.LogicaCampos;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Vista.VistaCrearCuenta;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static boolean camposLlenos() {
        boolean a = vistaCrear.getTxt_apellido().getText().equals("");
        boolean b = vistaCrear.getTxt_nombre().getText().equals("");
        boolean c = vistaCrear.getTxt_correo().getText().equals("");
        boolean d = vistaCrear.getTxt_usuario().getText().equals("");
        boolean e = vistaCrear.getTxt_password().getText().equals("");
        boolean f = vistaCrear.getTxt_celular().getText().equals("");
        return (a && b && c && d && e && f);

    }

    public static boolean validarNumero() {
        boolean valido = false;
        String numero = vistaCrear.getTxt_celular().getText();
        if (logica.numeroValido(numero)) {
            valido = true;
        }
        return valido;
    }

    public static boolean addCliente(Cliente cliente) {
        boolean creado = false;
        boolean existe;
        try {
            existe = logica.clienteExiste(cliente);
            if (!existe) {
                creado = true;
                dao.addCliente(cliente);
                ControladorInicioSesion.getDao().addCliente(cliente);
            }
        } catch (ClienteNoExistente ex) {
            JOptionPane.showMessageDialog(vistaCrear, "Nombre de usuario existente");
        }
        return creado;
    }

    public static void mostrarClientes() {
        dao.mostrarClientes();
    }
}
