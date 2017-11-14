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

    public static String convertirGson(PreguntaMultiple multiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(multiple);
        return objeto;
    }

    public static boolean solicitudGuardar(int idPreguntaMultiple, String opcion1, String opcion2, String opcion3, String opcion4, String opcionesCorrectas, String enunciado, int tema_idTema, int idTipo) {

        PreguntaMultiple multiple = new PreguntaMultiple(idPreguntaMultiple, opcion1, opcion2, opcion3, opcion4, opcionesCorrectas, enunciado, tema_idTema, idTipo);
        DaoGenerico preguntaMDAO = new DaoGenerico();
        String objeto = convertirGson(multiple);
        return preguntaMDAO.guardar(objeto, tabla);
    }

    public static ArrayList solicitudBuscarFiltrado(String caracter, String nombreColumna) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarPreguntas(nombreColumna, tabla, caracter);
    }

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

    public static ArrayList solicitudPreguntas(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.setPreguntas(enunciado, tabla);
    }

    public static ArrayList solicitudCargarPreguntas() {
        DaoGenerico preguntaUDAO = new DaoGenerico();
        return preguntaUDAO.cargarPreguntas(tabla, id);
    }

    public static ArrayList<String> SolicitudBuscarM(int idPreguntaM) {
        PreguntaMultiple preguntaM = new PreguntaMultiple(idPreguntaM, "", "", "", "", "", "", 0, 0);
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(preguntaM);
        return temaDAO.buscar1(objeto, tabla, idPreguntaM);
    }
    
    public static String solicitudBuscarId(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo(tabla, "enunciado", id, enunciado);
    }

    public static String solicitudBuscarCorrecta(int idp) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo1(tabla, id, "opcionesCorrectas", idp);
    } 
}
