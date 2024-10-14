/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Roma
 */
public class Dieta {
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private List<Comida> comidas;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private float peso_inicial;
    private float peso_buscado;
    private float peso_actual;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, List<Comida> comidas, LocalDate fecha_inicio, LocalDate fecha_fin, float peso_inicial, float peso_buscado, float peso_actual) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.comidas = comidas;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.peso_inicial = peso_inicial;
        this.peso_buscado = peso_buscado;
        this.peso_actual = peso_actual;
    }

    public Dieta(String nombre, Paciente paciente, List<Comida> comidas, LocalDate fecha_inicio, LocalDate fecha_fin, float peso_inicial, float peso_buscado, float peso_actual) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.comidas = comidas;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.peso_inicial = peso_inicial;
        this.peso_buscado = peso_buscado;
        this.peso_actual = peso_actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public float getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(float peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public float getPeso_buscado() {
        return peso_buscado;
    }

    public void setPeso_buscado(float peso_buscado) {
        this.peso_buscado = peso_buscado;
    }

    public float getPeso_actual() {
        return peso_actual;
    }

    public void setPeso_actual(float peso_actual) {
        this.peso_actual = peso_actual;
    }

    @Override
    public String toString() {
        return "Dieta{" + "idDieta=" + idDieta + ", nombre=" + nombre + ", paciente=" + paciente + ", comidas=" + comidas + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", peso_inicial=" + peso_inicial + ", peso_buscado=" + peso_buscado + ", peso_actual=" + peso_actual + '}';
    }


}