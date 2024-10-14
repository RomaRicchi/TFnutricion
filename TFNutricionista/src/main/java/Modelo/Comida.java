/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Roma
 */
public class Comida {
    private int idComida;
    private String nombre;
    private String detalle;
    private int calorias;

    public Comida() {
    }

    public Comida(String nombre, String detalle, int calorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
    }

    public Comida(int idComida, String nombre, String detalle, int calorias) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", nombre=" + nombre + ", detalle=" + detalle + ", calorias=" + calorias + '}';
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

}
