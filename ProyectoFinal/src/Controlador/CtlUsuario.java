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
    
    /**
     * convertir el objeto a un Json.
     *
     * @param usuario: objeto de Usuario
     * @return objeto
     */
    public static String convertirGson(Usuario usuario) {
        Gson gson = new Gson();
        String objeto = gson.toJson(usuario);
        return objeto;
    }

    /**
     * manda el Json al Dao para guardarlo en la base de datos.
     *
     * @param codigo,password,nombre,nombreUsuario,correo,telefono,tipoUsuario,semestre : objeto Usuario
     * @return objeto
     */
    public static boolean SolicitudGuardar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {
        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.guardar(objeto, tabla);
    }

    /**
     * verifica si un usuario existe en la base de datos.
     *
     * @param nombre: nombre de usuario
     * @return nombreUsuario
     */
    public static String solicitudVerificarUsuario(String nombre) {
        DaoGenerico DAO = new DaoGenerico();
        return DAO.VerificarUsuario(tabla, cb, nombre);
    }

    /**
     * verifica si la contraseña que ingresaron tiene relación con la que está en la base de datos.
     *
     * @param password: contraseña del usuario
     * @return objeto
     */
    public static ArrayList<String> solicitudVerificarContraseñaUsuario(String password) {
        Usuario usuario = new Usuario(0, password, "", "", "", "", "", "");
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, password);
    }

    /**
     * Este método va al dao, busca al usuario que acaba de ingresar y setea todos los campos en la vista del usuario.
     *
     * @param idUsuario: codigo del usuario
     * @return objeto
     */
    public static ArrayList<String> solicitudSet(int idUsu) {
        Usuario usuario = new Usuario(idUsu, "", "", "", "", "", "", "");
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, idUsu);
    }

    /**
     * obtiene lo que el objeto ya tenía y lo manda al dao para que modifique.
     *
     * @param codigo,password,nombre,nombreUsuario,correo,telefono,tipoUsuario,semestre : objeto Usuario
     * @return objeto
     */
    public static boolean SolicitudModificar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {
        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.modificar(objeto, tabla);
    }

    /**
     * manda el Json (objeto) al dao para que lo elimine.
     *
     * @param cedulaUsuario: cedula del usuario
     * @return objeto
     */
    public static boolean SolicitudEliminar(int cedulaUsuario) {
        Usuario usuario = new Usuario();
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.eliminar(objeto, tabla, cedulaUsuario);
    }
}
