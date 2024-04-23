package Modelo.DAO;

import Modelo.VO.Cliente;
import Repositorio.RepositorioClientes;
import java.util.ArrayList;

public class daoClientes {

    private RepositorioClientes repositorio = new RepositorioClientes();

    public int indice(String user) {
        return repositorio.index(user);
    }

    public ArrayList<Cliente> getLista() {
        return repositorio.getLista();
    }

    public boolean addCliente(Cliente nuevo) {
        return repositorio.addCliente(nuevo);
    }

    public boolean consulta(Cliente cliente) {
        return repositorio.consulta(cliente);
    }

    public void mostrarClientes() {
        repositorio.mostrarClientes();
    }

    public boolean consulta(String user) {
        return repositorio.consulta(user);
    }

    public Cliente returnCliente(String user) {
        return repositorio.returnCliente(user);
    }

}
