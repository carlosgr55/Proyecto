package Controlador;

import Modelo.Logica.LogicaVeterinario;
import Repositorio.RepositorioClientes;

public class app {

    public static void main(String[] args) {
        ControladorInicioSesion.mostrarVentana();
        ControladorMenuRecepcion.mostrarVentana();
        //ControladorVeterinarios.mostrarVentana(true);
    }
}
