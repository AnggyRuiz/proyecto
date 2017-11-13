/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela Machado
 */
public class Conexion {

    public static String driver = "com.mysql.jdbc.Driver"; //nombre del driver
    public static String connectString = "jdbc:mysql://localhost:3306/proyecto"; //ubicacion de la base de datos, para postgres esta es por defecto
    public static String user = "root"; //usuario de la base de datos
    public static String password = ""; //password de la base de datos
    public static Connection conexionDB; // variable que permite la conexion
    public static Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    public static ResultSet resultadoDB;//almacena el resultado de una consulta

    /**
     * Permite la conexion de la base de datos
     */
    public static void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL   
            System.out.println("sisas");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la conexion de la base de datos
     */
    public static void desconectar() {
        try {
            //sentenciaSQL.close();//cierra la consulta
            conexionDB.close();//cierra conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean ejecutar(String sentencia) {
        try {
            conectar();
            System.out.println(sentencia);
            sentenciaSQL.executeUpdate(sentencia);
            //desconectar();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);
//            desconectar();
        } catch (Exception e) {

        }
    }

}
