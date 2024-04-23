package Repositorio;

import Modelo.VO.Diagnostico;
import java.util.ArrayList;

public class RepositorioDiagnosticos {

    private ArrayList<Diagnostico> listaDiagnosticos = new ArrayList<>();

    public void addDiagnostico(Diagnostico diagnostico) {
        this.listaDiagnosticos.add(diagnostico);
    }

    public int existe(Diagnostico diagnostico) {
        return this.listaDiagnosticos.indexOf(diagnostico);
    }

    public ArrayList<Diagnostico> getListaDiagnosticos() {
        return listaDiagnosticos;
    }

    public void setListaDiagnosticos(ArrayList<Diagnostico> listaDiagnosticos) {
        this.listaDiagnosticos = listaDiagnosticos;
    }

}
