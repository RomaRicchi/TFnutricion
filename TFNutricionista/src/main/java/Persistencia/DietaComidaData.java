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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roma
 */
public class DietaComidaData {
    private Connection connection;

    public DietaComidaData() throws SQLException {
        connection = Conexion.getConexion();
    }
    public List<Comida> obtenerComidasDeDieta(int idDieta) {
        List<Comida> listaComidas = new ArrayList<>();

        String sql = "SELECT c.idComida, c.nombre, c.detalle, c.calorias " +
                     "FROM comida c " +
                     "INNER JOIN dieta_comidas dc ON c.idComida = dc.idComida " +
                     "WHERE dc.idDieta = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDieta);

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
            System.out.println("Error al obtener las comidas de la dieta: " + ex.getMessage());
        }

        return listaComidas;
    }
}
