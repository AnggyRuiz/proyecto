package Excepciones;


public class CorreoMal extends Exception{
    
    public CorreoMal(){
        super ("Excepcion definida por el usuario: EL CORREO ESTÁ MAL ESCRITO");
    }
}
