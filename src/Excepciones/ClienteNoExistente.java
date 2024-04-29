
package Excepciones;

public class ClienteNoExistente extends Exception {
    
    public ClienteNoExistente(){
        super();
    }
    public ClienteNoExistente(String msg){
        super(msg);
    }
    
}
