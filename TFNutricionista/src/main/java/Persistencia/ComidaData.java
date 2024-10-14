/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roma
 */
public class ComidaData {
    private Connection connection;

    public ComidaData() throws SQLException {
        connection = Conexion.getConexion();
    }
    public void agregarComida(Comida comida) {
        if (comida == null || comida.getNombre() == null || comida.getNombre().isEmpty()) {
                System.out.println("Error: El nombre de la comida no puede ser nulo o vacío.");
                return;
            }
        
        String sql = "INSERT INTO comida(nombre, detalle, calorias) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCalorias());
            
            // Ejecutar la actualización
            ps.executeUpdate();

            // Manejar claves generadas (si es necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setIdComida(rs.getInt(1));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar una comida: " + e.getMessage());
        }
    }

    public Comida buscarComida(int idComida) {
        String sql = "SELECT * FROM comida WHERE idComida = ?";

        Comida comida = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idComida);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                comida = new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCalorias(rs.getInt("calorias"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar la comida: " + e.getMessage());
        }

        return comida;
    }

    public void modificarComida(int idComida, String nombre, String detalle, int calorias) {
        String sql = "UPDATE comida SET nombre = ?, detalle = ?, calorias = ? WHERE idComida = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, detalle);
            ps.setInt(3, calorias);
            ps.setInt(4, idComida);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Comida modificada exitosamente");
            } else {
                System.out.println("No existe comida con ese ID");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al modificar la comida: " + ex.getMessage());
        }
    }

    public List<Comida> listarComidas() {
        ArrayList<Comida> listaComidas = new ArrayList<>();

        String sql = "SELECT * FROM comida";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCalorias(rs.getInt("calorias"));

                listaComidas.add(comida);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las comidas: " + ex.getMessage());
        }

        return listaComidas;
    }

    public List<Comida> buscarComidasPorCaloriasMenores(int maxCalorias) {
        List<Comida> listaComidas = new ArrayList<>();

        String sql = "SELECT * FROM comida WHERE calorias < ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maxCalorias);  // Asigna el valor máximo de calorías

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCalorias(rs.getInt("calorias"));

                listaComidas.add(comida);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar las comidas: " + ex.getMessage());
        }

        return listaComidas;
    }

}
