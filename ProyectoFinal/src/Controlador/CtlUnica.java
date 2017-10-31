/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
import Modelo.PreguntaUnica;
import com.google.gson.Gson;

/**
 *
 * @author Gabriela Machado
 */
public class CtlUnica {

    public CtlUnica() {
    }
    
    public static String tabla = "preguntaunica";
//    public static String id = "idTema";
//    public static String descripcion = "descripcion";

    public String convertirGson(PreguntaUnica unica) {
        Gson gson = new Gson();
        String objeto = gson.toJson(unica);
        return objeto;
    }

    public boolean SolicitudGuardar(int Tema_idTema, String opcion1, String opcion2, String opcion3, String opcion4, String opcionCorrecta, String enunciado) {

        PreguntaUnica unica = new PreguntaUnica(opcion1, opcion2, opcion3, opcion4, opcionCorrecta, enunciado, Tema_idTema);
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(unica);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
//    public ArrayList<String> SolicitudBuscar(int idTema) {
//        
//        Tema tema = new Tema(idTema, "");
//        DAOGenerico temaDAO = new DAOGenerico();
//        String objeto = convertirGson(tema);
//        return temaDAO.buscar(objeto, tabla, idTema);
//    }
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
