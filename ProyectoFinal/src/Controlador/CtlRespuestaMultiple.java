
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

    public static String convertirGson(RespuestaMultiple respuestaMultiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(respuestaMultiple);
        return objeto;
    }

    public boolean SolicitudGuardar(RespuestaMultiple respuestaMultiple) {
        DaoGenerico juegoDAO = new DaoGenerico();
        String objeto = convertirGson(respuestaMultiple);
        return juegoDAO.guardar(objeto, tabla);
    }

    public ArrayList solicitarBuscarIdu() {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.buscarIdj(tabla, id);
    }
    
}
