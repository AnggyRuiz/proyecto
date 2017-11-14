
package Controlador;

import DAO.DaoGenerico;
import Modelo.Tema;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriela Machado
 */
public class CtlTema {
    
    public static String tabla = "tema";
    public static String id = "idTema";
    public static String descripcion = "descripcion";
    
    
    public CtlTema() {

    }

    /**
     * convertir el objeto a un Json.
     *
     * @param tema: objeto de Tema
     * @return objeto
     */
    public static String convertirGson(Tema tema) {
        Gson gson = new Gson();
        String objeto = gson.toJson(tema);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param idTema,descripcion: objeto de Tema
     * @return objeto
     */
    public static boolean SolicitudGuardar(int idTema, String descripcion) {
        Tema tema = new Tema(idTema, descripcion);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
    /**
     * manda el objeto al dao para buscar si existe o no en la base de datos.
     *
     * @param idTema: codigo de Tema
     * @return objeto
     */
    public static ArrayList<String> SolicitudBuscar(int idTema) {        
        Tema tema = new Tema(idTema, "");
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.buscar1(objeto, tabla, idTema);
    }
    
    /**
     * obtiene lo que el objeto ya tenía y lo manda al dao para que modifique.
     *
     * @param idTema,cescripcion: objeto de Tema
     * @return objeto
     */
    public static boolean SolicitudModificar(int idTema, String descripcion) {
        Tema tema = new Tema(idTema, descripcion);
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.modificar(objeto, tabla);
    }
    
    /**
     * manda el Json al dao para que lo elimine.
     *
     * @param idTema: codigo de Tema
     * @return objeto
     */
    public static boolean SolicitudEliminar(int idTema) {
        Tema tema = new Tema();
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.eliminar(objeto, tabla, idTema);
    }

    /**
     * lista todos los temas que están en la base de datos.
     *
     * @param ninguno
     * @return lista
     */
    public static DefaultTableModel solicitudListar() {

        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Codigo", "Nombre"};

        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        DaoGenerico usuarioDAO = new DaoGenerico();
        ResultSet atributos = usuarioDAO.listar(tabla);

        try {
            while (atributos.next()) {
                modelTabla.addRow(new Object[]{
                    atributos.getString("idTema"),
                    atributos.getString("descripcion")
                });
            }
        } catch (Exception e) {
        }
        return modelTabla;
    }
    
    /**
     * trae el id del tema.
     *
     * @param nombre: nombre del Tema
     * @return idTema
     */
    public static String buscaValor(String nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.buscarCombo(tabla, descripcion, id, nombre);
    }
    
    /**
     * va al dao y trae todos los datos de la base de datos.
     *
     * @param : ninguno
     * @return objeto
     */
    public static DefaultComboBoxModel solicitudListarCombo() {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.llenarCombo(tabla, descripcion);
    }
    
    /**
     * trae el id que tenga ese enunciado.
     *
     * @param enunciado: Enunciado del tema
     * @return idTema
     */
    public static String solicitudBuscarId(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo(tabla, id, descripcion, enunciado);
    }
}
