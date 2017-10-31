
package Modelo;

/**
 *
 * @author Gabriela Machado
 */
public class Juego {
    
    int idJuego, resumen;
    String cantidadParticipantes; 

    public Juego(int idJuego, int resumen, String cantidadParticipantes) {
        this.idJuego = idJuego;
        this.resumen = resumen;
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public Juego() {
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getResumen() {
        return resumen;
    }

    public void setResumen(int resumen) {
        this.resumen = resumen;
    }

    public String getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(String cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }
    
    
}
