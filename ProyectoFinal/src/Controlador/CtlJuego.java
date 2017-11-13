/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoGenerico;
import Modelo.Juego;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Machado
 */
public class CtlJuego {

    public static String tabla = "juego";
    public static String id = "idJuego";

    public String convertirGson(Juego juego) {
        Gson gson = new Gson();
        String objeto = gson.toJson(juego);
        return objeto;
    }

    public boolean SolicitudGuardar(int idJuego, int cantidadParticipantes, String fecha_Juego) {

        Juego juego = new Juego(idJuego, cantidadParticipantes, fecha_Juego);
        DaoGenerico juegoDAO = new DaoGenerico();
        String objeto = convertirGson(juego);
        return juegoDAO.guardar(objeto, tabla);
    }
    
    public ArrayList solicitarBuscarIdj(){
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.buscarIdj(tabla, id);
    }
}

        