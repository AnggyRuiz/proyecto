/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoGenerico;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Machado
 */
public class CtlUsuario {

    public static String tabla = "usuario";
    public static String cb = "nombreUsuario";
    public static String cbP = "password";

    public CtlUsuario() {

    }
    
    /*Este método lo que hace es convertir el objeto a un Json*/
    public static String convertirGson(Usuario usuario) {
        Gson gson = new Gson();
        String objeto = gson.toJson(usuario);
        return objeto;
    }

    /*Este método manda el Json al Dao para guardarlo en la base de datos*/
    public static boolean SolicitudGuardar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {
        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.guardar(objeto, tabla);
    }

    /*Este método verifica si un usuario existe en la base de datos*/
    public static String solicitudVerificarUsuario(String nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.VerificarUsuario(tabla, cb, nombre);
    }

    /*Este método verifica si la contraseña que ingresaron tiene relación con la que está en la base de datos*/
    public static ArrayList<String> solicitudVerificarContraseñaUsuario(String password) {
        Usuario usuario = new Usuario(0, password, "", "", "", "", "", "");
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, password);
    }

    /*Este método va al dao, busca al usuario que acaba de ingresar y setea todos los campos en la vista del usuario*/
    public static ArrayList<String> solicitudSet(int idUsu) {
        Usuario usuario = new Usuario(idUsu, "", "", "", "", "", "", "");
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, idUsu);
    }

    /*Este método obtiene lo que el objeto ya tenía y lo manda al dao para que modifique*/
    public static boolean SolicitudModificar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {
        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.modificar(objeto, tabla);
    }

    /*Este método manda el Json al dao para que lo elimine*/
    public static boolean SolicitudEliminar(int cedulaUsuario) {
        Usuario usuario = new Usuario();
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.eliminar(objeto, tabla, cedulaUsuario);
    }
}
