package Modelo.VO;

import java.util.ArrayList;

public class Cliente extends Persona {

    private String usuario;
    private String password;
    public Cliente(String usuario, String password, String nombre, String apellido, String telefono, String correo) {
        super(nombre, apellido, telefono, correo);
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

  
    
    public Cliente() {
        super();
        this.usuario = "";
        this.password = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*@Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", password=" + password + '}';
    }*/

    
}
