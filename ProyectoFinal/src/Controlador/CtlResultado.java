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

    /**
     * convertir el objeto a un Json.
     *
     * @param resultado: objeto de Resultado
     * @return objeto
     */
    public static String convertirGson(Resultado resultado) {
        Gson gson = new Gson();
        String objeto = gson.toJson(resultado);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param resultadfo : objeto Resultado
     * @return objeto
     */
    public static boolean solicitudGuardarR(Resultado resultado) {

        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(resultado);
        return preguntaMDAO.guardar(objeto, tabla);
    }

    /**
     * trae el id del resultado.
     *
     * @param nombre: nombre del resultado
     * @return idResultado
     */
    public static String buscaValor(int nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.buscarCombo1(tabla, cb, cbID, nombre);
    }

}
