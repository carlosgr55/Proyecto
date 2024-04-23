package Repositorio;

import Modelo.VO.Cliente;
import java.util.ArrayList;

public class RepositorioClientes {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public RepositorioClientes() {
        cargarClientes();
    }

    public ArrayList<Cliente> getLista() {
        return this.listaClientes;

    }

    public boolean addCliente(Cliente nuevoCliente) {
        return this.listaClientes.add(nuevoCliente);
    }

    public boolean consulta(Cliente cliente) {
        boolean existe = false;
        for (Cliente aux : listaClientes) {
            if (aux.getUsuario().equalsIgnoreCase(cliente.getUsuario())) {
                existe = true;
            }

        }
        return existe;
    }

    public int index(String user) {
        Cliente cliente = returnCliente(user);
        return listaClientes.indexOf(cliente);
    }

    public void cargarClientes() {
        this.listaClientes.add(new Cliente("Rosalia", "Motomami", "Rosalia", "Vita", "654654654", "kdfljkljdslkj"));
        this.listaClientes.add(new Cliente("Shakira", "FijacionOral", "Shakira", "Vita", "654654654", "kdfljkljdslkj"));
        this.listaClientes.add(new Cliente("LDR", "BLDV", "Lana", "Del Rey", "654654654", "kdfljkljdslkj"));
        this.listaClientes.add(new Cliente("LG", "Chromatica", "Lady", "Gaga", "654654654", "kdfljkljdslkj"));
        this.listaClientes.add(new Cliente("", "", "Prueba", "Borrar", "61654321", "lgjklajflkjg"));
    }

    public void mostrarClientes() {
        for (Cliente cliente : listaClientes) {
         // System.out.println(cliente.toString());
        }
    }

    public boolean consulta(String user) {
        boolean existe = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getUsuario().equals(user)) {
                existe = true;
            }
        }
        return existe;
    }

    public Cliente returnCliente(String user) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getUsuario().equals(user)) {
                return cliente;
            }
        }
        return null;
    }
}
