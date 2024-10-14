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
    private Long celular;
    

    public Paciente() {
    }

    public Paciente(String nombre_completo, int dni, String domicilio, Long celular) {
        this.nombre_completo = nombre_completo;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }


    public Paciente(int idPaciente, String nombre_completo,int dni, String domicilio, Long celular) {
        this.idPaciente = idPaciente;
        this.nombre_completo = nombre_completo;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
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

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombre_completo=" + nombre_completo + ", dni=" + dni + ", domicilio=" + domicilio + ", celular=" + celular + '}';
    }

}