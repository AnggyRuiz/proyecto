/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.CtlMultiple.tabla;
import DAO.DaoGenerico;
import Modelo.PreguntaUnica;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Machado
 */
public class CtlUnica {

    public CtlUnica() {
    }

    public static String tabla = "preguntaunica";
    public static String cbID = "idTema";
    public static String cb = "descripcion";
    public static String id = "idPreguntaUnica";

    /**
     * convertir el objeto a un Json.
     *
     * @param multiple: objeto de pregunta unica
     * @return objeto
     */
    public static String convertirGson(PreguntaUnica unica) {
        Gson gson = new Gson();
        String objeto = gson.toJson(unica);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param idPreguntaUnica,opcion1,opcion2,opcion3,opcion4,opcionCorrecta,enunciado,tema_idTema,idTipo : objeto preguntaUnica
     * @return objeto
     */
    public static boolean SolicitudGuardar(int idPreguntaUnica, String opcion1, String opcion2, String opcion3, String opcion4, String opcionCorrecta, String enunciado, int Tema_idTema, int idTipo) {

        PreguntaUnica unica = new PreguntaUnica(idPreguntaUnica, opcion1, opcion2, opcion3, opcion4, opcionCorrecta, enunciado, Tema_idTema, idTipo);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(unica);
        return usuarioDAO.guardar(objeto, tabla);
    }

    /**
     * Busca la pregunta por filtro.
     *
     * @param caracter,nombreColumna: letra que va a buscar, columnas del registro
     * @return objeto
     */
    public static ArrayList solicitudBuscarFiltrado(String caracter, String nombreColumna) {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.buscarPreguntas(nombreColumna, tabla, caracter);
    }

    /**
     * trae la pregunta que necesita.
     *
     * @param enunciado: enunciado de la pregunta
     * @return objeto
     */
    public static ArrayList solicitudPreguntas(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.setPreguntas(enunciado, tabla);
    }

    /**
     * Carga las preuntas que encontró.
     *
     * @param ninguno
     * @return objeto
     */
    public static ArrayList solicitudCargarPreguntas() {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.cargarPreguntas(tabla, id);
    }

    /**
     * Busca la pregunta que necesita.
     *
     * @param idPreguntaU: id de la pregunta
     * @return objeto
     */
    public static ArrayList<String> SolicitudBuscarU(int idPreguntaM) {
        PreguntaUnica preguntaU = new PreguntaUnica(idPreguntaM, "", "", "", "", "", "", 0, 0);
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(preguntaU);
        return temaDAO.buscar1(objeto, tabla, idPreguntaM);
    }

    /**
     * Busca el id del enunciado enviado.
     *
     * @param enunciado: enunciado de la pregunta
     * @return id
     */
    public static String solicitudBuscarId(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo(tabla, "enunciado", id, enunciado);
    }
    
    /**
     * trae la respuesta correcta.
     *
     * @param idp: id de la pregunta
     * @return objeto
     */
    public static String solicitudBuscarCorrecta(int idp) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo1(tabla, id, "opcionCorrecta", idp);
    }
    
}
