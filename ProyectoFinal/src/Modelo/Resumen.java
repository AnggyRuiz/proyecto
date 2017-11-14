package Modelo;

public class Resumen {

    int idResumen, idPartida, idResultado, idUsuario;

    public Resumen() {
    }

    public Resumen(int idResumen, int idPartida, int idResultado, int idUsuario) {
        this.idResumen = idResumen;
        this.idPartida = idPartida;
        this.idResultado = idResultado;
        this.idUsuario = idUsuario;
    }

    public int getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(int idResumen) {
        this.idResumen = idResumen;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
