package Repositorio;

import Modelo.VO.Recepcion;
import java.util.ArrayList;

public class RepositorioRecepcion {

    private ArrayList<Recepcion> lista = new ArrayList<>();

    public RepositorioRecepcion() {
        cargarDatos();
    }

    public void add(Recepcion recepcion) {
        this.lista.add(recepcion);

    }

    public void delete(Recepcion recepcion) {
        this.lista.remove(recepcion);
    }

    public void cargarDatos() {
        lista.add(new Recepcion("Amy", "BackToBlack", 2500, "Amy", "Winehouse", "614231654", "fjdakljfl"));
        lista.add(new Recepcion("Madonna", "Madonna", 5000, "Madonna", "", "61654564", "fdjslkj"));
        lista.add(new Recepcion("Villano", "Antillano", 1654654, "La Villana", "Antillano", "654654", "flkdj"));
    }

    public Recepcion returnRecep(String user) {
        Recepcion recep = null;
        for (Recepcion recepcion : lista) {
            if (recepcion.getUser().equals(user)) {
                recep = recepcion;
            }
        }
        return recep;
    }

    public boolean contains(Recepcion recepcion) {
        return this.lista.contains(recepcion);
    }

    public boolean contains(String user) {
        boolean existe = false;
        for (Recepcion recepcion : lista) {
            if (recepcion.getUser().equals(user)) {
                existe = true;
            }
        }
        return existe;
    }

    public ArrayList<Recepcion> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Recepcion> lista) {
        this.lista = lista;
    }

}
