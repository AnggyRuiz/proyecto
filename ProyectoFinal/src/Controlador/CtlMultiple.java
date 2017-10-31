/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
import Modelo.PreguntaMultiple;
import com.google.gson.Gson;

/**
 *
 * @author Gabriela Machado
 */
public class CtlMultiple {

    public CtlMultiple() {
    }
    
    public static String tabla = "preguntamultiple";
//    public static String id = "idTema";
//    public static String descripcion = "descripcion";
    
    public String convertirGson(PreguntaMultiple multiple) {
        Gson gson = new Gson();
        String objeto = gson.toJson(multiple);
        return objeto;
    }
    
     public boolean SolicitudGuardar(String opcion1, String opcion2, String opcion3, String opcion4, String opcionesCorrectas, String enunciado, int tema_idTema) {

         PreguntaMultiple multiple = new PreguntaMultiple(opcion1, opcion2, opcion3, opcion4, opcionesCorrectas, enunciado, tema_idTema);
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(multiple);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
}
