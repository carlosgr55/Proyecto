package Modelo.DAO;

import Modelo.VO.Cita;
import Repositorio.RepositorioCitas;
import java.util.ArrayList;

public class daoCitas {

    private RepositorioCitas repositorio = new RepositorioCitas();

    public void addCita(Cita cita) {
        repositorio.getLista().add(cita);
    }

    public void mostrarCitas() {
        repositorio.mostrarCitas();
    }

    public void addId(Cita cita) {
        repositorio.addId(cita);
    }

    public ArrayList<Cita> getLista() {
        return repositorio.getLista();

    }
    public Cita getCita(String id){
        return repositorio.getCita(id);
    }

    public void setLista(ArrayList<Cita> lista){
        repositorio.setLista(lista);
    }

    
}
