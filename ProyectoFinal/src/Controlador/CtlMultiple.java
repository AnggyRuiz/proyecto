/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
import Modelo.PreguntaMultiple;
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

    public String convertirGson(PreguntaMultiple multiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(multiple);
        return objeto;
    }

    public boolean solicitudGuardar(String opcion1, String opcion2, String opcion3, String opcion4, String opcionesCorrectas, String enunciado, int tema_idTema) {

        PreguntaMultiple multiple = new PreguntaMultiple(opcion1, opcion2, opcion3, opcion4, opcionesCorrectas, enunciado, tema_idTema);
        DAOGenerico preguntaMDAO = new DAOGenerico();
        String objeto = convertirGson(multiple);
        return preguntaMDAO.guardar(objeto, tabla);
    }

    public ArrayList solicitudBuscarFiltrado(String caracter, String nombreColumna) {
        DAOGenerico preguntaMDAO = new DAOGenerico();
        return preguntaMDAO.buscarPreguntas(nombreColumna, tabla, caracter);
    }

    public DefaultTableModel listarM(ArrayList<String> buscar) {
        int num = buscar.size();
        DefaultTableModel modelo = new DefaultTableModel();
        String nombreColumnas[] = {"tema", "enunciado"};
        modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        for (int i = 0; i < num; i+=2) {
            modelo.addRow(new Object[]{
                buscar.get(i),
                buscar.get(i + 1)

            });
        }
        return modelo;
    }
    
     public ArrayList solicitudPreguntas(String enunciado) {
        DAOGenerico preguntaMDAO = new DAOGenerico();
        return preguntaMDAO.setPreguntas(enunciado, tabla);
    }
}
