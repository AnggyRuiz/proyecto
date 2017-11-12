/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
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

    public String convertirGson(Usuario usuario) {
        Gson gson = new Gson();
        String objeto = gson.toJson(usuario);
        return objeto;
    }

    public boolean SolicitudGuardar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {

        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.guardar(objeto, tabla);
    }

    public String solicitudVerificarUsuario(String nombre) {
        DAOGenerico DAO = new DAOGenerico();
        return DAO.VerificarUsuario(tabla, cb, nombre);
    }

    public ArrayList<String> solicitudVerificarContraseñaUsuario(String password) {
        Usuario usuario = new Usuario(0, password, "", "", "", "", "", "");
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, password);
    }

    public ArrayList<String> solicitudSet(int idUsu) {
        Usuario usuario = new Usuario(idUsu, "", "", "", "", "", "", "");
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.buscar1(objeto, tabla, idUsu);
    }

    public boolean SolicitudModificar(int codigo, String password, String nombre, String nombreUsuario, String correo, String telefono, String tipoUsuario, String semestre) {
        Usuario usuario = new Usuario(codigo, password, nombre, nombreUsuario, correo, telefono, tipoUsuario, semestre);
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.modificar(objeto, tabla);
    }

    public boolean SolicitudEliminar(int cedulaUsuario) {
        Usuario usuario = new Usuario();
        DAOGenerico usuarioDAO = new DAOGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.eliminar(objeto, tabla, cedulaUsuario);
    }
}
