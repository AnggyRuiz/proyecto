
package Modelo;

/**
 *
 * @author Gabriela Machado
 */
public class Resumen {
    
    int idResumen, idPregunta, idRespuesta, idUsuario;

    public Resumen(int idResumen, int idPregunta, int idRespuesta, int idUsuario) {
        this.idResumen = idResumen;
        this.idPregunta = idPregunta;
        this.idRespuesta = idRespuesta;
        this.idUsuario = idUsuario;
    }

    public Resumen() {
    }

    public int getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(int idResumen) {
        this.idResumen = idResumen;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
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
    
    
}
