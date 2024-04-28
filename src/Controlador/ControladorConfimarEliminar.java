package Controlador;

import Modelo.VO.Mascota;
import Vista.VistaConfirmarEliminar;
import java.awt.Dialog;

public class ControladorConfimarEliminar {
    static VistaConfirmarEliminar vistaConfirmar;
    public static boolean confirmacion;
    private static Mascota mascota;
    
    public static void mostrarVentana(Dialog parent, boolean modal, Mascota mascot){
        vistaConfirmar = new VistaConfirmarEliminar(parent, modal);
        vistaConfirmar.setVisible(true);
        mascota = mascot;
        vistaConfirmar.getLb_datos().setText(mascota.toString());
    }
    
    public static void confirmar(boolean confirmar){
        confirmacion = confirmar;
        vistaConfirmar.setVisible(false);
        vistaConfirmar.dispose();
    }
    
    public static void llenarLbl(Mascota pet){
        vistaConfirmar.getLb_datos().setText(pet.getNombre());
    }
}
