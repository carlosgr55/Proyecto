package Modelo.VO;

public class Mascota {

    private String nombre;
    private String especie; //Solo puede ser: PERRO, GATO, AVE, PEZ, ROEDOR
    private char sexo;

    public Mascota(String nombre, String especie, char sexo) {
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    

    @Override
    public String toString() {
        return nombre;
    }

    

}
