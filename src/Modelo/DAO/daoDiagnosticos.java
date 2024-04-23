package Modelo.DAO;

import Modelo.VO.Diagnostico;
import Repositorio.RepositorioDiagnosticos;
import java.util.ArrayList;

public class daoDiagnosticos {

    private RepositorioDiagnosticos lista = new RepositorioDiagnosticos();
    
    
    public void addDiagnostico(Diagnostico diagnostico){
        lista.addDiagnostico(diagnostico);
    }
    
    public int existe(Diagnostico diagnostico){
       return lista.existe(diagnostico);
    }

    public ArrayList<Diagnostico> getLista() {
        return lista.getListaDiagnosticos();
    }

    public void setLista(ArrayList<Diagnostico> lista) {
        this.lista.setListaDiagnosticos(lista);
    }
    
    
    

}
