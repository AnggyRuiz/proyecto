/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.CtlUnica.id;
import static Controlador.CtlUnica.tabla;
import DAO.DaoGenerico;
import Modelo.PreguntaMultiple;
import Modelo.PreguntaUnica;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriela Machado
 */
public class CtlMultiple {

    public CtlMultiple() {
    }

    public static String tabla = "preguntamultiple";
    public static String cbID = "idTema";
    public static String cb = "descripcion";
    public static String id = "idPreguntaMultiple";

    
    /**
     * convertir el objeto a un Json.
     *
     * @param multiple: objeto de pregunta multiple
     * @return objeto
     */
    public static String convertirGson(PreguntaMultiple multiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(multiple);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param idPreguntaMultiple,opcion1,opcion2,opcion3,opcion4,opcionesCorrectas,enunciado,tema_idTema,idTipo : objeto preguntaMultiple
     * @return objeto
     */
    public static boolean solicitudGuardar(int idPreguntaMultiple, String opcion1, String opcion2, String opcion3, String opcion4, String opcionesCorrectas, String enunciado, int tema_idTema, int idTipo) {

        PreguntaMultiple multiple = new PreguntaMultiple(idPreguntaMultiple, opcion1, opcion2, opcion3, opcion4, opcionesCorrectas, enunciado, tema_idTema, idTipo);
        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(multiple);
        return preguntaMDAO.guardar(objeto, tabla);
    }

    /**
     * Busca la pregunta por filtro.
     *
     * @param caracter,nombreColumna: letra que va a buscar, columnas del registro
     * @return objeto
     */
    public static ArrayList solicitudBuscarFiltrado(String caracter, String nombreColumna) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarPreguntas(nombreColumna, tabla, caracter);
    }

    /**
     * lista todas las preguntas múltiples que están en la base de datos.
     *
     * @param ninguno
     * @return lista
     */
    public static DefaultTableModel listarM(ArrayList<String> buscar) {
        int num = buscar.size();
        DefaultTableModel modelo = new DefaultTableModel();
        String nombreColumnas[] = {"tema", "enunciado"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        for (int i = 0; i < num; i += 2) {
            modelo.addRow(new Object[]{
                buscar.get(i),
                buscar.get(i + 1)

            });
        }
        return modelo;
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
     * @param idPreguntaM: id de la pregunta
     * @return objeto
     */
    public static ArrayList<String> SolicitudBuscarM(int idPreguntaM) {
        PreguntaMultiple preguntaM = new PreguntaMultiple(idPreguntaM, "", "", "", "", "", "", 0, 0);
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(preguntaM);
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
        return preguntaMDAO.buscarCombo1(tabla, id, "opcionesCorrectas", idp);
    } 
}
