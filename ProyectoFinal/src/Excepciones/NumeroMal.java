package Excepciones;

import javax.swing.JOptionPane;


public class NumeroMal extends Exception{
    
    public NumeroMal() {
        JOptionPane.showMessageDialog(null, "Excepción definida por el usuario: NÚMERO INCORRECTO.");
    }
}
