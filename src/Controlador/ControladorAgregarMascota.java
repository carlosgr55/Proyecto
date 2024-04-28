package Controlador;

import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaAgregarMascota;
import Vista.VistaRegistrarMascota;

public class ControladorAgregarMascota {

    static VistaAgregarMascota vistaAgregar = new VistaAgregarMascota();
    static Cliente cliente;

    public static void mostrarVentana() {
        vistaAgregar.setVisible(true);
        cliente = ControladorMenuInicio.getClienteActual();
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        ControladorRegistrarMascota.cliente = cliente;
    }
    
    public static void regresar(){
        vistaAgregar.setVisible(false);
        vistaAgregar.dispose();
        ControladorMenuInicio.mostraVentana();
    }

    public static void registrar() {
        cliente.addMascota(crearMascota());
        vistaAgregar.setVisible(false);
        ControladorMenuInicio.mostraVentana();
        vistaAgregar.dispose();
        mostrar();
    }

    private static void mostrar() {
        for (Mascota mascota : cliente.getMascotas()) {
            System.out.println(mascota.toString());

        }
    }

    public static Mascota crearMascota() {
        String nombre = vistaAgregar.getTxt_nombre().getText();
        char sexo = getSexo();
        String especie = getEspecie();
        Mascota mascota = new Mascota(nombre, especie, sexo);
        return mascota;

    }

    public static String getEspecie() {
        return (String) vistaAgregar.getCombo_especie().getSelectedItem();
    }

    private static char getSexo() {
        if (vistaAgregar.getRb_macho().isSelected()) {
            return 'M';
        } else {
            return 'H';
        }
    }
}
