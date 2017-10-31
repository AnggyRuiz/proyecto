/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gabriela Machado
 */
public class PreguntaMultiple {
    
    String opcion1, opcion2, opcion3, opcion4, opcionesCorrectas, enunciado;
    int tema_idTema;

    public PreguntaMultiple(String opcion1, String opcion2, String opcion3, String opcion4, String opcionesCorrectas, String enunciado, int tema_idTema) {
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcionesCorrectas = opcionesCorrectas;
        this.enunciado = enunciado;
        this.tema_idTema = tema_idTema;
    }

    public PreguntaMultiple() {
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public void setOpcionesCorrectas(String opcionesCorrectas) {
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTema_idTema() {
        return tema_idTema;
    }

    public void setTema_idTema(int tema_idTema) {
        this.tema_idTema = tema_idTema;
    }

    
    
}
