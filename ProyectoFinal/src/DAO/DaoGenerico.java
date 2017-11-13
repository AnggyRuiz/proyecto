/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Gabriela Machado
 */
public class DaoGenerico extends Conexion {

    public boolean guardar(String objeto, String tabla) {
        System.out.println(objeto);

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();
        for (int i = 0; i < listCampos.size(); i++) {
            System.out.println(listCampos.get(i));
            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }
        for (int i = 0; i < listValores.size(); i++) {
            System.out.println(listValores.get(i));
        }
        String consulta = "insert into " + tabla + "(";
        Iterator<String> itrCampos = listCampos.iterator();

        while (itrCampos.hasNext()) {
            Object atributo = itrCampos.next();
            consulta = consulta + "" + atributo.toString().toLowerCase();
            if (itrCampos.hasNext()) {
                consulta = consulta + ",";
            } else {
                consulta = consulta + ") values (";
            }

        }
        Iterator<String> itrValores = listValores.iterator();
        while (itrValores.hasNext()) {
            Object valor = itrValores.next();
            consulta = consulta + "'" + valor;
            if (itrValores.hasNext()) {
                consulta = consulta + "',";
            } else {
                consulta = consulta + "');";
            }

        }
        System.out.println(consulta);

        return super.ejecutar(consulta);
    }

    public ArrayList<String> buscar1(String objeto, String tabla, Object id) {
        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        String consulta = "select * from " + tabla + " where " + listCampos.get(0) + "='" + id + "'";
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        ArrayList<String> dao = new ArrayList<>();
        try {
            if (resultadoDB.next()) {
                for (int i = 0; i < listCampos.size(); i++) {
                    dao.add(resultadoDB.getString(listCampos.get(i)));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Se prendio esta mier**");
        }
        return dao;
    }

    public boolean modificar(String objeto, String tabla) {
        String consulta = "update " + tabla + " set ";

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();

        for (int i = 0; i < listCampos.size(); i++) {
            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }
        Iterator<String> itrCampos = listCampos.iterator();

        Iterator<String> itrValores = listValores.iterator();

        while (itrCampos.hasNext() && itrValores.hasNext()) {
            Object atributo = itrCampos.next();
            Object valor = itrValores.next();
            consulta += atributo.toString() + "='" + valor + "'";
            if (itrCampos.hasNext()) {
                consulta += ",";
            }
        }
        consulta += " where " + listCampos.get(0) + "='" + listValores.get(0) + "';";
        System.out.println(consulta);
        return super.ejecutar(consulta);

    }

    public boolean eliminar(String objeto, String tabla, Object variable) {
        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        String consulta = "delete from " + tabla + " where " + listCampos.get(0) + "='" + variable + "';";
        return super.ejecutar(consulta);
    }

    public ResultSet listar(String tabla) {

        String consulta = "select * from " + tabla;
        super.ejecutarRetorno(consulta);

        return resultadoDB;
    }

    public DefaultComboBoxModel llenarCombo(String tabla, String cb) {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement(tabla);

        String consulta = "select * FROM " + tabla;
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);

        try {
            while (resultadoDB.next()) {
                cbx.addElement(resultadoDB.getString(cb));
            }
        } catch (SQLException ex) {
            System.out.println("esto se tosto");
        }
        return cbx;
    }

    public String buscarCombo(String tabla, String cb, String cbID, String nombre) {
        String consulta = "SELECT " + cbID + " FROM " + tabla + " WHERE " + cb + " ='" + nombre + "'";
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);
        String id = "";
        try {
            if (resultadoDB.next()) {

                id = (resultadoDB.getString(cbID));
            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");

        }
        return id;
    }

    public String VerificarUsuario(String tabla, String cb, String nombre) {
        String consulta = " SELECT " + cb + " FROM " + tabla + " WHERE " + cb + " ='" + nombre + "'";
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);
        String nombreUsuario = "";
        try {
            if (resultadoDB.next()) {

                nombreUsuario = (resultadoDB.getString(cb));
            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");

        }
        return nombreUsuario;
    }

    public ArrayList buscarPreguntas(String nombreColumna, String nombreTabla, String caracter) {
        ArrayList<String> buscar = new ArrayList<>();
        String consulta = "SELECT Tema_idTema, enunciado FROM " + nombreTabla + " WHERE " + nombreColumna + " LIKE '" + caracter + "%'";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                for (int i = 1; i < resultadoDB.getMetaData().getColumnCount() + 1; i++) {
                    buscar.add(resultadoDB.getString(i));
                }
            }
        } catch (Exception e) {
            System.out.println("algo fallo :v");
            System.out.println(consulta);
        }
        System.out.println(buscar);
        System.out.println(consulta);

        return buscar;
    }

    public ArrayList setPreguntas(String enunciado, String nombreTabla) {
        ArrayList<String> buscar = new ArrayList<>();
        String consulta = "SELECT * FROM " + nombreTabla + " WHERE enunciado = '" + enunciado + "'";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                for (int i = 1; i < resultadoDB.getMetaData().getColumnCount() + 1; i++) {
                    buscar.add(resultadoDB.getString(i));
                }
            }
        } catch (Exception e) {
            System.out.println("algo fallo :v");
            System.out.println(consulta);
        }
        System.out.println(buscar);
        System.out.println(consulta);

        return buscar;
    }

    public ArrayList cargarPreguntas(String tabla, String id) {
        ArrayList<Integer> cargar = new ArrayList<>();
        String consulta = " SELECT " + id + " FROM " + tabla + " ORDER BY RAND() LIMIT 5";
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                for (int i = 1; i < resultadoDB.getMetaData().getColumnCount() + 1; i++) {
                    cargar.add(resultadoDB.getInt(id));
                }
            }
        } catch (Exception e) {
            System.out.println("algo fallo :v");
            System.out.println(consulta);
        }
        return cargar;
    }

    public ArrayList buscarIdj(String tabla, String id) {
        ArrayList<Integer> buscarIdj = new ArrayList<>();
        String consulta = " SELECT " + id + " FROM " + tabla + " ORDER BY (" + id + ")desc";
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                for (int i = 1; i < resultadoDB.getMetaData().getColumnCount() + 1; i++) {
                    buscarIdj.add(resultadoDB.getInt(id));
                }
            }
        } catch (Exception e) {
            System.out.println("algo fallo :v");
            System.out.println(consulta);
        }
        return buscarIdj;
    }

    public ArrayList buscar(String tabla, String id, String id2) {
        ArrayList<String> buscar = new ArrayList<>();
        String consulta = " SELECT * FROM " + tabla + " WHERE " + id + " = " + id2;
        super.ejecutarRetorno(consulta);

        try {
            if (resultadoDB.next()) {
                for (int i = 0; i < resultadoDB.getRow(); i++) {
                    buscar.add(resultadoDB.getString(id));
                }
            }
        } catch (Exception e) {
            System.out.println("algo fallo :v");
            System.out.println(consulta);
        }
        return buscar;
    }

//    public ArrayList<String> verificarContraseña(String objeto, String tabla, String cb, String cbP, Object contraseña) {
//        JsonParser parser = new JsonParser();
//        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
//        Set<String> keys = jobject.keySet();
//
//        ArrayList<String> listCampos = new ArrayList(keys);
//        String consulta = " SELECT " + cb + "," + cbP + " FROM " + tabla + " WHERE" + cbP + " = " + contraseña + "'";
//        System.out.println(consulta);
//        super.ejecutarRetorno(consulta);
//        ArrayList<String> dao = new ArrayList<>();
//        try {
//            if (resultadoDB.next()) {
//                for (int i = 0; i < listCampos.size(); i++) {
//                    dao.add(resultadoDB.getString(listCampos.get(i)));
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println("Se prendio esta mier**");
//        }
//        return dao;
//    }
}
