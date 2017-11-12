/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.CtlMultiple.tabla;
import DAO.DaoGenericoo;
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

    public String convertirGson(PreguntaUnica unica) {
        Gson gson = new Gson();
        String objeto = gson.toJson(unica);
        return objeto;
    }

    public boolean SolicitudGuardar(String opcion1, String opcion2, String opcion3, String opcion4, String opcionCorrecta, String enunciado, int Tema_idTema, int idTipo) {

        PreguntaUnica unica = new PreguntaUnica(opcion1, opcion2, opcion3, opcion4, opcionCorrecta, enunciado, Tema_idTema, idTipo);
        DaoGenericoo usuarioDAO = new DaoGenericoo();
        String objeto = convertirGson(unica);
        return usuarioDAO.guardar(objeto, tabla);
    }

    public ArrayList solicitudBuscarFiltrado(String caracter, String nombreColumna) {
        DaoGenericoo preguntaUDAO = new DaoGenericoo();
        return preguntaUDAO.buscarPreguntas(nombreColumna, tabla, caracter);
    }

    public ArrayList solicitudPreguntas(String enunciado) {
        DaoGenericoo preguntaMDAO = new DaoGenericoo();
        return preguntaMDAO.setPreguntas(enunciado, tabla);
    }

    public ArrayList solicitudCargarPreguntas() {
        DaoGenericoo preguntaUDAO = new DaoGenericoo();
        return preguntaUDAO.cargarPreguntas(tabla, id);
    }

//    
//    public boolean SolicitudModificar(int idTema, String descripcion) {
//        Tema tema = new Tema(idTema, descripcion);
//        DAOGenerico temaDAO = new DAOGenerico();
//        String objeto = convertirGson(tema);
//        return temaDAO.modificar(objeto, tabla);
//    }
//    
//    public boolean SolicitudEliminar(int idTema) {
//        Tema tema = new Tema();
//        DAOGenerico temaDAO = new DAOGenerico();
//        String objeto = convertirGson(tema);
//        return temaDAO.eliminar(objeto, tabla, idTema);
//    }
//
//    public DefaultTableModel solicitudListar() {
//
//        DefaultTableModel modelTabla;
//        String nombreColumnas[] = {"Codigo", "Nombre"};
//
//        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
//
//        DAOGenerico usuarioDAO = new DAOGenerico();
//        ResultSet atributos = usuarioDAO.listar(tabla);
//
//        try {
//            while (atributos.next()) {
//                modelTabla.addRow(new Object[]{
//                    atributos.getString("idTema"),
//                    atributos.getString("descripcion")
//                });
//            }
//        } catch (Exception e) {
//        }
//        return modelTabla;
//    }
//    
}
