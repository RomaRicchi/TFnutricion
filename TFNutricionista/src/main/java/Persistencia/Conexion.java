/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Roma
 */
public class Conexion {
   
private static String url = "jdbc:mariadb://localhost/nutricionista";
    private static String usuario = "root";
    private static String password = "";
    private static Conexion conexion = null;

    private Conexion() { // única conexión
        try {
            // Esta línea puede ser eliminada en versiones recientes de MariaDB JDBC, ya que se carga automáticamente.
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver"); // Error en el driver de MariaDB
        }
    }

    public static Connection getConexion() { // establecer la conexión a la base de datos
        Connection conn = null;
        if (conexion == null) {
            conexion = new Conexion();
        }

        try {
            conn = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error de Conexion: " + ex.getMessage());
        }

        return conn;
    }
}


