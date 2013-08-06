/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.configuracaoPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class DBConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://";
    private static String host = "192.168.1.250";
    //private static String host = "localhost";
    private static String database = "astec";
    private static String user = "root";
    private static String password = "aluno";
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                // carrega definicoes estaticas do driver JDBC
                Class.forName(driver);
                // cria conexao
                con = DriverManager.getConnection(url + host + '/' + database, user, password);
            }
            return con;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static ResultSet executeSQL(String sql) {
        try {
            if (con == null) {
                con = getConnection();
            }
            // cria objeto que executa comandos SQL
            Statement stm = con.createStatement();
            // executa SQL
            return stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        DBConnection.database = database;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        DBConnection.driver = driver;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DBConnection.host = host;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConnection.password = password;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DBConnection.user = user;
    }
}
