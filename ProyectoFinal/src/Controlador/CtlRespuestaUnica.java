/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoGenerico;
import Modelo.RespuestaUnica;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Machado
 */
public class CtlRespuestaUnica {

    public static String tabla = "respuestaUnica";
    public static String id = "idRespuesta";

    public static String convertirGson(RespuestaUnica respuestaUnica) {
        Gson gson = new Gson();
        String objeto = gson.toJson(respuestaUnica);
        return objeto;
    }

    public boolean SolicitudGuardar(RespuestaUnica respuestaUnica) {
        DaoGenerico juegoDAO = new DaoGenerico();
        String objeto = convertirGson(respuestaUnica);
        return juegoDAO.guardar(objeto, tabla);
    }

    public ArrayList solicitarBuscarIdu() {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.buscarIdj(tabla, id);
    }

    public String solicitudRespuestas(String i) {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.verificarRespuesta(tabla, i);
    }

}
