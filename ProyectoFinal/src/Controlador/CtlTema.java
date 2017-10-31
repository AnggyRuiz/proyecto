
package Controlador;

import DAO.DAOGenerico;
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
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(tema);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
    public ArrayList<String> SolicitudBuscar(int idTema) {
        
        Tema tema = new Tema(idTema, "");
        DAOGenerico temaDAO = new DAOGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.buscar(objeto, tabla, idTema);
    }
    
    public boolean SolicitudModificar(int idTema, String descripcion) {
        Tema tema = new Tema(idTema, descripcion);
        DAOGenerico temaDAO = new DAOGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.modificar(objeto, tabla);
    }
    
    public boolean SolicitudEliminar(int idTema) {
        Tema tema = new Tema();
        DAOGenerico temaDAO = new DAOGenerico();
        String objeto = convertirGson(tema);
        return temaDAO.eliminar(objeto, tabla, idTema);
    }

    public DefaultTableModel solicitudListar() {

        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Codigo", "Nombre"};

        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        DAOGenerico usuarioDAO = new DAOGenerico();
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
        DAOGenerico DAO = new DAOGenerico();
        return DAO.buscarCombo(tabla, descripcion, id, nombre);
    }
    
    public static DefaultComboBoxModel solicitudListarCombo() {
        DAOGenerico DAO = new DAOGenerico();
        return DAO.llenarCombo(tabla, descripcion);
    }
}
