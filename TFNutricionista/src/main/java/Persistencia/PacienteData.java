/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;


import Modelo.Paciente;
import Persistencia.Conexion;
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
public class PacienteData {
       private Connection connection;

    public PacienteData() throws SQLException {
        connection = Conexion.getConexion();
    }

   

    public void agregarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente(nombre_completo, dni, domicilio, celular) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre_completo());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getCelular());

            // Ejecutar la actualización
            ps.executeUpdate();

            // Manejar claves generadas (si es necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar un paciente: " + e.getMessage());
        }
    }
    
    public Paciente buscarPaciente(int dni) {
        String sql = "SELECT * FROM paciente WHERE dni = ?";

        Paciente paciente = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre_completo(rs.getString("nombre_completo"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setCelular(rs.getString("celular"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar el paciente: " + e.getMessage());
        }

        return paciente;
    }

    
            
    public void modificarPaciente(int idPaciente, String nombre_completo, int dni, String domicilio, String celular, boolean estado) {
        String sql = "UPDATE paciente SET nombre_completo = ?, dni = ?, domicilio = ?, celular = ?, estado=?  WHERE idPaciente = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombre_completo);
            ps.setInt(2, dni);
            ps.setString(3, domicilio);
            ps.setString(4, celular);
            ps.setBoolean(5, estado);
            ps.setInt(5, idPaciente);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Paciente Modificado Exitosamente");
            } else {
                System.out.println("No existe paciente con ese ID");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al modificar Paciente: " + ex.getMessage());
        }
    }

    public List<Paciente> listarPacientes() {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        String sql = "SELECT * FROM paciente";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre_completo(rs.getString("nombre_completo"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setCelular(rs.getString("celular"));

                listaPacientes.add(paciente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener pacientes: " + ex.getMessage());
        }

        return listaPacientes;
    }
    
    public List<Paciente> listarPacientesConPesoPendiente() {
        List<Paciente> listaPacientes = new ArrayList<>();

        String sql = "SELECT p.idPaciente, p.nombre_completo, p.dni, p.domicilio, p.celular " +
                     "FROM paciente p " +
                     "INNER JOIN dieta d ON p.idPaciente = d.idPaciente " +
                     "WHERE d.fecha_fin <= CURDATE() AND d.peso_actual > d.peso_buscado";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre_completo(rs.getString("nombre_completo"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setCelular(rs.getString("celular"));

                listaPacientes.add(paciente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener los pacientes con peso pendiente: " + ex.getMessage());
        }

        return listaPacientes;
    }


    
    


    
}

