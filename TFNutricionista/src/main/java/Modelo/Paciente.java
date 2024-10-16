/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Roma
 */
public class Paciente {
     private int idPaciente;
    private String nombre_completo;
    private int dni;
    private String domicilio;
    private String celular;
    private boolean estado;
    

    public Paciente() {
    }

    public Paciente(String nombre_completo, int dni, String domicilio, String celular, boolean estado) {
        this.nombre_completo = nombre_completo;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
        this.estado = estado;
    }

    public Paciente(int idPaciente, String nombre_completo, int dni, String domicilio, String celular, boolean estado) {
        this.idPaciente = idPaciente;
        this.nombre_completo = nombre_completo;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombre_completo=" + nombre_completo + ", dni=" + dni + ", domicilio=" + domicilio + ", celular=" + celular + ", estado=" + estado + '}';
    }
    
    
    
}