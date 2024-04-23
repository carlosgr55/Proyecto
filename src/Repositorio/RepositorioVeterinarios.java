package Repositorio;

import Modelo.VO.Veterinario;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class RepositorioVeterinarios {

    private ArrayList<Veterinario> lista = new ArrayList<>();

    public RepositorioVeterinarios() {
        this.cargarDatos();

        //Disponibilidad veterinario uno
        this.addHora(0, LocalDateTime.parse("2024-04-10T10:00:00"));
        this.addHora(0, LocalDateTime.parse("2024-04-10T11:00:00"));
        this.addHora(0, LocalDateTime.parse("2024-04-10T13:30:00"));
        //Disponibilidad veterinario dos
        this.addHora(1, LocalDateTime.parse("2024-04-10T10:00:00"));
        this.addHora(1, LocalDateTime.parse("2024-04-10T11:00:00"));
        this.addHora(1, LocalDateTime.parse("2024-04-10T13:30:00"));
        //Disponibilidad veterinario tres
        this.addHora(2, LocalDateTime.parse("2024-04-10T10:00:00"));
        this.addHora(2, LocalDateTime.parse("2024-04-10T11:00:00"));
        this.addHora(2, LocalDateTime.parse("2024-04-11T11:30:00"));
        //Disponibilidad veterinario cuatro
        this.addHora(3, LocalDateTime.parse("2024-04-10T10:00:00"));
        this.addHora(3, LocalDateTime.parse("2024-04-11T11:00:00"));
        this.addHora(3, LocalDateTime.parse("2024-04-12T13:30:00"));

        //Especialidades veterinario uno
        this.addEspecialidad(0, "Estetica");
        //Especialidades veterinario dos
        this.addEspecialidad(1, "General");
        this.addEspecialidad(1, "Estetica");
        //Especialidades veterinario tres
        this.addEspecialidad(2, "General");
        //Especialidades veterinario cuatro
        this.addEspecialidad(3, "Cirujana");

    }

    public void cargarDatos() {
        lista.add(new Veterinario("CEDULA1", 34880, "BEYONCE", "RENAISSANCE", "Beyonce", "Knowles-Carter", "65654654", "564654"));
        lista.add(new Veterinario("CEDULA2", 34880, "PhoebeBridgers", "ScottStreet", "Phoebe", "Bridgers", "65654654", "564654"));
        lista.add(new Veterinario("CEDULA3", 34880, "Kali", "Orquideas", "Kali", "Uchis", "65654654", "564654"));
        lista.add(new Veterinario("CEDULA4", 34880, "Arca", "kick", "Arca", "", "65654654", "564654"));
    }

    public ArrayList<Veterinario> getLista() {
        return this.lista;
    }

    public Veterinario crearVet() {
        //POR EDITAR
        return null;
    }

    public void setLista(ArrayList<Veterinario> lista) {
        this.lista = lista;
    }

        
    public void addHora(int index, LocalDateTime hora) {
        lista.get(index).addHora(hora);
    }
    
    public void quitarHora(LocalDateTime hora, Veterinario vet){
       
      lista.get(lista.indexOf(vet)).quitarHora(hora);
        
    }

    public void addEspecialidad(int index, String especialidad) {
        lista.get(index).addEspecialidad(especialidad);
    }

    public boolean existe(Veterinario vet) {
        boolean existe = false;
        String user = vet.getUsuario();
        for (Veterinario veterinario : lista) {
            if (veterinario.getUsuario().equals(user)) {
                existe = true;
            }
        }

        return existe;
    }

    public int getIndice(Veterinario vet) {
       return lista.indexOf(vet);
    }

    public ArrayList<String> getEspecialidades(Veterinario vet) {
        int index = getIndice(vet);
        return lista.get(index).getEspecialidad();
    }
    

}
