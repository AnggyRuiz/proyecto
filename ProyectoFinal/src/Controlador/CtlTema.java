
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

    public String convertirGson(Tema tema) {
        Gson gson = new Gson();
        String objeto = gson.toJson(tema);
        return objeto;
    }

    public boolean SolicitudGuardar(int idTema, String descripcion) {

        Tema tema = new Tema(idTema, descripcion);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
    public ArrayList<String> SolicitudBuscar(int idTema) {
        
        Tema tema = new Tema(idTema, "");
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.buscar1(objeto, tabla, idTema);
    }
    
    public boolean SolicitudModificar(int idTema, String descripcion) {
        Tema tema = new Tema(idTema, descripcion);
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.modificar(objeto, tabla);
    }
    
    public boolean SolicitudEliminar(int idTema) {
        Tema tema = new Tema();
        DaoGenerico temaDAO = new DaoGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.eliminar(objeto, tabla, idTema);
    }

    public DefaultTableModel solicitudListar() {

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
    
    public String buscaValor(String nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.buscarCombo(tabla, descripcion, id, nombre);
    }
    
    public static DefaultComboBoxModel solicitudListarCombo() {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.llenarCombo(tabla, descripcion);
    }
    
    public String solicitudBuscarId(String enunciado) {
        DaoGenerico preguntaMDAO = new DaoGenerico();
        return preguntaMDAO.buscarCombo(tabla, id, descripcion, enunciado);
    }
}
