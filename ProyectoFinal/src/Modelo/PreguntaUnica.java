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
public class PreguntaUnica {
    
    String opcion1, opcion2, opcion3, opcion4, opcionCorrecta, enunciado;
    int Tema_idTema;

    public PreguntaUnica(String opcion1, String opcion2, String opcion3, String opcion4, String opcionCorrecta, String enunciado, int Tema_idTema) {
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcionCorrecta = opcionCorrecta;
        this.enunciado = enunciado;
        this.Tema_idTema = Tema_idTema;
    }

    public PreguntaUnica() {
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

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTema_idTema() {
        return Tema_idTema;
    }

    public void setTema_idTema(int Tema_idTema) {
        this.Tema_idTema = Tema_idTema;
    }
    
}
