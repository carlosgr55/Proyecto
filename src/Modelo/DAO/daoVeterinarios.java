package Modelo.DAO;

import Modelo.VO.Veterinario;
import Repositorio.RepositorioVeterinarios;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class daoVeterinarios {

    private RepositorioVeterinarios repositorio = new RepositorioVeterinarios();
    private ArrayList<Veterinario> listaVet = repositorio.getLista();

    
    public Veterinario returnVet(String user){
        return this.repositorio.returnVet(user);
    }
    
    public ArrayList<Veterinario> getListaVet() {
        return repositorio.getLista();
    }

    public void addVet(Veterinario nuevoVet) {
        repositorio.getLista().add(nuevoVet);
    }

    public void quitarHoras(LocalDateTime hora, Veterinario vet) {
        repositorio.quitarHora(hora, vet);
    }

    public ArrayList<LocalDateTime> getHorario(Veterinario vet) {
        return vet.getDisponibilidad();
    }

    public ArrayList<String> getEspecialidad(Veterinario vet) {
        return vet.getEspecialidad();
    }

    public void setLista(ArrayList<Veterinario> lista) {
        repositorio.setLista(lista);
    }

    public void eliminarVet(String user) {
        repositorio.eliminarVet(user);
    }

    public Veterinario getVeterinario(String name){
        Veterinario veterinario = null;
        for(Veterinario vet : repositorio.getLista()){
            if(vet.getUsuario().equals(name)){
                veterinario = vet;
            }
        }
        return null;
    }
    
    public boolean contains(String user){
        return this.repositorio.contains(user);
    }
    
}
