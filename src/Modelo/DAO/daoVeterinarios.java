package Modelo.DAO;

import Modelo.VO.Veterinario;
import Repositorio.RepositorioVeterinarios;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class daoVeterinarios {

    private RepositorioVeterinarios repositorio = new RepositorioVeterinarios();
    private ArrayList<Veterinario> listaVet = repositorio.getLista();

    public ArrayList<Veterinario> getListaVet() {
        return repositorio.getLista();
    }

    
    public void quitarHoras(LocalDateTime hora, Veterinario vet){
        repositorio.quitarHora(hora, vet);
    }
    
    public ArrayList<LocalDateTime> getHorario(Veterinario vet){
        return vet.getDisponibilidad();
    }
    
    public ArrayList<String> getEspecialidad(Veterinario vet){
        return vet.getEspecialidad();
    }
    
    public void setLista(ArrayList<Veterinario> lista){
        repositorio.setLista(lista);
    }
    

}
