package Modelo.DAO;

import Modelo.VO.Recepcion;
import Repositorio.RepositorioRecepcion;
import java.util.ArrayList;

public class daoRecepcion {

    private RepositorioRecepcion repositorio = new RepositorioRecepcion();

    public boolean contains(Recepcion recepcion) {
        return this.repositorio.contains(recepcion);
    }

    public ArrayList<Recepcion> getLista() {
        return repositorio.getLista();
    }

    public void setLista(ArrayList<Recepcion> lista) {
        this.repositorio.setLista(lista);
    }

    public Recepcion returnRecep(String user) {
        return repositorio.returnRecep(user);
    }

    public void add(Recepcion recepcion) {
        this.repositorio.add(recepcion);

    }

    public void delete(Recepcion recepcion) {
        this.repositorio.delete(recepcion);
    }

    public boolean contains(String user) {
        return this.repositorio.contains(user);
    }

}
