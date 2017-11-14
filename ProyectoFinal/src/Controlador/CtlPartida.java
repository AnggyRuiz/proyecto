package Controlador;

import DAO.DaoGenerico;
import Modelo.Partida;
import com.google.gson.Gson;

/**
 *
 * @author Gabriela Machado
 */
public class CtlPartida {

    public static String tabla = "partida";
    public static String cbID = "idPartida";

    public static String convertirGson(Partida partida) {
        Gson gson = new Gson();
        String objeto = gson.toJson(partida);
        return objeto;
    }

    public static boolean solicitudGuardar(Partida partida) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(partida);
        return preguntaMDAO.guardar(objeto, tabla);
    }

}
