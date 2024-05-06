package Modelo.Logica;

import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Admin;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogicaAdministrador {
    
    private daoVeterinarios daoVet = new daoVeterinarios();

    public daoVeterinarios getDaoVet() {
        return daoVet;
    }

    public void setDaoVet(daoVeterinarios daoVet) {
        this.daoVet = daoVet;
    }
    
    public void agregarVeterinario(Veterinario vet) {
        daoVet.getListaVet().add(vet);
    }
    
    public void eliminarVeterinario(Veterinario vet) {
        daoVet.getListaVet().remove(vet);
    }
  
     public boolean accesoValido(String user, String password, Admin admin) {
        boolean valido = false;
        String registroUsuario = admin.getUsuario();
        String registroPassword = admin.getPassword();
        boolean acceso = registroUsuario.equals(user) && registroPassword.equals(password);
        if (acceso) {
            valido = true;
        }
        return valido;
    }
    public ArrayList<LocalDateTime> obtenerDisponibilidad(Veterinario vet) {
        return daoVet.getHorario(vet);
    }

    public ArrayList<String> obtenerEspecialidades(Veterinario vet) {
        return daoVet.getEspecialidad(vet);
    }

    public ArrayList<Veterinario> obtenerTodosVeterinarios() {
        return daoVet.getListaVet();
    }
}

