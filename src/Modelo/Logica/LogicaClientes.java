package Modelo.Logica;

import Excepciones.ClienteNoExistente;
import Modelo.DAO.daoClientes;
import Modelo.VO.Cliente;
import java.util.ArrayList;

public class LogicaClientes {

    private daoClientes dao = new daoClientes();

    public boolean clienteExiste(Cliente cliente) throws ClienteNoExistente {
        if (dao.getLista().contains(cliente)) {
            return dao.consulta(cliente);
        } else {
            throw new ClienteNoExistente();
        }
    }

    public boolean accesoValido(String user, String password, Cliente cliente) {
        boolean valido = false;
        String registroUsuario = cliente.getUsuario();
        String registroPassword = cliente.getPassword();
        boolean acceso = registroUsuario.equals(user) && registroPassword.equals(password);
        if (acceso) {
            valido = true;
        }
        return valido;

    }

    public boolean numeroValido(String numero) {
        boolean valido = false;
        char[] caracteres = numero.toCharArray();
        int numCaracteres = caracteres.length;
        boolean numerico = esNumerico(numero);

        if (numCaracteres == 10 && numerico) {
            valido = true;
        }
        return valido;
    }

    public static boolean esNumerico(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
