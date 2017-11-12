
package Controlador;

import DAO.DaoGenericoo;
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
        DaoGenericoo usuarioDAO = new DaoGenericoo();
        String objeto = convertirGson(tema);
        return usuarioDAO.guardar(objeto, tabla);
    }
    
    public ArrayList<String> SolicitudBuscar(int idTema) {
        
        Tema tema = new Tema(idTema, "");
        DaoGenericoo temaDAO = new DaoGenericoo();
        String objeto = convertirGson(tema);
        return temaDAO.buscar1(objeto, tabla, idTema);
    }
    
    public boolean SolicitudModificar(int idTema, String descripcion) {
        Tema tema = new Tema(idTema, descripcion);
        DaoGenericoo temaDAO = new DaoGenericoo();
        String objeto = convertirGson(tema);
        return temaDAO.modificar(objeto, tabla);
    }
    
    public boolean SolicitudEliminar(int idTema) {
        Tema tema = new Tema();
        DaoGenericoo temaDAO = new DaoGenericoo();
        String objeto = convertirGson(tema);
        return temaDAO.eliminar(objeto, tabla, idTema);
    }

    public DefaultTableModel solicitudListar() {

        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Codigo", "Nombre"};

        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        DaoGenericoo usuarioDAO = new DaoGenericoo();
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
        DaoGenericoo DAO = new DaoGenericoo();
        return DAO.buscarCombo(tabla, descripcion, id, nombre);
    }
    
    public static DefaultComboBoxModel solicitudListarCombo() {
        DaoGenericoo DAO = new DaoGenericoo();
        return DAO.llenarCombo(tabla, descripcion);
    }
    
    public String solicitudBuscarId(String enunciado) {
        DaoGenericoo preguntaMDAO = new DaoGenericoo();
        return preguntaMDAO.buscarCombo(tabla, id, descripcion, enunciado);
    }
}
