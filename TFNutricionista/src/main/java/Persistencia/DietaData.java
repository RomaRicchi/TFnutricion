
package Persistencia;

import Modelo.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roma
 */
public class DietaData {
    private Connection connection;

    public DietaData() throws SQLException {
        connection = Conexion.getConexion();
    }
    
    public void cargarPesoActual(int idPaciente, float peso_actual) throws SQLException {
        String sql = "UPDATE dieta SET peso_actual = ? WHERE idPaciente = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Asignar los valores al PreparedStatement
            ps.setFloat(1, peso_actual);  // Asignar el nuevo peso
            ps.setInt(2, idPaciente);     // Asignar el idPaciente

            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();

            // Verificar si se actualizó alguna fila
            if (filasAfectadas > 0) {
                System.out.println("Peso Actual Modificado Exitosamente");
            } else {
                System.out.println("No existe paciente con ese ID");
            }

        } catch (SQLException ex) {
            System.out.println("Error al modificar el peso actual: " + ex.getMessage());
            throw ex;  // Rethrow para que la excepción se maneje adecuadamente más arriba
        }
    }

    
    public void agregarComidaADieta(int idDieta, int idComida) {
        String sql = "INSERT INTO dieta_comidas (idDieta, idComida) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Comida agregada a la dieta correctamente.");
            } else {
                System.out.println("No se pudo agregar la comida a la dieta.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al agregar comida a la dieta: " + ex.getMessage());
        }
    }
    
    public void borrarComidaDeDieta(int idDieta, int idComida) {
        String sql = "DELETE FROM dieta_comidas WHERE idDieta = ? AND idComida = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Comida eliminada de la dieta correctamente.");
            } else {
                System.out.println("No se pudo eliminar la comida de la dieta.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al eliminar comida de la dieta: " + ex.getMessage());
        }
    }
    
    
   
}
