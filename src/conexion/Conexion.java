/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author Hugo
 */
public class Conexion {

    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tfg", "root", "");
            System.out.println("Conectado con Exito");
            return cn;
        } catch (SQLException e) {
            System.err.println("Error en la conexión local " + e);
        }
        return (null);
    }

    public static void main(String[] args) {
        conectar();
    }
}
