package Repositorio;

import Modelo.VO.Cita;
import java.util.ArrayList;

public class RepositorioCitas {

    private ArrayList<Cita> lista = new ArrayList<>();

    public void addCita(Cita cita) {
        lista.add(cita);
        addId(cita);
    }

    public ArrayList<Cita> getLista() {
        return lista;
    }

    public Cita getCita(String id) {
        Cita cita = null;
        for (Cita citas : lista) {
            if (citas.getId().equals(id)) {
                cita = citas;
            }
        }
        return cita;
    }

    public void setLista(ArrayList<Cita> lista) {
        this.lista = lista;
    }

    public void addId(Cita cita) {
        int index = lista.indexOf(cita);
        cita.crearId(index);
    }

    public void mostrarCitas() {
        for (Cita cita : lista) {
            System.out.println(cita.toString());

        }
    }

}
