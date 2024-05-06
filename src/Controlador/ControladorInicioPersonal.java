/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.UserNotFound;
import Modelo.DAO.daoRecepcion;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Admin;
import Modelo.VO.Recepcion;
import Modelo.VO.Veterinario;
import Vista.VistaInicioPersonal;
import java.awt.Color;

/**
 *
 * @author gambo
 */
public class ControladorInicioPersonal {

    static VistaInicioPersonal vistaPersonal = new VistaInicioPersonal();
    static daoVeterinarios daoVet = new daoVeterinarios();
    static daoRecepcion daoRecep = new daoRecepcion();
    static Admin admin = new Admin();

    public static boolean esRecepcion = false;
    public static boolean esAdmin = false;
    public static boolean esVet = false;

    public static void mostrarVentana() {
        vistaPersonal = new VistaInicioPersonal();
        vistaPersonal.setVisible(true);
    }

    public static void detectarUsuario(String password) throws UserNotFound {
        String user = vistaPersonal.getTxt_user().getText();
        vistaPersonal.getTxt_mensaje().setVisible(false);
        if (user.equals(admin.getUsuario())) {
            esAdmin = true;
            accesoAdmin(user, password);
        } else if (daoRecep.contains(user)) {
            esRecepcion = true;
            Recepcion recep = daoRecep.returnRecep(user);
            accesoRec(user, password, recep);
        } else if (daoVet.contains(user)) {
            esVet = true;
            Veterinario veterinario = daoVet.returnVet(user);
            accesoVet(user, password, veterinario);
        } else {
            throw new UserNotFound("Usuario no existe");
        }
    }

    public static void accesoVet(String user, String pass, Veterinario vet) {
        boolean valido = user.equals(vet.getUsuario()) && vet.getPassword().equals(pass);
        if (valido) {
            ControladorMenuVet.mostrarVentana(true);
        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void accesoRec(String user, String pass, Recepcion recep) {
        boolean valido = user.equals(recep.getUser()) && recep.getPassword().equals(pass);
        if (valido) {
            ControladorMenuRecepcion.mostrarVentana();
        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void accesoAdmin(String user, String pass) {
        boolean valido = user.equals(admin.getUsuario()) && admin.getPassword().equals(pass);
        if (valido) {
            ControladorMenuAdmi.mostrarVentana();
        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void salir() {
        System.exit(0);
    }

    public static void mensaje(String msg) {
        vistaPersonal.getTxt_mensaje().setVisible(true);
        vistaPersonal.getTxt_mensaje().setForeground(Color.red);
        vistaPersonal.getTxt_mensaje().setText(msg);
    }

}
