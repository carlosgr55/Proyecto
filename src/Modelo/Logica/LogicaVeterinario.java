package Modelo.Logica;

import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Veterinario;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogicaVeterinario {

    daoVeterinarios daoVet = new daoVeterinarios();

    public daoVeterinarios getDaoVet() {
        return daoVet;
    }

    public void setDaoVet(daoVeterinarios daoVet) {
        this.daoVet = daoVet;
    }

    public ArrayList<String> getDisponibilidad(ArrayList<Veterinario> lista) {
        ArrayList<String> horas = new ArrayList<>();
        for (Veterinario veterinario : lista) {
            for (LocalDateTime fecha : veterinario.getDisponibilidad()) {
                String fechaString = fecha.toString();
                horas.add(fechaString);
            }
        }
        return horas;
    }

    public ArrayList<Veterinario> espValida(String especialidad) {
        ArrayList<Veterinario> especiales = new ArrayList<>();
        int i = 0;
        for (Veterinario vet : daoVet.getListaVet()) {
            for (String esp : vet.getEspecialidad()) {
                if (esp.equals(especialidad)) {
                    especiales.add(vet);
                }
            }
        }
        return especiales;
    }

}
