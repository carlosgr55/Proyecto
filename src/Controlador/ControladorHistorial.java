package Controlador;

import Vista.VistaHistorialMedico;

public class ControladorHistorial {

    static VistaHistorialMedico vistaHistorial = new VistaHistorialMedico();

    public static void mostrarVentana() {
        vistaHistorial.setVisible(true);
    }
    
    public static void regresar(){
        vistaHistorial.setVisible(false);
        ControladorMenuInicio.mostraVentana();
    }
}
