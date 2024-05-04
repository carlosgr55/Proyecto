/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.daoClientes;
import Vista.VistaAgendarCita;
import Vista.VistaAgendarRecepcion;

/**
 *
 * @author gambo
 */
public class ControladorAgendarRecepcion {

    static VistaAgendarRecepcion vistaAgeRec = new VistaAgendarRecepcion();
    static boolean usuarioValido = false;
    static daoClientes clientesdao = ControladorInicioSesion.getDao();

    public static void mostrarVentana() {
        vistaAgeRec.getLb_mensaje().setVisible(false);
        vistaAgeRec.setVisible(true);
      
    }

    public static void verificarUsuario(String txt) {
        if (!clientesdao.consulta(txt)) {
            vistaAgeRec.getLb_mensaje().setText("El cliente no existe");
        } else {
            vistaAgeRec.getLb_mensaje().setText("ENCONTRADDE");
        }

    }

}
