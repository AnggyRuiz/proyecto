package Controlador;

import DAO.DaoGenerico;
import Modelo.Resultado;
import com.google.gson.Gson;

/**
 *
 * @author Gabriela Machado
 */
public class CtlResultado {

    public static String tabla = "resultado";
    public static String cbID = "idResultado";
    public static String cb = "idJuego";

    public static String convertirGson(Resultado resultado) {
        Gson gson = new Gson();
        String objeto = gson.toJson(resultado);
        return objeto;
    }

    public static boolean solicitudGuardarR(Resultado resultado) {

        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(resultado);
        return preguntaMDAO.guardar(objeto, tabla);
    }

    public static String buscaValor(int nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.buscarCombo1(tabla, cb, cbID, nombre);
    }

}
