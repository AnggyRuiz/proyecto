package Controlador;

import DAO.DaoGenerico;
import Modelo.RespuestaMultiple;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Machado
 */
public class CtlRespuestaMultiple {

    public static String tabla = "respuestaMultiple";
    public static String id = "idRespuesta";

    /**
     * convertir el objeto a un Json.
     *
     * @param respuestaMultiple: objeto de respuestaMultiple
     * @return objeto
     */
    public static String convertirGson(RespuestaMultiple respuestaMultiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(respuestaMultiple);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param respuestaMultiple: objeto RespuestaMultiple
     * @return objeto
     */
    public boolean SolicitudGuardar(RespuestaMultiple respuestaMultiple) {
        DaoGenerico juegoDAO = new DaoGenerico();
        String objeto = convertirGson(respuestaMultiple);
        return juegoDAO.guardar(objeto, tabla);
    }

    /**
     * trae el id de la repuesta multiple.
     *
     * @param ninguno
     * @return idRespuestaMultiple
     */
    public ArrayList solicitarBuscarIdu() {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.buscarIdj(tabla, id);
    }

    /**
     * trae el id de la respuesta.
     *
     * @param idRespuesta: id de la respuesta
     * @return idRespuestaMultiple
     */
    public String solicitudRespuestas(String idRespuesta) {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.verificarRespuesta(tabla, idRespuesta);
    }

}
