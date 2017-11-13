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
public class RespuestaUnica {
    int idRespuesta, idUsuario, idPregunta, idJuego;
    String respuesta, correcta;

    public RespuestaUnica(int idRespuesta, int idUsuario, int idPregunta, int idJuego, String respuesta, String correcta) {
        this.idRespuesta = idRespuesta;
        this.idUsuario = idUsuario;
        this.idPregunta = idPregunta;
        this.idJuego = idJuego;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
    
    
    
}
