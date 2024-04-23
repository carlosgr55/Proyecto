
package Controlador;

import Modelo.DAO.daoClientes;
import Modelo.VO.Cliente;
import Vista.VistaModificarCliente;
import javax.swing.JOptionPane;

public class ControladorModificarCliente {
    
    static VistaModificarCliente vistaModificar = new VistaModificarCliente();
    static daoClientes daoClientes = ControladorMenuInicio.daoCliente;
    static Cliente clienteActual = ControladorMenuInicio.getClienteActual();
    static int index = daoClientes.getLista().indexOf(clienteActual); 
    public static void mostrarVentana(){
      vistaModificar.setVisible(true);
      mostrarDatos();
    }
    
    public static void regresar(){
        vistaModificar.setVisible(false);
        ControladorMenuInicio.mostraVentana();
        vistaModificar.dispose();
    }
    
    public static void mostrarDatos(){
        vistaModificar.getTxt_nombre().setText(clienteActual.getNombre());
        vistaModificar.getTxt_apellido().setText(clienteActual.getApellido());
        vistaModificar.getTxt_correo().setText(clienteActual.getCorreo());
        vistaModificar.getTxt_telefono().setText(clienteActual.getTelefono());
        vistaModificar.getTxt_user().setText(clienteActual.getUsuario());
        vistaModificar.getTxt_password().setText(clienteActual.getPassword());       
    }
    
    public static void actualizarDatos(){
        
        clienteActual.setNombre(vistaModificar.getTxt_nombre().getText());
        clienteActual.setApellido(vistaModificar.getTxt_apellido().getText());
        clienteActual.setCorreo(vistaModificar.getTxt_correo().getText());
        clienteActual.setTelefono(vistaModificar.getTxt_telefono().getText());
        clienteActual.setUsuario(vistaModificar.getTxt_user().getText());
        clienteActual.setPassword(vistaModificar.getTxt_password().getText());
        ControladorMenuInicio.setClienteActual(clienteActual);
        daoClientes.getLista().set(index, clienteActual);
    }
    
    public static void eliminarCuenta(){
        String password = JOptionPane.showInputDialog(null,"Ingresa tu contraseña");
        if(password.equals(clienteActual.getPassword())){
            eliminar();
        }
    }
    private static void eliminar(){
        System.out.println("LISTA ANTES");
        daoClientes.mostrarClientes();
        daoClientes.getLista().remove(index);
        ControladorInicioSesion.setDao(daoClientes);
        ControladorInicioSesion.mostrarVentana();
        vistaModificar.setVisible(false);
        vistaModificar.dispose();
        System.out.println("LISTA DESPUES");
        daoClientes.mostrarClientes();
    }
}
