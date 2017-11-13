package Modelo;

/**
 *
 * @author Gabriela Machado
 */
public class Juego {

    int idJuego;
    int cantidadParticipantes;
    String fecha_Juego;

    public Juego() {
    }

    public Juego(int idJuego, int cantidadParticipantes, String fecha_Juego) {
        this.idJuego = idJuego;
        this.cantidadParticipantes = cantidadParticipantes;
        this.fecha_Juego = fecha_Juego;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public String getFecha_Juego() {
        return fecha_Juego;
    }

    public void setFecha_Juego(String fecha_Juego) {
        this.fecha_Juego = fecha_Juego;
    }

}
