/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoGenerico;
import Modelo.Resumen;
import com.google.gson.Gson;

/**
 *
 * @author Gabriela Machado
 */
public class CtlResumen {
    public static String tabla = "resumen";
    public static String cbID = "idResumen";
    public static String cb = "idJuego";

    /**
     * convertir el objeto a un Json.
     *
     * @param resumen: objeto de partida
     * @return objeto
     */
    public static String convertirGson(Resumen resumen) {
        Gson gson = new Gson();
        String objeto = gson.toJson(resumen);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param resumen : objeto resumen
     * @return objeto
     */
    public static boolean solicitudGuardar(Resumen resumen) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(resumen);
        return preguntaMDAO.guardar(objeto, tabla);
    }
    
}
